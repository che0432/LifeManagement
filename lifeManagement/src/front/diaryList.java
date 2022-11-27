package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class diaryList extends JPanel {	
	JLabel yearL, monthL;
	Integer[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	JButton diaryReadB, diaryDetail;
	tapMenu menu = new tapMenu();
	diaryTable diaryT;
	JTextField yearT;
	JComboBox monthC;
	
	diaryList(){		
		//상단 패널
		JPanel topP = new JPanel();
		topP.setBackground(Color.white);		
		
		//날짜 입력 패널
		JPanel dateP = new JPanel();
		dateP.setBackground(Color.white);
		yearT = new JTextField(menu.yearValue);
		yearT.setPreferredSize(new Dimension(80, 40));
		yearT.setFont(menu.f4);
		yearL = new JLabel("년");
		yearL.setBackground(Color.white);
		yearL.setFont(menu.f4);
		monthC = new JComboBox(month);
		monthC.getModel().setSelectedItem(menu.monthValue);
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
		
		//다이어리 목록 조회 패널
		JPanel dcp = new JPanel();
		menu.panelWhite(dcp);
		dcp.setLayout(new BorderLayout());
		dcp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));
		
		//다이어리 테이블 패널
		JPanel diaryP = new JPanel();
		diaryP.setPreferredSize(new Dimension(800, 600));
		diaryP.setBackground(Color.white);
		diaryT = new diaryTable();
		diaryT.setBackground(Color.white);
		diaryP.add(diaryT);
		
		//버튼 패널
		JPanel butp = new JPanel();
		menu.panelWhite(butp);
		diaryReadB = new JButton("날짜 조회");
		diaryDetail = new JButton("상세보기");
		butp.add(diaryReadB);
		butp.add(diaryDetail);
		
		dcp.add("North", diaryP);
		dcp.add("Center", butp);
		
		menu.main.add("North", topP);
		menu.main.add("Center", dcp);
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("East", menu.main);
		add("Center", menu.form);
	}
}
