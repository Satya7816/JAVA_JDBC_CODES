package DURGA_SOFT_JDBC_PROGRAMS;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class APP46_TO_RETRIEVE_CLOB_TYPE_FROM_DATABASE {

	public static void main(String[] args) 	throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		// already create a table cities(name varchar, history LONGTEXT)
		// in mysql instead of CLOB we use TEXT, MEDIUMTEXT, LONGTEXT
		
		FileWriter fw = new FileWriter("bhai_history_new.txt");
		
		PreparedStatement pst = con.prepareStatement("select * from cities;");
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			
			String name = rs.getString(1);
			
			Reader r = rs.getCharacterStream(2);
			
			char[] buffer = new char[1024];
			
			while(r.read(buffer) > 0) {
				fw.write(buffer);
			}
			fw.flush();
		}
		System.out.println("open bhai_history_new.txt file to see the retrieve file from the database");
	}

}
