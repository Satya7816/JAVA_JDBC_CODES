package DURGA_SOFT_JDBC_PROGRAMS;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP67_TO_DELETE_RECORDS_USING_CACHED_ROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
        RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet rs=rsf.createCachedRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/first?relaxAutoCommit=false");
        rs.setUsername("root");
        rs.setPassword("Satyabalaji@143");
        rs.setCommand("select * from employee");
        rs.execute();
        
	       while(rs.next()){
	            float esal=rs.getFloat(3);
	            if(esal>=5000){
	               rs.deleteRow();
	               rs.commit();
	            }
	        }
	        rs.moveToCurrentRow();
	        rs.acceptChanges();
			rs.close();
			System.out.println("Records deleted successfully");
	}

}
