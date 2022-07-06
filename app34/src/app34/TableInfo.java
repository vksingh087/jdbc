package app34;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TableInfo {

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
    	   DatabaseMetaData mdata=con.getMetaData();  
    	   
    	   ResultSet rs=mdata.getTables(null, null, null, null);
    	   
    	   while(rs.next())
    	   {
    		   System.out.println(rs.getString(3));
    	   }
    	   
    	   
    	   
       }
       catch(Exception e)
       {
    	   
       }
	}

}
