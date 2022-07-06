package app49;

import java.io.FileWriter;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetRetrieve {

	public static void main(String[] args) {
		
		try 
		{
		   RowSetFactory rsf=RowSetProvider.newFactory();
		   WebRowSet wrs=rsf.createWebRowSet();
		   
		   wrs.setUrl("jdbc:mysql://localhost:3306/hit");
		   wrs.setUsername("root");
		   wrs.setPassword("root");
		   
		   wrs.setCommand("select * from employees");
		   wrs.execute();
		   
		   FileWriter fw=new FileWriter("D:/abcxml.xml");
		   
		   wrs.writeXml(fw);
		   
		   System.out.println("Employee data is Transfered in xml file...");
		   
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
