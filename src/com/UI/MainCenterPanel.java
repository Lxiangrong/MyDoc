package com.UI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainCenterPanel extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	 private JTabbedPane tabbedPane;
	 private JPanel panel,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9;
	 private Dimension dimension;
	 public MainCenterPanel() {
		// TODO Auto-generated constructor stub
		 dimension = Toolkit.getDefaultToolkit().getScreenSize();
		 tabbedPane = new JTabbedPane();
	     tabbedPane.setPreferredSize(new Dimension((dimension.width-20), dimension.height-150));
		 panel= new IndexPanel();
		 panel2=new FileCenterPanel();
		 panel3 = new MDocpanel();
		 panel4 = new MQuanzong();
		 panel5 = new DocCenterPanel();
		 panel6 = new CdataPanel();
		 panel7 = new Pdecidepanel();
		 panel8 = new SysPanel();
		 panel9 = new Updatapanel();
		 tabbedPane.addTab("��ҳ", panel);
		 tabbedPane.addTab("�ļ�����", panel2);
		 tabbedPane.addTab("���������", panel3);
		 tabbedPane.addTab("ȫ�ڹ���", panel4);
		 tabbedPane.addTab("��������", panel5);
		 tabbedPane.addTab("ͳ������", panel6);
		 tabbedPane.addTab("�����ϱ�", panel9);
		 tabbedPane.addTab("��������", panel7);
		 tabbedPane.addTab("ϵͳ����", panel8);
		 add(tabbedPane);
			
	 }
}
