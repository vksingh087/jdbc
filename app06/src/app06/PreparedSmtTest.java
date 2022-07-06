package app06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedSmtTest {

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
			PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?,?)");
			
			ps.setInt(1,103);
			ps.setString(2, "Shunham");
			ps.setDouble(3, 12000.5);
			ps.setString(4, "Agra");
			
			ps.executeLargeUpdate();
			
			System.out.println("Record inserted Successfully......");
			
			
		}
		catch(Exception e)
		{
			
		}
		

	}

}
