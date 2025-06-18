package DURGA_SOFT_JDBC_PROGRAMS;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP62_TO_UPDATE_RECORDS_USING_JDBCROWSET {

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
			if(esal<10000){   
               float new_Esal=esal+500;   
               rs.updateFloat(3, new_Esal);   
               rs.updateRow();   
             }   
         }   
         System.out.println("Records Updated Successfully");   
         rs.close();  
		
	}

}
