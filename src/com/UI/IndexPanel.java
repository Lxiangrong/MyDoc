package com.UI;
/**
 *  ��ҳ���
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class IndexPanel extends JPanel
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   //
   private 	JPanel  lPanel,rPanel,lPanel2,rPanel2,rPanel_1;
   private Border line;
   private Dimension dimension;
   private FlowLayout flowLayout,flowLayout2;
   private JLabel label,label2,label3,label4,label5;
   private JEditorPane editorPane,editorPane2;
   private String table,table2;
  
	public IndexPanel() 
	{
		// TODO Auto-generated constructor stub
	
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		line = BorderFactory.createLineBorder(Color.blue);
		flowLayout = new FlowLayout();
		flowLayout.setHgap(60);
		flowLayout.setVgap(80);
		flowLayout2 = new FlowLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		setLayout(flowLayout);
		
		//
		lPanel = new JPanel();
		//lPanel.setBackground(Color.yellow);
		lPanel.setBorder(line);
		lPanel.setLayout(flowLayout2);
		lPanel.setPreferredSize(new Dimension(dimension.width/2-200,dimension.height/2-200));
		label = new JLabel("��������");
		label.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label.setOpaque(true);
		label.setBackground(Color.yellow);
		lPanel.add(label);
		//
		rPanel = new JPanel();
		rPanel.setLayout(flowLayout2);
		//rPanel.setBackground(Color.blue);
		rPanel.setPreferredSize(new Dimension(dimension.width/2-200,dimension.height/2-200));
		rPanel.setBorder(line);
		label2=new JLabel("�ѽ����еĵ���");
		label2.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label2.setOpaque(true);
		label2.setBackground(Color.yellow);
		//
		label3=new JLabel("�ر���ʾ");
		label3.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label3.setOpaque(true);
		label3.setBackground(Color.yellow);
		//
		rPanel_1 = new JPanel();
		rPanel_1.setPreferredSize(new Dimension(dimension.width/2-205,80));
		//
		rPanel.add(label2);
		rPanel.add(rPanel_1);
		rPanel.add(label3);
		//
		lPanel2 = new JPanel();
		//lPanel2.setBackground(Color.pink);
		lPanel2.setPreferredSize(new Dimension(dimension.width/2-200,dimension.height/2-200));
		lPanel2.setBorder(line);
		lPanel2.setLayout(flowLayout2);
		label4=new JLabel("��ʷ�����˴�ͳ��");
		label4.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label4.setOpaque(true);
		label4.setBackground(Color.yellow);
		lPanel2.add(label4);
		table="<body>"
				+ "<table border='1' width='100%'>"
				+ "<tr><td>�ܷ����˴�</td><td colspan='2'>2</td></tr>"
				+ "<tr><td rowspan ='2'>����ϵͳ�����˴�</td><td>�ڲ���������˴�</td><td>3</td></tr>"
				+ "<tr><td>�ⲿ��������˴�</td><td>3</td></tr>"
				+ "<tr><td rowspan ='2'>OAϵͳ�����˴�</td><td>�������Ľ�������˴�</td><td>3</td></tr>"
				+ "<tr><td>�ļ����ķ����˴�</td> <td>3</td></tr>"
				+ "</table>"
				+ "</body>";
		editorPane=new JEditorPane("text/html",table);
		editorPane.setEditable(false);
		editorPane.setPreferredSize(new Dimension(dimension.width/2-205,205));
		lPanel2.add(editorPane);
		//
		rPanel2 = new JPanel();
		rPanel2.setPreferredSize(new Dimension(dimension.width/2-200,dimension.height/2-200));
		rPanel2.setBorder(line);
		rPanel2.setLayout(flowLayout2);
		label5 = new JLabel("�����������ͳ��");
		label5.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label5.setOpaque(true);
		label5.setBackground(Color.yellow);
		rPanel2.add(label5);
		table2="<body>"
				+ "<table border='1' width='100%'>"
				+ "<tr><td>�ܷ����˴�</td><td colspan='2'>2</td></tr>"
				+ "<tr><td rowspan ='2'>����ϵͳ�����˴�</td><td>�ڲ���������˴�</td><td>3</td></tr>"
				+ "<tr><td>�ⲿ��������˴�</td><td>3</td></tr>"
				+ "<tr><td rowspan ='2'>OAϵͳ�����˴�</td><td>�������Ľ�������˴�</td><td>3</td></tr>"
				+ "<tr><td>�ļ����ķ����˴�</td> <td>3</td></tr>"
				+ "</table>"
				+ "</body>";
		editorPane2 = new JEditorPane("text/html",table2);
		editorPane2.setEditable(false);
		editorPane2.setPreferredSize(new Dimension(dimension.width/2-205,205));
		rPanel2.add(editorPane2);
		//rPanel2.setBackground(Color.CYAN);
		add(lPanel);
		add(rPanel);
		add(lPanel2);
		add(rPanel2);	
	}
	
	
	
}
