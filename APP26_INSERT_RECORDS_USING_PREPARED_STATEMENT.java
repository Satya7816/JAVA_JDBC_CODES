package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class APP26_INSERT_RECORDS_USING_PREPARED_STATEMENT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pst = null;
		Scanner sc = new Scanner(System.in);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","Satyabalaji@143");
			pst = con.prepareStatement("insert into employee values(?,?,?,?);");
			
			while(true) {
				System.out.println("enter employee Id: ");
				int eno = sc.nextInt();
				
				System.out.println("enter employee name");
				String ename= sc.next();
				
				System.out.println("enter employee salary");
				Double esal = sc.nextDouble();
				
				System.out.println("enter employee address");
				String eaddr = sc.next();
				
				pst.setInt(1, eno);
				pst.setString(2, ename);
				pst.setDouble(3, esal);
				pst.setString(4, eaddr);
				
				pst.executeUpdate();
				
				System.out.println("successfully inserted...!!!");
				
				System.out.println("Do you wanna insert another record???[yes/no]");
				String option = sc.next();
				if(option.equalsIgnoreCase("no")) {
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
		if(con!=null)	con.close();
		if(pst!=null)	pst.close();
		 }
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
