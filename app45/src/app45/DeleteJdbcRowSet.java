package app45;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DeleteJdbcRowSet {

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
		    
		    Scanner s=new Scanner(System.in);
		    System.out.println("Enter the Amount which you want to Update: ");
		    double incsal=s.nextDouble();
		    while(jrs.next())
		    {
		    	 double esal=jrs.getDouble(3);
		    	 if(esal<20000)
		    	 {
		    		 double newsal=esal+incsal;
		    		 jrs.updateDouble(3,newsal);
		    		 jrs.updateRow();
		    	 }
		    }
		    System.out.println("Record Updated Successfully.....");
		    
		    
		    
		}
		catch(Exception e)
		{
			
		}

	}

}
