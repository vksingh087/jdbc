package app35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.ResultSetMetaData;

public class MetaDataTest {
	

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
		
    	     Statement st=con.createStatement();
    	     
    	     ResultSet rs=st.executeQuery("select * from employees");
    	     
    	     ResultSetMetaData rsmd=rs.getMetaData();
    	     
    	     int count=rsmd.getColumnCount();
    	     System.out.println(count);
    	     
    	     for(int i=1;i<=count;i++)
    	     {
    	    	 System.out.println("Column number: "+i);
    	    	 System.out.println("Column Name: "+rsmd.getColumnName(i));
    	    	 System.out.println("Column Type: "+rsmd.getColumnType(i));
    	    	 System.out.println("Column Size: "+rsmd.getColumnDisplaySize(i));
    	    	 
    	     }
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	     
    	   
    	   
    	   
    	   
	} catch (Exception e) {
		// TODO: handle exception
	}

	}

}
