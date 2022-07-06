package app07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedTest 
{
    public static final String url="jdbc:oracle:thin:@localhost:1521:XE";
    public static final String user="system";
    public static final String pwd="root";
	public static Connection con=null;
	
	static
	{
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(url,user,pwd);
			
		} 
		catch (Exception e) 
		{
			
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		
		try
		{
			System.out.println("Enter the Empoyee Id: ");
			int n=s.nextInt();
			
			System.out.println("Enter the Empoyee Name: ");
			String name=s.next();
			
			
			PreparedStatement ps=con.prepareStatement("insert into employees values(?,?)");
			
			ps.setInt(1, n);
			ps.setNString(2, name);
			
			ps.executeUpdate();
			System.out.println("Record Inserted Successfully...");
			con.commit();
			
		}
		catch(Exception e)
		{
			
		}
		

	}

}
