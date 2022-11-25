package front;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
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
		JTextField yearT = new JTextField("2022");
		yearT.setPreferredSize(new Dimension(80, 40));
		yearT.setFont(menu.f4);
		yearL = new JLabel("년");
		yearL.setBackground(Color.white);
		yearL.setFont(menu.f4);
		JComboBox monthC = new JComboBox(month);
		monthC.setFont(menu.f4);
		monthC.setBackground(Color.white);
		monthL = new JLabel("월");
		monthL.setBackground(Color.white);
		monthL.setFont(menu.f4);
		dateP.add(yearT);
		dateP.add(yearL);
		dateP.add(menu.gapS);
		dateP.add(monthC);
		dateP.add(monthL);
		
		topP.add("West", dateP);
		topP.add("Center", menu.gap2);
		topP.add("East",menu.createB);
		
		//다이어리 테이블 패널
		JPanel diaryP = new JPanel();
		diaryP.setPreferredSize(new Dimension(1000, 550));
		diaryP.setBackground(Color.white);
		diaryTable diaryT = new diaryTable();
		diaryT.setBackground(Color.white);
		diaryP.add(diaryT);
		
		menu.main.add("North", topP);
		menu.main.add("Center", diaryP);
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("East", menu.main);
		add("Center", menu.form);
		
	}
}
