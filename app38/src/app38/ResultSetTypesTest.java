package app38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTypesTest {

	public static final String url="jdbc:mysql://localhost:3306/hit";
	public static final String user="root";
	public static final String password="root";
	public static Connection con=null;
	static
	{
		try 
		{
		     Class.forName("com.mysql.jdbc.Driver");
		     
			con=DriverManager.getConnection(url, user, password);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
	  
		try 
		{
			
		    Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);	
			
			ResultSet rs=smt.executeQuery("select * from employees");
			
			System.out.println("<---MOVEIN FORWORD DIRECTION--->");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+rs.getString(4));
			}
			
			System.out.println("<---MOVE IN BACKWORD DIRECTION--->");
			while(rs.previous())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+rs.getString(4));
					
			}
			
			rs.absolute(5);
			System.out.println("<---MOVE IN FORWORD DIRECTION AFTER ABSOLTE POSSION--->");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+rs.getString(4));
			}
		
			
			
			rs.absolute(-5);
			rs.relative(-3);
			System.out.println("<---AFTER RELATIVE POSITION--->");
			while(rs.previous())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+rs.getString(4));
					
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
     
	}

}
