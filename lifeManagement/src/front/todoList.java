package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import back.todoCheck;
import back.todoDeleteSave;
import back.todoEditSave;
import back.todoWriteSave;

public class todoList extends JPanel implements ActionListener {
	public static String todoPickDate;
	tapMenu menu = new tapMenu();
	calendar c = new calendar();
	toTable toT;
	doTable doT;
	JButton todoReadB, todoUpdateB, todoDeleteB;
	JTabbedPane pane;
	
    //JDatePicker
    Properties p = new Properties();
    
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	
	todoList(){
		
		//중간패널
		JPanel CMP = new JPanel();
		CMP.setLayout(new BoxLayout(CMP,BoxLayout.Y_AXIS));
		CMP.setBackground(Color.white);
		CMP.setSize(250, 750);
		
		//캘린더 패널
		JPanel calenderP = new JPanel();
		calenderP.setLayout(new BorderLayout());
		calenderP.setBackground(Color.darkGray);
		
		//캘린더 추가 구현필요
		calenderP.add(c.form);
		
		CMP.add("North", calenderP);
		//todo 넣기
		//CMP.add("South", memoP);
		
		//투두 상단 패널
		JPanel todoInfoP = new JPanel();
		todoInfoP.setBackground(Color.white);
		todoInfoP.setLayout(new BorderLayout());
		todoInfoP.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		//JDatePicker 구현
		p.put("text.today", "Today");
	    p.put("text.month", "Month");
	    p.put("text.year", "Year");
	    
		model.setDate(menu.nowYear, menu.nowMonthValue-1, menu.nowDayOfMonth);
		model.setSelected(true);
		
		todoPickDate = datePicker.getJFormattedTextField().getText();
		
		todoInfoP.add("West", datePicker);
		todoInfoP.add("Center", menu.gap);
		todoInfoP.add("East", menu.createB);
		
		//createB 클릭 시 입력 창 생성
		menu.createB.addActionListener(this);
		
		//todo 탭 패널
		JPanel todoTapP = new JPanel();
		todoTapP.setBackground(Color.white);
		todoTapP.setLayout(new BorderLayout());
		todoTapP.setPreferredSize(new Dimension(550, 650));
		todoTapP.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));
		
		JPanel tableP = new JPanel();
		tableP.setBackground(Color.white);
		//탭 추가
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setPreferredSize(new Dimension(430, 530));
		pane.setBackground(Color.white);
		JPanel toP = new JPanel();
		toP.setBackground(Color.white);
		JPanel doP = new JPanel();
		doP.setBackground(Color.white);
		
		toT = new toTable();
		doT = new doTable();
		toT.setBackground(Color.white);
		toT.setFont(menu.f2);
		doT.setBackground(Color.white);
		doT.setFont(menu.f2);
		toP.add(toT);
		doP.add(doT);
		
		toT.table.addMouseListener(new MoEvent());
		doT.table.addMouseListener(new MoEvent());
		
		
		//할 일, 완료 table을 패널에 넣고 tap에 추가
		pane.addTab("할 일", toP);
		pane.addTab("완료", doP);
		tableP.add(pane);
		//버튼 추가
		JPanel todoButtonP = new JPanel();
		todoButtonP.setBackground(Color.white);
		todoButtonP.setPreferredSize(new Dimension(550, 50));
		todoReadB = new JButton("날짜 조회");
		todoUpdateB = new JButton("수정");
		todoDeleteB = new JButton("삭제");
		//수정, 삭제 버튼 디자인 구현 필요
		todoButtonP.add(todoReadB);
		todoButtonP.add(todoUpdateB);
		todoButtonP.add(todoDeleteB);
	
		todoUpdateB.addActionListener(this);
		todoDeleteB.addActionListener(this);
		
		todoTapP.add("Center",tableP);
		todoTapP.add("South",todoButtonP);
		
		//투두 패널 합체
		JPanel todoP = new JPanel();
		todoP.setBackground(Color.white);
		todoP.setPreferredSize(new Dimension(450,750));
		todoP.add(todoInfoP);
		todoP.add(todoTapP);
		
		//투두 버튼 패널
		JPanel butp = new JPanel();
		butp.setLayout(new BorderLayout());
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("Center", CMP);
		menu.form.add("East", todoP);
		
		add("Center", menu.form);
	}
	
	//아직 덜 구현함
	class MoEvent extends MouseAdapter{
		@Override
		 public void mouseClicked(MouseEvent e) {
			 todoCheck tc;
			 todoPickDate = datePicker.getJFormattedTextField().getText();
			 System.out.println(todoPickDate);
			 System.out.println("pane.getSelectedIndex(): "+pane.getSelectedIndex());
			 if (pane.getSelectedIndex() == 0){
				 System.out.println(((boolean)toT.todoCheckValue()) == true);
				 if (((boolean)toT.todoCheckValue()) == true){
					 int toNo = (int) toT.todoNoValue();
					 tc = new todoCheck(true, toNo);
					 toT.toTableRead(todoPickDate);
					 doT.doTableRead(todoPickDate);
				 }
			 }else if(pane.getSelectedIndex() == 1)
				 System.out.println(((boolean)doT.todoCheckValue()) == false);
				 if (((boolean)doT.todoCheckValue()) == false){
					 int doNo = (int) doT.todoNoValue();
					 tc = new todoCheck(false, doNo);
					 toT.toTableRead(todoPickDate);
					 doT.doTableRead(todoPickDate);
				 }
		 }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== menu.createB) {
			String Contents = JOptionPane.showInputDialog(this, "To-Do 내용 입력");
			todoPickDate = datePicker.getJFormattedTextField().getText(); //JDatePicker로 지정한 날짜 전송
			todoWriteSave tws = new todoWriteSave(Contents, todoPickDate);
			toT.toTableRead();
		}else if(e.getSource()==todoUpdateB){
			todoEditSave tes;
			if (pane.getSelectedIndex() == 0){
				int toNo = (int) toT.todoNoValue();
				String Contents = JOptionPane.showInputDialog(this, "To-Do 수정", (String) toT.todoContentsValue());
				tes = new todoEditSave(Contents, toNo);
				toT.toTableRead();
			}else if(pane.getSelectedIndex() == 1){
				int doNo = (int) doT.todoNoValue();
				String Contents = JOptionPane.showInputDialog(this, "To-Do 수정", (String) doT.todoContentsValue());
				tes = new todoEditSave(Contents, doNo);
				doT.doTableRead();
			}
		}else if(e.getSource()==todoDeleteB){
			todoDeleteSave tds;
			if (pane.getSelectedIndex() == 0){
				int toNo = (int) toT.todoNoValue();
				tds = new todoDeleteSave(toNo);
				JOptionPane.showMessageDialog(this, "삭제되었습니다.", "삭제 완료 메세지",JOptionPane.PLAIN_MESSAGE );
				toT.toTableRead();
			}else if(pane.getSelectedIndex() == 1){
				int doNo = (int) doT.todoNoValue();
				tds = new todoDeleteSave(doNo);
				JOptionPane.showMessageDialog(this, "삭제되었습니다.", "삭제 완료 메세지",JOptionPane.PLAIN_MESSAGE );
				doT.doTableRead();
			}
		}
		
	}
}
