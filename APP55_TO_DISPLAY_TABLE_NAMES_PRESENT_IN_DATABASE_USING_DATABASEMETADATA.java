package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class APP55_TO_DISPLAY_TABLE_NAMES_PRESENT_IN_DATABASE_USING_DATABASEMETADATA {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");

		DatabaseMetaData dbmd = con.getMetaData();
		
		String catalog=null;  
		
		String schemaPattern=null;  
		
		String tableNamePattern=null;  
		
		String[] types=null;   
		
		ResultSet rs = dbmd.getTables(catalog,schemaPattern,tableNamePattern,types);
		
		//the parameters can help limit the number of tables that are returned in the ResultSet
		//the ResultSet contains 10 columns and 3rd column represent table names. 
		int count =0;
		
		while(rs.next()) {
			count++;
			System.out.println(rs.getString(3)); 
		}
		 System.out.println("The number of tables:"+count);  
		 con.close();
		 
		
		
	}

}
