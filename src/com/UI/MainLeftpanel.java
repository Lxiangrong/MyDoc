package com.UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainLeftpanel extends JPanel
{
    //
	 private ImageIcon bImageIcon;
	 private static int width,height;
	 private Image bImage;
	
	//
	public MainLeftpanel() {
		// TODO Auto-generated constructor stub
		bImageIcon = new ImageIcon("Images/m_left_tp1.jpg");
		width=bImageIcon.getIconWidth();
		height =bImageIcon.getIconHeight();
		bImage = bImageIcon.getImage();
		
	}
	
	//
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bImage, 0, 0, this.getWidth(), this.getHeight(), this);
		
	}
	
	
}
