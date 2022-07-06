package app03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleJavaCon {
	
	public static final String url="jdbc:oracle:thin:@localhost:1521:XE";
    public static final String user="system";
    public static final String pwd="root";
	
	public static void main(String[] args) {
	   try
	   {
		   Class.forName("oracle.jdbc.OracleDriver");
		   Connection con=DriverManager.getConnection(url,user,pwd);
		   Statement smt=con.createStatement();
		   
		   smt.executeUpdate("insert into student values(101,'Sachin',12000,'sre')");
		   System.out.println("One Record inserted Successfully....");
		   
		   
	   }
	   catch(Exception e)
	   {
		   
	   }
   
	}

}
