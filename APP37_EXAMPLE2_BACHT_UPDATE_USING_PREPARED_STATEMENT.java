package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class APP37_EXAMPLE2_BACHT_UPDATE_USING_PREPARED_STATEMENT {

	public static void main(String[] args) throws Exception {


// I have already created a table named SatyaBalaji with columns Id, name, score
//		we already learnt that in batch updates concept there are two methods
//		1. addBatch(sql_query)
//		2. executeBatch()
		
//		using the prepared statement the performance will be higher for the batch updates
String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		PreparedStatement pst = con.prepareStatement("insert into  satyaBalaji values(?,?,?)");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("enter a the values in the format[Id, name, score] ");
			
			System.out.println("enter Id: ");
			int id = sc.nextInt();
			System.out.println("enter name: ");
			String name = sc.next();
			System.out.println("enter score: ");
			int score = sc.nextInt();
			
			pst.setInt(1, id); pst.setString(2, name); pst.setInt(3, score);
			
			pst.addBatch();
			
			System.out.println("do you want to add another record[yes/no]: ");
			String option = sc.next();
			
			if(option.equalsIgnoreCase("no")) {
				break;
			}
			
		}
	
		pst.executeBatch();
		System.out.println("inserted Successfully");
	
	}

}
