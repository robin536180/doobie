// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
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
class SyncDatabaseMetaData[F[_]](value: DatabaseMetaData)(implicit F: Sync[F]) extends JdbcDatabaseMetaData[F] {

  val allProceduresAreCallable: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.allProceduresAreCallable()")) *>
    F.delay(value.allProceduresAreCallable())

  val allTablesAreSelectable: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.allTablesAreSelectable()")) *>
    F.delay(value.allTablesAreSelectable())

  val autoCommitFailureClosesAllResultSets: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.autoCommitFailureClosesAllResultSets()")) *>
    F.delay(value.autoCommitFailureClosesAllResultSets())

  val dataDefinitionCausesTransactionCommit: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.dataDefinitionCausesTransactionCommit()")) *>
    F.delay(value.dataDefinitionCausesTransactionCommit())

  val dataDefinitionIgnoredInTransactions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.dataDefinitionIgnoredInTransactions()")) *>
    F.delay(value.dataDefinitionIgnoredInTransactions())

  def deletesAreDetected(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.deletesAreDetected($a)")) *>
    F.delay(value.deletesAreDetected(a))

  val doesMaxRowSizeIncludeBlobs: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.doesMaxRowSizeIncludeBlobs()")) *>
    F.delay(value.doesMaxRowSizeIncludeBlobs())

  val generatedKeyAlwaysReturned: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.generatedKeyAlwaysReturned()")) *>
    F.delay(value.generatedKeyAlwaysReturned())

  def getAttributes(a: String, b: String, c: String, d: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getAttributes($a, $b, $c, $d)")) *>
    F.delay(value.getAttributes(a, b, c, d))

  def getBestRowIdentifier(a: String, b: String, c: String, d: Int, e: Boolean): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getBestRowIdentifier($a, $b, $c, $d, $e)")) *>
    F.delay(value.getBestRowIdentifier(a, b, c, d, e))

  val getCatalogSeparator: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getCatalogSeparator()")) *>
    F.delay(value.getCatalogSeparator())

  val getCatalogTerm: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getCatalogTerm()")) *>
    F.delay(value.getCatalogTerm())

  val getCatalogs: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getCatalogs()")) *>
    F.delay(value.getCatalogs())

  val getClientInfoProperties: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getClientInfoProperties()")) *>
    F.delay(value.getClientInfoProperties())

  def getColumnPrivileges(a: String, b: String, c: String, d: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getColumnPrivileges($a, $b, $c, $d)")) *>
    F.delay(value.getColumnPrivileges(a, b, c, d))

  def getColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getColumns($a, $b, $c, $d)")) *>
    F.delay(value.getColumns(a, b, c, d))

  val getConnection: F[Connection] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getConnection()")) *>
    F.delay(value.getConnection())

  def getCrossReference(a: String, b: String, c: String, d: String, e: String, f: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getCrossReference($a, $b, $c, $d, $e, $f)")) *>
    F.delay(value.getCrossReference(a, b, c, d, e, f))

  val getDatabaseMajorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDatabaseMajorVersion()")) *>
    F.delay(value.getDatabaseMajorVersion())

  val getDatabaseMinorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDatabaseMinorVersion()")) *>
    F.delay(value.getDatabaseMinorVersion())

  val getDatabaseProductName: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDatabaseProductName()")) *>
    F.delay(value.getDatabaseProductName())

  val getDatabaseProductVersion: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDatabaseProductVersion()")) *>
    F.delay(value.getDatabaseProductVersion())

  val getDefaultTransactionIsolation: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDefaultTransactionIsolation()")) *>
    F.delay(value.getDefaultTransactionIsolation())

  val getDriverMajorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDriverMajorVersion()")) *>
    F.delay(value.getDriverMajorVersion())

  val getDriverMinorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDriverMinorVersion()")) *>
    F.delay(value.getDriverMinorVersion())

  val getDriverName: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDriverName()")) *>
    F.delay(value.getDriverName())

  val getDriverVersion: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getDriverVersion()")) *>
    F.delay(value.getDriverVersion())

  def getExportedKeys(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getExportedKeys($a, $b, $c)")) *>
    F.delay(value.getExportedKeys(a, b, c))

  val getExtraNameCharacters: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getExtraNameCharacters()")) *>
    F.delay(value.getExtraNameCharacters())

  def getFunctionColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getFunctionColumns($a, $b, $c, $d)")) *>
    F.delay(value.getFunctionColumns(a, b, c, d))

  def getFunctions(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getFunctions($a, $b, $c)")) *>
    F.delay(value.getFunctions(a, b, c))

  val getIdentifierQuoteString: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getIdentifierQuoteString()")) *>
    F.delay(value.getIdentifierQuoteString())

  def getImportedKeys(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getImportedKeys($a, $b, $c)")) *>
    F.delay(value.getImportedKeys(a, b, c))

  def getIndexInfo(a: String, b: String, c: String, d: Boolean, e: Boolean): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getIndexInfo($a, $b, $c, $d, $e)")) *>
    F.delay(value.getIndexInfo(a, b, c, d, e))

  val getJDBCMajorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getJDBCMajorVersion()")) *>
    F.delay(value.getJDBCMajorVersion())

  val getJDBCMinorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getJDBCMinorVersion()")) *>
    F.delay(value.getJDBCMinorVersion())

  val getMaxBinaryLiteralLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxBinaryLiteralLength()")) *>
    F.delay(value.getMaxBinaryLiteralLength())

  val getMaxCatalogNameLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxCatalogNameLength()")) *>
    F.delay(value.getMaxCatalogNameLength())

  val getMaxCharLiteralLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxCharLiteralLength()")) *>
    F.delay(value.getMaxCharLiteralLength())

  val getMaxColumnNameLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxColumnNameLength()")) *>
    F.delay(value.getMaxColumnNameLength())

  val getMaxColumnsInGroupBy: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxColumnsInGroupBy()")) *>
    F.delay(value.getMaxColumnsInGroupBy())

  val getMaxColumnsInIndex: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxColumnsInIndex()")) *>
    F.delay(value.getMaxColumnsInIndex())

  val getMaxColumnsInOrderBy: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxColumnsInOrderBy()")) *>
    F.delay(value.getMaxColumnsInOrderBy())

  val getMaxColumnsInSelect: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxColumnsInSelect()")) *>
    F.delay(value.getMaxColumnsInSelect())

  val getMaxColumnsInTable: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxColumnsInTable()")) *>
    F.delay(value.getMaxColumnsInTable())

  val getMaxConnections: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxConnections()")) *>
    F.delay(value.getMaxConnections())

  val getMaxCursorNameLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxCursorNameLength()")) *>
    F.delay(value.getMaxCursorNameLength())

  val getMaxIndexLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxIndexLength()")) *>
    F.delay(value.getMaxIndexLength())

  val getMaxLogicalLobSize: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxLogicalLobSize()")) *>
    F.delay(value.getMaxLogicalLobSize())

  val getMaxProcedureNameLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxProcedureNameLength()")) *>
    F.delay(value.getMaxProcedureNameLength())

  val getMaxRowSize: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxRowSize()")) *>
    F.delay(value.getMaxRowSize())

  val getMaxSchemaNameLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxSchemaNameLength()")) *>
    F.delay(value.getMaxSchemaNameLength())

  val getMaxStatementLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxStatementLength()")) *>
    F.delay(value.getMaxStatementLength())

  val getMaxStatements: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxStatements()")) *>
    F.delay(value.getMaxStatements())

  val getMaxTableNameLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxTableNameLength()")) *>
    F.delay(value.getMaxTableNameLength())

  val getMaxTablesInSelect: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxTablesInSelect()")) *>
    F.delay(value.getMaxTablesInSelect())

  val getMaxUserNameLength: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getMaxUserNameLength()")) *>
    F.delay(value.getMaxUserNameLength())

  val getNumericFunctions: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getNumericFunctions()")) *>
    F.delay(value.getNumericFunctions())

  def getPrimaryKeys(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getPrimaryKeys($a, $b, $c)")) *>
    F.delay(value.getPrimaryKeys(a, b, c))

  def getProcedureColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getProcedureColumns($a, $b, $c, $d)")) *>
    F.delay(value.getProcedureColumns(a, b, c, d))

  val getProcedureTerm: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getProcedureTerm()")) *>
    F.delay(value.getProcedureTerm())

  def getProcedures(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getProcedures($a, $b, $c)")) *>
    F.delay(value.getProcedures(a, b, c))

  def getPseudoColumns(a: String, b: String, c: String, d: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getPseudoColumns($a, $b, $c, $d)")) *>
    F.delay(value.getPseudoColumns(a, b, c, d))

  val getResultSetHoldability: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getResultSetHoldability()")) *>
    F.delay(value.getResultSetHoldability())

  val getRowIdLifetime: F[RowIdLifetime] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getRowIdLifetime()")) *>
    F.delay(value.getRowIdLifetime())

  val getSQLKeywords: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSQLKeywords()")) *>
    F.delay(value.getSQLKeywords())

  val getSQLStateType: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSQLStateType()")) *>
    F.delay(value.getSQLStateType())

  val getSchemaTerm: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSchemaTerm()")) *>
    F.delay(value.getSchemaTerm())

  val getSchemas: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSchemas()")) *>
    F.delay(value.getSchemas())

  def getSchemas(a: String, b: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSchemas($a, $b)")) *>
    F.delay(value.getSchemas(a, b))

  val getSearchStringEscape: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSearchStringEscape()")) *>
    F.delay(value.getSearchStringEscape())

  val getStringFunctions: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getStringFunctions()")) *>
    F.delay(value.getStringFunctions())

  def getSuperTables(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSuperTables($a, $b, $c)")) *>
    F.delay(value.getSuperTables(a, b, c))

  def getSuperTypes(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSuperTypes($a, $b, $c)")) *>
    F.delay(value.getSuperTypes(a, b, c))

  val getSystemFunctions: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getSystemFunctions()")) *>
    F.delay(value.getSystemFunctions())

  def getTablePrivileges(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getTablePrivileges($a, $b, $c)")) *>
    F.delay(value.getTablePrivileges(a, b, c))

  val getTableTypes: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getTableTypes()")) *>
    F.delay(value.getTableTypes())

  def getTables(a: String, b: String, c: String, d: Array[String]): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getTables($a, $b, $c, $d)")) *>
    F.delay(value.getTables(a, b, c, d))

  val getTimeDateFunctions: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getTimeDateFunctions()")) *>
    F.delay(value.getTimeDateFunctions())

  val getTypeInfo: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getTypeInfo()")) *>
    F.delay(value.getTypeInfo())

  def getUDTs(a: String, b: String, c: String, d: Array[Int]): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getUDTs($a, $b, $c, $d)")) *>
    F.delay(value.getUDTs(a, b, c, d))

  val getURL: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getURL()")) *>
    F.delay(value.getURL())

  val getUserName: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getUserName()")) *>
    F.delay(value.getUserName())

  def getVersionColumns(a: String, b: String, c: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.getVersionColumns($a, $b, $c)")) *>
    F.delay(value.getVersionColumns(a, b, c))

  def insertsAreDetected(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.insertsAreDetected($a)")) *>
    F.delay(value.insertsAreDetected(a))

  val isCatalogAtStart: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.isCatalogAtStart()")) *>
    F.delay(value.isCatalogAtStart())

  val isReadOnly: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.isReadOnly()")) *>
    F.delay(value.isReadOnly())

  def isWrapperFor(a: Class[_]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  val locatorsUpdateCopy: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.locatorsUpdateCopy()")) *>
    F.delay(value.locatorsUpdateCopy())

  val nullPlusNonNullIsNull: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.nullPlusNonNullIsNull()")) *>
    F.delay(value.nullPlusNonNullIsNull())

  val nullsAreSortedAtEnd: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.nullsAreSortedAtEnd()")) *>
    F.delay(value.nullsAreSortedAtEnd())

  val nullsAreSortedAtStart: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.nullsAreSortedAtStart()")) *>
    F.delay(value.nullsAreSortedAtStart())

  val nullsAreSortedHigh: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.nullsAreSortedHigh()")) *>
    F.delay(value.nullsAreSortedHigh())

  val nullsAreSortedLow: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.nullsAreSortedLow()")) *>
    F.delay(value.nullsAreSortedLow())

  def othersDeletesAreVisible(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.othersDeletesAreVisible($a)")) *>
    F.delay(value.othersDeletesAreVisible(a))

  def othersInsertsAreVisible(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.othersInsertsAreVisible($a)")) *>
    F.delay(value.othersInsertsAreVisible(a))

  def othersUpdatesAreVisible(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.othersUpdatesAreVisible($a)")) *>
    F.delay(value.othersUpdatesAreVisible(a))

  def ownDeletesAreVisible(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.ownDeletesAreVisible($a)")) *>
    F.delay(value.ownDeletesAreVisible(a))

  def ownInsertsAreVisible(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.ownInsertsAreVisible($a)")) *>
    F.delay(value.ownInsertsAreVisible(a))

  def ownUpdatesAreVisible(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.ownUpdatesAreVisible($a)")) *>
    F.delay(value.ownUpdatesAreVisible(a))

  val storesLowerCaseIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.storesLowerCaseIdentifiers()")) *>
    F.delay(value.storesLowerCaseIdentifiers())

  val storesLowerCaseQuotedIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.storesLowerCaseQuotedIdentifiers()")) *>
    F.delay(value.storesLowerCaseQuotedIdentifiers())

  val storesMixedCaseIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.storesMixedCaseIdentifiers()")) *>
    F.delay(value.storesMixedCaseIdentifiers())

  val storesMixedCaseQuotedIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.storesMixedCaseQuotedIdentifiers()")) *>
    F.delay(value.storesMixedCaseQuotedIdentifiers())

  val storesUpperCaseIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.storesUpperCaseIdentifiers()")) *>
    F.delay(value.storesUpperCaseIdentifiers())

  val storesUpperCaseQuotedIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.storesUpperCaseQuotedIdentifiers()")) *>
    F.delay(value.storesUpperCaseQuotedIdentifiers())

  val supportsANSI92EntryLevelSQL: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsANSI92EntryLevelSQL()")) *>
    F.delay(value.supportsANSI92EntryLevelSQL())

  val supportsANSI92FullSQL: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsANSI92FullSQL()")) *>
    F.delay(value.supportsANSI92FullSQL())

  val supportsANSI92IntermediateSQL: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsANSI92IntermediateSQL()")) *>
    F.delay(value.supportsANSI92IntermediateSQL())

  val supportsAlterTableWithAddColumn: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsAlterTableWithAddColumn()")) *>
    F.delay(value.supportsAlterTableWithAddColumn())

  val supportsAlterTableWithDropColumn: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsAlterTableWithDropColumn()")) *>
    F.delay(value.supportsAlterTableWithDropColumn())

  val supportsBatchUpdates: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsBatchUpdates()")) *>
    F.delay(value.supportsBatchUpdates())

  val supportsCatalogsInDataManipulation: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsCatalogsInDataManipulation()")) *>
    F.delay(value.supportsCatalogsInDataManipulation())

  val supportsCatalogsInIndexDefinitions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsCatalogsInIndexDefinitions()")) *>
    F.delay(value.supportsCatalogsInIndexDefinitions())

  val supportsCatalogsInPrivilegeDefinitions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsCatalogsInPrivilegeDefinitions()")) *>
    F.delay(value.supportsCatalogsInPrivilegeDefinitions())

  val supportsCatalogsInProcedureCalls: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsCatalogsInProcedureCalls()")) *>
    F.delay(value.supportsCatalogsInProcedureCalls())

  val supportsCatalogsInTableDefinitions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsCatalogsInTableDefinitions()")) *>
    F.delay(value.supportsCatalogsInTableDefinitions())

  val supportsColumnAliasing: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsColumnAliasing()")) *>
    F.delay(value.supportsColumnAliasing())

  val supportsConvert: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsConvert()")) *>
    F.delay(value.supportsConvert())

  def supportsConvert(a: Int, b: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsConvert($a, $b)")) *>
    F.delay(value.supportsConvert(a, b))

  val supportsCoreSQLGrammar: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsCoreSQLGrammar()")) *>
    F.delay(value.supportsCoreSQLGrammar())

  val supportsCorrelatedSubqueries: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsCorrelatedSubqueries()")) *>
    F.delay(value.supportsCorrelatedSubqueries())

  val supportsDataDefinitionAndDataManipulationTransactions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsDataDefinitionAndDataManipulationTransactions()")) *>
    F.delay(value.supportsDataDefinitionAndDataManipulationTransactions())

  val supportsDataManipulationTransactionsOnly: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsDataManipulationTransactionsOnly()")) *>
    F.delay(value.supportsDataManipulationTransactionsOnly())

  val supportsDifferentTableCorrelationNames: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsDifferentTableCorrelationNames()")) *>
    F.delay(value.supportsDifferentTableCorrelationNames())

  val supportsExpressionsInOrderBy: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsExpressionsInOrderBy()")) *>
    F.delay(value.supportsExpressionsInOrderBy())

  val supportsExtendedSQLGrammar: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsExtendedSQLGrammar()")) *>
    F.delay(value.supportsExtendedSQLGrammar())

  val supportsFullOuterJoins: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsFullOuterJoins()")) *>
    F.delay(value.supportsFullOuterJoins())

  val supportsGetGeneratedKeys: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsGetGeneratedKeys()")) *>
    F.delay(value.supportsGetGeneratedKeys())

  val supportsGroupBy: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsGroupBy()")) *>
    F.delay(value.supportsGroupBy())

  val supportsGroupByBeyondSelect: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsGroupByBeyondSelect()")) *>
    F.delay(value.supportsGroupByBeyondSelect())

  val supportsGroupByUnrelated: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsGroupByUnrelated()")) *>
    F.delay(value.supportsGroupByUnrelated())

  val supportsIntegrityEnhancementFacility: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsIntegrityEnhancementFacility()")) *>
    F.delay(value.supportsIntegrityEnhancementFacility())

  val supportsLikeEscapeClause: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsLikeEscapeClause()")) *>
    F.delay(value.supportsLikeEscapeClause())

  val supportsLimitedOuterJoins: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsLimitedOuterJoins()")) *>
    F.delay(value.supportsLimitedOuterJoins())

  val supportsMinimumSQLGrammar: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsMinimumSQLGrammar()")) *>
    F.delay(value.supportsMinimumSQLGrammar())

  val supportsMixedCaseIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsMixedCaseIdentifiers()")) *>
    F.delay(value.supportsMixedCaseIdentifiers())

  val supportsMixedCaseQuotedIdentifiers: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsMixedCaseQuotedIdentifiers()")) *>
    F.delay(value.supportsMixedCaseQuotedIdentifiers())

  val supportsMultipleOpenResults: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsMultipleOpenResults()")) *>
    F.delay(value.supportsMultipleOpenResults())

  val supportsMultipleResultSets: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsMultipleResultSets()")) *>
    F.delay(value.supportsMultipleResultSets())

  val supportsMultipleTransactions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsMultipleTransactions()")) *>
    F.delay(value.supportsMultipleTransactions())

  val supportsNamedParameters: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsNamedParameters()")) *>
    F.delay(value.supportsNamedParameters())

  val supportsNonNullableColumns: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsNonNullableColumns()")) *>
    F.delay(value.supportsNonNullableColumns())

  val supportsOpenCursorsAcrossCommit: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsOpenCursorsAcrossCommit()")) *>
    F.delay(value.supportsOpenCursorsAcrossCommit())

  val supportsOpenCursorsAcrossRollback: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsOpenCursorsAcrossRollback()")) *>
    F.delay(value.supportsOpenCursorsAcrossRollback())

  val supportsOpenStatementsAcrossCommit: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsOpenStatementsAcrossCommit()")) *>
    F.delay(value.supportsOpenStatementsAcrossCommit())

  val supportsOpenStatementsAcrossRollback: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsOpenStatementsAcrossRollback()")) *>
    F.delay(value.supportsOpenStatementsAcrossRollback())

  val supportsOrderByUnrelated: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsOrderByUnrelated()")) *>
    F.delay(value.supportsOrderByUnrelated())

  val supportsOuterJoins: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsOuterJoins()")) *>
    F.delay(value.supportsOuterJoins())

  val supportsPositionedDelete: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsPositionedDelete()")) *>
    F.delay(value.supportsPositionedDelete())

  val supportsPositionedUpdate: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsPositionedUpdate()")) *>
    F.delay(value.supportsPositionedUpdate())

  val supportsRefCursors: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsRefCursors()")) *>
    F.delay(value.supportsRefCursors())

  def supportsResultSetConcurrency(a: Int, b: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsResultSetConcurrency($a, $b)")) *>
    F.delay(value.supportsResultSetConcurrency(a, b))

  def supportsResultSetHoldability(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsResultSetHoldability($a)")) *>
    F.delay(value.supportsResultSetHoldability(a))

  def supportsResultSetType(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsResultSetType($a)")) *>
    F.delay(value.supportsResultSetType(a))

  val supportsSavepoints: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSavepoints()")) *>
    F.delay(value.supportsSavepoints())

  val supportsSchemasInDataManipulation: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSchemasInDataManipulation()")) *>
    F.delay(value.supportsSchemasInDataManipulation())

  val supportsSchemasInIndexDefinitions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSchemasInIndexDefinitions()")) *>
    F.delay(value.supportsSchemasInIndexDefinitions())

  val supportsSchemasInPrivilegeDefinitions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSchemasInPrivilegeDefinitions()")) *>
    F.delay(value.supportsSchemasInPrivilegeDefinitions())

  val supportsSchemasInProcedureCalls: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSchemasInProcedureCalls()")) *>
    F.delay(value.supportsSchemasInProcedureCalls())

  val supportsSchemasInTableDefinitions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSchemasInTableDefinitions()")) *>
    F.delay(value.supportsSchemasInTableDefinitions())

  val supportsSelectForUpdate: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSelectForUpdate()")) *>
    F.delay(value.supportsSelectForUpdate())

  val supportsStatementPooling: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsStatementPooling()")) *>
    F.delay(value.supportsStatementPooling())

  val supportsStoredFunctionsUsingCallSyntax: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsStoredFunctionsUsingCallSyntax()")) *>
    F.delay(value.supportsStoredFunctionsUsingCallSyntax())

  val supportsStoredProcedures: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsStoredProcedures()")) *>
    F.delay(value.supportsStoredProcedures())

  val supportsSubqueriesInComparisons: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSubqueriesInComparisons()")) *>
    F.delay(value.supportsSubqueriesInComparisons())

  val supportsSubqueriesInExists: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSubqueriesInExists()")) *>
    F.delay(value.supportsSubqueriesInExists())

  val supportsSubqueriesInIns: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSubqueriesInIns()")) *>
    F.delay(value.supportsSubqueriesInIns())

  val supportsSubqueriesInQuantifieds: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsSubqueriesInQuantifieds()")) *>
    F.delay(value.supportsSubqueriesInQuantifieds())

  val supportsTableCorrelationNames: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsTableCorrelationNames()")) *>
    F.delay(value.supportsTableCorrelationNames())

  def supportsTransactionIsolationLevel(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsTransactionIsolationLevel($a)")) *>
    F.delay(value.supportsTransactionIsolationLevel(a))

  val supportsTransactions: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsTransactions()")) *>
    F.delay(value.supportsTransactions())

  val supportsUnion: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsUnion()")) *>
    F.delay(value.supportsUnion())

  val supportsUnionAll: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.supportsUnionAll()")) *>
    F.delay(value.supportsUnionAll())

  def unwrap[T](a: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.unwrap($a)")) *>
    F.delay(value.unwrap(a))

  def updatesAreDetected(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.updatesAreDetected($a)")) *>
    F.delay(value.updatesAreDetected(a))

  val usesLocalFilePerTable: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.usesLocalFilePerTable()")) *>
    F.delay(value.usesLocalFilePerTable())

  val usesLocalFiles: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: DatabaseMetaData.usesLocalFiles()")) *>
    F.delay(value.usesLocalFiles())

}

