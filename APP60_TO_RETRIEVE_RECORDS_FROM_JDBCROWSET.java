package DURGA_SOFT_JDBC_PROGRAMS;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP60_TO_RETRIEVE_RECORDS_FROM_JDBCROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		RowSetFactory rsf = RowSetProvider.newFactory();   
		JdbcRowSet rs = rsf.createJdbcRowSet();     
		rs.setUrl("jdbc:mysql://localhost:3306/first");   
		rs.setUsername("root");   
		rs.setPassword("Satyabalaji@143");   
		rs.setCommand("select * from employee");   
		rs.execute(); 
		
		System.out.println("Employee Details In Forward Direction");   
		System.out.println("ENO\tENAME\tESAL\tEADDR");   
		System.out.println("----------------------------------");   
		while(rs.next()) {   
		   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));   
	         }   
		System.out.println("Employee Details In Backward Direction");   
		System.out.println("ENO\tENAME\tESAL\tEADDR");   
		System.out.println("----------------------------------");   
		while(rs.previous()) {   
		         System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));   
		 }   
		System.out.println("Accessing Randomly...");   
		rs.absolute(3);   
		System.out.println(rs.getRow()+"-->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));   
		rs.first();   
		System.out.println(rs.getRow()+"-->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));   
		rs.last();   
		System.out.println(rs.getRow()+"-->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));   
		rs.close();    
	}

}
