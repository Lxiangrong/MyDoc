package com.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import com.Contrl.FileCenterDboperation;
import com.Contrl.FileCenterTable;


public class FileCenterPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private ImageIcon miImageIcon,qImageIcon,fImageIcon;
	private JMenuBar menuBar;
	private JMenu Menu;
	private JMenuItem wMenuItem,qMenuItem;
	private JPanel Mlpanel,Centerpanels,centerfilePanel,otherpanel;
	private BorderLayout borderLayout;
	private CardLayout cardLayout;
    public static String menuname ="文书文件";
    public static int width;
    //private JTable table;
	
	public FileCenterPanel() 
	{
	
		this.Init();
	}
	
	//
	 public void Init()
	 {
			// TODO Auto-generated constructor stub
			borderLayout = new BorderLayout();
			borderLayout.setHgap(0);
			borderLayout.setVgap(0);
			setLayout(borderLayout);
			cardLayout=new CardLayout();
			Centerpanels = new JPanel();
			Centerpanels.setLayout(cardLayout);
			centerfilePanel = new CenterfilePanel();
			otherpanel = new OtherfilePanel();
			Centerpanels.add(centerfilePanel,"cp");
			Centerpanels.add(otherpanel,"op");
			add(Centerpanels,borderLayout.CENTER);
			miImageIcon = new ImageIcon("Images/alluser.gif");
			fImageIcon = new ImageIcon("Images/tb_01.gif");
			qImageIcon = new ImageIcon("Images/tb_09.gif");	
			 //
		    Mlpanel = new MainLeftpanel();
		    menuBar = new JMenuBar();
		    Menu = new JMenu("文件管理");
		    Menu.setIcon(miImageIcon);
		    wMenuItem = new JMenuItem("文书文件", fImageIcon);
		    wMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.out.println(wMenuItem.getText());
					cardLayout.show(Centerpanels, "cp");
					menuname = wMenuItem.getText();
				}
			});
		    wMenuItem.setPreferredSize(new Dimension(MainLeftpanel.WIDTH+200, 20));
		    qMenuItem = new JMenuItem("其他文件", qImageIcon);
		    qMenuItem.setPreferredSize(new Dimension(MainLeftpanel.WIDTH+200, 20));
		    qMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//System.out.println(qMenuItem.getText());
					cardLayout.show(Centerpanels, "op");
					menuname = qMenuItem.getText();	
				}
			});
		    width = wMenuItem.getWidth();
		    Menu.add(wMenuItem);
		    Menu.setPreferredSize(new Dimension(MainLeftpanel.WIDTH+200, 20));
		    Menu.add(qMenuItem);
		    menuBar.add(Menu);
		    menuBar.setBackground(Color.yellow);
		    menuBar.setPreferredSize(new Dimension(MainLeftpanel.WIDTH+200, 20));
		    Mlpanel.add(menuBar);
		    //
		   this.add(Mlpanel,borderLayout.WEST);
	 }
	
}

//
class CenterfilePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowLayout layout,layout2;
	private JLabel label,label2;
	private ImageIcon imageIcon,idj,icx,igd,isq;
	private Dimension dimension;
	private JButton dj,cx,gd,sq;
	private JTable table;
	private JScrollPane scrollPane;
	private String sqlstament;
	//
	public CenterfilePanel() 
	{
		// TODO Auto-generated constructor stub
		//Cpanel = new JPanel();
		initpanel();
		
	}
	//
	public void initpanel()
	{
		
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		idj = new ImageIcon("Images/dj.gif");
		icx = new ImageIcon("Images/cx.gif");
		igd = new ImageIcon("Images/gd.gif");
		isq = new ImageIcon("Images/sq.gif");
		//
		dj = new JButton(idj);
		dj.setPreferredSize(new Dimension(idj.getIconWidth(), idj.getIconHeight()));
		cx = new JButton(icx);
		cx.setPreferredSize(new Dimension(icx.getIconWidth(), icx.getIconHeight()));
		gd = new JButton(igd);
		gd.setPreferredSize(new Dimension(igd.getIconWidth(), igd.getIconHeight()));
		sq = new JButton(isq);
		sq.setPreferredSize(new Dimension(isq.getIconWidth(), isq.getIconHeight()));
		//Cpanel.setPreferredSize(new Dimension((int)dimension.getWidth()-FileCenterPanel.width-250, dj.getHeight()+30));
		layout2 =new FlowLayout(FlowLayout.LEFT);
		layout2.setVgap(0);
		layout2.setHgap(20);
		label2 = new JLabel();
		label2.setOpaque(false);
		label2.setLayout(layout2);
		label2.setPreferredSize(new Dimension((int)dimension.getWidth()-FileCenterPanel.width-250, dj.getHeight()+30));
		label2.add(dj);
		label2.add(cx);
		label2.add(gd);
		label2.add(sq);
		//
		layout = new FlowLayout();
		layout.setVgap(0);
		layout.setHgap(10);
		imageIcon = new ImageIcon("Images/middle_right_tb.gif");
		label =new JLabel("您现在的位置:文件管理>"+FileCenterPanel.menuname, imageIcon,SwingConstants.LEFT );	
		label.setPreferredSize(new Dimension((int)dimension.getWidth()-FileCenterPanel.width-250, imageIcon.getIconHeight()));
		label.setOpaque(true);	
		//
		sqlstament ="select top 38 t.ArchiveDuty as 责任者 ,t.ArchiveNO as 文件字号 ,t.ArchiveTitle as 题名,t.ReceiveTime as 文件日期 ,t.PageCount as 页数,t.SaveLevel as 保管期限  from T_Base_Archive t order by id desc";
		table = new JTable();
		InitTable(table, sqlstament);
		table.setPreferredScrollableViewportSize(new Dimension((int)dimension.getWidth()-FileCenterPanel.width-250, (int)dimension.getHeight()-100));
		scrollPane = new JScrollPane(table);
		//
		this.add(label);
		this.add(label2);
		this.add(scrollPane);
	}
	
	//
	 public void InitTable(JTable table,String sqlstament)
	 {
		 FileCenterDboperation fileCenterDboperation = new FileCenterDboperation(sqlstament);
		 Vector<String>  title = fileCenterDboperation.getcolumnamees();
		 Vector<Vector<Object>> data = fileCenterDboperation.getresultset();
		 FileCenterTable fileCenterTable =new FileCenterTable(title, data);
		 TableColumn tableColumn;
		 table.setModel(fileCenterTable); 
		 table.getTableHeader().setResizingAllowed(false);
		 table.getTableHeader().setReorderingAllowed(false);
		 tableColumn = table.getColumnModel().getColumn(3);
		 tableColumn.setPreferredWidth(550);
		
	 }
	
}
//
class OtherfilePanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OtherfilePanel() {
		// TODO Auto-generated constructor stub
		setBackground(Color.cyan);
	}
	



}
