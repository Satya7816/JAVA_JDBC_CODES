package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;



public class APP25_PROGRAM1_TO_DEMONSTARTE_CODING_STANDARDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","Satyabalaji@143");
			st = con.createStatement();
			rs = st.executeQuery("select * from employee");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
		if(con!=null)	con.close();
		if(st!=null)	st.close();
		if(rs!=null)	rs.close();
		 }
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
