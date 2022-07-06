package app20;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
		
		Date d=new Date();
		System.out.println(d);
		long l=d.getTime();
		
		
		java.sql.Date sd=new java.sql.Date(l);
		System.out.println(sd);

	}

}
