package app36;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

public class ParamterMetaDataTest {


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
			   PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?,?)");
			   
			   ParameterMetaData pmd=ps.getParameterMetaData();
			   
			   int count=pmd.getParameterCount();
	    	    System.out.println(count);
	    	    
	    	    for(int i=1;i<=count;i++)
	    	    {
	    	    	System.out.println(pmd.getParameterMode(i));
	    	    	//System.out.println(pmd.getParameterType(i));
	    	    	//System.out.println(pmd.getPrecision(i));
	    	    	//System.out.println(pmd.getScale(i));
	    	    	//System.out.println(pmd.getParameterTypeName(i));
	    	    }
	       }
	       catch(Exception e)
	       {
	    	   System.out.println(e);
	       }

	}

}
