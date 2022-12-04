package front;

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
		menu.colorWhite(topP);
		
		//날짜 입력 패널
		JPanel dateP = new JPanel();
		menu.colorWhite(dateP);
		yearT = new JTextField(menu.yearValue);
		yearT.setPreferredSize(new Dimension(80, 40));
		yearT.setFont(menu.f4);
		yearL = new JLabel("년");
		menu.colorWhite(yearL);
		yearL.setFont(menu.f4);
		monthC = new JComboBox(month);
		monthC.getModel().setSelectedItem(menu.monthValue);
		monthC.setFont(menu.f4);
		menu.colorWhite(monthC);
		monthL = new JLabel("월");
		menu.colorWhite(monthL);
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
		menu.panelWhiteBorder(dcp);
		dcp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));
		
		//다이어리 테이블 패널
		JPanel diaryP = new JPanel();
		diaryP.setPreferredSize(new Dimension(800, 600));
		menu.colorWhite(diaryP);
		diaryT = new diaryTable();
		menu.colorWhite(diaryT);
		diaryP.add(diaryT);
		
		//버튼 패널
		JPanel butp = new JPanel();
		menu.colorWhite(butp);
		diaryReadB = new JButton("날짜 조회");
		diaryDetail = new JButton("상세보기");
		menu.colorBlack(diaryReadB);
		diaryReadB.setFont(menu.f3);
		menu.colorBlack(diaryDetail);
		diaryDetail.setFont(menu.f3);
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
