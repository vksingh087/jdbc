package app27;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageUploadDB {

	public static final String url="jdbc:mysql://localhost:3306/hit"; 
	public static final String user="root";
	public static final String pwd="root";
	
	public static Connection con=null;
	
	static
	{
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(url, user, pwd);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) 
	{
		try {
			
			    File f=new File("D:/dhoni.png");
			    FileInputStream fis=new FileInputStream(f);
			    
			    PreparedStatement ps=con.prepareStatement("insert into officer values(?,?)");
			    ps.setString(1, "M S Dhoni");
			    ps.setBinaryStream(2, fis);
			    
			    ps.executeUpdate();
			    
			    System.out.println("Record Inserted with Photo Sccessfully.....");
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
