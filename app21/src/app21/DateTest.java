package app21;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateTest {

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
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
	  
		try {
			
			  Scanner s=new Scanner(System.in);
			  System.out.println("Enter the date in (YYYY-MM-DD)format: ");
			  String s1=s.next();
			  
//			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
//			  
//			  java.util.Date ud=sdf.parse(s1);
//			  
//			  long l=ud.getTime();
			  
			  java.sql.Date sd=java.sql.Date.valueOf(s1);
			  
			  System.out.println("enter the student id: ");
			  int sno=s.nextInt();
			  
			  System.out.println("Enter the student name: ");
			  String name=s.next();
			  
			  PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
			  ps.setInt(1, sno);
			  ps.setString(2, name);
			  ps.setDate(3, sd);
			  
			  ps.executeUpdate();
			  
			  System.out.println("Record Inserted Successfully...");
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    
	}

}
