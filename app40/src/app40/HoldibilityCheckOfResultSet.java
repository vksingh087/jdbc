package app40;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class HoldibilityCheckOfResultSet {

	
	public static final String url="jdbc:oracle:thin:@localhost:1521:XE"; 
	public static final String user="system";
	public static final String pwd="root";
	public static Connection con=null;
	
	static
	{
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(url, user, pwd);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {

            try
            {
            	DatabaseMetaData dbmd=con.getMetaData();
            	System.out.println(dbmd.supportsResultSetHoldability(2));
            	
            		
            
            }
            catch(Exception e)
            {
            	
            }
	}

}
