package com.UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Contrl.LoginDecide;

public class MainWindowsFrame  extends JFrame 
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Tpanel,Lpanel,Rpanel,Centerpanel;
	private JButton Qbutton,Ebutton;
	private JLabel TimeLabel;
	private String Times;
	private ImageIcon qiImageIcon,eImageIcon;
	private FlowLayout flowLayout;

	

	public MainWindowsFrame() {
		// TODO Auto-generated constructor stub
		
		flowLayout = new FlowLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		eImageIcon = new ImageIcon("Images/top_r2.gif");
		qiImageIcon =new ImageIcon("Images/top_r3.gif");
		Ebutton = new JButton(eImageIcon);
		Ebutton.setPreferredSize(new Dimension(eImageIcon.getIconWidth(), eImageIcon.getIconHeight()));
		Ebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new LoginMain();
				
			}
		});	
		Qbutton = new JButton(qiImageIcon);
		Qbutton.setPreferredSize(new Dimension(qiImageIcon.getIconWidth(), qiImageIcon.getIconHeight()));
		Qbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			      System.exit(0);
				
			}
		});
		TimeLabel = new JLabel(getTime());
		TimeLabel.setPreferredSize(new Dimension(qiImageIcon.getIconWidth()*7, qiImageIcon.getIconHeight()));
		//
		Tpanel = new MainToppanel();
	    Lpanel = new MainTopLpanel();
	    Lpanel.setPreferredSize(new Dimension(MainTopLpanel.width+353, MainTopLpanel.height));
	    Rpanel = new MainTopRpanel();
	    Rpanel.setPreferredSize(new Dimension(MainTopRpanel.width+125, MainTopLpanel.height));	
	    Rpanel.add(Ebutton);
	    Rpanel.add(Qbutton);
	    Rpanel.add(TimeLabel);
	    Tpanel.setLayout(flowLayout);
	    Tpanel.add(Lpanel,flowLayout.LEFT);
	    Tpanel.add(Rpanel);
	    //
	    Centerpanel = new MainCenterPanel();
	    //
		add(Tpanel,BorderLayout.NORTH);
		//add(Mlpanel,BorderLayout.WEST);
		add(Centerpanel,BorderLayout.CENTER);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	    
	}
	
	//获取时间内容
	public String getTime()
	{
		Date dates = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		/*SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");*/
		Calendar calendar = Calendar.getInstance();
		
		Times ="                                      欢迎您,"+LoginDecide.name+"  "+calendar.get(Calendar.YEAR)+"年"+calendar.get(Calendar.MONTH)+"月"+calendar.get(Calendar.DAY_OF_MONTH)+"日";
		return Times;
	}
	
}

