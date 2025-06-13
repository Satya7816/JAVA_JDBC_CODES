package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class APP52_TO_UNDERSTAND_SAVEPOINT_CONCEPT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// already created a table politicians(name varchar(30), party varchar(30));
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");
		
		Statement st = con.createStatement();
		
		con.setAutoCommit(false);
		st.executeUpdate("insert into politicians values('kcr','trs')");
		st.executeUpdate("insert into politicians values('balu','kdp')");

		Savepoint sp = con.setSavepoint();
		
		st.executeUpdate("insert into politicians values('siddhu','bjp')");
		System.out.println("oops... wrong entry just roll back");
		con.rollback();
		System.out.println("operations are rollback from savepoint");
		con.commit(); 
	}

}
