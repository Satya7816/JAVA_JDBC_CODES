package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*
 * 
 --stored procedure
 
 DELIMITER //
 CREATE PROCEDURE getEmpDetails(IN emp_id INT, OUT emp_name VARCHAR(30), OUT emp_sal Float )
 BEGIN
		SELECT EmpName,EmpSalary into emp_name, emp_sal from employee where EmpId = emp_id;
 END //
 DELIMITER ;
 
 * */

public class APP32_EXAMPLE2_FOR_CALLABLE_STATEMENTS {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		CallableStatement cst = con.prepareCall("{ call getEmpDetails(?, ?, ?) }");
		
		cst.setInt(1,100);
		
		
		cst.registerOutParameter(2,Types.VARCHAR);
		cst.registerOutParameter(3, Types.FLOAT);
		
		cst.execute();
		
		System.out.println(cst.getString(2)+"\t"+cst.getFloat(3));
	}

}
