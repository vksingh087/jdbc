package app19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecord {

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
			System.out.println(e);
		}
	}
	
	
	
	public static void main(String[] args) {
		try
		{
			   Statement st1=con.createStatement();
			   Statement st2=con.createStatement();
			   
			   String q1="select * from employees";
			   String q2="select ename,esal from employees where eno<=110";
			   
			   ResultSet rs1=st1.executeQuery(q1);
			   ResultSet rs2=st2.executeQuery(q2);
			   
			   while(rs1.next())
			   {
				   System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getDouble(3)+rs1.getString(4));
			   }
			   
			   System.out.println("**************************************************************");
			   
			   while(rs2.next())
			   {
				   System.out.println(rs2.getString(1)+" = "+rs2.getDouble(2));
			   }
			   
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
