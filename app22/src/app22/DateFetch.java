package app22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DateFetch {

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
		try
		{
			 PreparedStatement ps=con.prepareStatement("select * from student");
			 
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				int sno=rs.getInt(1);
				String name=rs.getString(2);
				java.sql.Date sd=rs.getDate(3);
				System.out.println(sno+" "+name+" "+sd);
			}
			
		}catch(Exception e)
		{
			
		}

	}

}
