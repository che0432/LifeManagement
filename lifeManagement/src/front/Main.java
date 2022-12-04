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
		//상단에 탭 메뉴 제작 필요
		
		super("일상 관리 어플리케이션");
		
		//화면 전환용 마지막 패널 선언
		finalP = new JPanel();
		finalP.setLayout(new BoxLayout(finalP,BoxLayout.X_AXIS));
		finalP.add(todoAll.menu.form);
		add(finalP);
		
		diaryAll.menu.form.setVisible(false);
		diaryW.menu.form.setVisible(false);
		diaryD.menu.form.setVisible(false);
		diaryE.menu.form.setVisible(false);
		
		//화면전환 리스너 선언
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
		
		//메모 창 띄우기 리스너 선언
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
		
		//날짜 조회 리스너 구현
		diaryAll.diaryReadB.addActionListener(this);
		diaryAll.diaryReadB.setActionCommand("diaryDateRead");
		todoAll.todoReadB.addActionListener(this);
		todoAll.todoReadB.setActionCommand("todoDateRead");
		
		//일기장 입력 화면 전환
		diaryAll.menu.getCreateB().addActionListener(this);
		diaryAll.menu.getCreateB().setActionCommand("diaryCreate");
		
		//일기장 작성 저장
		diaryW.diarySave.addActionListener(this);
		diaryW.diarySave.setActionCommand("diarySave");
		
		//일기장 한건 상세 화면 전환
		diaryAll.diaryDetail.addActionListener(this);
		diaryAll.diaryDetail.setActionCommand("diaryDetail");
		
		//한건 상세에서 삭제 버튼 클릭 이벤트
		diaryD.diaryDelete.addActionListener(this);
		diaryD.diaryDelete.setActionCommand("diaryDelete");
		
		//한건 상세에서 수정 버튼 클릭 이벤트
		diaryD.diaryEdit.addActionListener(this);
		diaryD.diaryEdit.setActionCommand("diaryEdit");
		
		//수정에서 저장 버튼 클릭 이벤트
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
			if(me.memoVisible == false)
				me.setVisible(true);
		}else if(cmd.equals("diaryDateRead")){
			int year = Integer.parseInt(diaryAll.yearT.getText());
			int month = Integer.parseInt(diaryAll.monthC.getSelectedItem().toString()); 
			diaryAll.diaryT.diaryTableRead(year, month);
		}else if(cmd.equals("todoDateRead")){
			String todoDate = todoAll.datePicker.getFormattedTextField().getText().replace(". ", "-");
			todoAll.toT.toTableRead(todoDate);
			todoAll.doT.doTableRead(todoDate);
		}else if(cmd.equals("diaryCreate")){
			finalP.remove(diaryAll.menu.form);
			diaryAll.menu.form.setVisible(false);
			finalP.add(diaryW.menu.form);
			diaryW.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}else if(cmd.equals("diarySave")){
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
			//한건 삭제 실행
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
			String diaryT = diaryE.title.getText(); 
			String diaryC = diaryE.contents.getText(); 
			diaryE.diaryPickDate = diaryE.datePicker.getFormattedTextField().getText().replace(". ", "-");
			int diaryN = (int) diaryAll.diaryT.diaryNoValue();
			
			diaryEditSave des = new diaryEditSave(diaryT, diaryC, diaryE.diaryPickDate, diaryN);
			JOptionPane.showMessageDialog(this, "저장되었습니다.", "저장 완료 메세지",JOptionPane.PLAIN_MESSAGE );
			
			finalP.remove(diaryE.menu.form);
			diaryE.menu.form.setVisible(false);
			finalP.add(diaryD.menu.form);
			diaryD.menu.form.setVisible(true);
			finalP.revalidate();
			finalP.repaint();
		}
	}
}
