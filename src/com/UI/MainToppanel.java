package com.UI;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class MainToppanel extends JPanel 
{
  private JPanel Lpanel,Rpanel;
   private FlowLayout flowLayout;
   public  static int height,width;

	public MainToppanel() 
    {
		// TODO Auto-generated constructor stub
	/*	flowLayout = new FlowLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
	    setLayout(flowLayout);
	   // setBackground(Color.green);
		Lpanel = new MainTopLpanel();
		Lpanel.setPreferredSize(new Dimension(MainTopLpanel.width+353, MainTopLpanel.height));
		Rpanel = new MainTopRpanel();
		Rpanel.setPreferredSize(new Dimension(MainTopRpanel.width+125, MainTopLpanel.height));
		height = Lpanel.HEIGHT;
		add(Lpanel,flowLayout.LEFT);
		add(Rpanel);*/
	}
	
	
}



//¶¥²¿ÓÒ±ß¿ò
class MainTopLpanel extends JPanel
{
	//
	private Image bImage;
	private ImageIcon bImageIcon;
	public static int width,height;
	
	public MainTopLpanel()
	{
		// TODO Auto-generated constructor stub
		 bImageIcon = new ImageIcon("Images/logo.jpg");
		 bImage = bImageIcon.getImage();
		 width =bImageIcon.getIconWidth();
		 height=bImageIcon.getIconHeight();
	}
	
   
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	

}

//¶¥²¿ÓÒ±ß¿ò
class MainTopRpanel extends JPanel
{
	
	private Image bImage;
	private ImageIcon bImageIcon;
	public static int width,height;
	
	public MainTopRpanel()
	{
		// TODO Auto-generated constructor stub
		 bImageIcon = new ImageIcon("Images/top_right.jpg");
		 bImage = bImageIcon.getImage();
		 width=bImageIcon.getIconWidth();
		 height=bImageIcon.getIconHeight();
		 //setBackground(Color.yellow);
	}
	  
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}