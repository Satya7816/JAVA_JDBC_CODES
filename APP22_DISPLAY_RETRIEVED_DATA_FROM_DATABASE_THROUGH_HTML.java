package DURGA_SOFT_JDBC_PROGRAMS;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class APP22_DISPLAY_RETRIEVED_DATA_FROM_DATABASE_THROUGH_HTML {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from employee");
		
		String data ="";
		data = data+"<html><body><table>";
		data = data+"<tr><td>ENO</td><td>ENAME</td><td>ESAL</td><td>EADDR</td><tR>";
		
		while(rs.next()) {
			data= data+"<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getDouble(3)+"</td><td>"+rs.getString(4)+"</td><tr>";
		}
		data = data+"</table></body></html>";
		
		FileOutputStream fos = new FileOutputStream("emp.html");
		byte[] b = data.getBytes();
		fos.write(b);
		fos.flush();
		System.out.println("open emp.html to get Employees data");
		fos.close();
		con.close();
	}

}
