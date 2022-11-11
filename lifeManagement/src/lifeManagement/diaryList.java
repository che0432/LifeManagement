package lifeManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class diaryList extends JPanel {	
	JLabel yearL, monthL;
	Integer[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	
	tapMenu menu = new tapMenu();
	
	diaryList(){		
		//상단 패널
		JPanel topP = new JPanel();
		topP.setBackground(Color.white);		
		
		//날짜 입력 패널
		JPanel dateP = new JPanel();
		dateP.setBackground(Color.white);
		JTextField yearT = new JTextField("�⵵");
		yearL = new JLabel("년");
		yearL.setBackground(Color.white);
		yearL.setFont(menu.f2);
		JComboBox monthC = new JComboBox(month);
		monthL = new JLabel("월");
		monthL.setBackground(Color.white);
		monthL.setFont(menu.f2);
		dateP.add(yearT);
		dateP.add(yearL);
		dateP.add(monthC);
		dateP.add(monthL);
		
		topP.add("Center", dateP);
		topP.add("East",menu.createB);
		
		//다이어리 테이블 패널
		JPanel diaryP = new JPanel();
		diaryP.setBackground(Color.white);
		diaryTable diaryT = new diaryTable();
		diaryP.add(diaryT);
		
		menu.main.add("North", topP);
		menu.main.add("Center", diaryP);
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("East", menu.main);
		add("Center", menu.form);
		
	}
}
