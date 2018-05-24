// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import java.io.File
import java.lang.reflect._
import scala.reflect.ClassTag
import scala.Predef._


@SuppressWarnings(scala.Array(
  "org.wartremover.warts.NonUnitStatements",
  "org.wartremover.warts.Recursion",
  "org.wartremover.warts.Equals",
  "org.wartremover.warts.ToString",
  "org.wartremover.warts.StringPlusAny"
))
class TGen(managed: List[Class[_]], pkg: String, renames: Map[Class[_], String]) {

  implicit class MethodOps(m: Method) {
    def isStatic: Boolean =
      (m.getModifiers & Modifier.STATIC) != 0
  }

  // These Java classes will have non-Java names in our generated code
  val ClassBoolean  = classOf[Boolean]
  val ClassByte     = classOf[Byte]
  val ClassShort    = classOf[Short]
  val ClassInt      = classOf[Int]
  val ClassLong     = classOf[Long]
  val ClassFloat    = classOf[Float]
  val ClassDouble   = classOf[Double]
  val ClassObject   = classOf[Object]
  val ClassVoid     = Void.TYPE

  private def tparams(t: Type): List[String] =
    t match {
      case t: GenericArrayType  => tparams(t.getGenericComponentType)
      case t: ParameterizedType => t.getActualTypeArguments.toList.flatMap(tparams)
      case t: TypeVariable[_]   => List(t.toString)
      case _                    => Nil
    }

  private def toScalaType(t: Type): String =
    t match {
      case t: GenericArrayType  => s"Array[${toScalaType(t.getGenericComponentType)}]"
      case t: ParameterizedType => s"${toScalaType(t.getRawType)}${t.getActualTypeArguments.map(toScalaType).mkString("[", ", ", "]")}"
      case t: WildcardType      =>
        t.getUpperBounds.toList.filterNot(_ == classOf[Object]) match {
          case (c: Class[_]) :: Nil => s"_ <: ${c.getName}"
          case      Nil => "_"
          case cs       => sys.error("unhandled upper bounds: " + cs.toList)
        }
      case t: TypeVariable[_]   => t.toString
      case ClassVoid            => "Unit"
      case ClassBoolean         => "Boolean"
      case ClassByte            => "Byte"
      case ClassShort           => "Short"
      case ClassInt             => "Int"
      case ClassLong            => "Long"
      case ClassFloat           => "Float"
      case ClassDouble          => "Double"
      case ClassObject          => "AnyRef"
      case x: Class[_] if x.isArray => s"Array[${toScalaType(x.getComponentType)}]"
      case x: Class[_]          => renames.getOrElse(x, x.getSimpleName)
    }

  def importStatement(c: Class[_]): String = {
    val sn = c.getSimpleName
    val an = renames.getOrElse(c, sn)
    if (sn == an) s"import ${c.getName}"
    else          s"import ${c.getPackage.getName}.{ $sn => $an }"
  }

  // Operations for all methods in of A plus superclasses, interfaces, etc.
  private def operations[A](implicit ev: ClassTag[A]): List[Operation] = {

    // This class, plus any superclasses and interfaces, "all the way up"
    def closure(c: Class[_]): List[Class[_]] =
      (c :: (Option(c.getSuperclass).toList ++ c.getInterfaces.toList).flatMap(closure)).distinct
        .filterNot(_.getName == "java.lang.AutoCloseable") // not available in jdk1.6
        .filterNot(_.getName == "java.lang.Object")        // we don't want .equals, etc.

    // All method for this class and any superclasses/interfaces
    def methods(c: Class[_]): List[Method] =
      closure(c).flatMap(_.getDeclaredMethods.toList).distinct.filterNot(_.isStatic)

    // All methods for this class, turned into Operations
    methods(ev.runtimeClass).groupBy(_.getName).toList.flatMap { case (_, ms) =>
      ms.toList.sortBy(_.getGenericParameterTypes.map(toScalaType).mkString(",")).zipWithIndex.map {
        case (m, i) => Operation(m, i)
      }
    }.sortBy(c => (c.methodName, c.index))

  }

  // All types referenced by all methods on A, superclasses, interfaces, etc.
  private def imports[A](implicit ev: ClassTag[A]): List[String] =
    (importStatement(ev.runtimeClass) :: operations.map(_.method).flatMap { m =>
      m.getReturnType :: m.getParameterTypes.toList
    }.map { t =>
      if (t.isArray) t.getComponentType else t
    }.filterNot(t => t.isPrimitive || t == classOf[Object]).map { c =>
      importStatement(c)
    }).distinct.sorted

  // Each operation in our algebra maps to an underlying method, and an index is provided to
  // disambiguate in cases of overloading.
  case class Operation(method: Method, index: Int) {

    // The method name, unchanged
    def methodName: String =
      method.getName

    // Method parameter type names
    private def parameterTypes: List[String] =
      method.getGenericParameterTypes.toList.map(toScalaType)

    private def typeParameterList: String = {
      val ss = (method.getGenericParameterTypes.toList.flatMap(tparams) ++ tparams(method.getGenericReturnType)).toSet
      if (ss.isEmpty) "" else ss.mkString("[", ", ", "]")
    }

    // method arguments, a .. z zipped with the right type
    private def formalParameterList: String =
      "abcdefghijklmnopqrstuvwxyz".toList.zip(parameterTypes).map { case (n, t) => s"$n: $t" } .mkString(", ")

    // Return type name
    private def returnType: String =
      toScalaType(method.getGenericReturnType)

    // Argument list: a, b, c, ... up to the proper arity
    private def argumentList: String =
      "abcdefghijklmnopqrstuvwxyz".toList.take(parameterTypes.length).mkString(", ")

    // Arg list prefixed with $
    private def arguments: String =
      "abcdefghijklmnopqrstuvwxyz".toList.take(parameterTypes.length).map("$" + _).mkString(", ")

    def jdbcMethod: String =
      if (formalParameterList.isEmpty) s"  def $methodName: F[$returnType]"
      else s"  def $methodName$typeParameterList($formalParameterList): F[$returnType]"

    def syncMethod(oname: String): String =
      if (formalParameterList.isEmpty)
        s"""|  def $methodName =
            |    F.delay(Console.err.println("$oname.$methodName()")) *>
            |    F.delay(value.$methodName())
            |""".stripMargin
      else
        s"""|  def $methodName$typeParameterList($formalParameterList) =
            |    F.delay(Console.err.println(s"$oname.$methodName($arguments)")) *>
            |    F.delay(value.$methodName($argumentList))
            |""".stripMargin

    def asyncMethod: String =
      if (formalParameterList.isEmpty) s"  def $methodName = primitive(_.$methodName())"
      else s"  def $methodName$typeParameterList($formalParameterList) = primitive(_.$methodName($argumentList))"

  }

  // The Jdbc module for A
  private def jdbc[A](implicit ev: ClassTag[A]): String =
    s"""
      |package $pkg.jdbc
      |
      |${imports[A].mkString("\n")}
      |
      |/** Algebra of operations for `${ev.runtimeClass.getName}`. */
      |@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
      |trait Jdbc${ev.runtimeClass.getSimpleName}[F[_]] {
      |${operations[A].map(_.jdbcMethod).mkString("\n")}
      |}
      |""".trim.stripMargin

  // The Sync module for A
  private def sync[A](implicit ev: ClassTag[A]): String = {
    val oname = ev.runtimeClass.getSimpleName // original name, without name mapping
    val jname = s"Jdbc${oname}"
    val aname = s"Sync${oname}"
    s"""
      |package $pkg.sync
      |
      |import cats.effect.Sync
      |import cats.implicits._
      |import cats.syntax._
      |import $pkg.jdbc._
      |${imports[A].mkString("\n")}
      |
      |/**
      | * Implementation of $jname that wraps a $oname and lifts its primitive operations into any F
      | * given a Sync instance.
      | */
      |@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
      |class $aname[F[_]](value: $oname)(implicit F: Sync[F]) extends $jname[F] {
      |
      |${operations[A].map(_.syncMethod(oname)).mkString("\n")}
      |}
      |""".trim.stripMargin
    }

  // JdbcInterpreter
  def jdbcInterp: String = {

    def forType[A](implicit ev: ClassTag[A]): String = {
      val sname = ev.runtimeClass.getSimpleName
      s"def for$sname(a: $sname): Jdbc$sname[F]"
    }

    s"""
     |package $pkg.jdbc
     |
     |${managed.map(importStatement).mkString("\n")}
     |
     |trait JdbcInterpreter[F[_]] {
     |  ${managed.map(ClassTag(_)).map(forType(_)).mkString("\n  ") }
     |}
     |""".trim.stripMargin

  }

  // SyncInterpreter
  def syncInterp: String = {

    def forType[A](implicit ev: ClassTag[A]): String = {
      val sname = ev.runtimeClass.getSimpleName
      s"def for$sname(a: $sname) = new Sync$sname[F](a)"
    }

    s"""
     |package $pkg.sync
     |
     |import cats.effect.Sync
     |import $pkg.jdbc._
     |${managed.map(importStatement).mkString("\n")}
     |
     |object SyncInterpreter {
     |  def apply[F[_]: Sync]: JdbcInterpreter[F] =
     |    new JdbcInterpreter[F] {
     |      ${managed.map(ClassTag(_)).map(forType(_)).mkString("\n      ") }
     |    }
     |}
     |""".trim.stripMargin

  }

  def gen(baseDir: File): Unit = {
    import java.io._

    val jdbcDir = new File(baseDir, "jdbc")
    println("Generating tagless algebras into " + jdbcDir)
    managed.foreach { c =>
      jdbcDir.mkdirs
      val mod  = jdbc(ClassTag(c))
      val file = new File(jdbcDir, s"Jdbc${c.getSimpleName}.scala")
      val pw = new PrintWriter(file)
      pw.println(mod)
      pw.close()
      println(s"${c.getName} -> ${file.getName}")
    }

    val syncDir = new File(baseDir, "sync")
    println("Generating Sync interpreters into " + syncDir)
    managed.foreach { c =>
      syncDir.mkdirs
      val mod  = sync(ClassTag(c))
      val file = new File(syncDir, s"Sync${c.getSimpleName}.scala")
      val pw = new PrintWriter(file)
      pw.println(mod)
      pw.close()
      println(s"${c.getName} -> ${file.getName}")
    }

    {
      println("Generating JdbcInterpreter into " + jdbcDir)
      val file = new File(jdbcDir, s"JdbcInterpreter.scala")
      val pw = new PrintWriter(file)
      pw.println(jdbcInterp)
      pw.close()
      println(s"... -> ${file.getName}")
    }

    {
      println("Generating SyncInterpreter into " + syncDir)
      val file = new File(syncDir, s"SyncInterpreter.scala")
      val pw = new PrintWriter(file)
      pw.println(syncInterp)
      pw.close()
      println(s"... -> ${file.getName}")
    }

  }

}

object TGen {

  def main(args: scala.Array[String]): Unit =
    new TGen(
      List[Class[_]](
        classOf[java.sql.NClob],
        classOf[java.sql.Blob],
        classOf[java.sql.Clob],
        classOf[java.sql.DatabaseMetaData],
        classOf[java.sql.Driver],
        classOf[java.sql.Ref],
        classOf[java.sql.SQLData],
        classOf[java.sql.SQLInput],
        classOf[java.sql.SQLOutput],
        classOf[java.sql.Connection],
        classOf[java.sql.Statement],
        classOf[java.sql.PreparedStatement],
        classOf[java.sql.CallableStatement],
        classOf[java.sql.ResultSet]
      ),
      "doobie.tagless",
      Map(classOf[java.sql.Array] -> "SqlArray")
    ).gen(new File("./modules/tagless/src/main/scala/"))


}