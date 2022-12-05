package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import back.diaryEditSave;
import back.diaryWriteSave;
import db.diaryModel;
import db.lifeDAO;
import front.diaryList;
import front.todoList;

public class Main extends JFrame implements ActionListener  {
	JPanel finalP;
	diaryModel dm;
	//객체 생성
	lifeDAO ldao = new lifeDAO();
	todoList todoAll = new todoList();
	diaryList diaryAll = new diaryList();
	diaryWrite diaryW = new diaryWrite();
	diaryDetail diaryD = new diaryDetail();
	diaryEdit diaryE = new diaryEdit();
	memo me = new memo();
	
	String msg = "";
	String diaryDatePick;
	
	Main() throws IOException {		
		super("일상 관리 어플리케이션");
		
		//화면 전환용 패널 선언(이 패널에 다른 패널을 가져와 추가함)
		finalP = new JPanel();
		finalP.setLayout(new BoxLayout(finalP,BoxLayout.X_AXIS));
		finalP.add(todoAll.menu.form);
		add(finalP);
		
		//첫 화면은 투두리스트 페이지이므로 다른 페이지는 보이지 않게 처리, 필요할 때 true로 바꿔줌
		diaryAll.menu.form.setVisible(false);
		diaryW.menu.form.setVisible(false);
		diaryD.menu.form.setVisible(false);
		diaryE.menu.form.setVisible(false);
		
		//투두리스트 페이지로 화면 전환
		diaryAll.menu.getTodoB().addActionListener(this);
		diaryAll.menu.getTodoB().setActionCommand("todo");
		diaryW.menu.getTodoB().addActionListener(this);
		diaryW.menu.getTodoB().setActionCommand("todo");
		diaryD.menu.getTodoB().addActionListener(this);
		diaryD.menu.getTodoB().setActionCommand("todo");
		diaryE.menu.getTodoB().addActionListener(this);
		diaryE.menu.getTodoB().setActionCommand("todo");
		
		todoAll.menu.getDiaryB().addActionListener(this);
		todoAll.menu.getDiaryB().setActionCommand("diary");
		diaryW.menu.getDiaryB().addActionListener(this);
		diaryW.menu.getDiaryB().setActionCommand("diary");
		diaryD.menu.getDiaryB().addActionListener(this);
		diaryD.menu.getDiaryB().setActionCommand("diary");
		diaryE.menu.getDiaryB().addActionListener(this);
		diaryE.menu.getDiaryB().setActionCommand("diary");
		
		//메모 버튼 클릭 이벤트
		diaryAll.menu.getMemoB().addActionListener(this);
		diaryAll.menu.getMemoB().setActionCommand("memo");
		todoAll.menu.getMemoB().addActionListener(this);
		todoAll.menu.getMemoB().setActionCommand("memo");
		diaryW.menu.getMemoB().addActionListener(this);
		diaryW.menu.getMemoB().setActionCommand("memo");
		diaryD.menu.getMemoB().addActionListener(this);
		diaryD.menu.getMemoB().setActionCommand("memo");
		diaryE.menu.getMemoB().addActionListener(this);
		diaryE.menu.getMemoB().setActionCommand("memo");
		
		//날짜로 조회하는 버튼 클릭 이벤트
		diaryAll.diaryReadB.addActionListener(this);
		diaryAll.diaryReadB.setActionCommand("diaryDateRead");
		todoAll.todoReadB.addActionListener(this);
		todoAll.todoReadB.setActionCommand("todoDateRead");
		
		//일기 생성 페이지로 화면 전환
		diaryAll.menu.getCreateB().addActionListener(this);
		diaryAll.menu.getCreateB().setActionCommand("diaryCreate");
		
		//일기장 생성 페이지에서 저장 버튼 클릭 이벤트
		diaryW.diarySave.addActionListener(this);
		diaryW.diarySave.setActionCommand("diarySave");
		
		//일기 상세 페이지로 화면 전환
		diaryAll.diaryDetail.addActionListener(this);
		diaryAll.diaryDetail.setActionCommand("diaryDetail");
		
		//일기 상세 페이지에서 삭제 버튼 클릭 이벤트
		diaryD.diaryDelete.addActionListener(this);
		diaryD.diaryDelete.setActionCommand("diaryDelete");
		
		//일기 상세 페이지에서 수정 버튼 클릭 이벤트
		diaryD.diaryEdit.addActionListener(this);
		diaryD.diaryEdit.setActionCommand("diaryEdit");
		
		//일기 수정 페이지에서 저장 버튼 클릭 이벤트
		diaryE.diaryEditSave.addActionListener(this);
		diaryE.diaryEditSave.setActionCommand("diaryEditSave");
		
		setSize(1200, 750);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();

	}
	
	//패널 전환 화면 이동 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("diary")){
			// 일기 페이지로 이동
			if(todoAll.menu.form.isVisible()){
				finalP.remove(todoAll.menu.form);
				todoAll.menu.form.setVisible(false);
			}else if(diaryW.menu.form.isVisible()){
				finalP.remove(diaryW.menu.form);
				diaryW.menu.form.setVisible(false);
			}else if(diaryD.menu.form.isVisible()){
				finalP.remove(diaryD.menu.form);
				diaryD.menu.form.setVisible(false);
			}else if(diaryE.menu.form.isVisible()){
				finalP.remove(diaryE.menu.form);
				diaryE.menu.form.setVisible(false);
			}
			finalP.add(diaryAll.menu.form);
			diaryAll.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("todo")){
			//투두리스트 페이지로 이동
			if(diaryAll.menu.form.isVisible()){
				finalP.remove(diaryAll.menu.form);
				diaryAll.menu.form.setVisible(false);
			}else if(diaryW.menu.form.isVisible()){
				finalP.remove(diaryW.menu.form);
				diaryW.menu.form.setVisible(false);
			}else if(diaryD.menu.form.isVisible()){
				finalP.remove(diaryD.menu.form);
				diaryD.menu.form.setVisible(false);
			}else if(diaryE.menu.form.isVisible()){
				finalP.remove(diaryE.menu.form);
				diaryE.menu.form.setVisible(false);
			}
			finalP.add(todoAll.menu.form);
			todoAll.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("memo")){
			//메모 창 띄우기
			if(me.memoVisible == false)
				me.setVisible(true);
		}else if(cmd.equals("diaryDateRead")){
			//일기 항목 날짜로 조회
			int year = Integer.parseInt(diaryAll.yearT.getText());
			int month = Integer.parseInt(diaryAll.monthC.getSelectedItem().toString()); 
			diaryAll.diaryT.diaryTableRead(year, month);
		}else if(cmd.equals("todoDateRead")){
			//투두리스트 항목 날짜로 조회
			String todoDate = todoAll.datePicker.getFormattedTextField().getText().replace(". ", "-");
			todoAll.toT.toTableRead(todoDate);
			todoAll.doT.doTableRead(todoDate);
		}else if(cmd.equals("diaryCreate")){
			//일기 생성 페이지로 이동
			finalP.remove(diaryAll.menu.form);
			diaryAll.menu.form.setVisible(false);
			finalP.add(diaryW.menu.form);
			diaryW.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("diarySave")){
			//일기 생성
			String diaryT = diaryW.title.getText(); 
			String diaryC = diaryW.contents.getText(); 
			diaryW.diaryPickDate = diaryW.datePicker.getFormattedTextField().getText().replace(". ", "-");
			diaryWriteSave dws = new diaryWriteSave(diaryT, diaryC, diaryW.diaryPickDate);
			JOptionPane.showMessageDialog(this, "저장되었습니다.", "저장 완료 메세지",JOptionPane.PLAIN_MESSAGE );
			
			finalP.remove(diaryW.menu.form);
			diaryW.menu.form.setVisible(false);
			finalP.add(diaryAll.menu.form);
			diaryAll.menu.form.setVisible(true);
			diaryAll.diaryT.diaryTableRead();
			
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("diaryDetail")){
			//일기 상세 페이지로 이동
			diaryDatePick = (String) diaryAll.diaryT.diaryDateValue();
			
			dm = ldao.readDiaryDetail(diaryDatePick);
			diaryD.diaryDetailTitle = dm.getTitle();
			diaryD.diaryDetailDate = dm.getDiaryDate();
			diaryD.diaryDetailContents = dm.getDiaryContents();
			diaryD.setValue();
			
			finalP.remove(diaryAll.menu.form);
			diaryAll.menu.form.setVisible(false);
			finalP.add(diaryD.menu.form);
			diaryD.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("diaryDelete")){
			//일기 삭제
			diaryDatePick = (String) diaryD.diaryDetailDate;
			ldao.diaryDelete(diaryDatePick);
			JOptionPane.showMessageDialog(this, "삭제되었습니다.", "삭제 완료 메세지",JOptionPane.PLAIN_MESSAGE );
			finalP.remove(diaryD.menu.form);
			diaryD.menu.form.setVisible(false);
			finalP.add(diaryAll.menu.form);
			diaryAll.menu.form.setVisible(true);
			diaryAll.diaryT.diaryTableRead();
			
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("diaryEdit")){
			//일기 수정 페이지로 이동(정보 가져오기)
			diaryE.setEditTitle = diaryD.diaryDetailTitle;
			diaryE.setEditDate = diaryD.diaryDetailDate;
			diaryE.setEditContents = diaryD.diaryDetailContents; 
			
			diaryE.diaryEditSet();
			
			finalP.remove(diaryD.menu.form);
			diaryD.menu.form.setVisible(false);
			finalP.add(diaryE.menu.form);
			diaryE.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("diaryEditSave")){
			//일기 수정
			String diaryT = diaryE.title.getText(); 
			String diaryC = diaryE.contents.getText(); 
			diaryE.diaryPickDate = diaryE.datePicker.getFormattedTextField().getText().replace(". ", "-");
			int diaryN = (int) diaryAll.diaryT.diaryNoValue();
			
			diaryEditSave des = new diaryEditSave(diaryT, diaryC, diaryE.diaryPickDate, diaryN);
			JOptionPane.showMessageDialog(this, "저장되었습니다.", "저장 완료 메세지",JOptionPane.PLAIN_MESSAGE );
			
			diaryDatePick = (String) diaryAll.diaryT.diaryDateValue();
			
			dm = ldao.readDiaryDetail(diaryDatePick);
			diaryD.diaryDetailTitle = dm.getTitle();
			diaryD.diaryDetailDate = dm.getDiaryDate();
			diaryD.diaryDetailContents = dm.getDiaryContents();
			diaryD.setValue();
			
			finalP.remove(diaryE.menu.form);
			diaryE.menu.form.setVisible(false);
			finalP.add(diaryD.menu.form);
			diaryD.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}
	}
}
