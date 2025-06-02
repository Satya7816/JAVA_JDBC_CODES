package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.sql.CallableStatement;


// this is the function already executed in the database mysql workbench
/*
 
 DELIMITER //

CREATE FUNCTION getemp(id1 INT, id2 INT) 
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE sal1 INT;
    DECLARE sal2 INT;

    SELECT empsalary INTO sal1 FROM Employee WHERE empid = id1;
    SELECT empsalary INTO sal2 FROM Employee WHERE empid = id2;

    RETURN (sal1 + sal2) / 2;
END //

DELIMITER ;

 
 * */
public class APP35_CODE_TO_UNDERSTAND_FUNCTIONS {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		CallableStatement cst = con.prepareCall("{?= call getemp(?,?)}");
		
		cst.registerOutParameter(1, Types.FLOAT);
		
		cst.setInt(2, 2);
		cst.setInt(3, 3);
		
		cst.execute();
		System.out.println("Average salary: "+ cst.getFloat(1));
		
		
	}

}
