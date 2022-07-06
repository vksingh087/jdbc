package app25;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class PropertyTest {

	public static String url=null;
	public static String user=null;
	public static String pwd=null;
	public static Connection con=null;
	
	
	static 
	{
	    try 
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
		}
	    catch (Exception e) {
			
		}
	    
	}
	
	public static void main(String[] args) {
	    try
	    {
	    	Properties p=new Properties();
	    	FileInputStream f=new FileInputStream("D:/db.properties");
	    	p.load(f);
	    	
	    	url=p.getProperty("url");
	    	user=p.getProperty("user");
	    	pwd=p.getProperty("password");
	    	
	    	con=DriverManager.getConnection(url, user, pwd);
	    	Statement smt=con.createStatement();
	    	
	    	smt.executeLargeUpdate("create table demo(did int,dname varchar(20))");
	    	System.out.println("Table created Successfully");
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    catch(Exception e)
	    {
	    	
	    }
   
	}

}
