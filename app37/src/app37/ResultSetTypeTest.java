package app37;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ResultSetTypeTest {
	
	
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
		
		public static void main(String[] args) {
	    
	       try 
	       {
	    	        DatabaseMetaData dm=con.getMetaData(); 
	    	        
	    	        System.out.println(dm.supportsResultSetConcurrency(1003, 1007));
	    	        System.out.println(dm.supportsResultSetConcurrency(1003, 1008));
	    	      
	       }
	       catch(Exception e)
	       {
	    	   
	       }
	       
		}
}
