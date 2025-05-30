package DURGA_SOFT_JDBC_PROGRAMS;


/*
 *
 *
 
delimiter //
create procedure EmployeeProcedure()
begin
  select * from employee;
end //

 * */

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

public class APP30_TO_CALL_STORED_PROCEDURE_FROM_JAVA_APPLICATION_THROUGH_CALLABLE_STATEMENT {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		String Query="delete from employee where EmpName='satyarao'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		CallableStatement cst = con.prepareCall("call EmployeeProcedure;");
		
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
	}

}
