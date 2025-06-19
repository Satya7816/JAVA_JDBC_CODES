package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP64_TO_RETRIEVE_RECORDS_FROM_CACHED_ROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","Satyabalaji@143");
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery("select * from employee");
        RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet crs=rsf.createCachedRowSet();
		crs.populate(rs);
		con.close();
		//Now we cannot access RS but we can access CRS
		//if(rs.next()){}//RE:SQLException:Operation not allowed after ResultSet closed
        System.out.println("ENO\tENAME\tESAL\tEADDR");
	    System.out.println("-----------------------------");
        while(crs.next()){
            System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getFloat(3)+"\t"+crs.getString(4));
        }

	}

}
