package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class APP39_INSERT_DATES_INTO_DATABASE_EXAMPLE1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
	String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// we have already created a table users1 with the columns [name, dop(date of proposal)]
		
		PreparedStatement pst = con.prepareStatement("insert into users1 values(?,?);");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name: ");
		String name = sc.next();
		pst.setString(1, name);
		
		System.out.println("enter the date[dd-mm-yyyy]: ");
		String dop = sc.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		java.util.Date udate = sdf.parse(dop);
		
		long l = udate.getTime();
		
		java.sql.Date sdate = new java.sql.Date(l);
		
		pst.setDate(2, sdate);
		
		int updatecount = pst.executeUpdate();
		
		if(updatecount == 0)
		System.out.println("no recorsd inserted...!");
		
		else {
			System.out.println("inserted successfully...!");
		}
		
	}

}
