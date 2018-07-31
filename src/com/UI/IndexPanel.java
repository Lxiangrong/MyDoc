package com.UI;
/**
 *  首页面板
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
		label = new JLabel("待办事项");
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
		label2=new JLabel("已借阅中的档案");
		label2.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label2.setOpaque(true);
		label2.setBackground(Color.yellow);
		//
		label3=new JLabel("特别提示");
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
		label4=new JLabel("历史访问人次统计");
		label4.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label4.setOpaque(true);
		label4.setBackground(Color.yellow);
		lPanel2.add(label4);
		table="<body>"
				+ "<table border='1' width='100%'>"
				+ "<tr><td>总访问人次</td><td colspan='2'>2</td></tr>"
				+ "<tr><td rowspan ='2'>档案系统访问人次</td><td>内部进入访问人次</td><td>3</td></tr>"
				+ "<tr><td>外部进入访问人次</td><td>3</td></tr>"
				+ "<tr><td rowspan ='2'>OA系统访问人次</td><td>档案中心进入访问人次</td><td>3</td></tr>"
				+ "<tr><td>文件中心访问人次</td> <td>3</td></tr>"
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
		label5 = new JLabel("今天访问人数统计");
		label5.setPreferredSize(new Dimension(dimension.width/2-205,40));
		label5.setOpaque(true);
		label5.setBackground(Color.yellow);
		rPanel2.add(label5);
		table2="<body>"
				+ "<table border='1' width='100%'>"
				+ "<tr><td>总访问人次</td><td colspan='2'>2</td></tr>"
				+ "<tr><td rowspan ='2'>档案系统访问人次</td><td>内部进入访问人次</td><td>3</td></tr>"
				+ "<tr><td>外部进入访问人次</td><td>3</td></tr>"
				+ "<tr><td rowspan ='2'>OA系统访问人次</td><td>档案中心进入访问人次</td><td>3</td></tr>"
				+ "<tr><td>文件中心访问人次</td> <td>3</td></tr>"
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
