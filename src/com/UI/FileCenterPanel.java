package com.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import com.Contrl.FileDatamanipulation;


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
	private FlowLayout layout2;
	private JLabel label,label2;
	private ImageIcon imageIcon,idj,icx,igd,isq;
	private Dimension dimension;
	private JButton dj,cx,gd,sq,button,button2,button3,button4,button5,button6;
	private JTable table;
	private JScrollPane scrollPane;
	private FileDatamanipulation fileDatamanipulation;
	private static int pagesize,pagenow,pagecount,pagerecord;
	private  boolean result = false;
	private  int num;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gridBagConstraints;
	private JPanel panel;
	private JTextField textField,textField2;
	//
	public CenterfilePanel() 
	{
		// TODO Auto-generated constructor stub
		pagesize=37;
		pagenow=1;
		initpanel();
		
	}
	//
	public void initpanel()
	{
		
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		setLayout(gridBagLayout);
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
		imageIcon = new ImageIcon("Images/middle_right_tb.gif");
		label =new JLabel("您现在的位置:文件管理>"+FileCenterPanel.menuname, imageIcon,SwingConstants.LEFT );	
		label.setPreferredSize(new Dimension((int)dimension.getWidth()-FileCenterPanel.width-250, imageIcon.getIconHeight()));
		label.setOpaque(true);	
		//
		table = new JTable();
		InitTable(table);
		TableEvent(table,sq);
		table.setPreferredScrollableViewportSize(new Dimension((int)dimension.getWidth()-FileCenterPanel.width-250, (int)dimension.getHeight()-90));
		scrollPane = new JScrollPane(table);
		//文件中心底部面板组件初始化
		 button = new JButton();
		 button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				 int  temp = Integer.parseInt(textField.getText());
				 System.out.println(temp);
				 //if(temp>0&&temp<pagecount)
				 ChangeTable(table, temp,pagenow);	
			}
		});
		 button2 = new JButton();
		 button3 = new JButton();
		 button4 = new JButton();
		 button5 = new JButton();
		 button6 = new JButton();
		 textField =new JTextField();
		 textField2 = new JTextField();
		 //
		 pagerecord =Setpages(pagerecord);
		 pagecount =pagerecord/pagesize+1;
		 panel = new FilecenterEndPanel(button, button2, button3, button4, button5, button6, textField, textField2,pagerecord, pagecount);
		 panel.setPreferredSize(new Dimension((int)dimension.getWidth()/2, 20));
		//
		 setplace(label, gridBagLayout, gridBagConstraints, 0, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		 setplace(label2, gridBagLayout, gridBagConstraints, 0, 1, new Insets(1, 1, 1, 1), 100.0, 4.0, 1, 1);
		 setplace(scrollPane, gridBagLayout, gridBagConstraints, 0, 2, new Insets(1, 1, 1, 1), 100.0, 100.0, 1, 1);
	     setplace(panel, gridBagLayout, gridBagConstraints, 0, 3, new Insets(1, 1, 1, 1), 95.0,0.77, 1, 1);
		 
		 //
		 this.add(label);
		 this.add(label2);
		 this.add(scrollPane);
		 this.add(panel);
		 
	}
	
	//初始化表格
	 public void InitTable(JTable table)
	 {
		 //
		 fileDatamanipulation = new FileDatamanipulation("T_Base_Archive");
		 fileDatamanipulation.SetTable(table,"ArchiveDuty as 责任者 ,ArchiveNO as 文件字号 ,ArchiveTitle as 题名,ReceiveTime as 文件日期 ,PageCount as 页数,SaveLevel as 保管期限", "id",pagesize, pagenow);
		
	 }
	 //删除数据后更新表
	 public void updatetable(JTable table)
	 {
		 
		 InitTable(table);
		 
	 }
	//表格数据删除操作
	 public void TableEvent(JTable table,JButton buttons)
	 {
		
		 table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	     table.getModel().addTableModelListener(new TableModelListener() {	
			@Override
			public void tableChanged(TableModelEvent e) 
			{
				// TODO Auto-generated method stub
				int rows = table.getRowCount();
			   buttons.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i=0;i<rows;i++)
					{
						if((boolean)table.getValueAt(i,0))
						{
							//System.out.println(table.getValueAt(i, 3)+","+i);
						   String title =(String)table.getValueAt(i, 3);
						   String ArchiveNO = (String)table.getValueAt(i, 2);
						   //System.out.println(title+","+ArchiveNO+","+i);
						   if( fileDatamanipulation!=null)
						   {
							  result= fileDatamanipulation.DeleteData(title, ArchiveNO);
							  if(result)
							  {
								 num++; 
							  }
						   }	
						}
						table.setValueAt(false, i, 0);
					}
					 if(num>0)
				      {
				    	  JOptionPane.showMessageDialog(new JPanel(), "删除成功", "", JOptionPane.WARNING_MESSAGE);
				    	  updatetable(table);  
				    	  num=0;
				      }
				}
			});
			     		
			}
		});
	      
	 }
	 //
		public void setplace(Component pComponent,GridBagLayout layout,GridBagConstraints gridBagConstraints,int x,int y,Insets insets,Double a,Double b,int c,int d)
		{
			gridBagConstraints.fill =GridBagConstraints.BOTH;
			gridBagConstraints.insets = insets;
			gridBagConstraints.gridx=x;
			gridBagConstraints.gridy=y;
			gridBagConstraints.weightx=a;
			gridBagConstraints.weighty=b;
			gridBagConstraints.gridwidth=c;
			gridBagConstraints.gridheight=d;
			layout.setConstraints(pComponent, gridBagConstraints);
			
		}
		
	//表格跳转页数
	public void ChangeTable(JTable table,int pagenows,int paagesize)
	{
		fileDatamanipulation = new FileDatamanipulation("T_Base_Archive");
		fileDatamanipulation.ChoseData(table, pagenows); 
	}
	//设置总页数、总记录数
	public int Setpages(int pagescount)
	{
		fileDatamanipulation = new FileDatamanipulation("T_Base_Archive");
		return fileDatamanipulation.Getpagecount(pagecount);
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
	
	//



}
