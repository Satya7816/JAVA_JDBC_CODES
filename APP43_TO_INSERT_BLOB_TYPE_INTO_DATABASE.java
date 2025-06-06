package DURGA_SOFT_JDBC_PROGRAMS;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class APP43_TO_INSERT_BLOB_TYPE_INTO_DATABASE {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// already created a table persons[name varchar(30), image BLOB] 
		
		File f = new File("BALAJI.jpg");
		//System.out.println("Looking for file at: " + f.getAbsolutePath());
		
		FileInputStream fis = new FileInputStream(f);
		
		PreparedStatement pst = con.prepareStatement("insert into persons values(?,?);");
		
		pst.setString(1, "Balaji");
		pst.setBinaryStream(2, fis,(int) f.length());
		
		int rc = pst.executeUpdate();
		
		if(rc==0) {
			System.out.println("record not inserted...!");
		}
		else {
			System.out.println("record inserted successfully...!");
		}
		
		con.close();
	}

}
