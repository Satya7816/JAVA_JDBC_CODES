package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


// this is the function already executed in the database mysql workbench
/*
   DELIMITER //
 CREATE PROCEDURE getAllEmployeeInfo1(IN sal int)
 BEGIN
	select * from employee where esal> sal;
 END //
 DELIMITER ;
 
 * */

public class APP34_EXAMPLE_CODE_TO_UNDERSTAND_CUSORS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		CallableStatement cst = con.prepareCall("{ call getAllEmployeeInfo1(?) }");
		
		cst.setInt(1, 9000);
		
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
		   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
	}

}
