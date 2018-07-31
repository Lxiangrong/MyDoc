package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectDb 
{
  
	//
	private final String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String Url="jdbc:sqlserver://127.0.0.1:1433;databaseName=ELEDoc";
	private final String username="sa";
	private final String password="akie@163.com";
	private Connection result =null;
	//
	public Connection GetConnect()
	{
		try {
			 Class.forName(Driver);
			 result = DriverManager.getConnection(Url, username, password);
			 if(result==null)
			 {
				 System.out.println("Çý¶¯ÓÐÎó");
			 }
		    } 
		   catch (Exception e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		return result;
	}
	
}
