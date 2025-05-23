package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class APP20_DISPLAY_LOWEST_SALARY_EMPLOYEES_FROM_TABLE {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",
				uname="root",
				pass="Satyabalaji@143";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		String sqlQuery = "select * from employee where EmpSalary in(select min(EmpSalary) from Employee);";
		
		ResultSet rs = st.executeQuery(sqlQuery);
		
		System.out.println("Highest Salary Employee Information:");
		System.out.println("--------------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		con.close();
		
	}

}
