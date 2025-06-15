package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class APP54_TO_DEMONSTRATE_DATABASEMETADATA {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");

		DatabaseMetaData dbmd = con.getMetaData();
		
		System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
		System.out.println("Database Product version: "+dbmd.getDatabaseProductVersion());
		System.out.println("Database major version: "+dbmd.getDatabaseMajorVersion());
		System.out.println("Database minor version: "+dbmd.getDatabaseMinorVersion());
		System.out.println("JDBC major version: "+dbmd.getJDBCMajorVersion());
		System.out.println("JDBC minor version: "+dbmd.getJDBCMinorVersion());
		System.out.println("Driver Name: "+dbmd.getDriverName());
		System.out.println("Driver Version: "+dbmd.getDriverVersion());
		System.out.println("URL: "+dbmd.getURL());
		System.out.println("UserName:"+dbmd.getUserName());
		System.out.println("Max Columns In Table: "+dbmd.getMaxColumnsInTable());
		System.out.println("Max Row Size:"+dbmd.getMaxRowSize());
		System.out.println("Max statement length: "+dbmd.getMaxStatementLength());
		System.out.println("Max Tables In Select: "+dbmd.getMaxTablesInSelect());
		System.out.println("SQL keywords: "+dbmd.getSQLKeywords());
		System.out.println("Numeric Functions: "+dbmd.getNumericFunctions());
		System.out.println("String functions: "+dbmd.getStringFunctions());
		System.out.println("System Functions: "+dbmd.getSystemFunctions());
		System.out.println("Supports full outer joins or not: "+dbmd.supportsFullOuterJoins());
		System.out.println("Supports stored procedure or not: "+dbmd.supportsStoredProcedures());

		

		
	}

}
