package app08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NthSalary 
{
   public static final String url="jdbc:mysql://localhost:3306/hit";
   public static final String user="root";
   public static final String pwd="root";
	public static Connection con=null;
   
   static
   {
       try 
       {
    	   
    	   Class.forName("com.mysql.jdbc.Driver");
    	   con=DriverManager.getConnection(url, user, pwd);
       }
       
       catch (Exception e) 
       {
		System.out.println(e);
	   }
   }   
   public static void main(String[] args) 
	{
	    try
	    {
	           Scanner s=new Scanner(System.in); 
	           System.out.println("Enter the Number: ");
	           int n=s.nextInt();
	           Statement smt=con.createStatement();
	           ResultSet rs=smt.executeQuery("select * from employees order by esal desc");
	           
	           int i=1;
	           
	           while(rs.next())
	           {
	        	   if(i==n)
	        	   {
	        		   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
	        	   }
	        	   i++;
	           }
	             
	           
	    }
	    catch(Exception e)
	    {
	    	
	    }

	}
}
