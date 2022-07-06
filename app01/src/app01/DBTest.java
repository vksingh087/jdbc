package app01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBTest 
{

	public static void main(String[] args) 
	{
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hit","root","root");
			
			Statement smt= con.createStatement();
			
			smt.executeUpdate("insert into employees values('101','Amit Sharma','14000','sre')");
			System.out.println("Inserted Record Successfully.....");
			
		}
		catch(Exception e)
		{
			
		}

	}

}
