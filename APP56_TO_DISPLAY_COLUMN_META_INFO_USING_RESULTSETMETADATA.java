package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class APP56_TO_DISPLAY_COLUMN_META_INFO_USING_RESULTSETMETADATA {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");

		Statement st = con.createStatement();
		
		// we have already created a table employee(empId int, empName varchar, empSalary float, empAddress varchar)
		ResultSet rs = st.executeQuery("select * from employee");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int count = rsmd.getColumnCount();
		
		for(int i=1;i<=count;i++) {
			System.out.println("column number: "+ i);
			System.out.println("column Name: "+ rsmd.getColumnName(i));
			System.out.println("column Type: "+ rsmd.getColumnType(i));
			System.out.println("column Display size: "+rsmd.getColumnDisplaySize(i));
			System.out.println("__________________________");
		}
		
		con.close();
		
		
		
	}

}
