package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class calendar extends JPanel implements ItemListener {
	JPanel p1, p2, form;
	JLabel yearL, monthL;
    JComboBox month;
    JComboBox year;
    int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    int months[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    
    Font f4 = new Font("KoPub돋움체 Medium", Font.PLAIN, 25);
    
    @SuppressWarnings("deprecation")
	public calendar()
    {
    	form = new JPanel();
        p1 = new JPanel();
        p1.setBackground(Color.white);
        
        //month 선택할 콤보박스 및 아이템 리스너 선언
        month = new JComboBox();
        for(int i=0;i< months.length;i++)
        {
            month.addItem(months[i]);
        }
        month.setFont(f4);
		month.setBackground(Color.white);
        month.addItemListener(this);
        //year 선택할 콤보박스 및 아이템 리스너 선언
        year = new JComboBox();
        for(int i=1980;i<=2099;i++)
        {
            year.addItem(i);
        }
        year.setFont(f4);
        year.setBackground(Color.white);
        year.addItemListener(this);
        
        //레이블 추가
        yearL = new JLabel("년 ");
        monthL = new JLabel("월");
        yearL.setFont(f4);
        monthL.setFont(f4);
        
        //상단 패널에 추가
        p1.add(year);
        p1.add(yearL);
        p1.add(month);
        p1.add(monthL);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(0,7,5,5));
        p2.setBackground(Color.white);
        Date date = new Date();
        
        //달력 그리기
        drawCalendar(date.getMonth(), (1900+date.getYear()));
        
        //실행했을 때 콤보박스 아이템 세팅
        year.setSelectedItem((1900+date.getYear()));
        month.setSelectedItem(months[date.getMonth()]);
        
        form.setLayout(new BorderLayout());
        form.add(p1, "North");
        form.add(p2, "Center");
        form.setBackground(Color.white);
    }
    @Override
    public void itemStateChanged(ItemEvent e)
    {	
    	//아이템을 선택하면 다시 캘린더 그리기
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            drawCalendar((Integer)month.getSelectedItem(), (Integer)year.getSelectedItem());
        }
    }
    
    //달력 그리는 함수
    public void drawCalendar(int inputMonth, int inputYear)
    {	
    	String Month = null;
        p2.removeAll();
        for(int i=0;i< weekdays.length;i++){
            JLabel label = new JLabel(weekdays[i]);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            p2.add(label);
        }
        //숫자로 선택한 날짜를 Date형에 맞게 변경
        for(int i=0; i<months.length; i++){
        	if(inputMonth==1)
        		Month = "January";
        	else if(inputMonth==2)
        		Month = "February";
        	else if(inputMonth==3)
        		Month = "March";
        	else if(inputMonth==4)
        		Month = "April";
        	else if(inputMonth==5)
        		Month = "May";
        	else if(inputMonth==6)
        		Month = "June";
        	else if(inputMonth==7)
        		Month = "July";
        	else if(inputMonth==8)
        		Month = "August";
        	else if(inputMonth==9)
        		Month = "September";
        	else if(inputMonth==10)
        		Month = "October";
        	else if(inputMonth==11)
        		Month = "November";
        	else if(inputMonth==12)
        		Month = "December";
        }
        
        Date date = new Date("01-"+Month+"-"+inputYear);
        int noOfDaysInMonth = days[date.getMonth()];
        if(date.getYear()%4==0 && date.getMonth()==1)
        {
            noOfDaysInMonth = 29;
        }

        for(int i=1, day=1;day<=noOfDaysInMonth;i++){
        	String today = LocalDate.now().toString();
        	JLabel label;
        	boolean isToday;
            for(int j=0;j<7;j++){
                if(day==1){
                    if(j==date.getDay()){
                    	label = new JLabel(String.valueOf(day));
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                        p2.add(label);
                        day++;
                    }else {
                    	label = new JLabel("");
                        p2.add(label);
                    }
                }else {	
                	label = new JLabel(String.valueOf(day));
                    label.setHorizontalAlignment(SwingConstants.RIGHT);
                    p2.add(label);
                    day++;
                }
                if(day>noOfDaysInMonth){
                    break;
                }
                String equalDay = label.getText();
                if(equalDay!=null&&equalDay!="") {
                    int a = Integer.parseInt(equalDay);
                    if(a<10)
                    	equalDay = "0" + a;
                }
                //현재 날짜인지 비교해보고, 현재 날짜와 같으면 빨간색으로 표시
                isToday = (inputYear+"-"+inputMonth+"-"+equalDay).equals(today);
                if(isToday)
            		label.setForeground(Color.red);
            }
        }
        p2.validate();
    }
}