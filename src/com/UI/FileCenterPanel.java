package com.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FileCenterPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private ImageIcon miImageIcon,qImageIcon,fImageIcon;
	private JMenuBar menuBar;
	private JMenu Menu;
	private JMenuItem wMenuItem,qMenuItem;
	private JPanel Mlpanel;
	private BorderLayout borderLayout;
    public static String menuname ="文书文件";
    public static int width;
	
	public FileCenterPanel() 
	{
		// TODO Auto-generated constructor stub
		borderLayout = new BorderLayout();
		borderLayout.setHgap(0);
		borderLayout.setVgap(0);
		setLayout(borderLayout);
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
				add(new CenterfilePanel() , borderLayout.CENTER);
				//System.out.println(wMenuItem.getText());
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
				add(new OtherfilePanel() , borderLayout.CENTER);
				//System.out.println(qMenuItem.getText());
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
	    add(Mlpanel,borderLayout.WEST);
		
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
	//private JPanel Cpanel ;
	
	public CenterfilePanel() 
	{
		// TODO Auto-generated constructor stub
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		//Cpanel = new JPanel();
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
		//label.setBackground(Color.yellow);
		add(label);
		add(label2);
		//setBackground(Color.pink);
		
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
