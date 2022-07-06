package app11;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureGetSal {

	public static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String user="system";
	public static final String pwd="root";
	public static Connection con=null;
	
	
	static
	{
		try 
		{
			
		    Class.forName("oracle.jdbc.OracleDriver");	
		    con=DriverManager.getConnection(url, user, pwd);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) 
	{
	    try 
	    {
		      CallableStatement cs=con.prepareCall("{call getSal(?,?)}"); 
	    	  Scanner sc=new Scanner(System.in);
	    	  System.out.println("Enter the Employee Id: ");
	    	  int n=sc.nextInt();
	    	  
	    	  cs.setInt(1,n);
	    	  
		      cs.registerOutParameter(2,Types.INTEGER);
		      cs.execute();
		      
		      System.out.print("Employee Salary is: "+cs.getInt(2));
	    	  
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}	

	}

}
