package app05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBFunction {



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
				
				Statement smt=con.createStatement();
				String query="select count(*) from employees";
				ResultSet rs=smt.executeQuery(query);
				
				if(rs.next())
				{
					System.out.println(rs.getInt(1)+" Rows in employees Table");
				}
				
				
				
				
				
			}
			catch(Exception e)
			{
				
			}
		}
	}


