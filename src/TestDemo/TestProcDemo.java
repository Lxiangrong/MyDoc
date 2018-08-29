package TestDemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.Model.ConectDb;

public class TestProcDemo 
{
   //
	private ConectDb conectDb ;
	private Connection connection;
	private CallableStatement callableStatement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	//
	public TestProcDemo() 
	{
		// TODO Auto-generated constructor stub
		conectDb = new ConectDb();
		connection =conectDb.GetConnect();
		if(connection!=null)
		{
			try {
				callableStatement = connection.prepareCall("{call filecenterfenye (?,?,?,?,?,?)}");
				callableStatement.setString(1, "T_Base_Archive");
				callableStatement.setString(2, "37");
				callableStatement.setString(3, "1");
				callableStatement.setString(4, "ArchiveTitle,ArchiveDept");
				callableStatement.setString(5, "id");
				callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
				resultSet = callableStatement.executeQuery();
				metaData =resultSet.getMetaData();
				int coumns = metaData.getColumnCount();
				//System.out.println(callableStatement.getInt(6));
				while(resultSet.next())
				{
					for(int i=1;i<=coumns;i++)
					{
						System.out.print(resultSet.getString(i)+",");
					}
					System.out.println();
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					if(resultSet!=null)
						resultSet.close();
					if(callableStatement!=null)
						callableStatement.close();
					if(connection!=null)
						connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}
	
	
	
	public static void main(String[] args)
	{
		TestProcDemo testProcDemo = new TestProcDemo();
	}
	
}
