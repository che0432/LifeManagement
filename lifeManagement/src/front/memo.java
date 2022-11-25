package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class memo extends JFrame implements ActionListener {
	JTextArea memo;
	String msg;
	JButton memoB;
	boolean memoVisible;

	Color memoColor = new Color(255,250,176);
	Color memoFontColor = new Color(192,109,21);
	Font mf = new Font("KoPub돋움체 medium", Font.PLAIN, 20);
	
	public memo(){
		super("메모장");
		memoVisible = isVisible();
		
		Container c = getContentPane();
		c.setBackground(Color.white);
        c.setLayout(new BorderLayout());
        c.add(new CenterPanel(),BorderLayout.CENTER);
        c.add(new SouthPanel(),BorderLayout.SOUTH);
        
		memoB.addActionListener(this);

		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.white);
	}
	
	class CenterPanel extends JPanel {
        public CenterPanel() {
            setLayout(new BorderLayout());
            JTextArea memo = new JTextArea();
            memo.setFont(mf);
    		memo.setForeground(memoFontColor);
    		memo.setBackground(memoColor);
    		memo.setLineWrap(true);
            JScrollPane sp = new JScrollPane(memo);
            add(sp, BorderLayout.CENTER);
        }
    }
	
	class SouthPanel extends JPanel {
        public SouthPanel() {
        	memoB = new JButton("저장");
        	setBackground(Color.white);
            add(memoB);
        }
    }

	
	public static void main(String[] args) {
		new memo();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼 눌렀을 시 JSON 파일로 저장 되도록
	}

	public boolean isMemoVisible() {
		return memoVisible;
	}
	
}
