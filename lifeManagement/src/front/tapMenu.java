package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tapMenu extends JPanel {
	JButton createB;
	JPanel form, main;
	JButton todoB, diaryB, memoB;
	JLabel gap, gap2, gapS;

	JPanel buttonP;
	
	//현재 날짜 가져오기
	LocalDate now = LocalDate.now();
	int nowYear = now.getYear();
	int nowMonthValue = now.getMonthValue();
	int nowDayOfMonth = now.getDayOfMonth();
	
	//날짜 format 정의
	String monthValue = now.format(DateTimeFormatter.ofPattern("MM"));
	String yearValue = now.format(DateTimeFormatter.ofPattern("yyyy"));	
	
	//폰트 정의
	Font f1 = new Font("KoPub돋움체 Medium", Font.BOLD, 30);
	Font f2 = new Font("KoPub돋움체 Light", Font.PLAIN, 15);
	Font f3 = new Font("KoPub돋움체 medium", Font.PLAIN, 20);
	Font f4 = new Font("KoPub돋움체 Medium", Font.PLAIN, 25);
	Font f5 = new Font("KoPub돋움체 Medium", Font.PLAIN, 15);
	
	//이미지 경로 정의
	ImageIcon diaryImg = new ImageIcon("./image/diaryButton.png");
	ImageIcon todoImg = new ImageIcon("./image/todoButton.png");
	ImageIcon memoImg = new ImageIcon("./image/memoButton.png");
	ImageIcon createImg = new ImageIcon("./image/createButton.png");
	ImageIcon createRolloverImg = new ImageIcon("./image/createRolloverButton.png");
	
	tapMenu(){	
	//전체 패널
	form = new JPanel();
	form.setLayout(new BoxLayout(form,BoxLayout.X_AXIS));
	colorWhite(form);
	
	//컴포넌트 간 갭 레이블
	gap = new JLabel(" ");
	gap.setPreferredSize(new Dimension(50, 10));
	gap2 = new JLabel(" ");
	gap2.setPreferredSize(new Dimension(100, 10));
	gapS = new JLabel(" ");
	gapS.setPreferredSize(new Dimension(10, 10));
	
	//일기 메인 패널
	main = new JPanel();
	diaryMainPanel(main);
	
	//버튼 패널
	buttonP = new JPanel();
	buttonP.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
	buttonP.setLayout(new FlowLayout());
	buttonP.setPreferredSize(new Dimension(300,750));
	buttonP.setBackground(Color.black);
	
	//메뉴 버튼 디자인
	todoB = new JButton(todoImg);
	diaryB = new JButton(diaryImg);
	memoB = new JButton(memoImg);
	buttonSet(todoB, "./image/todoButtonClick.png");
	buttonSet(diaryB, "./image/diaryButtonClick.png");
	buttonSet(memoB, "./image/memoButtonClick.png");
	gap = new JLabel(" ");
	gap.setPreferredSize(new Dimension(100, 10));
	buttonP.add(todoB);
	buttonP.add(diaryB);
	buttonP.add(memoB);
	
	//CreateB 생성 버튼
	createB = new JButton(createImg);
	createB.setPreferredSize(new Dimension(40, 40));
	createB.setBackground(Color.white);
	createB.setBorderPainted(false);
	createB.setRolloverIcon(createRolloverImg);
	}
	
	//메뉴 버튼 디자인 함수
	public void buttonSet(JButton btn, String location) {
		ImageIcon img = new ImageIcon(location);
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		btn.setPreferredSize(new Dimension(250,80));
		btn.setBorderPainted(false);
		btn.setRolloverIcon(img); // 버튼에 마우스가 올라갈때 이미지 변환
	}
	
	//패널 흰 배경, BorderLayout지정 함수
	public void panelWhiteBorder(JPanel form){
		form.setBackground(Color.white);
		form.setLayout(new BorderLayout());
	}
	
	//컴포넌트 흰 배경 지정 함수
	public void colorWhite(Component c){
		c.setBackground(Color.white);
	}
	
	//컴포넌트 검은 배경, 흰 글씨 지정 함수
	public void colorBlack(Component c){
		c.setBackground(Color.black);
		c.setForeground(Color.white);
	}
	
	//일기 패널 main 크기와 배경, 레이아웃 지정 함수
	public void diaryMainPanel(JPanel main){
		main.setPreferredSize(new Dimension(700,750));
		panelWhiteBorder(main);
	}
	
	//Main.java에서 이벤트 구현 시 필요한 버튼 가져오는 getter
	public JButton getTodoB(){
		return todoB;
	}
	
	public JButton getDiaryB(){
		return diaryB;
	}
	
	public JButton getMemoB() {
		return memoB;
	}

	public JButton getCreateB() {
		return createB;
	}
}