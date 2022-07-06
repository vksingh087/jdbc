package app04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBExecute {

	public static final String url="jdbc:mysql://localhost:3306/hit";
	public static final String user="root";
	public static final String pwd="root";
	public static Connection con=null;
	
	static
	{
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con=DriverManager.getConnection(url,user,pwd);
	    }
	    catch(Exception e)
	    {
	    	
	    }
	}
	
	public static void main(String[] args)
	{
		try
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Your Query: ");
			String query=s.nextLine();
			
			
			Statement smt=con.createStatement();
			boolean b=smt.execute(query);
			
			if(b==true)
			{
				ResultSet rs=smt.getResultSet();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
				}
			}
			else
			{
			       int n=smt.getUpdateCount();
			       System.out.println(n+ " Record Changed.....");
			    
			}
			
		}catch(Exception e)
		{
				
		}

	}

}
