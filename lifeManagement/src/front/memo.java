package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class memo extends JFrame implements ActionListener {
	JTextArea memo;
	String msg;
	JButton memoB;
	boolean memoVisible;
	
	//메모 색깔, 폰트
	Color memoColor = new Color(255,250,176);
	Color memoFontColor = new Color(192,109,21);
	Font mf = new Font("KoPub돋움체 medium", Font.PLAIN, 20);
	
	public memo() {
		super("메모장");
		
		//Visible 상태 변수
		memoVisible = isVisible();
		
		//컨테이너 입력 패널(CenterPanel), 저장 패널(SouthPanel) 추가
		Container c = getContentPane();
		c.setBackground(Color.white);
        c.setLayout(new BorderLayout());
        c.add(new CenterPanel(),BorderLayout.CENTER);
        c.add(new SouthPanel(),BorderLayout.SOUTH);
        
        //저장 버튼 액션 리스너 선언
		memoB.addActionListener(this);

		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.white);
	}
	
	//입력 패널 함수
	class CenterPanel extends JPanel {
        public CenterPanel() {
            setLayout(new BorderLayout());
            memo = new JTextArea();
            memo.setFont(mf);
    		memo.setForeground(memoFontColor);
    		memo.setBackground(memoColor);
    		memo.setLineWrap(true);
            JScrollPane sp = new JScrollPane(memo);
            add(sp, BorderLayout.CENTER);
            
            //memo.txt 파일 읽기
    		BufferedOutputStream bs = null;
    		String fileName = "memo.txt";
    		
    		try {
    		       /// 바이트 단위로 파일읽기
    		        String filePath = fileName; // 대상 파일
    		        FileInputStream fileStream = null; // 파일 스트림
    		        
    		        fileStream = new FileInputStream( filePath );// 파일 스트림 생성
    		        //버퍼 선언
    		        byte[ ] readBuffer = new byte[fileStream.available()];
    		        while (fileStream.read( readBuffer ) != -1){}

    		        String rs = new String(readBuffer); //출력
    		        memo.setText(rs);

    		        fileStream.close(); //스트림 닫기S
    		 } catch (Exception e) {
    			e.getStackTrace();
    		 }
        }
    }
	
	//저장 버튼 패널 함수
	class SouthPanel extends JPanel {
        public SouthPanel() {
        	setBackground(Color.white);
        	memoB = new JButton("저장");
        	memoB.setBackground(Color.black);
        	memoB.setForeground(Color.white);
        	memoB.setPreferredSize(new Dimension(150, 40));
        	memoB.setFont(mf);
            add(memoB);
        }
    }

	//memo 실행
	public static void main(String[] args) throws IOException {
		new memo();
	}
	
	//저장 버튼 클릭 시 memo.txt 파일 쓰기 함수
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== memoB) {
			File file = new File("memo.txt");
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				
				writer.write(memo.getText());
				System.out.println("메모 저장 성공");
				writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//메모 Visible 상태 반환
	public boolean isMemoVisible() {
		return memoVisible;
	}
	
	//메모 내용 getter
	public String getMemo() {
		return memo.getText();
	}
}