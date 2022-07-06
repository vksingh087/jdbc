package app44;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class InsertJdbcRowSet {

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
		    
		    System.out.print("Enter the eid: ");
		    int eno=s.nextInt();
		    
		    System.out.print("Enter The ename: ");
		    
		    String name=s.next();
		    
		    System.out.print("Enter The esal: ");
		    double esal=s.nextDouble();
		    
		    System.out.print("Enter The eaddress: ");
		    String address=s.next();
		    
		    jrs.moveToInsertRow();
		    jrs.updateInt(1, eno);
		    jrs.updateString(2, name);
		    jrs.updateDouble(3, esal);
            jrs.updateString(4, address);	
            
            jrs.insertRow();
            
            System.out.println("Record Inserted Successfully......");
		    
		    
		    
		}
		catch(Exception e)
		{
			
		}
		
	}

}
