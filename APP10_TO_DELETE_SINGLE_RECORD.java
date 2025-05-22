package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class APP10_TO_DELETE_SINGLE_RECORD {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		String Query="delete from employees where ename='Sunny'";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		int updatecount = st.executeUpdate(Query);
		
		System.out.println("The number of rows deleted"+updatecount);
		
		con.close();
	}

}
