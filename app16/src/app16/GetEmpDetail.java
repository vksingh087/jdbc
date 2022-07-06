package app16;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class GetEmpDetail 
{
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
		
		CallableStatement cs=con.prepareCall("{? = call getEmp(?,?)}");
		cs.setInt(2,x);
		cs.setInt(3,y);
		
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		
		ResultSet rs=(ResultSet)cs.getObject(1);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));  
		    
			
		}
		
		
		
		
		
		
		
		
	}
	catch(Exception e)
	{
		
	}

}
}
