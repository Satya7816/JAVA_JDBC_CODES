package DURGA_SOFT_JDBC_PROGRAMS;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP63_TO_DELETE_RECORDS_USING_JDBCROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RowSetFactory rsf = RowSetProvider.newFactory();   
		JdbcRowSet rs = rsf.createJdbcRowSet();     
		rs.setUrl("jdbc:mysql://localhost:3306/first");   
		rs.setUsername("root");   
		rs.setPassword("Satyabalaji@143");   
		rs.setCommand("select * from employee");   
		rs.execute(); 
		
		 while(rs.next()){   
             float esal=rs.getFloat(3);   
             if(esal>5000){   
                 rs.deleteRow();   
             }   
         }   
         System.out.println("Records Deleted Successfully");   
         rs.close();  
	}

}
