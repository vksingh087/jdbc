package app28;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReceiveImage {

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
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		try 
		{
			
			 PreparedStatement ps=con.prepareStatement("select * from officer");
			 ResultSet rs=ps.executeQuery();
			  rs.next();
			  String name=rs.getString(1);
			  InputStream  is=rs.getBinaryStream(2);
			  byte[] b=new byte[2048];
              
			  
			  FileOutputStream fos=new FileOutputStream("D:/jk/abc.png");
			 
			  while(is.read(b)>0)
			  {
				  fos.write(b);
			  }
			  
			  fos.flush();
			  fos.close();
			  
			  System.out.println("Name: "+name);
			  System.out.println("Your image is saved in Given location");
 
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}

}
