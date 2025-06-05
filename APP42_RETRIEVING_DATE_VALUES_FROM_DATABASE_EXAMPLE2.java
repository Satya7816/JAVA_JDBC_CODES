package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class APP42_RETRIEVING_DATE_VALUES_FROM_DATABASE_EXAMPLE2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// we have already created a table users1 with the columns [name, dop(date of proposal)]
		
		PreparedStatement pst = con.prepareStatement("select * from users1;");
		
		ResultSet rs = pst.executeQuery();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		while(rs.next()) {
			String name = rs.getString(1);
			java.sql.Date sdate = rs.getDate(2); 
			String s = sdf.format(sdate);
			System.out.println(name +"\t"+ s);
			
		}
		con.close();
	}

}
