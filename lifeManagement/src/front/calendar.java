package front;

import java.awt.BorderLayout;
import java.awt.Color;
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
    
    @SuppressWarnings("deprecation")
	public calendar()
    {
    	form = new JPanel();
        p1 = new JPanel();
        p1.setBackground(Color.white);
        
        month = new JComboBox();
        for(int i=0;i< months.length;i++)
        {
            month.addItem(months[i]);
        }
        month.addItemListener(this);
        year = new JComboBox();
        for(int i=1980;i<=2099;i++)
        {
            year.addItem(i);
        }
        year.addItemListener(this);
        yearL = new JLabel("년");
        monthL = new JLabel("월");
        p1.add(year);
        p1.add(yearL);
        p1.add(month);
        p1.add(monthL);
        p2 = new JPanel();
        p2.setLayout(new GridLayout(0,7,5,5));
        p2.setBackground(Color.white);
        Date date = new Date();

        drawCalendar(date.getMonth(), (1900+date.getYear()));

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
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            drawCalendar((Integer)month.getSelectedItem(), (Integer)year.getSelectedItem());
        }
    }
    
    public void drawCalendar(int inputMonth, int inputYear)
    {	
    	String Month = null;
        p2.removeAll();
        for(int i=0;i< weekdays.length;i++){
            JLabel label = new JLabel(weekdays[i]);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            p2.add(label);
        }
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
            for(int j=0;j<7;j++){
                if(day==1){
                    if(j==date.getDay()){
                    	JLabel label = new JLabel(String.valueOf(day));
                    	System.out.println(label.getText().equals(LocalDate.now()));
                    	boolean isToday = (inputYear+"-"+inputMonth+"-"+label.getText()).equals(today);
                        if(isToday)
                    		label.setForeground(Color.blue);
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                        p2.add(label);
                        day++;
                    }else {
                    	JLabel label = new JLabel("");
                        p2.add(label);
                    }
                }else {	
                	JLabel label = new JLabel(String.valueOf(day));
                	boolean isToday = (inputYear+"-"+inputMonth+"-"+label.getText()).equals(today);
                    if(isToday)
                		label.setForeground(Color.blue);
                    label.setHorizontalAlignment(SwingConstants.RIGHT);
                    p2.add(label);
                    day++;
                }
                if(day>noOfDaysInMonth){
                    break;
                }
            }
        }
        
        p2.validate();
    }
}
