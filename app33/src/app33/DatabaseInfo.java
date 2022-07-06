package app33;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseInfo {

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
    	   System.out.println("Database Name: "+mdata.getDatabaseProductName());
    	   System.out.println("Database Version: "+mdata.getDatabaseMajorVersion());
    	   System.out.println("Database Version: "+mdata.getDatabaseMinorVersion());
    	   System.out.println("JDBC Major Version: "+mdata.getJDBCMajorVersion());
    	   System.out.println("JDBC Major Version: "+mdata.getJDBCMinorVersion());
    	   System.out.println("Driver Name: "+mdata.getDriverName());
    	   System.out.println("Driver Version: "+mdata.getDriverVersion());
    	   System.out.println("URL: "+mdata.getURL());
    	   System.out.println("USER: "+mdata.getUserName());
    	   System.out.println("MAX column: "+mdata.getMaxColumnsInTable());
		   
    	   
	} 
       catch (Exception e) {
		System.out.println(e);
	}

	}

}
