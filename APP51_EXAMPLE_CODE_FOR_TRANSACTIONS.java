package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class APP51_EXAMPLE_CODE_FOR_TRANSACTIONS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// already a table named accounts(name varchar(30), balance int)
		// inserted values durga, 100000
		// inserted values satya, 1000
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");

		Statement st = con.createStatement();
		
		System.out.println("transaction begins...");
		
		// usually in jdbc operations will be auto commited in database
		// to paused the auto commit we use this...
		con.setAutoCommit(false);
		
		st.executeUpdate("update accounts set balance= balance-10000 where name ='durga';");
		
		st.executeUpdate("update accounts set balance= balance+10000 where name ='satya';");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("please confirm the transaction of 10000[yes/no]");
		
		String option = sc.next();
		
		if(option.equalsIgnoreCase("yes")) {
			// to resume the pause...
			con.commit();
			System.out.println("transaction completed");
		}
		else {
			//  rollback() is used to 
			con.rollback();
			System.out.println("transaction rolled back");
		}
	}

}
