package com.UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Contrl.LoginDecide;

public class LoginMain  extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JPanel bPanel;
    private JLabel Ulabel,Plabel;
	private JTextField Utextfield,Ptextfield;
	private JButton Lbutton,Qbutton;
	private ImageIcon Licon,Qicon;
 	
	//
	public LoginMain()
	{
		bPanel = new BackPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		bPanel.setLayout(gridBagLayout);
		Ulabel = new JLabel("用户名:");
		Plabel = new JLabel("密  码:");
		Utextfield = new JTextField();
		Utextfield.setPreferredSize(new Dimension(200, 25));
		Ptextfield = new JTextField();
		Ptextfield.setPreferredSize(new Dimension(200, 25));
	    Licon =new ImageIcon("Images/denglu3an2.gif");
	    Qicon = new ImageIcon("Images/denglu3an3.gif");
	    Lbutton = new JButton(Licon);
	    Lbutton.setPreferredSize(new Dimension(Licon.getIconWidth(), Licon.getIconHeight()));
	    Lbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(new LoginDecide().getresult(Utextfield.getText(), Ptextfield.getText()))
				{
					System.out.println("ture");
					dispose();
					new MainWindowsFrame();
				}else
				{
					System.out.println("false");
					Utextfield.setText("");
					Ptextfield.setText("");
					
				}
				
			}
		});
	    Qbutton = new JButton(Qicon);
	    Qbutton.setPreferredSize(new Dimension(Qicon.getIconWidth(),Qicon.getIconHeight()));
	    Qbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Utextfield.setText("");
				Ptextfield.setText("");		
			}
		});
		//
		bPanel.add(Lbutton);
		bPanel.add(Qbutton);
		bPanel.add(Ulabel);
		bPanel.add(Plabel);
		bPanel.add(Utextfield);
		bPanel.add(Ptextfield);
		//
		Setlocations(gridBagConstraints, new Insets(90, 45, 5, 5), 0, 0, 1, 1, 6, 10);
		gridBagLayout.setConstraints(Ulabel, gridBagConstraints);
		//
		Setlocations(gridBagConstraints, new Insets(20, 45, 5, 5), 0, 0, 1, 1, 6, 15);
		gridBagLayout.setConstraints(Plabel, gridBagConstraints);
		//
		Setlocations(gridBagConstraints, new Insets(90, 5, 5, 5), 0, 0, 5, 1, 8, 10);
		gridBagLayout.setConstraints(Utextfield, gridBagConstraints);
		//
		
		Setlocations(gridBagConstraints, new Insets(20, 5, 5, 5), 0, 0, 5, 1, 8, 15);
		gridBagLayout.setConstraints(Ptextfield, gridBagConstraints);
	    //
	
		Setlocations(gridBagConstraints, new Insets(5, 1, 1, 1), 0, 0, 1, 1, 9, 16);
		gridBagLayout.setConstraints(Lbutton, gridBagConstraints);
		//
		Setlocations(gridBagConstraints, new Insets(5, 10, 1, 1), 0, 0, 1, 1, 10, 16);
		gridBagLayout.setConstraints(Qbutton, gridBagConstraints); 
	    
	    //
		add(bPanel);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	  //网格布局参数设置
		public void Setlocations(GridBagConstraints gridBagConstraints,Insets  insets,int weighty,int weightx,int gridwidth,int gridheight,int gridx,int gridy)
		{
			gridBagConstraints.fill =GridBagConstraints.BOTH;
			gridBagConstraints.insets=insets;
			gridBagConstraints.weightx=weightx;
			gridBagConstraints.weighty=weighty;
			gridBagConstraints.gridwidth=gridwidth;
			gridBagConstraints.gridheight=gridheight;
			gridBagConstraints.gridx=gridx;
			gridBagConstraints.gridy=gridy;
			
		}
}

//背景图片容器
class BackPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
    //
	private ImageIcon bImageIcon;
	private Image bImage;

	//
	public BackPanel() 
	{
		bImageIcon = new ImageIcon("Images/denglu_bak1227.jpg");
		bImage = bImageIcon.getImage();
	}
	//
	@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			g.drawImage(bImage, 0, 0, this.getWidth(), this.getHeight(), this);
		}

}