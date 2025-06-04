package DURGA_SOFT_JDBC_PROGRAMS;

public class APP38_TO_UNDERSTAND_THE_DATE_HANDLING {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//using java.util.Date we will get both date and time
		java.util.Date udate = new java.util.Date();
		
		System.out.println("java util date: "+ udate);
		
		long l = udate.getTime();
		
		
		// using java.sql.Date we will get only date
		java.sql.Date sdate = new java.sql.Date(l);
		
		System.out.println("java sql date: "+ sdate);
	}

}
