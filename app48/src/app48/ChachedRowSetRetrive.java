package app48;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class ChachedRowSetRetrive {

	public static void main(String[] args) {
		try {
			
			RowSetFactory rsf=RowSetProvider.newFactory();
			
			CachedRowSet crs=rsf.createCachedRowSet();
			
			crs.setUrl("jdbc:mysql://localhost:3306/hit");
			crs.setUsername("root");
			crs.setPassword("root");
			
			crs.setCommand("select * from employees");
			crs.execute();
			
			while(crs.next())
			{
				System.out.println(crs.getInt(1)+" "+crs.getString(2)+" "+crs.getDouble(3)+" "+crs.getString(4));
			}
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
