package DURGA_SOFT_JDBC_PROGRAMS;

import java.io.FileWriter;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class APP68_TO_RETRIEVE_RECORDS_USING_WEB_ROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        RowSetFactory rsf=RowSetProvider.newFactory();
		WebRowSet rs=rsf.createWebRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/first");
        rs.setUsername("root");
        rs.setPassword("Satyabalaji@143");
        rs.setCommand("select * from employee");
        rs.execute();
        FileWriter fw=new FileWriter("emp.xml");
        rs.writeXml(fw);
        System.out.println("Employee Data transfered to emp.xml file");
        fw.close();
	}

}
