/*
 * ÅÐ¶ÏµÇÂ¼ÕËºÅ¡¢ÃÜÂë
 * 
 */
package com.Contrl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Model.ConectDb;

public class LoginDecide 
{

	//
	private ConectDb conectDb;
	private Connection connection;
	private ResultSet resultSet = null;
	private Statement statement =null;
	private boolean result =false;
	public static String name = null;
	
	//
	public LoginDecide()
	{
		conectDb = new ConectDb();
	}
	//
	public boolean getresult(String username,String password)
	{
		connection =conectDb.GetConnect();
		try {
			statement =connection.createStatement();
			resultSet =statement.executeQuery("select * from dbo.T_Sys_UserInfo where User_ID='"+username+"' and Password ='"+password+"'");
			if(resultSet.next())
			{
				result=true;
				LoginDecide.name = username;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{
			closeAll();
		}
		return result;
	}
	//
	public void closeAll()
	{
		try {
			statement.close();
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
