package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.*;
import java.util.Scanner;

public class APP14_SELECT_RANGE_OF_RECORDS_BASED_ON_ADDRESS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter city name");
		String addr = sc.nextLine();
		String sqlQuery = String.format("select * from employees where eaddr='%s'", addr);
		
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
