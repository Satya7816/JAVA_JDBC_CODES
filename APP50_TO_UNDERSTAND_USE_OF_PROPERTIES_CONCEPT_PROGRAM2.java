package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class APP50_TO_UNDERSTAND_USE_OF_PROPERTIES_CONCEPT_PROGRAM2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// here i have just combined up the jdbc_url, username and password
		// url = jdbc:mysql://localhost:3306/first
		// user = root
		// password = Satyabalaji@143
		// hence it became jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143"
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");
 		
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
