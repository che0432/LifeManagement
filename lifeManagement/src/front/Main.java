package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import db.lifeDAO;
import front.diaryList;
import front.todoList;

public class Main extends JFrame implements ActionListener  {
	JPanel finalP;
	todoList todoAll = new todoList();
	diaryList diaryAll = new diaryList();
	memo me = new memo();
	String msg = "";
	
	Main(){
		//상단에 탭 메뉴 제작 필요
		
		super("일상 관리 어플리케이션");
		
		//화면 전환용 마지막 패널 선언
		finalP = new JPanel();
		finalP.setLayout(new BoxLayout(finalP,BoxLayout.X_AXIS));
		finalP.add(todoAll.menu.form);
		add(finalP);
		
		//화면전환 리스너 선언
		diaryAll.menu.getTodoB().addActionListener(this);
		diaryAll.menu.getTodoB().setActionCommand("todo");
		todoAll.menu.getDiaryB().addActionListener(this);
		todoAll.menu.getDiaryB().setActionCommand("diary");
		
		//메모 창 띄우기 리스너 선언
		diaryAll.menu.getMemoB().addActionListener(this);
		diaryAll.menu.getMemoB().setActionCommand("memo");
		todoAll.menu.getMemoB().addActionListener(this);
		todoAll.menu.getMemoB().setActionCommand("memo");
		
		//System.out.println(memoVisible);
		setSize(1200, 750);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Main m = new Main();

	}
	
	//패널 전환 화면 이동 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("diary")){
			finalP.remove(todoAll.menu.form);
			finalP.add(diaryAll.menu.form);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("todo")){
			finalP.remove(diaryAll.menu.form);
			finalP.add(todoAll.menu.form);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("memo")){
			if(me.memoVisible == false)
				me.setVisible(true);
		}
	}
}
