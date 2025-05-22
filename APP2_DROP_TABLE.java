package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class APP2_DROP_TABLE {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		String query = "drop table employees;";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		st.executeUpdate(query);
		
		System.out.println("Dropped the table successfully");
		
		con.close();
	}

}
