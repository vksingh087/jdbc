package app18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMultiBatch {

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
			PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?,?)");
			
			Scanner s=new Scanner(System.in);
			System.out.print("Are you want to insert record[Yes/No]: ");
			String res=s.next();
			
			while(res.equalsIgnoreCase("yes"))
			{
				System.out.print("Enter Eno: ");
				int eno=s.nextInt();
				System.out.print("Enter Ename: ");
				String name=s.next();
				System.out.print("Enter Esal: ");
				double esal=s.nextDouble();
				System.out.print("Enter Address: ");
				String addr=s.next();
				
				ps.setInt(1, eno);
				ps.setString(2, name);
				ps.setDouble(3, esal);
				ps.setString(4, addr);
				
				ps.addBatch();
				
				System.out.print("Are Your want to insert More Record[Yes/No]: ");
				res=s.next();
				
				if(res.equalsIgnoreCase("no"))
					break;
				
			}
			
			ps.executeBatch();
			System.out.println("Record Inserted Successfully......");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
