package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class APP57_TO_DISPLAY_TABLE_DATA_INCLUDING_COLUMN_NAMES_USING_RESULTSETMEDTADATA {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");

		Statement st = con.createStatement();
		
		// we have already created a table employee(empId int, empName varchar, empSalary float, empAddress varchar)
		ResultSet rs = st.executeQuery("select * from employee");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		String col1 = rsmd.getColumnName(1);
		String col2 =rsmd.getColumnName(2);
		String col3 = rsmd.getColumnName(3);
		String col4 = rsmd.getColumnName(4);
		
		System.out.println(col1+"\t"+col2+"\t"+col3+"\t"+col4);
		System.out.println("-------------------------------------");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t\t"+rs.getString(4));
		}
		con.close();
		
		
	}

}
