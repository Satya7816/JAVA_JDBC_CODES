package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class APP41_RETRIEVING_DATE_VALUES_FROM_DATABASE_EXAMPLE1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// we have already created a table users1 with the columns [name, dop(date of proposal)]
		
		PreparedStatement pst = con.prepareStatement("select * from users1;");
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			// we can use in to ways here
			// type1
			String name = rs.getString(1);
			java.sql.Date sdate = rs.getDate(2);
			System.out.println(name +"\n"+ sdate);
			
			
			// type2
			//System.out.println(rs.getString(1)+"\t"+rs.getDate(2));
		}
	}

}
