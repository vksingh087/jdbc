package app48;

import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class ChachedRowsetInsertion {

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
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter EmpNo: ");
		int eno=s.nextInt();
		
		System.out.println("Enter Ename: ");
		String name=s.next();
		
		System.out.println("Enter Sal: ");
		double sal=s.nextDouble();
		
		System.out.println("Enter Address: ");
		String addr=s.next();
		
		rs.moveToInsertRow();
		
		rs.updateInt(1,eno);
		
		rs.updateString(2, name);
		
		rs.updateDouble(3, sal);
		
		rs.updateString(4, addr);
   
		rs.insertRow();
		System.out.println("Inserted Successfully....");
		
		rs.moveToCurrentRow();
		rs.acceptChanges();
		rs.close();
		

	}
    catch (Exception e) {
      
    }
	}

}
