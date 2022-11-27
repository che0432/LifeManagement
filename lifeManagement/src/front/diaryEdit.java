package front;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class diaryEdit extends JPanel {
	tapMenu menu = new tapMenu();
	JLabel titleL, contentsL, dateL;
	JTextField title;
	JTextArea contents;
	JButton diaryEditSave;
	
	String setEditTitle = "";
	String setEditDate = "0000-00-00";
	String setEditContents = "";
	
	Font df = new Font("KoPub돋움체 medium", Font.PLAIN, 20);
	
	String diaryPickDate;
	
	//JDatePicker
    Properties p = new Properties();
    
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	
	public diaryEdit(){
			//종합 패널
			JPanel allP = new JPanel();
			allP.setLayout(new BorderLayout());
			menu.panelWhite(allP);
			
			//상단 패널
			JPanel topP = new JPanel();
			topP.setLayout(new BorderLayout());
			menu.panelWhite(topP);
			
			//title 패널
			JPanel tp = new JPanel();
			menu.panelWhite(tp);
			titleL = new JLabel("제목: ");
			titleL.setFont(df);
			title = new JTextField();
			title.setPreferredSize(new Dimension(500, 30));
			tp.add(titleL);
			tp.add(title);
			
			//date 패널
			JPanel dp = new JPanel();
			menu.panelWhite(dp);
			dateL = new JLabel("날짜: ");
			dateL.setFont(df);
			//JDatePicker 구현
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			
			tp.add(dateL);
			tp.add(datePicker);
			
			//contents 패널
			JPanel cp = new JPanel();
			cp.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));
			cp.setLayout(new BorderLayout());
			menu.panelWhite(cp);
			contentsL = new JLabel("내용: ");
			contentsL.setFont(df);
			//내용
			JPanel cc = new JPanel();
			cc.setLayout(new BorderLayout());
			menu.panelWhite(cc);
			cc.setPreferredSize(new Dimension(500, 300));
			contents = new JTextArea();
			contents.setLineWrap(true);
			JScrollPane sp = new JScrollPane(contents);
			cc.add(sp, "Center");
			
			cp.add(contentsL, "North");
			cp.add(cc, "Center");
			
			diaryEditSet();
			
			diaryEditSave = new JButton("저장");
			
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
	
	public void diaryEditSet(){
		//한건 상세 정보 set
		String getDate[] = setEditDate.split("-");
		int year, month, day;
		year = Integer.parseInt(getDate[0]);
		month = Integer.parseInt(getDate[1])-1;
		day = Integer.parseInt(getDate[2]);
		
		title.setText(setEditTitle);
		model.setDate(year, month, day);
		model.setSelected(true);
		contents.setText(setEditContents);
	}
}
