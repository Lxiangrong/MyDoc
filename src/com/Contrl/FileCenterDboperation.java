package com.Contrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.table.TableRowSorter;

import com.Model.ConectDb;

public class FileCenterDboperation
{
   private Connection connection;
   private ConectDb  ConectDbs; 
   private Vector<Vector<Object> > result;
   private boolean resuts;
   private ResultSet resultSet;
   private PreparedStatement preparedStatement;
   private ResultSetMetaData metaData;
   private String sqlstament;
   private Vector<String> columnname;
   //
   public FileCenterDboperation(String sqlstament) 
   {
	// TODO Auto-generated constructor stub
	   ConectDbs = new ConectDb();
	   //connection = ConectDbs.GetConnect();
	   result = new Vector<>();
	   this.sqlstament =sqlstament;
	   columnname = new Vector<>();
   }
   //
      public FileCenterDboperation() 
      {
		// TODO Auto-generated constructor stub
      ConectDbs = new ConectDb();
   	   //connection = ConectDbs.GetConnect();
   	   result = new Vector<>();
   	  // this.sqlstament =sqlstament;
   	   columnname = new Vector<>();
    	  
	  }
   //
   public Vector<Vector<Object>> getresultset()
   {
	   
	   try {
		   connection =ConectDbs.GetConnect();
		   if(connection!=null)
		   {
			   preparedStatement = connection.prepareStatement(sqlstament);
			   resultSet = preparedStatement.executeQuery();
			   metaData =resultSet.getMetaData();
			   int columnnum = metaData.getColumnCount();
			   while(resultSet.next())
			   {
				   Vector<Object> temp = new Vector<>();
				   temp.add(false);
				   for(int i=1;i<=columnnum;i++)
				   {
					   temp.add(resultSet.getString(i));
				   }
				   result.add(temp);
			   }
		   }
		   	   
	      } 
	   catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	  }finally{
		  
		  closeall();
	  }
	   
	   return result;
   }
   
   //
   public Vector<String> getcolumnamees()
   {
	    try {
	    	connection =ConectDbs.GetConnect();
	    	 if(connection!=null)
	    	 { 
	    		preparedStatement = connection.prepareStatement(sqlstament);
	    		//System.out.println(sqlstament);
				resultSet = preparedStatement.executeQuery();
				metaData =resultSet.getMetaData();
				int cloumnnum =metaData.getColumnCount();
				columnname.add(" ");
				//System.out.println(cloumnnum);
				for(int j=1;j<=cloumnnum;j++)
				{
					columnname.add(metaData.getColumnName(j));
					//System.out.println(metaData.getColumnName(j));
				}
	    	 }
	    	 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeall();
		}
	   
	   return columnname;
   }
   
  //
   public boolean DeleteData(String parameter,String parameter2)
   {
	   boolean resultes = false;
	   try 
	   {
		   connection = ConectDbs.GetConnect();
		   String sqlstament ="delete  T_Base_Archive  where ArchiveTitle ='"+parameter+"' and ArchiveNO ='"+parameter2+"'";
		   if(connection!=null)
		   {
			   //System.out.println(sqlstament);
			   preparedStatement = connection.prepareStatement(sqlstament);
			   resultes =preparedStatement.execute();
			   System.out.println(resultes);
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
   
	
   //
   public void closeall()
   {   
	   try {
		   if(resultSet!=null)
			   resultSet.close();
		   if(preparedStatement!=null)
			   preparedStatement.close();
		   if(connection!=null)
			   connection.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   
   }
	
}
