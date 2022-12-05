package front;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilCalendarModel;

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
    UtilCalendarModel model = new UtilCalendarModel();
    JDatePanel datePanel = new JDatePanel(model);
	JDatePicker datePicker = new JDatePicker();
	
	todoList(){
		//캘린더 패널
		JPanel calenderP = new JPanel();
		menu.panelWhiteBorder(calenderP);
		calenderP.add(c.form);
		
		//투두 상단 패널
		JPanel todoInfoP = new JPanel();
		menu.panelWhiteBorder(todoInfoP);
		todoInfoP.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

		//JDatePicker 구현  
		datePicker.getModel().setDate(menu.nowYear, menu.nowMonthValue-1, menu.nowDayOfMonth);
		datePicker.getModel().setSelected(true);
		menu.colorWhite(datePanel);
		menu.colorWhite(datePicker);
		
		todoPickDate = datePicker.getFormattedTextField().getText().replace(". ", "-");		
		
		todoInfoP.add("West", datePicker);
		todoInfoP.add("Center", menu.gap);
		todoInfoP.add("East", menu.createB);
		
		//createB 액션리스너 선언
		menu.createB.addActionListener(this);
		
		//todo 탭 패널
		JPanel todoTapP = new JPanel();
		menu.panelWhiteBorder(todoTapP);
		todoTapP.setPreferredSize(new Dimension(550, 650));
		todoTapP.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));
		
		JPanel tableP = new JPanel();
		menu.colorWhite(tableP);
		
		//탭 추가
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setPreferredSize(new Dimension(430, 530));
		menu.colorWhite(pane);
		//각 테이블 추가
		JPanel toP = new JPanel();
		menu.colorWhite(toP);
		JPanel doP = new JPanel();
		menu.colorWhite(doP);
		toT = new toTable();
		doT = new doTable();
		menu.colorWhite(toT);
		menu.colorWhite(doT);
		toT.setFont(menu.f2);
		doT.setFont(menu.f2);
		toP.add(toT);
		doP.add(doT);
		
		//체크박스를 클릭할 시 이동하는 마우스리스너 선언
		toT.table.addMouseListener(new MoEvent());
		doT.table.addMouseListener(new MoEvent());
		
		//할 일, 완료 table을 패널에 넣고 tap에 추가
		pane.addTab("할 일", toP);
		pane.addTab("완료", doP);
		tableP.add(pane);
		
		//버튼 추가
		JPanel todoButtonP = new JPanel();
		menu.colorWhite(todoButtonP);
		todoButtonP.setPreferredSize(new Dimension(550, 50));
		todoReadB = new JButton("날짜 조회");
		todoUpdateB = new JButton("수정");
		todoDeleteB = new JButton("삭제");
		menu.colorBlack(todoReadB);
		todoReadB.setFont(menu.f3);
		menu.colorBlack(todoUpdateB);
		todoUpdateB.setFont(menu.f3);
		menu.colorBlack(todoDeleteB);
		todoDeleteB.setFont(menu.f3);

		todoButtonP.add(todoReadB);
		todoButtonP.add(todoUpdateB);
		todoButtonP.add(todoDeleteB);
	
		//수정, 삭제 버튼 액션 리스너 선언
		todoUpdateB.addActionListener(this);
		todoDeleteB.addActionListener(this);
		
		todoTapP.add("Center",tableP);
		todoTapP.add("South",todoButtonP);
		
		//투두 패널 합치기
		JPanel todoP = new JPanel();
		menu.colorWhite(todoP);
		todoP.setPreferredSize(new Dimension(450,750));
		todoP.add(todoInfoP);
		todoP.add(todoTapP);
		
		menu.form.add("West", menu.buttonP);
		menu.form.add("Center", calenderP);
		menu.form.add("East", todoP);
		
		add("Center", menu.form);
	}
	
	//마우스 리스너를 위한 마우스 어댑터
	class MoEvent extends MouseAdapter{
		@Override
		 public void mouseClicked(MouseEvent e) {
			 todoCheck tc;
			 todoPickDate = datePicker.getFormattedTextField().getText().replace(". ", "-");
			 //할 일 탭에서 클릭했을 경우 todoCheck 항목을 true로 바꾸고 재로드(todoCheck.java로 전달)
			 if (pane.getSelectedIndex() == 0){
				 if (((boolean)toT.todoCheckValue()) == true){
					 int toNo = (int) toT.todoNoValue();
					 tc = new todoCheck(true, toNo);
					 toT.toTableRead(todoPickDate);
					 doT.doTableRead(todoPickDate);
				 }
			//완료 탭에서 클릭했을 경우 todoCheck 항목을 false로 바꾸고 재로드(todoCheck.java로 전달)
			 }else if(pane.getSelectedIndex() == 1)
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
		//생성 버튼을 클릭했을 경우 입력창을 띄워서 입력한 항목 추가 및 재로드(todoWriteSave.java로 전달)
		if(e.getSource()== menu.createB) {
			String Contents = JOptionPane.showInputDialog(this, "To-Do 내용 입력");
			todoPickDate = datePicker.getFormattedTextField().getText().replace(". ", "-"); //JDatePicker로 지정한 날짜 전송
			todoWriteSave tws = new todoWriteSave(Contents, todoPickDate);
			toT.toTableRead();
		//수정 버튼을 클릭했을 경우 해당 항목 값을 가져와 보여주고, 사용자가 재입력하면 수정 후 재로드(todoEditSave.java로 전달)
		}else if(e.getSource()==todoUpdateB){
			todoEditSave tes;
			if (pane.getSelectedIndex() == 0){	//할 일 탭은 toTable를 사용해 값을 가져오고 재로드
				int toNo = (int) toT.todoNoValue();
				String Contents = JOptionPane.showInputDialog(this, "To-Do 수정", (String) toT.todoContentsValue());
				tes = new todoEditSave(Contents, toNo);
				toT.toTableRead();
			}else if(pane.getSelectedIndex() == 1){	//할 일 탭은 doTable를 사용해 값을 가져오고 재로드
				int doNo = (int) doT.todoNoValue();
				String Contents = JOptionPane.showInputDialog(this, "To-Do 수정", (String) doT.todoContentsValue());
				tes = new todoEditSave(Contents, doNo);
				doT.doTableRead();
			}
		//삭제 버튼을 클릭했을 경우 해당 항목의 번호를 가져와 삭제 후 재로드(todoDeleteSave.java로 전달)
		}else if(e.getSource()==todoDeleteB){
			todoDeleteSave tds;
			if (pane.getSelectedIndex() == 0){	//할 일 탭은 toTable를 사용해 값을 가져오고 재로드
				int toNo = (int) toT.todoNoValue();
				tds = new todoDeleteSave(toNo);
				JOptionPane.showMessageDialog(this, "삭제되었습니다.", "삭제 완료 메세지",JOptionPane.PLAIN_MESSAGE );
				toT.toTableRead();
			}else if(pane.getSelectedIndex() == 1){	//할 일 탭은 doTable를 사용해 값을 가져오고 재로드
				int doNo = (int) doT.todoNoValue();
				tds = new todoDeleteSave(doNo);
				JOptionPane.showMessageDialog(this, "삭제되었습니다.", "삭제 완료 메세지",JOptionPane.PLAIN_MESSAGE );
				doT.doTableRead();
			}
		}
	}
}