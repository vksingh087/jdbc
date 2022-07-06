package app15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class FunctionTest {
	
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
			// TODO: handle exception
		}
	}

	public static void main(String[] args) 
	{
	   	
		try 
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Two Employee id's : ");
			int x=s.nextInt();
			int y=s.nextInt();
			
			CallableStatement cs=con.prepareCall("{? = call getAvg(?,?)}");
			
			
			
			cs.setInt(2, x);
			cs.setInt(3, y);
			cs.registerOutParameter(1, Types.FLOAT);
			
			cs.execute();
			
			System.out.println("Avg of two Employee is: "+cs.getFloat(1));
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}

}
