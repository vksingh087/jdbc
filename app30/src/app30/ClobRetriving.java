package app30;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClobRetriving {


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
		try {
			
			PreparedStatement ps=con.prepareStatement("select * from topic");
			ResultSet rs=ps.executeQuery();
			
			FileWriter wr=new FileWriter("D:/fatchswing.txt");
			
			rs.next();
			String topicname=rs.getString(1);
			Reader r=rs.getCharacterStream(2);
			
			char buffer[] =new char[1024];
			
			while(r.read(buffer)>0)
			{
				wr.write(buffer);
			}
			
			wr.flush();
			
		    System.out.println(topicname+" Data Fatch Successfully..");
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
