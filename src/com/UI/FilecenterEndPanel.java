package com.UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 文件中心底部面板
 * */

public class FilecenterEndPanel extends JPanel
{
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义相关组件
	private GridBagLayout gridBagLayout ;
	private GridBagConstraints gridBagConstraints;
	private JLabel label,label2,label3,label4;
	private JButton button,button2,button3,button4,button5,button6;
	private JTextField textField,textField2;
	private ImageIcon icon,icon2,icon3,icon4,icon5,icon6,icon7;
	private final int weight,height;
	private Dimension dimension;
	//
	public FilecenterEndPanel(JButton button,JButton button2,JButton button3,JButton button4,JButton button5,JButton button6,JTextField textField,JTextField textField2,int pagecount,int pagesize)
	{
		// TODO Auto-generated constructor stub
		/**初始化组件
		 * */
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		setLayout(gridBagLayout);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.button=button;
		this.button2=button2;
		this.button3=button3;
		this.button4=button4;
		this.button5=button5;
		this.button6=button6;
		this.textField=textField;
		this.textField2 =textField2;
		//
		icon = new ImageIcon("Images/bc.gif");
		icon2 = new ImageIcon("Images/main_62.gif");
		icon3 = new ImageIcon("Images/main_62.gif");
		icon4 = new ImageIcon("Images/xy.gif");
		icon5 = new ImageIcon("Images/qian.gif");
		icon6 = new ImageIcon("Images/pub_but_next.gif");
		icon7 = new ImageIcon("Images/wy.gif");
		weight = icon.getIconWidth();
		height = icon.getIconHeight();
		//
		label = new JLabel("共"+pagecount+"项纪录，共"+pagesize+"页", icon, SwingConstants.LEFT);
		label.setPreferredSize(new Dimension((int)dimension.getWidth()/2, height));
		//
		setplace(label, gridBagLayout, gridBagConstraints, 0, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(label);
		//
		label2 = new JLabel("第", SwingConstants.LEFT);
		label2.setPreferredSize(new Dimension(30, height));
		//
		setplace(label2, gridBagLayout, gridBagConstraints, 1, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(label2);
		//
		textField.setPreferredSize(new Dimension(35, height));
		setplace(textField, gridBagLayout, gridBagConstraints, 2, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(textField);
		//
		label3 = new JLabel("页", SwingConstants.RIGHT);
		label3.setPreferredSize(new Dimension(30, height));
		//
		setplace(label3, gridBagLayout, gridBagConstraints, 3, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(label3);
		//
		button.setIcon(icon2);
		button.setPreferredSize(new Dimension(weight,15));
		setplace(button, gridBagLayout, gridBagConstraints, 4, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(button);
		//
		label4 = new JLabel("每页", SwingConstants.LEFT);
		label4.setPreferredSize(new Dimension(30, height));
		//
		setplace(label4, gridBagLayout, gridBagConstraints, 5, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(label4);
		//
		textField2.setPreferredSize(new Dimension(35, height));
		setplace(textField2, gridBagLayout, gridBagConstraints, 6, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(textField2);
		//
		button2.setIcon(icon2);
		button.setPreferredSize(new Dimension(weight,15));
		setplace(button2, gridBagLayout, gridBagConstraints, 7, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(button2);
		//
		button3.setIcon(icon5);
		button.setPreferredSize(new Dimension(weight,15));
		setplace(button3, gridBagLayout, gridBagConstraints, 8, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(button3);
		//
		button4.setIcon(icon6);
		button.setPreferredSize(new Dimension(weight,15));
		setplace(button4, gridBagLayout, gridBagConstraints, 9, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(button4);
		//
		button5.setIcon(icon7);
		setplace(button5, gridBagLayout, gridBagConstraints, 10, 0, new Insets(1, 1, 1, 1), 100.0, 1.0, 1, 1);
		this.add(button5);
		
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
	
}
