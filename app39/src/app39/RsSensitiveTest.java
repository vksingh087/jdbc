package app39;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RsSensitiveTest 
{
	public static final String url="jdbc:oracle:thin:@localhost:1521:XE"; 
	public static final String user="system";
	public static final String pwd="root";
	public static Connection con=null;
	
	static
	{
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(url, user, pwd);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
   public static void main(String arg[])
   {
	   
	   
	   try {
		   
		   Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   ResultSet rs=smt.executeQuery("select * from employee");
		   
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		   }
		   
		   System.out.println("Database is Updating........");
		   System.in.read();
		   rs.beforeFirst();
		   
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		   }
		   	   
		
	} catch (Exception e) {
		System.out.println(e);
	}
	   
   }
}
