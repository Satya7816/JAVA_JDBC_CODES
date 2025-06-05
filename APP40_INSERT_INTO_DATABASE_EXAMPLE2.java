package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class APP40_INSERT_INTO_DATABASE_EXAMPLE2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// we have already created a table users1 with the columns [name, dop(date of proposal)]
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name: ");
		String name = sc.next();
		
		System.out.println("enter the date[yyyy-mm-dd]: ");
		String dop = sc.next();

        java.sql.Date sdate = java.sql.Date.valueOf(dop);
		PreparedStatement pst = con.prepareStatement("insert into users1 values(?,?);");
		
		pst.setString(1, name);
		
		pst.setDate(2, sdate);
		
		int updatecount = pst.executeUpdate();
		
		if(updatecount == 0)
		System.out.println("no recorsd inserted...!");
		
		else {
			System.out.println("inserted successfully...!");
		}
		
	}

}
