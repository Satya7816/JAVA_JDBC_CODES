package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class APP29_TO_SHOW_NO_POSSIBILITY_OF_SQL_INJECTION_WITH_PREPARED_STATEMENT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
    String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		String Query="delete from employee where EmpName='satyarao'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM users WHERE uname=? AND upwd=?;");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = sc.nextLine();
		System.out.print("Enter password: ");
		String upwd = sc.nextLine();
		
		pst.setString(1, username);
		pst.setString(2, upwd);
		ResultSet rs =pst.executeQuery();
		
		int c=0;
		if(rs.next()) {
			c = rs.getInt(1);
		}
		
		if(c==0) {
			System.out.println("invalid credientials");
		}
		else {
			System.out.println("valid credientials");
		}

	}

}
