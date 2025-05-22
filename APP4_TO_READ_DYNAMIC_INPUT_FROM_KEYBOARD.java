package DURGA_SOFT_JDBC_PROGRAMS;

import java.util.*;
public class APP4_TO_READ_DYNAMIC_INPUT_FROM_KEYBOARD {

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
		System.out.println(eno+"\t"+ename+"\t"+esal+"\t"+eaddr);
	}

}
