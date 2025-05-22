package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class APP8_UPDATE_SINGLE_ROW {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		 
		String Query="update employee set esal='777' where ename='Durga'; ";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		int updatecount=st.executeUpdate(Query);
		
		System.out.println("the number of rows updated: "+updatecount);
		
		con.close();
	}

}
