package app24;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class MysqlConnectionPoolTest {

	public static void main(String[] args) {
		
		
		try
		{
			
			MysqlConnectionPoolDataSource ds=new MysqlConnectionPoolDataSource();
			
			ds.setUrl("jdbc:mysql://localhost:3306/hit");
			ds.setUser("root");
			ds.setPassword("root");
			
			Connection con =ds.getConnection();
			
			Statement smt=con.createStatement();
			
			ResultSet rs=smt.executeQuery("select * from employees");
			
			while(rs.next())
			{
				System.out.println("ENO :" + rs.getInt(1));
				System.out.println("Ename: "+ rs.getString(2));
				System.out.println("Esal: "+rs.getDouble(3));
				System.out.println("Address: "+rs.getString(4));
				System.out.println("-------------------------------------------");
			}
			
			
			
		}
		catch(Exception e)
		{
			
		}

	}

}
