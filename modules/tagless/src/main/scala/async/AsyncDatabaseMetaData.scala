// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.async

import cats.effect.Sync
import doobie.tagless.RTS
import doobie.tagless.jdbc._
import org.slf4j.Logger
import java.lang.Class
import java.lang.String
import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.ResultSet
import java.sql.RowIdLifetime

/**
 * Implementation of JdbcDatabaseMetaData that wraps a DatabaseMetaData and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncDatabaseMetaData[F[_]: Sync](value: DatabaseMetaData, rts: RTS[F], log: Logger) extends JdbcDatabaseMetaData[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} DatabaseMetaData".padTo(28, ' ')

  val allProceduresAreCallable: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id allProceduresAreCallable()")
        value.allProceduresAreCallable()
      }
    }

  val allTablesAreSelectable: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id allTablesAreSelectable()")
        value.allTablesAreSelectable()
      }
    }

  val autoCommitFailureClosesAllResultSets: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id autoCommitFailureClosesAllResultSets()")
        value.autoCommitFailureClosesAllResultSets()
      }
    }

  val dataDefinitionCausesTransactionCommit: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id dataDefinitionCausesTransactionCommit()")
        value.dataDefinitionCausesTransactionCommit()
      }
    }

  val dataDefinitionIgnoredInTransactions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id dataDefinitionIgnoredInTransactions()")
        value.dataDefinitionIgnoredInTransactions()
      }
    }

  def deletesAreDetected(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id deletesAreDetected($a)")
        value.deletesAreDetected(a)
      }
    }

  val doesMaxRowSizeIncludeBlobs: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id doesMaxRowSizeIncludeBlobs()")
        value.doesMaxRowSizeIncludeBlobs()
      }
    }

  val generatedKeyAlwaysReturned: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id generatedKeyAlwaysReturned()")
        value.generatedKeyAlwaysReturned()
      }
    }

  def getAttributes(a: String, b: String, c: String, d: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getAttributes($a, $b, $c, $d)")
        value.getAttributes(a, b, c, d)
      }
    }

  def getBestRowIdentifier(a: String, b: String, c: String, d: Int, e: Boolean): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBestRowIdentifier($a, $b, $c, $d, $e)")
        value.getBestRowIdentifier(a, b, c, d, e)
      }
    }

  val getCatalogSeparator: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCatalogSeparator()")
        value.getCatalogSeparator()
      }
    }

  val getCatalogTerm: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCatalogTerm()")
        value.getCatalogTerm()
      }
    }

  val getCatalogs: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCatalogs()")
        value.getCatalogs()
      }
    }

  val getClientInfoProperties: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getClientInfoProperties()")
        value.getClientInfoProperties()
      }
    }

  def getColumnPrivileges(a: String, b: String, c: String, d: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getColumnPrivileges($a, $b, $c, $d)")
        value.getColumnPrivileges(a, b, c, d)
      }
    }

  def getColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getColumns($a, $b, $c, $d)")
        value.getColumns(a, b, c, d)
      }
    }

  val getConnection: F[Connection] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getConnection()")
        value.getConnection()
      }
    }

  def getCrossReference(a: String, b: String, c: String, d: String, e: String, f: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCrossReference($a, $b, $c, $d, $e, $f)")
        value.getCrossReference(a, b, c, d, e, f)
      }
    }

  val getDatabaseMajorVersion: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDatabaseMajorVersion()")
        value.getDatabaseMajorVersion()
      }
    }

  val getDatabaseMinorVersion: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDatabaseMinorVersion()")
        value.getDatabaseMinorVersion()
      }
    }

  val getDatabaseProductName: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDatabaseProductName()")
        value.getDatabaseProductName()
      }
    }

  val getDatabaseProductVersion: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDatabaseProductVersion()")
        value.getDatabaseProductVersion()
      }
    }

  val getDefaultTransactionIsolation: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDefaultTransactionIsolation()")
        value.getDefaultTransactionIsolation()
      }
    }

  val getDriverMajorVersion: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDriverMajorVersion()")
        value.getDriverMajorVersion()
      }
    }

  val getDriverMinorVersion: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDriverMinorVersion()")
        value.getDriverMinorVersion()
      }
    }

  val getDriverName: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDriverName()")
        value.getDriverName()
      }
    }

  val getDriverVersion: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDriverVersion()")
        value.getDriverVersion()
      }
    }

  def getExportedKeys(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getExportedKeys($a, $b, $c)")
        value.getExportedKeys(a, b, c)
      }
    }

  val getExtraNameCharacters: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getExtraNameCharacters()")
        value.getExtraNameCharacters()
      }
    }

  def getFunctionColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getFunctionColumns($a, $b, $c, $d)")
        value.getFunctionColumns(a, b, c, d)
      }
    }

  def getFunctions(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getFunctions($a, $b, $c)")
        value.getFunctions(a, b, c)
      }
    }

  val getIdentifierQuoteString: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getIdentifierQuoteString()")
        value.getIdentifierQuoteString()
      }
    }

  def getImportedKeys(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getImportedKeys($a, $b, $c)")
        value.getImportedKeys(a, b, c)
      }
    }

  def getIndexInfo(a: String, b: String, c: String, d: Boolean, e: Boolean): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getIndexInfo($a, $b, $c, $d, $e)")
        value.getIndexInfo(a, b, c, d, e)
      }
    }

  val getJDBCMajorVersion: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getJDBCMajorVersion()")
        value.getJDBCMajorVersion()
      }
    }

  val getJDBCMinorVersion: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getJDBCMinorVersion()")
        value.getJDBCMinorVersion()
      }
    }

  val getMaxBinaryLiteralLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxBinaryLiteralLength()")
        value.getMaxBinaryLiteralLength()
      }
    }

  val getMaxCatalogNameLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxCatalogNameLength()")
        value.getMaxCatalogNameLength()
      }
    }

  val getMaxCharLiteralLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxCharLiteralLength()")
        value.getMaxCharLiteralLength()
      }
    }

  val getMaxColumnNameLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxColumnNameLength()")
        value.getMaxColumnNameLength()
      }
    }

  val getMaxColumnsInGroupBy: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxColumnsInGroupBy()")
        value.getMaxColumnsInGroupBy()
      }
    }

  val getMaxColumnsInIndex: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxColumnsInIndex()")
        value.getMaxColumnsInIndex()
      }
    }

  val getMaxColumnsInOrderBy: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxColumnsInOrderBy()")
        value.getMaxColumnsInOrderBy()
      }
    }

  val getMaxColumnsInSelect: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxColumnsInSelect()")
        value.getMaxColumnsInSelect()
      }
    }

  val getMaxColumnsInTable: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxColumnsInTable()")
        value.getMaxColumnsInTable()
      }
    }

  val getMaxConnections: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxConnections()")
        value.getMaxConnections()
      }
    }

  val getMaxCursorNameLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxCursorNameLength()")
        value.getMaxCursorNameLength()
      }
    }

  val getMaxIndexLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxIndexLength()")
        value.getMaxIndexLength()
      }
    }

  val getMaxLogicalLobSize: F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxLogicalLobSize()")
        value.getMaxLogicalLobSize()
      }
    }

  val getMaxProcedureNameLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxProcedureNameLength()")
        value.getMaxProcedureNameLength()
      }
    }

  val getMaxRowSize: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxRowSize()")
        value.getMaxRowSize()
      }
    }

  val getMaxSchemaNameLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxSchemaNameLength()")
        value.getMaxSchemaNameLength()
      }
    }

  val getMaxStatementLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxStatementLength()")
        value.getMaxStatementLength()
      }
    }

  val getMaxStatements: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxStatements()")
        value.getMaxStatements()
      }
    }

  val getMaxTableNameLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxTableNameLength()")
        value.getMaxTableNameLength()
      }
    }

  val getMaxTablesInSelect: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxTablesInSelect()")
        value.getMaxTablesInSelect()
      }
    }

  val getMaxUserNameLength: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxUserNameLength()")
        value.getMaxUserNameLength()
      }
    }

  val getNumericFunctions: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNumericFunctions()")
        value.getNumericFunctions()
      }
    }

  def getPrimaryKeys(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getPrimaryKeys($a, $b, $c)")
        value.getPrimaryKeys(a, b, c)
      }
    }

  def getProcedureColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getProcedureColumns($a, $b, $c, $d)")
        value.getProcedureColumns(a, b, c, d)
      }
    }

  val getProcedureTerm: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getProcedureTerm()")
        value.getProcedureTerm()
      }
    }

  def getProcedures(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getProcedures($a, $b, $c)")
        value.getProcedures(a, b, c)
      }
    }

  def getPseudoColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getPseudoColumns($a, $b, $c, $d)")
        value.getPseudoColumns(a, b, c, d)
      }
    }

  val getResultSetHoldability: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getResultSetHoldability()")
        value.getResultSetHoldability()
      }
    }

  val getRowIdLifetime: F[RowIdLifetime] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getRowIdLifetime()")
        value.getRowIdLifetime()
      }
    }

  val getSQLKeywords: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSQLKeywords()")
        value.getSQLKeywords()
      }
    }

  val getSQLStateType: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSQLStateType()")
        value.getSQLStateType()
      }
    }

  val getSchemaTerm: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSchemaTerm()")
        value.getSchemaTerm()
      }
    }

  val getSchemas: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSchemas()")
        value.getSchemas()
      }
    }

  def getSchemas(a: String, b: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSchemas($a, $b)")
        value.getSchemas(a, b)
      }
    }

  val getSearchStringEscape: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSearchStringEscape()")
        value.getSearchStringEscape()
      }
    }

  val getStringFunctions: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getStringFunctions()")
        value.getStringFunctions()
      }
    }

  def getSuperTables(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSuperTables($a, $b, $c)")
        value.getSuperTables(a, b, c)
      }
    }

  def getSuperTypes(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSuperTypes($a, $b, $c)")
        value.getSuperTypes(a, b, c)
      }
    }

  val getSystemFunctions: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSystemFunctions()")
        value.getSystemFunctions()
      }
    }

  def getTablePrivileges(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTablePrivileges($a, $b, $c)")
        value.getTablePrivileges(a, b, c)
      }
    }

  val getTableTypes: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTableTypes()")
        value.getTableTypes()
      }
    }

  def getTables(a: String, b: String, c: String, d: Array[String]): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTables($a, $b, $c, $d)")
        value.getTables(a, b, c, d)
      }
    }

  val getTimeDateFunctions: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTimeDateFunctions()")
        value.getTimeDateFunctions()
      }
    }

  val getTypeInfo: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTypeInfo()")
        value.getTypeInfo()
      }
    }

  def getUDTs(a: String, b: String, c: String, d: Array[Int]): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getUDTs($a, $b, $c, $d)")
        value.getUDTs(a, b, c, d)
      }
    }

  val getURL: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getURL()")
        value.getURL()
      }
    }

  val getUserName: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getUserName()")
        value.getUserName()
      }
    }

  def getVersionColumns(a: String, b: String, c: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getVersionColumns($a, $b, $c)")
        value.getVersionColumns(a, b, c)
      }
    }

  def insertsAreDetected(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id insertsAreDetected($a)")
        value.insertsAreDetected(a)
      }
    }

  val isCatalogAtStart: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isCatalogAtStart()")
        value.isCatalogAtStart()
      }
    }

  val isReadOnly: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isReadOnly()")
        value.isReadOnly()
      }
    }

  def isWrapperFor(a: Class[_]): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isWrapperFor($a)")
        value.isWrapperFor(a)
      }
    }

  val locatorsUpdateCopy: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id locatorsUpdateCopy()")
        value.locatorsUpdateCopy()
      }
    }

  val nullPlusNonNullIsNull: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id nullPlusNonNullIsNull()")
        value.nullPlusNonNullIsNull()
      }
    }

  val nullsAreSortedAtEnd: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id nullsAreSortedAtEnd()")
        value.nullsAreSortedAtEnd()
      }
    }

  val nullsAreSortedAtStart: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id nullsAreSortedAtStart()")
        value.nullsAreSortedAtStart()
      }
    }

  val nullsAreSortedHigh: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id nullsAreSortedHigh()")
        value.nullsAreSortedHigh()
      }
    }

  val nullsAreSortedLow: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id nullsAreSortedLow()")
        value.nullsAreSortedLow()
      }
    }

  def othersDeletesAreVisible(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id othersDeletesAreVisible($a)")
        value.othersDeletesAreVisible(a)
      }
    }

  def othersInsertsAreVisible(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id othersInsertsAreVisible($a)")
        value.othersInsertsAreVisible(a)
      }
    }

  def othersUpdatesAreVisible(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id othersUpdatesAreVisible($a)")
        value.othersUpdatesAreVisible(a)
      }
    }

  def ownDeletesAreVisible(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id ownDeletesAreVisible($a)")
        value.ownDeletesAreVisible(a)
      }
    }

  def ownInsertsAreVisible(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id ownInsertsAreVisible($a)")
        value.ownInsertsAreVisible(a)
      }
    }

  def ownUpdatesAreVisible(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id ownUpdatesAreVisible($a)")
        value.ownUpdatesAreVisible(a)
      }
    }

  val storesLowerCaseIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id storesLowerCaseIdentifiers()")
        value.storesLowerCaseIdentifiers()
      }
    }

  val storesLowerCaseQuotedIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id storesLowerCaseQuotedIdentifiers()")
        value.storesLowerCaseQuotedIdentifiers()
      }
    }

  val storesMixedCaseIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id storesMixedCaseIdentifiers()")
        value.storesMixedCaseIdentifiers()
      }
    }

  val storesMixedCaseQuotedIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id storesMixedCaseQuotedIdentifiers()")
        value.storesMixedCaseQuotedIdentifiers()
      }
    }

  val storesUpperCaseIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id storesUpperCaseIdentifiers()")
        value.storesUpperCaseIdentifiers()
      }
    }

  val storesUpperCaseQuotedIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id storesUpperCaseQuotedIdentifiers()")
        value.storesUpperCaseQuotedIdentifiers()
      }
    }

  val supportsANSI92EntryLevelSQL: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsANSI92EntryLevelSQL()")
        value.supportsANSI92EntryLevelSQL()
      }
    }

  val supportsANSI92FullSQL: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsANSI92FullSQL()")
        value.supportsANSI92FullSQL()
      }
    }

  val supportsANSI92IntermediateSQL: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsANSI92IntermediateSQL()")
        value.supportsANSI92IntermediateSQL()
      }
    }

  val supportsAlterTableWithAddColumn: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsAlterTableWithAddColumn()")
        value.supportsAlterTableWithAddColumn()
      }
    }

  val supportsAlterTableWithDropColumn: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsAlterTableWithDropColumn()")
        value.supportsAlterTableWithDropColumn()
      }
    }

  val supportsBatchUpdates: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsBatchUpdates()")
        value.supportsBatchUpdates()
      }
    }

  val supportsCatalogsInDataManipulation: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsCatalogsInDataManipulation()")
        value.supportsCatalogsInDataManipulation()
      }
    }

  val supportsCatalogsInIndexDefinitions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsCatalogsInIndexDefinitions()")
        value.supportsCatalogsInIndexDefinitions()
      }
    }

  val supportsCatalogsInPrivilegeDefinitions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsCatalogsInPrivilegeDefinitions()")
        value.supportsCatalogsInPrivilegeDefinitions()
      }
    }

  val supportsCatalogsInProcedureCalls: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsCatalogsInProcedureCalls()")
        value.supportsCatalogsInProcedureCalls()
      }
    }

  val supportsCatalogsInTableDefinitions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsCatalogsInTableDefinitions()")
        value.supportsCatalogsInTableDefinitions()
      }
    }

  val supportsColumnAliasing: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsColumnAliasing()")
        value.supportsColumnAliasing()
      }
    }

  val supportsConvert: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsConvert()")
        value.supportsConvert()
      }
    }

  def supportsConvert(a: Int, b: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsConvert($a, $b)")
        value.supportsConvert(a, b)
      }
    }

  val supportsCoreSQLGrammar: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsCoreSQLGrammar()")
        value.supportsCoreSQLGrammar()
      }
    }

  val supportsCorrelatedSubqueries: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsCorrelatedSubqueries()")
        value.supportsCorrelatedSubqueries()
      }
    }

  val supportsDataDefinitionAndDataManipulationTransactions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsDataDefinitionAndDataManipulationTransactions()")
        value.supportsDataDefinitionAndDataManipulationTransactions()
      }
    }

  val supportsDataManipulationTransactionsOnly: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsDataManipulationTransactionsOnly()")
        value.supportsDataManipulationTransactionsOnly()
      }
    }

  val supportsDifferentTableCorrelationNames: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsDifferentTableCorrelationNames()")
        value.supportsDifferentTableCorrelationNames()
      }
    }

  val supportsExpressionsInOrderBy: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsExpressionsInOrderBy()")
        value.supportsExpressionsInOrderBy()
      }
    }

  val supportsExtendedSQLGrammar: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsExtendedSQLGrammar()")
        value.supportsExtendedSQLGrammar()
      }
    }

  val supportsFullOuterJoins: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsFullOuterJoins()")
        value.supportsFullOuterJoins()
      }
    }

  val supportsGetGeneratedKeys: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsGetGeneratedKeys()")
        value.supportsGetGeneratedKeys()
      }
    }

  val supportsGroupBy: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsGroupBy()")
        value.supportsGroupBy()
      }
    }

  val supportsGroupByBeyondSelect: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsGroupByBeyondSelect()")
        value.supportsGroupByBeyondSelect()
      }
    }

  val supportsGroupByUnrelated: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsGroupByUnrelated()")
        value.supportsGroupByUnrelated()
      }
    }

  val supportsIntegrityEnhancementFacility: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsIntegrityEnhancementFacility()")
        value.supportsIntegrityEnhancementFacility()
      }
    }

  val supportsLikeEscapeClause: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsLikeEscapeClause()")
        value.supportsLikeEscapeClause()
      }
    }

  val supportsLimitedOuterJoins: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsLimitedOuterJoins()")
        value.supportsLimitedOuterJoins()
      }
    }

  val supportsMinimumSQLGrammar: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsMinimumSQLGrammar()")
        value.supportsMinimumSQLGrammar()
      }
    }

  val supportsMixedCaseIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsMixedCaseIdentifiers()")
        value.supportsMixedCaseIdentifiers()
      }
    }

  val supportsMixedCaseQuotedIdentifiers: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsMixedCaseQuotedIdentifiers()")
        value.supportsMixedCaseQuotedIdentifiers()
      }
    }

  val supportsMultipleOpenResults: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsMultipleOpenResults()")
        value.supportsMultipleOpenResults()
      }
    }

  val supportsMultipleResultSets: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsMultipleResultSets()")
        value.supportsMultipleResultSets()
      }
    }

  val supportsMultipleTransactions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsMultipleTransactions()")
        value.supportsMultipleTransactions()
      }
    }

  val supportsNamedParameters: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsNamedParameters()")
        value.supportsNamedParameters()
      }
    }

  val supportsNonNullableColumns: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsNonNullableColumns()")
        value.supportsNonNullableColumns()
      }
    }

  val supportsOpenCursorsAcrossCommit: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsOpenCursorsAcrossCommit()")
        value.supportsOpenCursorsAcrossCommit()
      }
    }

  val supportsOpenCursorsAcrossRollback: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsOpenCursorsAcrossRollback()")
        value.supportsOpenCursorsAcrossRollback()
      }
    }

  val supportsOpenStatementsAcrossCommit: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsOpenStatementsAcrossCommit()")
        value.supportsOpenStatementsAcrossCommit()
      }
    }

  val supportsOpenStatementsAcrossRollback: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsOpenStatementsAcrossRollback()")
        value.supportsOpenStatementsAcrossRollback()
      }
    }

  val supportsOrderByUnrelated: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsOrderByUnrelated()")
        value.supportsOrderByUnrelated()
      }
    }

  val supportsOuterJoins: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsOuterJoins()")
        value.supportsOuterJoins()
      }
    }

  val supportsPositionedDelete: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsPositionedDelete()")
        value.supportsPositionedDelete()
      }
    }

  val supportsPositionedUpdate: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsPositionedUpdate()")
        value.supportsPositionedUpdate()
      }
    }

  val supportsRefCursors: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsRefCursors()")
        value.supportsRefCursors()
      }
    }

  def supportsResultSetConcurrency(a: Int, b: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsResultSetConcurrency($a, $b)")
        value.supportsResultSetConcurrency(a, b)
      }
    }

  def supportsResultSetHoldability(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsResultSetHoldability($a)")
        value.supportsResultSetHoldability(a)
      }
    }

  def supportsResultSetType(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsResultSetType($a)")
        value.supportsResultSetType(a)
      }
    }

  val supportsSavepoints: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSavepoints()")
        value.supportsSavepoints()
      }
    }

  val supportsSchemasInDataManipulation: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSchemasInDataManipulation()")
        value.supportsSchemasInDataManipulation()
      }
    }

  val supportsSchemasInIndexDefinitions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSchemasInIndexDefinitions()")
        value.supportsSchemasInIndexDefinitions()
      }
    }

  val supportsSchemasInPrivilegeDefinitions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSchemasInPrivilegeDefinitions()")
        value.supportsSchemasInPrivilegeDefinitions()
      }
    }

  val supportsSchemasInProcedureCalls: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSchemasInProcedureCalls()")
        value.supportsSchemasInProcedureCalls()
      }
    }

  val supportsSchemasInTableDefinitions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSchemasInTableDefinitions()")
        value.supportsSchemasInTableDefinitions()
      }
    }

  val supportsSelectForUpdate: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSelectForUpdate()")
        value.supportsSelectForUpdate()
      }
    }

  val supportsStatementPooling: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsStatementPooling()")
        value.supportsStatementPooling()
      }
    }

  val supportsStoredFunctionsUsingCallSyntax: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsStoredFunctionsUsingCallSyntax()")
        value.supportsStoredFunctionsUsingCallSyntax()
      }
    }

  val supportsStoredProcedures: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsStoredProcedures()")
        value.supportsStoredProcedures()
      }
    }

  val supportsSubqueriesInComparisons: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSubqueriesInComparisons()")
        value.supportsSubqueriesInComparisons()
      }
    }

  val supportsSubqueriesInExists: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSubqueriesInExists()")
        value.supportsSubqueriesInExists()
      }
    }

  val supportsSubqueriesInIns: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSubqueriesInIns()")
        value.supportsSubqueriesInIns()
      }
    }

  val supportsSubqueriesInQuantifieds: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsSubqueriesInQuantifieds()")
        value.supportsSubqueriesInQuantifieds()
      }
    }

  val supportsTableCorrelationNames: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsTableCorrelationNames()")
        value.supportsTableCorrelationNames()
      }
    }

  def supportsTransactionIsolationLevel(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsTransactionIsolationLevel($a)")
        value.supportsTransactionIsolationLevel(a)
      }
    }

  val supportsTransactions: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsTransactions()")
        value.supportsTransactions()
      }
    }

  val supportsUnion: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsUnion()")
        value.supportsUnion()
      }
    }

  val supportsUnionAll: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id supportsUnionAll()")
        value.supportsUnionAll()
      }
    }

  def unwrap[T](a: Class[T]): F[T] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id unwrap($a)")
        value.unwrap(a)
      }
    }

  def updatesAreDetected(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updatesAreDetected($a)")
        value.updatesAreDetected(a)
      }
    }

  val usesLocalFilePerTable: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id usesLocalFilePerTable()")
        value.usesLocalFilePerTable()
      }
    }

  val usesLocalFiles: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id usesLocalFiles()")
        value.usesLocalFiles()
      }
    }

}

