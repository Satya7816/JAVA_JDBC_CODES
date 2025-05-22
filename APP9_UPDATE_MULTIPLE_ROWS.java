package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class APP9_UPDATE_MULTIPLE_ROWS {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Increament Amount: ");
		double increament=sc.nextDouble();
		
		System.out.println("enter salary range: ");
		double salRange = sc.nextDouble();
		
		String sqlQuery = String.format("update employees set esal=esal+ %f where esal<%f ", increament,salRange);
		
		int updatecount = st.executeUpdate(sqlQuery);
		System.out.println("The no of rows updated: "+updatecount);
		
		con.close();
	}

}
