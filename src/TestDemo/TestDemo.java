package TestDemo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import com.Model.ConectDb;

public class TestDemo extends JFrame {
	private JPanel panel;
	private JTable table;
	//private Object data[][] ;
	private JScrollPane scrollPane;
	//private JButton button ;
	private JCheckBox box;
	private 	TableColumn tableColumn;
	public TestDemo() {
		
		// TODO Auto-generated constructor stub
     	/*panel =new MainToppanel();
		add(panel,BorderLayout.NORTH);*/
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 300));
		/*data= new Object[][]
			
	   {
		{"demo_1",true,2440},
		{"demo_2",false,2110},
		{"demo_2",true,2230}		
		};
		String title[] =
			{
				"name","result","sail"	
			};
		table = new JTable(data, title);
		table.setAutoCreateRowSorter(true);
		scrollPane = new JScrollPane(table);
		button = new JButton("��ӡ");
		button.setPreferredSize(new Dimension(100, 20));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(scrollPane);
		panel.add(button);*/
		AbstractTableModel model = new Mytablemodel();
		box = new JCheckBox();
		table = new JTable(model);
		table.getTableHeader().setDefaultRenderer(new CheckHeaderCellRenderer(table));
		table.setAutoCreateRowSorter(true);
		System.out.println(table.getSelectedRows()+","+table.getSelectedColumns());
		//table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(true);
	
		
		
		//box = new JCheckBox();
        tableColumn =table.getColumnModel().getColumn(0);
       /* tableColumn.setResizable(false);
        tableColumn.setPreferredWidth(200);*/
        //tableColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
        //tableColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
       // tableColumn.setCellEditor(new DefaultCellEditor(box));
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		add(panel,BorderLayout.CENTER);
		//
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
        new TestDemo();
        
	}

}

/*public class TestDemo  {

  private JFrame frame ;
	
public TestDemo()
{
	frame =new MainWindowsFrame();
	
}

public static void main(String[] args) 
{
	// TODO Auto-generated method stub
	
	new TestDemo();
}

}*/


//����ģ��

class Mytablemodel extends AbstractTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	 private Vector<Object> vector1;
	Vector<Vector<Object>> vector2;
	 private OperationDb operationDb;
	 String sql;
	 
	//
	 public Mytablemodel() 
	 {
		// TODO Auto-generated constructor stub
		 vector1 =new Vector<>();
		 vector1.add(" ");
		 vector1.add("������");
		 vector1.add("�ļ��ֺ�");
		 vector1.add("����");
		 vector1.add("�ļ�����");
		 vector1.add("ҳ��");
		 vector1.add("��������");
		 //vector1.add("��ע");
		 operationDb = new OperationDb();
		 sql ="select top 10 t.ArchiveDuty,t.ArchiveNO,t.ArchiveTitle,t.ReceiveTime,t.PageCount,t.SaveLevel from T_Base_Archive t order by id desc";
		 vector2 =operationDb.getresult(sql);
	     System.out.println(vector2.size());
	 
	 }
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return vector1.size();
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
		return (String)vector1.get(column);
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
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
		for(int i=0;i<getRowCount()-1;i++)
		{
			setValueAt(result, i, getColumnCount()-1);
		}
	}
   
}

//
class CheckHeaderCellRenderer implements TableCellRenderer
{
     private JCheckBox jCheckBox;
     private JTableHeader tableHeader;
     private Mytablemodel mytablemodel;
	
	  //
	   public CheckHeaderCellRenderer(final JTable table) 
	   {
		// TODO Auto-generated constructor stub
		   mytablemodel = (Mytablemodel)table.getModel();
		   tableHeader = table.getTableHeader();
		   jCheckBox =new JCheckBox(mytablemodel.getColumnName(0));
		   jCheckBox.setSelected(false);
		   tableHeader.addMouseListener(new MouseAdapter() 
		   {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	// TODO Auto-generated method stub
			    	if(e.getClickCount()>0)
			    	{
			    		int selectcount = tableHeader.columnAtPoint(e.getPoint());
			    		if(selectcount ==0)
			    		{
			    			boolean values1= !jCheckBox.isSelected();
			    			jCheckBox.setSelected(values1);
			    			mytablemodel.selectAllOrNull(values1);
			    			tableHeader.repaint();
			    		}
			    	} 	
			    }   
		   });
	   }
	
	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		
		Object temp = value;
		JLabel label = new JLabel((String) temp);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		jCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        jCheckBox.setBorderPainted(true);
		JComponent component = (column ==0) ?jCheckBox:label;
		component.setForeground(tableHeader.getForeground());
        component.setBackground(tableHeader.getBackground());
        component.setFont(tableHeader.getFont());
        //component.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		return component;
	}
}



//
class OperationDb
{
	//
	private Connection connection ;
	private Vector<Vector<Object>> vectors;
	private ConectDb connect;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;
	//
	public OperationDb() 
	{
		// TODO Auto-generated constructor stub
		connect = new ConectDb();		
		vectors =new Vector<>();
	}
	//
	public Vector<Vector<Object>> getresult(String sql)
	{
		
		connection = connect.GetConnect(); 
		if(connection!=null)
		{
			//System.out.println("456");	
		  try {
			   statement = connection.prepareStatement(sql);
			   resultSet = statement.executeQuery();
			   resultSetMetaData =resultSet.getMetaData();
			   
			   while(resultSet.next())
			   {
				   Vector<Object> vector2 = new Vector<>();
				   vector2.add(false);
				   int column = resultSetMetaData.getColumnCount();
				   if(column>0)
				   {
					   int temp=1;
					   do 
					   {
						//System.out.println(resultSet.getString(column));
						vector2.add(resultSet.getString(temp));	   
						temp++;   
					   } while (temp<=column);   
					   				   
				   }   
					   
				   vectors.add(vector2);	   
			   }	  
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.close();
		}			
		}
		else 
		{
			System.out.println("123");	
			
		}
		return vectors;
	}
	
	//
	public void close()
	{
		
			try {
				if(resultSet!=null)
				resultSet.close();
				if(statement!=null);
				statement.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}


}
