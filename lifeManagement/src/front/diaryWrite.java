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

public class diaryWrite extends JPanel  {
	tapMenu menu = new tapMenu();
	JLabel titleL, contentsL, dateL;
	JTextField title;
	JTextArea contents;
	JButton diarySave;
	
	String diaryPickDate;
	
	//JDatePicker
	UtilCalendarModel model = new UtilCalendarModel();
    JDatePanel datePanel = new JDatePanel(model);
	JDatePicker datePicker = new JDatePicker();
	
	public diaryWrite(){
		
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
		title.setFont(menu.f5);
		title.setPreferredSize(new Dimension(500, 30));
		tp.add(titleL);
		tp.add(title);
		
		//date 패널
		JPanel dp = new JPanel();
		menu.colorWhite(dp);
		dateL = new JLabel("날짜: ");
		dateL.setFont(menu.f3);
		//JDatePicker 구현	    
		datePicker.getModel().setDate(menu.nowYear, menu.nowMonthValue-1, menu.nowDayOfMonth);
		datePicker.getModel().setSelected(true);
		
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
		
		//저장 버튼
		diarySave = new JButton("저장");
		menu.colorBlack(diarySave);
		diarySave.setFont(menu.f4);
		
		topP.add("North", tp);
		topP.add("South", dp);
		
		allP.add(topP, "North");
		allP.add(cp, "Center");
		
		menu.main.add("Center", allP);
		menu.main.add("South", diarySave);
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("East", menu.main);
		
		add("Center", menu.form);
	}
}