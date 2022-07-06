package app48;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDeleteDemo {

	public static void main(String[] args) {
		
		try 
	    {
			RowSetFactory rsf=RowSetProvider.newFactory();
			CachedRowSet rs=rsf.createCachedRowSet();
			
			rs.setUrl("jdbc:mysql://localhost:3306/hit?relaxAutoCommit=true");
			rs.setUsername("root");
			rs.setPassword("root");
			
			rs.setCommand("select * from employees");
			rs.execute();
			
			while(rs.next())
			{
				double sal=rs.getDouble(3);
				if(sal<300)
				{
					rs.deleteRow();
				}
				
			}
			rs.moveToCurrentRow();
			rs.acceptChanges();
			System.out.println("Record Deleted Successfully...");
			rs.close();
	    }
		catch(Exception e)
		{
	    	
		}
            
	}

}
