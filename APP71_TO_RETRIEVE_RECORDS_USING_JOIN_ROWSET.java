package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class APP71_TO_RETRIEVE_RECORDS_USING_JOIN_ROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root", "Satyabalaji@143");
        RowSetFactory rsf=RowSetProvider.newFactory();

        CachedRowSet rs1=rsf.createCachedRowSet();
        rs1.setCommand("select * from students");
        rs1.execute(con);
        
        CachedRowSet rs2=rsf.createCachedRowSet();
        rs2.setCommand("select * from courses");
        rs2.execute(con);
        
        JoinRowSet rs=rsf.createJoinRowSet();
        rs.addRowSet(rs1, 4);
        rs.addRowSet(rs2, 1);
        System.out.println("SID\tSNAME\tSADDR\tCID\tCNAME\tCCOST");
        System.out.println("---------------------------------------------");
        while(rs.next()){
            System.out.print(rs.getString(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getString(3)+"\t");
            System.out.print(rs.getString(4)+"\t");
            System.out.print(rs.getString(5)+"\t");
            System.out.print(rs.getString(6)+"\n");
        }
        con.close();
	}

}
