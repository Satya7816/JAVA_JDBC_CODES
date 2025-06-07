package DURGA_SOFT_JDBC_PROGRAMS;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class APP44_TO_RETRIEVE_BLOB_TYPE_FROM_DATABASE {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// already created a table persons[name varchar(30), image BLOB] 
		
		PreparedStatement pst = con.prepareStatement("select * from persons");
		
		FileOutputStream fos = new FileOutputStream("balaji_new.jpeg");
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
		
			String name = rs.getString(1);
			
			InputStream is = rs.getBinaryStream(2);
		
			byte[] buffer = new byte[4096];
		
			while(is.read(buffer)> 0) {
				fos.write(buffer);
			}
			fos.flush();
			System.out.println("executed successfully image is avaiable in balaji_new.jpeg");
		}
		con.close();
		pst.close();
		rs.close();
	}

}
