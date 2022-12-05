package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import db.diaryModel;
import db.lifeDAO;

public class diaryTable  extends JPanel {
	DefaultTableModel model;
	DefaultTableCellRenderer dtcr;
	
	lifeDAO ldao = new lifeDAO();
	JTable table = null;
	
	Font f3 = new Font("KoPub돋움체 medium", Font.PLAIN, 20);
	
	public diaryTable(){
		//테이블 모델 생성
		model = new DefaultTableModel(){
			public Class<?> getColumnClass(int column){
				switch(column){
				case 0: return Integer.class;
				case 1: return String.class;
				case 2: return String.class;
				default: return String.class;
				}
			}
		};
		//컬럼 추가
		model.addColumn("No");
		model.addColumn("제목");
		model.addColumn("날짜");
		
		//테이블 생성
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
	    header.setBackground(Color.black);
	    header.setForeground(Color.white);
	    header.setFont(f3);
		
		//테이블 항목 로드, 0번째, 2번째 열 가운데 정렬 
		diaryTableRead();
		tableCellCenter(table);
		
		//테이블 디자인
		table.setRowHeight(30);
		table.getColumn("No").setPreferredWidth(1);
		table.getColumn("제목").setPreferredWidth(460);
		table.getColumn("날짜").setPreferredWidth(70);
		table.setBackground(Color.white);
		table.setFont(f3);
		table.setPreferredScrollableViewportSize(new Dimension(700, 550));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		//스크롤 생성
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
		JScrollPane js = new JScrollPane(table, v, h);
		add(js);
	}
	
	//테이블 항목 로드 함수
	public void diaryTableRead(){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		
		ArrayList<diaryModel> arr = new ArrayList<diaryModel>();
		arr = ldao.readDiary();
		
		//항목 추가
		for(int i=0; i<=arr.size()-1; i++){
			model.addRow(new Object[0]);
			model.setValueAt((Integer)arr.get(i).getDiary_no(), i, 0);
			model.setValueAt((String)arr.get(i).getTitle(), i, 1);
			model.setValueAt((String)arr.get(i).getDiaryDate(), i, 2);
			model.addRow(new Object[1]);
		}
	}
	
	//지정된 날짜를 가져와서 항목 재로드 함수
	public void diaryTableRead(int year, int month){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		
		ArrayList<diaryModel> arr = new ArrayList<diaryModel>();
		arr = ldao.readDiary(year, month);	
		
		//항목 추가
		for(int i=0; i<=arr.size()-1; i++){
			model.addRow(new Object[0]);
			model.setValueAt((Integer)arr.get(i).getDiary_no(), i, 0);
			model.setValueAt((String)arr.get(i).getTitle(), i, 1);
			model.setValueAt((String)arr.get(i).getDiaryDate(), i, 2);
			model.addRow(new Object[1]);
		}
	}
	
	//0번째, 2번째 열 가운데 정렬 함수
	public void tableCellCenter(JTable t){
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
	}
	
	//diaryTable의 선택한 항목의 값을 가져오는 함수(날짜, 번호)
	public Object diaryDateValue(){
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 2);
		return value;
	}
	
	public Object diaryNoValue(){
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 0);
		return value;
	}
}