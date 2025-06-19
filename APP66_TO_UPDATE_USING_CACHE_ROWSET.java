package DURGA_SOFT_JDBC_PROGRAMS;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP66_TO_UPDATE_USING_CACHE_ROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
        RowSetFactory rsf=RowSetProvider.newFactory();
		CachedRowSet rs=rsf.createCachedRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/first");
        rs.setUsername("root");
        rs.setPassword("Satyabalaji@143");
        rs.setCommand("select * from employee");
        rs.execute();
        while(rs.next()){
            float esal=rs.getFloat(3);
            if(esal<3500){
                esal=esal+111;
                rs.updateFloat(3, esal);
                rs.updateRow();
            }
        }
        rs.moveToCurrentRow();
        rs.acceptChanges();
		System.out.println("Records Updated Successfully");
		rs.close();
	}

}
