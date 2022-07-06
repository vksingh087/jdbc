package app47;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DisConnectedRowSetCheck {

	public static void main(String[] args) {
		
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hit","root", "root");
			
			RowSetFactory rsf=RowSetProvider.newFactory();
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from employees");
			CachedRowSet crs=rsf.createCachedRowSet();
			
			crs.populate(rs);
			
			con.close();
			
			while(crs.next())
			{
				System.out.println(crs.getInt(1)+" "+crs.getString(2)+" "+crs.getDouble(3)+" "+crs.getString(4));
			}
			
			
			
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
