package app31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionTest {
  public static final String url="jdbc:mysql://localhost:3306/hdfcbank";
  public static final String user="root";
  public static final String password="root";
  public static Connection con=null;
  
  static
  {
	  try {
		
		      Class.forName("com.mysql.jdbc.Driver");
		      con=DriverManager.getConnection(url, user, password);
		  
		  
	} catch (Exception e) {
		// TODO: handle exception
	}
  }
  
	public static void main(String[] args) 
	{
            
            try 
            {
			         Statement st=con.createStatement();
			         con.setAutoCommit(false);
			         Scanner sc=new Scanner(System.in);
			         System.out.println("Enter the amount you want to Transfer: ");
			         int amount=sc.nextInt();
			         st.executeUpdate("update account set balance=balance-"+amount+" where accNo=111");
			         st.executeUpdate("update account set balance=balance+"+amount+" where accNo=222");
			         
			         System.out.println("Are Your Sure Want to Transfer Fund :");
			         
			         String confirm=sc.next();
			         
			         if(confirm.equalsIgnoreCase("yes"))
			         {
			        	 con.commit();
			         }
			         else
			         {
			        	 con.rollback();
			        	 System.out.println("Transaction Failed....");
			        	 
			         }
			         
			         
			         System.out.println("Transaction Completed....");
			         
			         ResultSet rs=st.executeQuery("select * from account where accNo in (111,222)");
			         
			         while(rs.next())
			         {
			        	 System.out.println("Your AccNO is"+rs.getInt(1));
			        	 System.out.println("Your Name is"+rs.getString(2));
			        	 System.out.println("Your Balance is"+rs.getInt(3));
			        	 System.out.println("------------------------------------------------");
			         }
			         
			         
			} 
            catch (Exception e) {
				System.out.println(e);
			}

	}

}
