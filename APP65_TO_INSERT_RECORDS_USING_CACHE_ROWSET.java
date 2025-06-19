package DURGA_SOFT_JDBC_PROGRAMS;

import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP65_TO_INSERT_RECORDS_USING_CACHE_ROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet rs=rsf.createCachedRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/first?relaxAutoCommit=true");
        rs.setUsername("root");
        rs.setPassword("Satyabalaji@143");
        rs.setCommand("select * from employee");
        rs.execute();
        Scanner s=new Scanner(System.in);
        while(true){
            System.out.print("Employee Number  :");
            int eno=s.nextInt();
            System.out.print("Employee Name    :");
            String ename=s.next();
            System.out.print("Employee Salary  :");
            float esal=s.nextFloat();
            System.out.print("EMployee Address :");
            String saddr=s.next();
            
            rs.moveToInsertRow();
            rs.updateInt(1, eno);
            rs.updateString(2, ename);
            rs.updateFloat(3, esal);
            rs.updateString(4, saddr);
            rs.insertRow();
                    
            System.out.println("Employee Inserted Successfully");
            System.out.print("Do you want to insert One more Employee[Yes/No]?  :");
            String option=s.next();
            if(option.equalsIgnoreCase("No")){
                break;
            }
        }
        rs.moveToCurrentRow();
        rs.acceptChanges();
		rs.close();

	}

}
