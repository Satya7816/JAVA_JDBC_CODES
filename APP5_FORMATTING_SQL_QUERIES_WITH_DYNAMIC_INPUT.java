package DURGA_SOFT_JDBC_PROGRAMS;

import java.util.*;

public class APP5_FORMATTING_SQL_QUERIES_WITH_DYNAMIC_INPUT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Employee Number: ");
		int eno = sc.nextInt();
		System.out.println("Enter employee Name: ");
		String ename=sc.next();
		System.out.println("Enter employee salary: ");
		Double esal=sc.nextDouble();
		System.out.println("Enter employee Address: ");
		String eaddr=sc.next();
		
		String sqlQuery="insert into employees values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"');";
		
		//String sqlQuery = String.format("insert into employees values(%d,'%s',%f,'%s')", eno,ename,esal,eaddr); 
		System.out.println("Query with your Dynamic Input is: ");
		System.out.println(sqlQuery);
	}

}
