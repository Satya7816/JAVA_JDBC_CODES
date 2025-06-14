package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;

public class APP53_TO_DEMONSTRATE_MYSQL_DATABASE_ISOLATION_LEVEL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");

		System.out.println(con.getTransactionIsolation());//4      
		con.setTransactionIsolation(8);   
		System.out.println(con.getTransactionIsolation());//8      
	}

}
