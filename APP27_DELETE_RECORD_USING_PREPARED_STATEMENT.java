package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class APP27_DELETE_RECORD_USING_PREPARED_STATEMENT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pst = null;
		

		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter ename to delete record: ");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","Satyabalaji@143");
			pst = con.prepareStatement("delete from employee where EmpName=?");
			
			
			while(true) {
			System.out.println("enter ename to delete record: ");
			String ename = sc.next();
			pst.setString(1, ename);
			pst.executeUpdate();
			System.out.println("successfully deleted...!!!");
			
			
			System.out.println("want to deleted one more record[yes/no]");
			String option = sc.next();
			if(option.equalsIgnoreCase("no")) {
				break;
			}
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			if(pst!=null) {pst.close();}
			if(con!=null) {con.close();}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
