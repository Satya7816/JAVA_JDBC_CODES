package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class APP11_DELETE_MULTIPLE_ROWS {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the cutoff salary: ");
		double cutoff= sc.nextDouble();
		
		String sqlQuery = String.format("delete from employees where esal>=%f", cutoff);
		
		int updatecount = st.executeUpdate(sqlQuery);
		
		System.out.println("the number of rows deleted "+updatecount);

		con.close();
		
	}

}
