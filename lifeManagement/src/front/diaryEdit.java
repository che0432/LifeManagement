package front;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilCalendarModel;

public class diaryEdit extends JPanel {
	tapMenu menu = new tapMenu();
	JLabel titleL, contentsL, dateL;
	JTextField title;
	JTextArea contents;
	JButton diaryEditSave;
	
	String setEditTitle = "";
	String setEditDate = "0000-00-00";
	String setEditContents = "";
	
	String diaryPickDate;
	
	//JDatePicker
	UtilCalendarModel model = new UtilCalendarModel();
    JDatePanel datePanel = new JDatePanel(model);
	JDatePicker datePicker = new JDatePicker();
	
	public diaryEdit(){
		//종합 패널
		JPanel allP = new JPanel();
		menu.panelWhiteBorder(allP);
		
		//상단 패널
		JPanel topP = new JPanel();
		menu.panelWhiteBorder(topP);
		
		//title 패널
		JPanel tp = new JPanel();
		menu.colorWhite(tp);
		titleL = new JLabel("제목: ");
		titleL.setFont(menu.f3);
		title = new JTextField();
		title.setPreferredSize(new Dimension(500, 30));
		title.setFont(menu.f5);
		tp.add(titleL);
		tp.add(title);
		
		//date 패널
		JPanel dp = new JPanel();
		menu.colorWhite(dp);
		dateL = new JLabel("날짜: ");
		dateL.setFont(menu.f3);
		//JDatePicker 구현

		tp.add(dateL);
		tp.add(datePicker);
		
		//contents 패널
		JPanel cp = new JPanel();
		cp.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));
		menu.panelWhiteBorder(cp);
		contentsL = new JLabel("내용: ");
		contentsL.setFont(menu.f3);
		//내용
		JPanel cc = new JPanel();
		menu.panelWhiteBorder(cc);
		cc.setPreferredSize(new Dimension(500, 300));
		contents = new JTextArea();
		contents.setFont(menu.f5);
		contents.setLineWrap(true);
		JScrollPane sp = new JScrollPane(contents);
		cc.add(sp, "Center");
		
		cp.add(contentsL, "North");
		cp.add(cc, "Center");
		
		//일기 상세 정보 세팅
		diaryEditSet();
		
		//저장 버튼
		diaryEditSave = new JButton("저장");
		menu.colorBlack(diaryEditSave);
		diaryEditSave.setFont(menu.f4);
		
		topP.add("North", tp);
		topP.add("South", dp);
		
		allP.add(topP, "North");
		allP.add(cp, "Center");
		
		menu.main.add("Center", allP);
		menu.main.add("South", diaryEditSave);
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("East", menu.main);
		
		add("Center", menu.form);
	}
	
	//일기 상세 정보 세팅 함수
	public void diaryEditSet(){
		String getDate[] = setEditDate.split("-");
		int year, month, day;
		year = Integer.parseInt(getDate[0]);
		month = Integer.parseInt(getDate[1])-1;
		day = Integer.parseInt(getDate[2]);
		
		title.setText(setEditTitle);
		datePicker.getModel().setDate(year, month, day);
		datePicker.getModel().setSelected(true);
		contents.setText(setEditContents);
	}
}