package com.Contrl;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class FileCenterTablecell implements TableCellRenderer
{
     private JCheckBox box;
     private JTableHeader header;
     private FileCenterTable tablemodel;
     //
     public FileCenterTablecell(final JTable table) 
     {
		// TODO Auto-generated constructor stub
    	 tablemodel = (FileCenterTable)table.getModel();
    	 header = table.getTableHeader();
    	 box = new JCheckBox(tablemodel.getColumnName(0));
    	 box.setSelected(false);
    	/* header.addMouseListener(new MouseAdapter() 
    	 {
    		 @Override
    		public void mouseClicked(MouseEvent e) 
    		 {
    			// TODO Auto-generated method stub
    			//super.mouseClicked(e);
    			 if(e.getClickCount()>0)
			    	{
			    		int selectcount = header.columnAtPoint(e.getPoint());
			    		if(selectcount ==0)
			    		{
			    			boolean values1= !box.isSelected();
			    			box.setSelected(values1);
			    			tablemodel.selectAllOrNull(values1);
			    			header.repaint();
			    		}
			    	} 	
    		 }
		 });*/
	 }
     
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		Object temp = value;
		JLabel label = new JLabel((String) temp);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		box.setHorizontalAlignment(SwingConstants.CENTER);
        box.setBorderPainted(true);
		/*JComponent component = (column ==0) ?jCheckBox:label;*/
        JComponent component = label;
		component.setForeground(header.getForeground());
        component.setBackground(header.getBackground());
        component.setFont(header.getFont());
        //component.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		return component;
	}

}
