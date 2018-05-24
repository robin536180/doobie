// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import cats.syntax._
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

  def allProceduresAreCallable =
    F.delay(Console.err.println("DatabaseMetaData.allProceduresAreCallable()")) *>
    F.delay(value.allProceduresAreCallable())

  def allTablesAreSelectable =
    F.delay(Console.err.println("DatabaseMetaData.allTablesAreSelectable()")) *>
    F.delay(value.allTablesAreSelectable())

  def autoCommitFailureClosesAllResultSets =
    F.delay(Console.err.println("DatabaseMetaData.autoCommitFailureClosesAllResultSets()")) *>
    F.delay(value.autoCommitFailureClosesAllResultSets())

  def dataDefinitionCausesTransactionCommit =
    F.delay(Console.err.println("DatabaseMetaData.dataDefinitionCausesTransactionCommit()")) *>
    F.delay(value.dataDefinitionCausesTransactionCommit())

  def dataDefinitionIgnoredInTransactions =
    F.delay(Console.err.println("DatabaseMetaData.dataDefinitionIgnoredInTransactions()")) *>
    F.delay(value.dataDefinitionIgnoredInTransactions())

  def deletesAreDetected(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.deletesAreDetected($a)")) *>
    F.delay(value.deletesAreDetected(a))

  def doesMaxRowSizeIncludeBlobs =
    F.delay(Console.err.println("DatabaseMetaData.doesMaxRowSizeIncludeBlobs()")) *>
    F.delay(value.doesMaxRowSizeIncludeBlobs())

  def generatedKeyAlwaysReturned =
    F.delay(Console.err.println("DatabaseMetaData.generatedKeyAlwaysReturned()")) *>
    F.delay(value.generatedKeyAlwaysReturned())

  def getAttributes(a: String, b: String, c: String, d: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getAttributes($a, $b, $c, $d)")) *>
    F.delay(value.getAttributes(a, b, c, d))

  def getBestRowIdentifier(a: String, b: String, c: String, d: Int, e: Boolean) =
    F.delay(Console.err.println(s"DatabaseMetaData.getBestRowIdentifier($a, $b, $c, $d, $e)")) *>
    F.delay(value.getBestRowIdentifier(a, b, c, d, e))

  def getCatalogSeparator =
    F.delay(Console.err.println("DatabaseMetaData.getCatalogSeparator()")) *>
    F.delay(value.getCatalogSeparator())

  def getCatalogTerm =
    F.delay(Console.err.println("DatabaseMetaData.getCatalogTerm()")) *>
    F.delay(value.getCatalogTerm())

  def getCatalogs =
    F.delay(Console.err.println("DatabaseMetaData.getCatalogs()")) *>
    F.delay(value.getCatalogs())

  def getClientInfoProperties =
    F.delay(Console.err.println("DatabaseMetaData.getClientInfoProperties()")) *>
    F.delay(value.getClientInfoProperties())

  def getColumnPrivileges(a: String, b: String, c: String, d: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getColumnPrivileges($a, $b, $c, $d)")) *>
    F.delay(value.getColumnPrivileges(a, b, c, d))

  def getColumns(a: String, b: String, c: String, d: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getColumns($a, $b, $c, $d)")) *>
    F.delay(value.getColumns(a, b, c, d))

  def getConnection =
    F.delay(Console.err.println("DatabaseMetaData.getConnection()")) *>
    F.delay(value.getConnection())

  def getCrossReference(a: String, b: String, c: String, d: String, e: String, f: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getCrossReference($a, $b, $c, $d, $e, $f)")) *>
    F.delay(value.getCrossReference(a, b, c, d, e, f))

  def getDatabaseMajorVersion =
    F.delay(Console.err.println("DatabaseMetaData.getDatabaseMajorVersion()")) *>
    F.delay(value.getDatabaseMajorVersion())

  def getDatabaseMinorVersion =
    F.delay(Console.err.println("DatabaseMetaData.getDatabaseMinorVersion()")) *>
    F.delay(value.getDatabaseMinorVersion())

  def getDatabaseProductName =
    F.delay(Console.err.println("DatabaseMetaData.getDatabaseProductName()")) *>
    F.delay(value.getDatabaseProductName())

  def getDatabaseProductVersion =
    F.delay(Console.err.println("DatabaseMetaData.getDatabaseProductVersion()")) *>
    F.delay(value.getDatabaseProductVersion())

  def getDefaultTransactionIsolation =
    F.delay(Console.err.println("DatabaseMetaData.getDefaultTransactionIsolation()")) *>
    F.delay(value.getDefaultTransactionIsolation())

  def getDriverMajorVersion =
    F.delay(Console.err.println("DatabaseMetaData.getDriverMajorVersion()")) *>
    F.delay(value.getDriverMajorVersion())

  def getDriverMinorVersion =
    F.delay(Console.err.println("DatabaseMetaData.getDriverMinorVersion()")) *>
    F.delay(value.getDriverMinorVersion())

  def getDriverName =
    F.delay(Console.err.println("DatabaseMetaData.getDriverName()")) *>
    F.delay(value.getDriverName())

  def getDriverVersion =
    F.delay(Console.err.println("DatabaseMetaData.getDriverVersion()")) *>
    F.delay(value.getDriverVersion())

  def getExportedKeys(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getExportedKeys($a, $b, $c)")) *>
    F.delay(value.getExportedKeys(a, b, c))

  def getExtraNameCharacters =
    F.delay(Console.err.println("DatabaseMetaData.getExtraNameCharacters()")) *>
    F.delay(value.getExtraNameCharacters())

  def getFunctionColumns(a: String, b: String, c: String, d: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getFunctionColumns($a, $b, $c, $d)")) *>
    F.delay(value.getFunctionColumns(a, b, c, d))

  def getFunctions(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getFunctions($a, $b, $c)")) *>
    F.delay(value.getFunctions(a, b, c))

  def getIdentifierQuoteString =
    F.delay(Console.err.println("DatabaseMetaData.getIdentifierQuoteString()")) *>
    F.delay(value.getIdentifierQuoteString())

  def getImportedKeys(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getImportedKeys($a, $b, $c)")) *>
    F.delay(value.getImportedKeys(a, b, c))

  def getIndexInfo(a: String, b: String, c: String, d: Boolean, e: Boolean) =
    F.delay(Console.err.println(s"DatabaseMetaData.getIndexInfo($a, $b, $c, $d, $e)")) *>
    F.delay(value.getIndexInfo(a, b, c, d, e))

  def getJDBCMajorVersion =
    F.delay(Console.err.println("DatabaseMetaData.getJDBCMajorVersion()")) *>
    F.delay(value.getJDBCMajorVersion())

  def getJDBCMinorVersion =
    F.delay(Console.err.println("DatabaseMetaData.getJDBCMinorVersion()")) *>
    F.delay(value.getJDBCMinorVersion())

  def getMaxBinaryLiteralLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxBinaryLiteralLength()")) *>
    F.delay(value.getMaxBinaryLiteralLength())

  def getMaxCatalogNameLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxCatalogNameLength()")) *>
    F.delay(value.getMaxCatalogNameLength())

  def getMaxCharLiteralLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxCharLiteralLength()")) *>
    F.delay(value.getMaxCharLiteralLength())

  def getMaxColumnNameLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxColumnNameLength()")) *>
    F.delay(value.getMaxColumnNameLength())

  def getMaxColumnsInGroupBy =
    F.delay(Console.err.println("DatabaseMetaData.getMaxColumnsInGroupBy()")) *>
    F.delay(value.getMaxColumnsInGroupBy())

  def getMaxColumnsInIndex =
    F.delay(Console.err.println("DatabaseMetaData.getMaxColumnsInIndex()")) *>
    F.delay(value.getMaxColumnsInIndex())

  def getMaxColumnsInOrderBy =
    F.delay(Console.err.println("DatabaseMetaData.getMaxColumnsInOrderBy()")) *>
    F.delay(value.getMaxColumnsInOrderBy())

  def getMaxColumnsInSelect =
    F.delay(Console.err.println("DatabaseMetaData.getMaxColumnsInSelect()")) *>
    F.delay(value.getMaxColumnsInSelect())

  def getMaxColumnsInTable =
    F.delay(Console.err.println("DatabaseMetaData.getMaxColumnsInTable()")) *>
    F.delay(value.getMaxColumnsInTable())

  def getMaxConnections =
    F.delay(Console.err.println("DatabaseMetaData.getMaxConnections()")) *>
    F.delay(value.getMaxConnections())

  def getMaxCursorNameLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxCursorNameLength()")) *>
    F.delay(value.getMaxCursorNameLength())

  def getMaxIndexLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxIndexLength()")) *>
    F.delay(value.getMaxIndexLength())

  def getMaxLogicalLobSize =
    F.delay(Console.err.println("DatabaseMetaData.getMaxLogicalLobSize()")) *>
    F.delay(value.getMaxLogicalLobSize())

  def getMaxProcedureNameLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxProcedureNameLength()")) *>
    F.delay(value.getMaxProcedureNameLength())

  def getMaxRowSize =
    F.delay(Console.err.println("DatabaseMetaData.getMaxRowSize()")) *>
    F.delay(value.getMaxRowSize())

  def getMaxSchemaNameLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxSchemaNameLength()")) *>
    F.delay(value.getMaxSchemaNameLength())

  def getMaxStatementLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxStatementLength()")) *>
    F.delay(value.getMaxStatementLength())

  def getMaxStatements =
    F.delay(Console.err.println("DatabaseMetaData.getMaxStatements()")) *>
    F.delay(value.getMaxStatements())

  def getMaxTableNameLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxTableNameLength()")) *>
    F.delay(value.getMaxTableNameLength())

  def getMaxTablesInSelect =
    F.delay(Console.err.println("DatabaseMetaData.getMaxTablesInSelect()")) *>
    F.delay(value.getMaxTablesInSelect())

  def getMaxUserNameLength =
    F.delay(Console.err.println("DatabaseMetaData.getMaxUserNameLength()")) *>
    F.delay(value.getMaxUserNameLength())

  def getNumericFunctions =
    F.delay(Console.err.println("DatabaseMetaData.getNumericFunctions()")) *>
    F.delay(value.getNumericFunctions())

  def getPrimaryKeys(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getPrimaryKeys($a, $b, $c)")) *>
    F.delay(value.getPrimaryKeys(a, b, c))

  def getProcedureColumns(a: String, b: String, c: String, d: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getProcedureColumns($a, $b, $c, $d)")) *>
    F.delay(value.getProcedureColumns(a, b, c, d))

  def getProcedureTerm =
    F.delay(Console.err.println("DatabaseMetaData.getProcedureTerm()")) *>
    F.delay(value.getProcedureTerm())

  def getProcedures(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getProcedures($a, $b, $c)")) *>
    F.delay(value.getProcedures(a, b, c))

  def getPseudoColumns(a: String, b: String, c: String, d: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getPseudoColumns($a, $b, $c, $d)")) *>
    F.delay(value.getPseudoColumns(a, b, c, d))

  def getResultSetHoldability =
    F.delay(Console.err.println("DatabaseMetaData.getResultSetHoldability()")) *>
    F.delay(value.getResultSetHoldability())

  def getRowIdLifetime =
    F.delay(Console.err.println("DatabaseMetaData.getRowIdLifetime()")) *>
    F.delay(value.getRowIdLifetime())

  def getSQLKeywords =
    F.delay(Console.err.println("DatabaseMetaData.getSQLKeywords()")) *>
    F.delay(value.getSQLKeywords())

  def getSQLStateType =
    F.delay(Console.err.println("DatabaseMetaData.getSQLStateType()")) *>
    F.delay(value.getSQLStateType())

  def getSchemaTerm =
    F.delay(Console.err.println("DatabaseMetaData.getSchemaTerm()")) *>
    F.delay(value.getSchemaTerm())

  def getSchemas =
    F.delay(Console.err.println("DatabaseMetaData.getSchemas()")) *>
    F.delay(value.getSchemas())

  def getSchemas(a: String, b: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getSchemas($a, $b)")) *>
    F.delay(value.getSchemas(a, b))

  def getSearchStringEscape =
    F.delay(Console.err.println("DatabaseMetaData.getSearchStringEscape()")) *>
    F.delay(value.getSearchStringEscape())

  def getStringFunctions =
    F.delay(Console.err.println("DatabaseMetaData.getStringFunctions()")) *>
    F.delay(value.getStringFunctions())

  def getSuperTables(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getSuperTables($a, $b, $c)")) *>
    F.delay(value.getSuperTables(a, b, c))

  def getSuperTypes(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getSuperTypes($a, $b, $c)")) *>
    F.delay(value.getSuperTypes(a, b, c))

  def getSystemFunctions =
    F.delay(Console.err.println("DatabaseMetaData.getSystemFunctions()")) *>
    F.delay(value.getSystemFunctions())

  def getTablePrivileges(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getTablePrivileges($a, $b, $c)")) *>
    F.delay(value.getTablePrivileges(a, b, c))

  def getTableTypes =
    F.delay(Console.err.println("DatabaseMetaData.getTableTypes()")) *>
    F.delay(value.getTableTypes())

  def getTables(a: String, b: String, c: String, d: Array[String]) =
    F.delay(Console.err.println(s"DatabaseMetaData.getTables($a, $b, $c, $d)")) *>
    F.delay(value.getTables(a, b, c, d))

  def getTimeDateFunctions =
    F.delay(Console.err.println("DatabaseMetaData.getTimeDateFunctions()")) *>
    F.delay(value.getTimeDateFunctions())

  def getTypeInfo =
    F.delay(Console.err.println("DatabaseMetaData.getTypeInfo()")) *>
    F.delay(value.getTypeInfo())

  def getUDTs(a: String, b: String, c: String, d: Array[Int]) =
    F.delay(Console.err.println(s"DatabaseMetaData.getUDTs($a, $b, $c, $d)")) *>
    F.delay(value.getUDTs(a, b, c, d))

  def getURL =
    F.delay(Console.err.println("DatabaseMetaData.getURL()")) *>
    F.delay(value.getURL())

  def getUserName =
    F.delay(Console.err.println("DatabaseMetaData.getUserName()")) *>
    F.delay(value.getUserName())

  def getVersionColumns(a: String, b: String, c: String) =
    F.delay(Console.err.println(s"DatabaseMetaData.getVersionColumns($a, $b, $c)")) *>
    F.delay(value.getVersionColumns(a, b, c))

  def insertsAreDetected(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.insertsAreDetected($a)")) *>
    F.delay(value.insertsAreDetected(a))

  def isCatalogAtStart =
    F.delay(Console.err.println("DatabaseMetaData.isCatalogAtStart()")) *>
    F.delay(value.isCatalogAtStart())

  def isReadOnly =
    F.delay(Console.err.println("DatabaseMetaData.isReadOnly()")) *>
    F.delay(value.isReadOnly())

  def isWrapperFor(a: Class[_]) =
    F.delay(Console.err.println(s"DatabaseMetaData.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def locatorsUpdateCopy =
    F.delay(Console.err.println("DatabaseMetaData.locatorsUpdateCopy()")) *>
    F.delay(value.locatorsUpdateCopy())

  def nullPlusNonNullIsNull =
    F.delay(Console.err.println("DatabaseMetaData.nullPlusNonNullIsNull()")) *>
    F.delay(value.nullPlusNonNullIsNull())

  def nullsAreSortedAtEnd =
    F.delay(Console.err.println("DatabaseMetaData.nullsAreSortedAtEnd()")) *>
    F.delay(value.nullsAreSortedAtEnd())

  def nullsAreSortedAtStart =
    F.delay(Console.err.println("DatabaseMetaData.nullsAreSortedAtStart()")) *>
    F.delay(value.nullsAreSortedAtStart())

  def nullsAreSortedHigh =
    F.delay(Console.err.println("DatabaseMetaData.nullsAreSortedHigh()")) *>
    F.delay(value.nullsAreSortedHigh())

  def nullsAreSortedLow =
    F.delay(Console.err.println("DatabaseMetaData.nullsAreSortedLow()")) *>
    F.delay(value.nullsAreSortedLow())

  def othersDeletesAreVisible(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.othersDeletesAreVisible($a)")) *>
    F.delay(value.othersDeletesAreVisible(a))

  def othersInsertsAreVisible(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.othersInsertsAreVisible($a)")) *>
    F.delay(value.othersInsertsAreVisible(a))

  def othersUpdatesAreVisible(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.othersUpdatesAreVisible($a)")) *>
    F.delay(value.othersUpdatesAreVisible(a))

  def ownDeletesAreVisible(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.ownDeletesAreVisible($a)")) *>
    F.delay(value.ownDeletesAreVisible(a))

  def ownInsertsAreVisible(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.ownInsertsAreVisible($a)")) *>
    F.delay(value.ownInsertsAreVisible(a))

  def ownUpdatesAreVisible(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.ownUpdatesAreVisible($a)")) *>
    F.delay(value.ownUpdatesAreVisible(a))

  def storesLowerCaseIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.storesLowerCaseIdentifiers()")) *>
    F.delay(value.storesLowerCaseIdentifiers())

  def storesLowerCaseQuotedIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.storesLowerCaseQuotedIdentifiers()")) *>
    F.delay(value.storesLowerCaseQuotedIdentifiers())

  def storesMixedCaseIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.storesMixedCaseIdentifiers()")) *>
    F.delay(value.storesMixedCaseIdentifiers())

  def storesMixedCaseQuotedIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.storesMixedCaseQuotedIdentifiers()")) *>
    F.delay(value.storesMixedCaseQuotedIdentifiers())

  def storesUpperCaseIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.storesUpperCaseIdentifiers()")) *>
    F.delay(value.storesUpperCaseIdentifiers())

  def storesUpperCaseQuotedIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.storesUpperCaseQuotedIdentifiers()")) *>
    F.delay(value.storesUpperCaseQuotedIdentifiers())

  def supportsANSI92EntryLevelSQL =
    F.delay(Console.err.println("DatabaseMetaData.supportsANSI92EntryLevelSQL()")) *>
    F.delay(value.supportsANSI92EntryLevelSQL())

  def supportsANSI92FullSQL =
    F.delay(Console.err.println("DatabaseMetaData.supportsANSI92FullSQL()")) *>
    F.delay(value.supportsANSI92FullSQL())

  def supportsANSI92IntermediateSQL =
    F.delay(Console.err.println("DatabaseMetaData.supportsANSI92IntermediateSQL()")) *>
    F.delay(value.supportsANSI92IntermediateSQL())

  def supportsAlterTableWithAddColumn =
    F.delay(Console.err.println("DatabaseMetaData.supportsAlterTableWithAddColumn()")) *>
    F.delay(value.supportsAlterTableWithAddColumn())

  def supportsAlterTableWithDropColumn =
    F.delay(Console.err.println("DatabaseMetaData.supportsAlterTableWithDropColumn()")) *>
    F.delay(value.supportsAlterTableWithDropColumn())

  def supportsBatchUpdates =
    F.delay(Console.err.println("DatabaseMetaData.supportsBatchUpdates()")) *>
    F.delay(value.supportsBatchUpdates())

  def supportsCatalogsInDataManipulation =
    F.delay(Console.err.println("DatabaseMetaData.supportsCatalogsInDataManipulation()")) *>
    F.delay(value.supportsCatalogsInDataManipulation())

  def supportsCatalogsInIndexDefinitions =
    F.delay(Console.err.println("DatabaseMetaData.supportsCatalogsInIndexDefinitions()")) *>
    F.delay(value.supportsCatalogsInIndexDefinitions())

  def supportsCatalogsInPrivilegeDefinitions =
    F.delay(Console.err.println("DatabaseMetaData.supportsCatalogsInPrivilegeDefinitions()")) *>
    F.delay(value.supportsCatalogsInPrivilegeDefinitions())

  def supportsCatalogsInProcedureCalls =
    F.delay(Console.err.println("DatabaseMetaData.supportsCatalogsInProcedureCalls()")) *>
    F.delay(value.supportsCatalogsInProcedureCalls())

  def supportsCatalogsInTableDefinitions =
    F.delay(Console.err.println("DatabaseMetaData.supportsCatalogsInTableDefinitions()")) *>
    F.delay(value.supportsCatalogsInTableDefinitions())

  def supportsColumnAliasing =
    F.delay(Console.err.println("DatabaseMetaData.supportsColumnAliasing()")) *>
    F.delay(value.supportsColumnAliasing())

  def supportsConvert =
    F.delay(Console.err.println("DatabaseMetaData.supportsConvert()")) *>
    F.delay(value.supportsConvert())

  def supportsConvert(a: Int, b: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.supportsConvert($a, $b)")) *>
    F.delay(value.supportsConvert(a, b))

  def supportsCoreSQLGrammar =
    F.delay(Console.err.println("DatabaseMetaData.supportsCoreSQLGrammar()")) *>
    F.delay(value.supportsCoreSQLGrammar())

  def supportsCorrelatedSubqueries =
    F.delay(Console.err.println("DatabaseMetaData.supportsCorrelatedSubqueries()")) *>
    F.delay(value.supportsCorrelatedSubqueries())

  def supportsDataDefinitionAndDataManipulationTransactions =
    F.delay(Console.err.println("DatabaseMetaData.supportsDataDefinitionAndDataManipulationTransactions()")) *>
    F.delay(value.supportsDataDefinitionAndDataManipulationTransactions())

  def supportsDataManipulationTransactionsOnly =
    F.delay(Console.err.println("DatabaseMetaData.supportsDataManipulationTransactionsOnly()")) *>
    F.delay(value.supportsDataManipulationTransactionsOnly())

  def supportsDifferentTableCorrelationNames =
    F.delay(Console.err.println("DatabaseMetaData.supportsDifferentTableCorrelationNames()")) *>
    F.delay(value.supportsDifferentTableCorrelationNames())

  def supportsExpressionsInOrderBy =
    F.delay(Console.err.println("DatabaseMetaData.supportsExpressionsInOrderBy()")) *>
    F.delay(value.supportsExpressionsInOrderBy())

  def supportsExtendedSQLGrammar =
    F.delay(Console.err.println("DatabaseMetaData.supportsExtendedSQLGrammar()")) *>
    F.delay(value.supportsExtendedSQLGrammar())

  def supportsFullOuterJoins =
    F.delay(Console.err.println("DatabaseMetaData.supportsFullOuterJoins()")) *>
    F.delay(value.supportsFullOuterJoins())

  def supportsGetGeneratedKeys =
    F.delay(Console.err.println("DatabaseMetaData.supportsGetGeneratedKeys()")) *>
    F.delay(value.supportsGetGeneratedKeys())

  def supportsGroupBy =
    F.delay(Console.err.println("DatabaseMetaData.supportsGroupBy()")) *>
    F.delay(value.supportsGroupBy())

  def supportsGroupByBeyondSelect =
    F.delay(Console.err.println("DatabaseMetaData.supportsGroupByBeyondSelect()")) *>
    F.delay(value.supportsGroupByBeyondSelect())

  def supportsGroupByUnrelated =
    F.delay(Console.err.println("DatabaseMetaData.supportsGroupByUnrelated()")) *>
    F.delay(value.supportsGroupByUnrelated())

  def supportsIntegrityEnhancementFacility =
    F.delay(Console.err.println("DatabaseMetaData.supportsIntegrityEnhancementFacility()")) *>
    F.delay(value.supportsIntegrityEnhancementFacility())

  def supportsLikeEscapeClause =
    F.delay(Console.err.println("DatabaseMetaData.supportsLikeEscapeClause()")) *>
    F.delay(value.supportsLikeEscapeClause())

  def supportsLimitedOuterJoins =
    F.delay(Console.err.println("DatabaseMetaData.supportsLimitedOuterJoins()")) *>
    F.delay(value.supportsLimitedOuterJoins())

  def supportsMinimumSQLGrammar =
    F.delay(Console.err.println("DatabaseMetaData.supportsMinimumSQLGrammar()")) *>
    F.delay(value.supportsMinimumSQLGrammar())

  def supportsMixedCaseIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.supportsMixedCaseIdentifiers()")) *>
    F.delay(value.supportsMixedCaseIdentifiers())

  def supportsMixedCaseQuotedIdentifiers =
    F.delay(Console.err.println("DatabaseMetaData.supportsMixedCaseQuotedIdentifiers()")) *>
    F.delay(value.supportsMixedCaseQuotedIdentifiers())

  def supportsMultipleOpenResults =
    F.delay(Console.err.println("DatabaseMetaData.supportsMultipleOpenResults()")) *>
    F.delay(value.supportsMultipleOpenResults())

  def supportsMultipleResultSets =
    F.delay(Console.err.println("DatabaseMetaData.supportsMultipleResultSets()")) *>
    F.delay(value.supportsMultipleResultSets())

  def supportsMultipleTransactions =
    F.delay(Console.err.println("DatabaseMetaData.supportsMultipleTransactions()")) *>
    F.delay(value.supportsMultipleTransactions())

  def supportsNamedParameters =
    F.delay(Console.err.println("DatabaseMetaData.supportsNamedParameters()")) *>
    F.delay(value.supportsNamedParameters())

  def supportsNonNullableColumns =
    F.delay(Console.err.println("DatabaseMetaData.supportsNonNullableColumns()")) *>
    F.delay(value.supportsNonNullableColumns())

  def supportsOpenCursorsAcrossCommit =
    F.delay(Console.err.println("DatabaseMetaData.supportsOpenCursorsAcrossCommit()")) *>
    F.delay(value.supportsOpenCursorsAcrossCommit())

  def supportsOpenCursorsAcrossRollback =
    F.delay(Console.err.println("DatabaseMetaData.supportsOpenCursorsAcrossRollback()")) *>
    F.delay(value.supportsOpenCursorsAcrossRollback())

  def supportsOpenStatementsAcrossCommit =
    F.delay(Console.err.println("DatabaseMetaData.supportsOpenStatementsAcrossCommit()")) *>
    F.delay(value.supportsOpenStatementsAcrossCommit())

  def supportsOpenStatementsAcrossRollback =
    F.delay(Console.err.println("DatabaseMetaData.supportsOpenStatementsAcrossRollback()")) *>
    F.delay(value.supportsOpenStatementsAcrossRollback())

  def supportsOrderByUnrelated =
    F.delay(Console.err.println("DatabaseMetaData.supportsOrderByUnrelated()")) *>
    F.delay(value.supportsOrderByUnrelated())

  def supportsOuterJoins =
    F.delay(Console.err.println("DatabaseMetaData.supportsOuterJoins()")) *>
    F.delay(value.supportsOuterJoins())

  def supportsPositionedDelete =
    F.delay(Console.err.println("DatabaseMetaData.supportsPositionedDelete()")) *>
    F.delay(value.supportsPositionedDelete())

  def supportsPositionedUpdate =
    F.delay(Console.err.println("DatabaseMetaData.supportsPositionedUpdate()")) *>
    F.delay(value.supportsPositionedUpdate())

  def supportsRefCursors =
    F.delay(Console.err.println("DatabaseMetaData.supportsRefCursors()")) *>
    F.delay(value.supportsRefCursors())

  def supportsResultSetConcurrency(a: Int, b: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.supportsResultSetConcurrency($a, $b)")) *>
    F.delay(value.supportsResultSetConcurrency(a, b))

  def supportsResultSetHoldability(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.supportsResultSetHoldability($a)")) *>
    F.delay(value.supportsResultSetHoldability(a))

  def supportsResultSetType(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.supportsResultSetType($a)")) *>
    F.delay(value.supportsResultSetType(a))

  def supportsSavepoints =
    F.delay(Console.err.println("DatabaseMetaData.supportsSavepoints()")) *>
    F.delay(value.supportsSavepoints())

  def supportsSchemasInDataManipulation =
    F.delay(Console.err.println("DatabaseMetaData.supportsSchemasInDataManipulation()")) *>
    F.delay(value.supportsSchemasInDataManipulation())

  def supportsSchemasInIndexDefinitions =
    F.delay(Console.err.println("DatabaseMetaData.supportsSchemasInIndexDefinitions()")) *>
    F.delay(value.supportsSchemasInIndexDefinitions())

  def supportsSchemasInPrivilegeDefinitions =
    F.delay(Console.err.println("DatabaseMetaData.supportsSchemasInPrivilegeDefinitions()")) *>
    F.delay(value.supportsSchemasInPrivilegeDefinitions())

  def supportsSchemasInProcedureCalls =
    F.delay(Console.err.println("DatabaseMetaData.supportsSchemasInProcedureCalls()")) *>
    F.delay(value.supportsSchemasInProcedureCalls())

  def supportsSchemasInTableDefinitions =
    F.delay(Console.err.println("DatabaseMetaData.supportsSchemasInTableDefinitions()")) *>
    F.delay(value.supportsSchemasInTableDefinitions())

  def supportsSelectForUpdate =
    F.delay(Console.err.println("DatabaseMetaData.supportsSelectForUpdate()")) *>
    F.delay(value.supportsSelectForUpdate())

  def supportsStatementPooling =
    F.delay(Console.err.println("DatabaseMetaData.supportsStatementPooling()")) *>
    F.delay(value.supportsStatementPooling())

  def supportsStoredFunctionsUsingCallSyntax =
    F.delay(Console.err.println("DatabaseMetaData.supportsStoredFunctionsUsingCallSyntax()")) *>
    F.delay(value.supportsStoredFunctionsUsingCallSyntax())

  def supportsStoredProcedures =
    F.delay(Console.err.println("DatabaseMetaData.supportsStoredProcedures()")) *>
    F.delay(value.supportsStoredProcedures())

  def supportsSubqueriesInComparisons =
    F.delay(Console.err.println("DatabaseMetaData.supportsSubqueriesInComparisons()")) *>
    F.delay(value.supportsSubqueriesInComparisons())

  def supportsSubqueriesInExists =
    F.delay(Console.err.println("DatabaseMetaData.supportsSubqueriesInExists()")) *>
    F.delay(value.supportsSubqueriesInExists())

  def supportsSubqueriesInIns =
    F.delay(Console.err.println("DatabaseMetaData.supportsSubqueriesInIns()")) *>
    F.delay(value.supportsSubqueriesInIns())

  def supportsSubqueriesInQuantifieds =
    F.delay(Console.err.println("DatabaseMetaData.supportsSubqueriesInQuantifieds()")) *>
    F.delay(value.supportsSubqueriesInQuantifieds())

  def supportsTableCorrelationNames =
    F.delay(Console.err.println("DatabaseMetaData.supportsTableCorrelationNames()")) *>
    F.delay(value.supportsTableCorrelationNames())

  def supportsTransactionIsolationLevel(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.supportsTransactionIsolationLevel($a)")) *>
    F.delay(value.supportsTransactionIsolationLevel(a))

  def supportsTransactions =
    F.delay(Console.err.println("DatabaseMetaData.supportsTransactions()")) *>
    F.delay(value.supportsTransactions())

  def supportsUnion =
    F.delay(Console.err.println("DatabaseMetaData.supportsUnion()")) *>
    F.delay(value.supportsUnion())

  def supportsUnionAll =
    F.delay(Console.err.println("DatabaseMetaData.supportsUnionAll()")) *>
    F.delay(value.supportsUnionAll())

  def unwrap[T](a: Class[T]) =
    F.delay(Console.err.println(s"DatabaseMetaData.unwrap($a)")) *>
    F.delay(value.unwrap(a))

  def updatesAreDetected(a: Int) =
    F.delay(Console.err.println(s"DatabaseMetaData.updatesAreDetected($a)")) *>
    F.delay(value.updatesAreDetected(a))

  def usesLocalFilePerTable =
    F.delay(Console.err.println("DatabaseMetaData.usesLocalFilePerTable()")) *>
    F.delay(value.usesLocalFilePerTable())

  def usesLocalFiles =
    F.delay(Console.err.println("DatabaseMetaData.usesLocalFiles()")) *>
    F.delay(value.usesLocalFiles())

}

