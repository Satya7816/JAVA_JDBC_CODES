package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class APP23_EXECUTE_SELECT_AND_NON_SELECT_QUERIES_USING_EXECUTE_METHOD {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		String sqlQuery=sc.nextLine();
		boolean b = st.execute(sqlQuery);
		
		if(b==true) {
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
				
			}
		}
		
		else {
			int rowcount = st.getUpdateCount();
			System.out.println("the number of records affected "+rowcount);
		}
		
		con.close(); 
	}

}
