package front;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//한건상세 구현 필요
public class diaryDetail extends JPanel {
	tapMenu menu = new tapMenu();
	JLabel titleL, contentsL, dateL;
	JButton diaryEdit, diaryDelete;
	String diaryDetailTitle, diaryDetailDate, diaryDetailContents;
	
	String diaryPickDate;
	
	diaryDetail(){		
		//종합 패널
		JPanel allP = new JPanel();
		menu.panelWhiteBorder(allP);
		
		//상단 패널
		JPanel topP = new JPanel();
		menu.panelWhiteBorder(topP);
		topP.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		
		titleL = new JLabel();
		titleL.setFont(menu.f3);
		topP.add("North", titleL);

		dateL = new JLabel();
		dateL.setFont(menu.f3);
		topP.add("Center", dateL);
		
		//contents 패널
		JPanel cp = new JPanel();
		cp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		menu.panelWhiteBorder(cp);
		contentsL = new JLabel();
		contentsL.setFont(menu.f3);
		cp.add(contentsL);
		
		setValue();
		
		allP.add(topP, "North");
		allP.add(cp, "Center");

		//버튼 패널
		JPanel butp = new JPanel();
		menu.colorWhite(butp);
		butp.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
		diaryEdit = new JButton("수정");
		diaryDelete = new JButton("삭제");
		menu.colorBlack(diaryEdit);
		diaryEdit.setFont(menu.f3);
		menu.colorBlack(diaryDelete);
		diaryDelete.setFont(menu.f3);
		butp.add(diaryEdit);
		butp.add(diaryDelete);
		
		menu.main.add("North", allP);
		menu.main.add("South", butp);
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("East", menu.main);
		
		add("Center", menu.form);
	}
	
	public void setValue(){
		titleL.setText("제목: " + diaryDetailTitle);
		dateL.setText("날짜: " + diaryDetailDate);
		contentsL.setText("내용: " + diaryDetailContents);
	}

}
