package app14;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

  public class GetESal {

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
		try {
			
			
		Scanner s=new Scanner(System.in);
       
		System.out.println("Enter Employee Salary: ");
		int sal=s.nextInt();
		
		CallableStatement cs=con.prepareCall("{call getHighSal(?,?)}");
		cs.setInt(1, sal);
		cs.registerOutParameter(2,OracleTypes.CURSOR);
		
		cs.execute();
		
		ResultSet rs=(ResultSet)cs.getObject(2);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getInt(3));
		}
		
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
			
	
	}

}
