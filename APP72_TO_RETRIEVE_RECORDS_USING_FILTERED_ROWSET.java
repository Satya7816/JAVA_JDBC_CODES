package DURGA_SOFT_JDBC_PROGRAMS;

import java.sql.SQLException;
import java.util.function.Predicate;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;



class EmployeeSalaryFilter implements Predicate{
    float low;
    float high;
    public EmployeeSalaryFilter(float low,float high) {
        this.low=low;
        this.high=high;
       	}
      //this method will be called at the time of row insertion
      public boolean evaluate(Object value, String columnName) throws SQLException {
       return false;
    }
      //this method will be called at the time of row insertion
     public boolean evaluate(Object value, int columnindex) throws SQLException {
        return false;
    }
    
      public boolean evaluate(RowSet rs) {
        boolean eval=false;
        try{
        FilteredRowSet frs=(FilteredRowSet)rs;
        float esal=frs.getFloat(3);
        if((esal>=low) && (esal<=high)){
            eval=true;
        }else{
            eval=false;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return eval;
    }
	@Override
	public boolean test(Object t) {
		// TODO Auto-generated method stub
		return false;
	}
}



public class APP72_TO_RETRIEVE_RECORDS_USING_FILTERED_ROWSET {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		RowSetFactory rsf=RowSetProvider.newFactory();
		FilteredRowSet rs=rsf.createFilteredRowSet();
        rs.setUrl("jdbc:mysql://localhost:3306/first");
        rs.setUsername("root");
        rs.setPassword("Satyabalaji@143");
        rs.setCommand("select * from employee");
		rs.execute();
		System.out.println("Data Before Filtering");
        System.out.println("ENO\tENAME\tESAL\tEADDR");
        System.out.println("------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
		}
        EmployeeSalaryFilter f=new EmployeeSalaryFilter(4500,8000);
        rs.setFilter((javax.sql.rowset.Predicate) f);
		rs.beforeFirst();
		System.out.println("Data After Filtering");
        System.out.println("ENO\tENAME\tESAL\tEADDR");
        System.out.println("------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
		}
       rs.close();
	}

}


