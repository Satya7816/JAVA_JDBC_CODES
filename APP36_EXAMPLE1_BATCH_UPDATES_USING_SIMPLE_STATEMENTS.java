package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class APP36_EXAMPLE1_BATCH_UPDATES_USING_SIMPLE_STATEMENTS {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
// I have already created a table named SatyaBalaji with columns Id, name, score
//		we already learnt that in batch updates concept there are two methods
//		1. addBatch(sql_query)
//		2. executeBatch()
		
//	These Batch Updates concept is used to increase the performance and reduce the network traffic
//		Batch Updates are applicable for only non-select queries
//		if we try to run select query using batch updates we will get BatchUpdate exception.
		
		
		st.addBatch("create table if not exists SatyaBalaji(Id int, Name varchar(30), score int);");
		st.addBatch("insert into SatyaBalaji values(11,'sathi',99);");
		st.addBatch("insert into SatyaBalaji values(12,'sathi babu',92);");
		st.addBatch("insert into SatyaBalaji values(13,'sathi raju',90);");
		st.addBatch("update SatyaBalaji set score=95 where id =12;");
		st.addBatch("delete from SatyaBalaji where Id = 13;");

		int[] result = st.executeBatch();
		
		int updatecount =0;
		
		for(int x : result) {
			updatecount += x;
		}
		
		System.out.println("total number updates:" + updatecount);
	}

}
