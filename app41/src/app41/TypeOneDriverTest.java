package app41;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TypeOneDriverTest {

	public static final String url="jdbc:mysql://localhost:3306/hit";
	public static final String user="root";
	public static final String pwd="root";
	public static void main(String[] args) {
		
		try
		{
			
			Connection con=DriverManager.getConnection(url,user,pwd);
			Statement smt=con.createStatement();
			
			smt.executeUpdate("insert into employees values(130,'ajeet',23000,'Delhi')");
			System.out.println("Inserted Successfully....");
		}
		catch(Exception e)
		{
			
		}
	}

}
