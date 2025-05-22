package DURGA_SOFT_JDBC_PROGRAMS;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class APP1_CREATE_TABLE {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		String query = "create table IF NOT EXISTS Employee(EmpId int,"
				+ "EmpName varchar(30),"
				+ "EmpSalary int,"
				+ "EmpAddress varchar(30));";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		st.executeUpdate(query);
		
		System.out.println("Created the table successfully");
		
		con.close();
	}

}
