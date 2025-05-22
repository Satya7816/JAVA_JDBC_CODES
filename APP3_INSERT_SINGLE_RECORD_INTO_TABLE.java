package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class APP3_INSERT_SINGLE_RECORD_INTO_TABLE {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		String query = "insert into employees values(100,'Durga',1000,'Hyd');";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		int updatecount = st.executeUpdate(query);
		
		System.out.println("no of rows inserted: "+updatecount);
		
		con.close();
	}

}
