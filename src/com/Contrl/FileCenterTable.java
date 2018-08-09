package com.Contrl;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

public class FileCenterTable  extends AbstractTableModel
{
	 private Vector<String> title;
	 private Vector<Vector<Object>> vector2;
	  //private OperationDb operationDb;
	 //String sql;
	 //TableRowSorter rowSorter;
	 
	 
	//
	 public FileCenterTable(Vector<String> title,Vector<Vector<Object>> vector2) 
	 {
		// TODO Auto-generated constructor stub
		 /*vector1 =new Vector<>();
		 vector1.add(" ");
		 vector1.add("责任者");
		 vector1.add("文件字号");
		 vector1.add("题名");
		 vector1.add("文件日期");
		 vector1.add("页数");
		 vector1.add("保管期限");
		 //vector1.add("备注");
		// operationDb = new OperationDb();
		 sql ="select top 10 t.ArchiveDuty,t.ArchiveNO,t.ArchiveTitle,t.ReceiveTime,t.PageCount,t.SaveLevel from T_Base_Archive t order by id desc";
		 //vector2 =operationDb.getresult(sql);
	     System.out.println(vector2.size());*/
		 this.title =title;
		 this.vector2=vector2;
		 //rowSorter = new TableRowSorter(this);
	 
	 }
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vector2.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return  vector2.get(arg0).get(arg1)  ;
	}
	//
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		 /*for(int i=0;i<title.size();i++)
		 {
			 if(i==3)
			 {
				 rowSorter.setSortable(i, true);
			 }
			 rowSorter.setSortable(i, false);
		 }*/
		return (String)title.get(column);
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex==0)
			return true;
		return false;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return getValueAt(0, columnIndex).getClass();

     }
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		vector2.get(rowIndex).set(columnIndex, aValue);	 
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	public void selectAllOrNull(Object result)
	{
		for(int i=0;i<=getRowCount();i++)
		{
			setValueAt(result, i, 0);
		}
	}
	//
}
