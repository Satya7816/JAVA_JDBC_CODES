package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

public class APP58_TO_DISPLAY_PARAMETER_META_INFO_USING_PARAMETERMETADATA {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?user=root&password=Satyabalaji@143");

		PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?);");
		
		ParameterMetaData pmd = pst.getParameterMetaData();
		
		int count = pmd.getParameterCount();
		
		for(int i=1;i<=count;i++) {
			System.out.println("parameter numbre:"+i);
			System.out.println("parametr mode:"+pmd.getParameterMode(i));
			System.out.println("parameter type:"+pmd.getParameterType(i));
			System.out.println("parameter precision:"+pmd.getPrecision(i));
			System.out.println("parameter Scale:"+pmd.getScale(i));
			System.out.println("parameter isSigned:"+pmd.isSigned(i));
			System.out.println("parameter isNullable:"+pmd.isNullable(i));
			System.out.println("---------------------------------------");
		}
		con.close();
	}

}
