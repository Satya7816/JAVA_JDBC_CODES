package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class APP6_7_INSERT_MULTIPLE_RECORDS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("enter Employee Number: ");
			int eno = sc.nextInt();
			System.out.println("Enter employee Name: ");
			String ename=sc.next();
			System.out.println("Enter employee salary: ");
			Double esal=sc.nextDouble();
			System.out.println("Enter employee Address: ");
			String eaddr=sc.next();
			
			String sqlQuery = String.format("insert into employees values(%d,'%s',%f,'%s')", eno,ename,esal,eaddr); 
			st.executeUpdate(sqlQuery);
			
			System.out.println("Record inserted successfully");
			System.out.println("Do u want to insert another record[yes/no]");
			String option=sc.next();
			if(option.equalsIgnoreCase("no")) {
				break;
			}
			
		}
		con.close();
	}

}
