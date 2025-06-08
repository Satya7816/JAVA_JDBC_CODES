package DURGA_SOFT_JDBC_PROGRAMS;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class APP45_TO_INSERT_CLOB_TYPE_INTO_DATABASE {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// already create a table cities(name varchar, history LONGTEXT)
		// in mysql instead of CLOB we use TEXT, MEDIUMTEXT, LONGTEXT
		
		File f = new File("C:/Users/padhu/OneDrive/Desktop/BALAJI FOLDER/history.txt");
		
		FileReader fr = new FileReader(f);
		
		PreparedStatement pst = con.prepareStatement("insert into cities values(?,?);");
		
		pst.setString(1,"satya");
		pst.setCharacterStream(2, fr);
		
		int rc = pst.executeUpdate();
		
		if(rc==0) {
			System.out.println("record not inserted");
		}
		else {
			System.out.println("record inserted successfully");
		}
	}

}
