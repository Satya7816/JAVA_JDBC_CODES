package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class APP18_DISPLAY_NO_OF_ROWS_USING_AGGREGATE_FUNCTION_COUNT {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		String sqlQuery = "select count(*) from employee;";
		
		ResultSet rs = st.executeQuery(sqlQuery);
		
		if(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		con.close();
		
	}

}
