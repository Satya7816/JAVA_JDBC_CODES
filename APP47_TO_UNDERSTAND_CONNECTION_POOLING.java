package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class APP47_TO_UNDERSTAND_CONNECTION_POOLING {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/first",uname="root",pass="Satyabalaji@143";

		Class.forName("com.mysql.cj.jdbc.Driver");
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setURL(url);
		ds.setUser(uname);
		ds.setPassword(pass);
		
		Connection con = ds.getConnection();
		
		PreparedStatement pst = con.prepareStatement("select * from employee");	
		
		ResultSet rs = pst.executeQuery();
		System.out.println("empno\tempName\tempsalary\tempaddress ");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		
	}

}
