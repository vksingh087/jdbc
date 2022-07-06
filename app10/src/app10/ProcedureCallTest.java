package app10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureCallTest {

	public static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String user="system";
	public static final String pwd="root";
	public static Connection con=null;
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(url,user,pwd);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		try
		{
			CallableStatement cs=con.prepareCall("{call getSum(?,?,?)}");
			cs.setInt(1, 100);
			cs.setInt(2, 200);
			
			cs.registerOutParameter(3, Types.INTEGER);
			
			cs.execute();
			
			int n=cs.getInt(3);
			
			System.out.println("Sum is: "+n);		
			
		}
		catch(Exception e)
		{
			
		}
		
	

	}

}
