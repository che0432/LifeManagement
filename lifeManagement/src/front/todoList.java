package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import back.todoWriteSave;

public class todoList extends JPanel implements ActionListener {
	JLabel todoDay;
	
	tapMenu menu = new tapMenu();
	
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
		
		
		

		
		CMP.add("North", calenderP);
		//todo 넣기
		//CMP.add("South", memoP);
		
		//투두 상단 패널
		JPanel todoInfoP = new JPanel();
		todoInfoP.setBackground(Color.white);
		todoInfoP.setLayout(new BorderLayout());
		todoInfoP.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		todoDay = new JLabel("2022-11-12");
		todoDay.setFont(menu.f1);
		todoInfoP.add("West", todoDay);
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
		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setPreferredSize(new Dimension(430, 530));
		pane.setBackground(Color.white);
		JPanel toP = new JPanel();
		toP.setBackground(Color.white);
		JPanel doP = new JPanel();
		doP.setBackground(Color.white);
		toTable toT = new toTable();
		doTable doT = new doTable();
		toT.setBackground(Color.white);
		toT.setFont(menu.f2);
		doT.setBackground(Color.white);
		doT.setFont(menu.f2);
		toP.add(toT);	doP.add(doT);
		//할 일, 완료 table을 패널에 넣고 tap에 추가
		pane.addTab("할 일", toP);
		pane.addTab("완료", doP);
		tableP.add(pane);
		//버튼 추가
		JPanel todoButtonP = new JPanel();
		todoButtonP.setBackground(Color.white);
		todoButtonP.setPreferredSize(new Dimension(550, 50));
		JButton todoUpdateB = new JButton("수정");
		JButton todoDeleteB = new JButton("삭제");
		//수정, 삭제 버튼 디자인 구현 필요
		todoButtonP.add(todoUpdateB);
		todoButtonP.add(todoDeleteB);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== menu.createB) {
			String Contents = JOptionPane.showInputDialog(this, "To-Do 내용 입력");
			String todoDate = todoDay.getText();
			todoWriteSave tws = new todoWriteSave(Contents, todoDate);
			}
		
	}
}
