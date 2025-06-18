package DURGA_SOFT_JDBC_PROGRAMS;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP61_INSERT_RECORDS_INTO_TABLE_USING_JDBCROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		RowSetFactory rsf = RowSetProvider.newFactory();   
		JdbcRowSet rs = rsf.createJdbcRowSet();     
		rs.setUrl("jdbc:mysql://localhost:3306/first");   
		rs.setUsername("root");   
		rs.setPassword("Satyabalaji@143");   
		rs.setCommand("select * from employee");   
		rs.execute(); 
		
		 Scanner s=new Scanner(System.in);   
		 rs.moveToInsertRow();   
		 while(true){   
			 System.out.print("Employee Number    :");   
            int eno=s.nextInt();   
            System.out.print("Employee Name      :");   
            String ename=s.next();   
            System.out.print("Employee Salary    :");   
            float esal=s.nextFloat();   
            System.out.print("Employee Address   :");   
            String eaddr=s.next();   
                
            rs.updateInt(1, eno);   
            rs.updateString(2, ename);   
            rs.updateFloat(3, esal);   
            rs.updateString(4, eaddr);   
            rs.insertRow();   
                
            System.out.println("Employee Inserted Successfully");   
            System.out.print("Do You Want to insert One more Employee[yes/no]?  :");   
            String option=s.next();   
            if(option.equalsIgnoreCase("No")){   
                 break;   
             }              
         }   
         rs.close();  
	}

}
