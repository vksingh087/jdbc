package app32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

public class SavePointTest {
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
				         st.executeUpdate("update account set balance=balance+1 where accNo=111");
				         st.executeUpdate("update account set balance=balance+1 where accNo=222");
				         
				         Savepoint sp=con.setSavepoint();
				         Scanner s=new Scanner(System.in);
				         
				         System.out.println("Enter the amount want to transfer: ");
				         int amt=s.nextInt();
				         
				         st.executeUpdate("update account set balance=balance-"+amt+" where accNo=111");
				         st.executeUpdate("update account set balance=balance+"+amt+" where accNo=222");
				         
				         if(amt<1000)
				         {
				        	 con.rollback(sp);
				        	 System.out.println("Enter Amount Greater than 1000.");
				         }
				         else
				         {
				        	 con.commit();
				        	 System.out.println("Transaction Completed Successfully .");
				         }
				         
				         con.commit();
				         
	            }
	            catch(Exception e)
	            {
	            	
	            }

	}

}
