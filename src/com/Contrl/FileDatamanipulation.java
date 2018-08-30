package com.Contrl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.Model.ConectDb;

/**
 * �ļ�����ģ�����ݲ�����
 * 
 * */

public class FileDatamanipulation
{
   //������ر���
	private String tablename;//��������
	private ConectDb conectDb;
	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private ResultSetMetaData metaData;
	//constructor
	public FileDatamanipulation(String tablename) 
	{
		// TODO Auto-generated constructor stub
		this.tablename = tablename;
		conectDb = new ConectDb();
	}
	
	//��ȡ���ܼ�¼��
	public int Getpagecount()
	{
	   int result =0;
		
		if(conectDb!=null)
		{
			connection = conectDb.GetConnect();
			if(connection!=null)
			{
				try {
					preparedStatement =connection.prepareStatement("select count(*) from "+tablename);
					resultSet =preparedStatement.executeQuery();
					if(resultSet!=null)
					{
						while(resultSet.next())
						{
							result = resultSet.getInt(1);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					closeall();
				}
			}
			
		}
		return result;
	}
	
	//�ر����ݿ���ز���
	public void closeall()
	{
		try {
			 if(resultSet!=null)
				 resultSet.close();
			 if(preparedStatement!=null)
			 { preparedStatement.close();
			   
			 }
			 if(callableStatement!=null)
				 callableStatement.close();
			 if(connection!=null)
				 connection.close();
			
		} catch (Exception e)
        {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//������ز���������ݱ�
	public void SetTable(JTable table ,String columns,String keywords,int pagesize,int pagenow)
	{
		Vector<Vector<Object>> datas= new Vector<>();
		Vector<String> columnames = new Vector<>();
		int numcolumns =0;
		TableColumn tableColumn;
		if(conectDb!=null)
		{
			connection = conectDb.GetConnect();
			if(connection!=null)
			{
				try {
					callableStatement = connection.prepareCall("{call filecenterfenye (?,?,?,?,?,?)}");
					callableStatement.setString(1, tablename);
					callableStatement.setInt(2, pagesize);
					callableStatement.setInt(3, pagenow);
					callableStatement.setString(4, columns);
					//System.out.println(columns);
					callableStatement.setString(5, keywords);
					callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
					resultSet =callableStatement.executeQuery();
					//��ȡ������
					if(resultSet!=null)
					{
						 while(resultSet.next())
						 {
							 metaData =resultSet.getMetaData();
							 numcolumns = metaData.getColumnCount();
							 System.out.println(numcolumns);
								while(resultSet.next())
								{

									   Vector<Object> temp = new Vector<>();
									   temp.add(false);
									   for(int i=1;i<=numcolumns;i++)
									   {
										   temp.add(resultSet.getString(i));
									   }
									   datas.add(temp);
								}
						 }
					}
					//��ȡ����
					columnames.add("");
					for(int i=1;i<=numcolumns;i++)
					{
						columnames.add(metaData.getColumnName(i));
					}
					//��ʼ�������������
					FileCenterTable fileCenterTable = new FileCenterTable(columnames,datas);
					table.setModel(fileCenterTable);
					table.getTableHeader().setResizingAllowed(false);
					table.getTableHeader().setReorderingAllowed(false);
					tableColumn = table.getColumnModel().getColumn(3);
					tableColumn.setPreferredWidth(550);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					
					closeall();
				}
			}
		}
	}
	//ɾ����������ز���
	public boolean DeleteData(String parameter,String parameter2 )
	{
		boolean resultes = false;//����ɾ�����
		 try 
		   {
			   connection = conectDb.GetConnect();
			   String sqlstament ="delete "+tablename+"  where ArchiveTitle ='"+parameter+"' and ArchiveNO ='"+parameter2+"'";
			   if(connection!=null)
			   {
				   preparedStatement = connection.prepareStatement(sqlstament);
				   int resultnum =preparedStatement.executeUpdate();
				   if(resultnum>0)
				   {
					   resultes=true;
				   }
			   }  
		  } catch (Exception e) 
		   {
			// TODO: handle exception
			e.printStackTrace();
		  }finally 
		   {
			  closeall();  
		   } 
		return resultes;
	}
	
	
	
	
	
}
