package app23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnectionPoolTest {

	public static void main(String[] args) {
		try
		{
			
			OracleConnectionPoolDataSource ds=new OracleConnectionPoolDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521:XE");
			ds.setUser("system");
			ds.setPassword("root");
			
			Connection con=ds.getConnection();
			
			Statement smt=con.createStatement();
			smt.executeUpdate("insert into employee values(106,'Yatharth',54000)");
			System.out.println("Record inserted Successfully.......");
		    
			
		}
		catch(Exception e)
		{
			
		}

	}

}
