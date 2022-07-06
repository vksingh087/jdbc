package app29;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClobTest {

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
	public static void main(String[] args) {
      
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into topic values(?,?)");
			File f=new File("D:/swing.txt");
			FileReader fr=new FileReader(f);
			
			ps.setString(1,"Swing topic");
			ps.setCharacterStream(2,fr);
			
			ps.executeUpdate();
			
			System.out.println("File inserted Successfully...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
