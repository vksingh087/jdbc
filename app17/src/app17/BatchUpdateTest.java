package app17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdateTest {

	
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
			
		   Statement s=con.createStatement();
		   s.addBatch("insert into employees values(122,'Govind',14000,'Noida')");
		   s.addBatch("insert into employees values(123,'Gyan',14000,'Noida')");
		   s.addBatch("delete from employees where eno=109");
		   s.addBatch("update employees set esal=10000 where eno<=110");
		   
		   int n[]=s.executeBatch();
		   
		   System.out.println(n[0]+n[1]+n[2]+n[3]);
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
