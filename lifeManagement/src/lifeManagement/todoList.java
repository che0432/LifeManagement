package lifeManagement;



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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class todoList extends JPanel implements FocusListener {
	JLabel today;
	JTextArea memo;

	tapMenu menu = new tapMenu();
	
	Color memoColor = new Color(255,250,176);
	Color memoFontColor = new Color(192,109,21);
	Font mf = new Font("KoPub돋움체 medium", Font.PLAIN, 15);
	
	todoList(){
		
		//중간패널
		JPanel CMP = new JPanel();
		CMP.setLayout(new BoxLayout(CMP,BoxLayout.Y_AXIS));
		CMP.setBackground(Color.white);
		CMP.setSize(250, 750);
		
		//캘린더 패널
		JPanel calenderP = new JPanel();
		calenderP.setLayout(new BorderLayout());
		calenderP.setBackground(Color.blue);
		//캘린더 추가 구현필요
		
		
		//메모 패널
		JPanel memoP = new JPanel();
		memoP.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		memoP.setLayout(new BorderLayout());
		memoP.setBackground(Color.white);
		memo = new JTextArea("내용을 입력하세요.");
		memo.setFont(mf);
		memo.setForeground(memoFontColor);
		memo.setBackground(memoColor);
		memo.setLineWrap(true);

		memoP.add(new JScrollPane(memo), BorderLayout.CENTER);
		memo.addFocusListener(this);
		//클릭할시 내용 초기화 하는 함수 작성 필요
		/*
		memo.addFocusListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				t.setText(""); 
			}
		});
		*/
		
		CMP.add("North", calenderP);
		CMP.add("South", memoP);
		
		//투두 상단 패널
		JPanel todoInfoP = new JPanel();
		todoInfoP.setBackground(Color.white);
		todoInfoP.setLayout(new BorderLayout());
		todoInfoP.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		today = new JLabel("2022년 11월 12일");
		today.setFont(menu.f1);
		todoInfoP.add("West", today);
		todoInfoP.add("Center", menu.gap);
		todoInfoP.add("East", menu.createB);
		
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
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
