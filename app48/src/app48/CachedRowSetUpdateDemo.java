package app48;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetUpdateDemo {

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
				if(sal==12000)
				{
					sal=sal+3000;
					rs.updateDouble(3, sal);
					rs.updateRow();
				}
			}
			rs.moveToCurrentRow();
			rs.acceptChanges();
			System.out.println("Record Updated Sucessfully....");
			rs.close();
			
			
			
	    }
		catch(Exception e)
		{
			
		}

	}

}
