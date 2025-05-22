package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class APP15_SELECT_RANGE_OF_RECORDS_BASED_ON_SALARY {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Begin Salary Range:");
		double beginsal = sc.nextDouble();
		
		System.out.println("Enter End Salary range:");
		double endsal = sc.nextDouble();
		
		String sqlQuery = String.format("select * from employees where esal>=%f and esal<=%f", beginsal,endsal);
		
		ResultSet rs = st.executeQuery(sqlQuery);
		boolean flag = false;
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------");
		
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			
		}
		
		if(flag==false) {
			System.out.println("no matched records found");
		}
		
		con.close();
	}

}
