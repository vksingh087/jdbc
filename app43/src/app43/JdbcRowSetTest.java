package app43;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {

	public static void main(String[] args) {
    
		try 
		{
			
		    RowSetFactory rsf=RowSetProvider.newFactory();
		    
		    JdbcRowSet jrs=rsf.createJdbcRowSet();
		    
		    jrs.setUrl("jdbc:mysql://localhost:3306/hit");
		    jrs.setUsername("root");
		    jrs.setPassword("root");
		    
		    jrs.setCommand("select * from employees");
		    
		    jrs.execute();
		    
		    while(jrs.next())
		    {
		    	System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getDouble(3)+" "+jrs.getString(4));
		    }
		    
		   System.out.println("********************************************************"); 
		    while(jrs.previous())
		    {
		    	System.out.println(jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getDouble(3)+" "+jrs.getString(4));
		    }
		    
			jrs.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		

	}

}
