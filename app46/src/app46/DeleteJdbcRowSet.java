package app46;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DeleteJdbcRowSet {

	public static void main(String[] args) throws Exception {
		
		RowSetFactory rsf=RowSetProvider.newFactory();
	    
	    JdbcRowSet jrs=rsf.createJdbcRowSet();
	    
	    jrs.setUrl("jdbc:mysql://localhost:3306/hit");
	    jrs.setUsername("root");
	    jrs.setPassword("root");
	    
	    
	    jrs.setCommand("select * from employees");
	    jrs.execute();
	    
	    while(jrs.next())
	    {
	    	double esal=jrs.getDouble(3);
	    	
	    	if(esal>30000)
	    	{
	    		jrs.deleteRow();
	    	}
	    		
	    }
	    System.out.println("Record Deleted Successfully.......");

	}

}
