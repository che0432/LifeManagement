package lifeManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tapMenu extends JPanel {
	JButton createB;
	JPanel form, main;
	JButton todoB, diaryB;
	JLabel gap, gap2, gapS;
	JPanel buttonP;
	
	Font f1 = new Font("KoPub돋움체 Medium", Font.BOLD, 30);
	Font f2 = new Font("KoPub돋움체 Light", Font.PLAIN, 15);
	Font f4 = new Font("KoPub돋움체 Medium", Font.PLAIN, 25);
	
	ImageIcon diaryImg = new ImageIcon("./image/diaryButton.png");
	ImageIcon todoImg = new ImageIcon("./image/todoButton.png");
	ImageIcon createImg = new ImageIcon("./image/createButton.png");
	ImageIcon createRolloverImg = new ImageIcon("./image/createRolloverButton.png");
	
	tapMenu(){
	
	//전체 패널
	form = new JPanel();
	form.setLayout(new BoxLayout(form,BoxLayout.X_AXIS));
	panelWhite(form);
	
	//갭 레이블
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
	
	todoB = new JButton(todoImg);
	diaryB = new JButton(diaryImg);
	buttonSet(todoB, "./image/todoButtonClick.png");
	buttonSet(diaryB, "./image/diaryButtonClick.png");
	gap = new JLabel(" ");
	gap.setPreferredSize(new Dimension(100, 10));
	buttonP.add(todoB);
	buttonP.add(diaryB);
	
	//CreateB 생성 버튼
	createB = new JButton(createImg);
	createB.setPreferredSize(new Dimension(40, 40));
	createB.setBackground(Color.white);
	createB.setBorderPainted(false);
	createB.setRolloverIcon(createRolloverImg);
	}

	public void buttonSet(JButton btn, String location) {
		ImageIcon img = new ImageIcon(location);
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		btn.setPreferredSize(new Dimension(250,80));
		btn.setBorderPainted(false);
		btn.setRolloverIcon(img); // 버튼에 마우스가 올라갈때 이미지 변환
	}
	
	//패널 배경 하얗게 해주는 함수
	public void panelWhite(JPanel form){
		form.setBackground(Color.white);
	}
	
	public void diaryMainPanel(JPanel main){
		main.setLayout(new BorderLayout());
		main.setPreferredSize(new Dimension(700,750));
		panelWhite(main);
	}
	
	public JButton getTodoB(){
		return todoB;
	}
	
	public JButton getDiaryB(){
		return diaryB;
	}
}
