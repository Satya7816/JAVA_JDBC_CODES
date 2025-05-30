package DURGA_SOFT_JDBC_PROGRAMS;




/*
 * 

DELIMITER //

CREATE PROCEDURE getSal(IN emp_id INT, OUT emp_sal FLOAT)
BEGIN
    SELECT empsalary INTO emp_sal FROM employees WHERE EmpId = emp_id;
END //

DELIMITER ;

 * 
 * */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class APP31_EXAMPLE1_FOR_CALLABLE_STATEMENTS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		CallableStatement cst = con.prepareCall("{ call getSal(?, ?) }");
		
		cst.setInt(1,100);
		
		cst.registerOutParameter(2,Types.FLOAT);
		
		cst.execute();
		
		System.out.println(cst.getFloat(2));
		
	}

}
