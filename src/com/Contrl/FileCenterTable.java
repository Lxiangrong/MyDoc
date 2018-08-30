package com.Contrl;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class FileCenterTable  extends AbstractTableModel
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<String> title;
	 private Vector<Vector<Object>> vector2;
	  
	 
	 
	//
	 public FileCenterTable(Vector<String> title,Vector<Vector<Object>> vector2) 
	 {
		// TODO Auto-generated constructor stub
	
		 this.title =title;
		 this.vector2=vector2;
	 
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
