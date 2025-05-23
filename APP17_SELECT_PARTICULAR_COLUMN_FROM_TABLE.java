package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class APP17_SELECT_PARTICULAR_COLUMN_FROM_TABLE {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		String sqlQuery = "select EmpName,EmpAddress from employee;";
		
		ResultSet rs = st.executeQuery(sqlQuery);
		boolean flag = false;
		//System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("ENAME\tEMPADDRESS");
		System.out.println("------------------------");
		
		while(rs.next()) {
			flag=true;
			//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		}
		
		if(flag==false) {
			System.out.println("no matched records found");
		}
		
		con.close();
	
	}

}
