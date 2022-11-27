package front;

import java.awt.BorderLayout;
import java.awt.Font;

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
	
	Font df = new Font("KoPub돋움체 medium", Font.PLAIN, 20);
	
	String diaryPickDate;
	
	diaryDetail(){		
		//종합 패널
		JPanel allP = new JPanel();
		allP.setLayout(new BorderLayout());
		menu.panelWhite(allP);
		
		//상단 패널
		JPanel topP = new JPanel();
		topP.setLayout(new BorderLayout());
		menu.panelWhite(topP);
		topP.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		
		titleL = new JLabel();
		titleL.setFont(df);
		topP.add("North", titleL);

		dateL = new JLabel();
		dateL.setFont(df);
		topP.add("Center", dateL);
		
		//contents 패널
		JPanel cp = new JPanel();
		cp.setLayout(new BorderLayout());
		cp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		menu.panelWhite(cp);
		contentsL = new JLabel();
		contentsL.setFont(df);
		cp.add(contentsL);
		
		setValue();
		
		allP.add(topP, "North");
		allP.add(cp, "Center");

		//버튼 패널
		JPanel butp = new JPanel();
		menu.panelWhite(butp);
		diaryEdit = new JButton("수정");
		diaryDelete = new JButton("삭제");
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
