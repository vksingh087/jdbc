package app09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlToOracle 
{
	
	public static final String mysqlurl="jdbc:mysql://localhost:3306/hit";
	public static final String oracleurl="jdbc:oracle:thin:@localhost:1521:XE";
	
	public static final String mysqluser="root";
	public static final String oracleuser="system";
	
	public static final String mysqlpwd="root";
	public static final String oraclepwd="root";
	
	public static Connection mysqlcon=null;
	public static Connection oraclecon=null;

	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.OracleDriver");
			
			mysqlcon=DriverManager.getConnection(mysqlurl, mysqluser, mysqlpwd);
			oraclecon=DriverManager.getConnection(oracleurl, oracleuser, oraclepwd);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args)
	{
		 try
		 {
			 Statement mysqlsmt=mysqlcon.createStatement();
			 Statement oraclesmt=oraclecon.createStatement();
			 
			 ResultSet rs= mysqlsmt.executeQuery("select * from employees");
			 
			 while(rs.next())
			 {
				 int eno=rs.getInt(1);
				 String ename=rs.getString(2);
				 double esal=rs.getDouble(3);
				 String eaddr=rs.getString(4);
				 
				 oraclesmt.executeUpdate("insert into officer values('"+eno+"','"+ename+"','"+esal+"','"+eaddr+"')");
				 
				 
				 
			 }
			 System.out.println("All Record Transfer Successfully....");
			 
			 
		 }
		 catch(Exception e)
		 {
			 System.out.print(e);
		 }

	}

}
