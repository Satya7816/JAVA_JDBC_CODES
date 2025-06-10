package DURGA_SOFT_JDBC_PROGRAMS;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class APP48_TO_UNDERSTAND_PROPERTIES_CONCEPT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// before starting this program, create a db.properties file having url, username, password
		//
		Properties p = new Properties();
		// here pass the db.properties file location
		FileInputStream fis = new FileInputStream("../Learn_JDBC/src/DURGA_SOFT_JDBC_PROGRAMS/db.properties");
		p.load(fis);// to load all the properties from properties files to the properties object
		String url = p.getProperty("URL");
		String uname = p.getProperty("UNAME");
		String pass = p.getProperty("PASS");

		Connection con = DriverManager.getConnection(url, uname, pass);

		// we have already created a table employee(empId, empName,empSalary, empAddress)
		PreparedStatement pst = con.prepareStatement("select * from employee");	

		ResultSet rs = pst.executeQuery();
		System.out.println("empno\tempName\tempsalary empaddress ");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		
		con.close();
	}

}
