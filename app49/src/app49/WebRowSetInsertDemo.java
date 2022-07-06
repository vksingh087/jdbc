package app49;

import java.io.FileReader;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetInsertDemo {

	public static void main(String[] args) 
	{
		try 
		{
		   RowSetFactory rsf=RowSetProvider.newFactory();
		   WebRowSet wrs=rsf.createWebRowSet();
		   
		   wrs.setUrl("jdbc:mysql://localhost:3306/hit");
		   wrs.setUsername("root");
		   wrs.setPassword("root");
		   
		   wrs.setCommand("select * from employees");
		   wrs.execute();
		   
		   FileReader fr=new FileReader("D:/abcxml.xml");
		   
		   wrs.readXml(fr);
		  
		   wrs.acceptChanges();
		   
		   System.out.println("Record Inserted Successfully...");
		   wrs.close();
		   fr.close();
		   
		   
		   
		}
		catch(Exception e)
		{
		     e.printStackTrace();
		}

	}

}
