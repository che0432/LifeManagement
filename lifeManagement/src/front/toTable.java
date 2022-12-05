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

import db.lifeDAO;
import db.todoModel;

public class toTable  extends JPanel {
	DefaultTableModel model;
	
	lifeDAO ldao = new lifeDAO();
	JTable table = null;
	DefaultTableCellRenderer dtcr;
	
	Font f3 = new Font("KoPub돋움체 medium", Font.PLAIN, 15);
	
	public toTable(){		
		//테이블 모델 생성
		model = new DefaultTableModel(){
			public Class<?> getColumnClass(int column){
				switch(column){
				case 0: return Integer.class;
				case 1: return Boolean.class;
				case 2: return String.class;
				default: return String.class;
				}
			}
		};
		//컬럼 추가
		model.addColumn("No");
		model.addColumn("체크");
		model.addColumn("내용");
				
		//테이블 생성
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
	    header.setBackground(Color.black);
	    header.setForeground(Color.white);
	    header.setFont(f3);
		
		//테이블 항목 로드, 0번째 열 가운데 정렬 
		toTableRead();
		tableCellCenter(table);
		
		//테이블 디자인
		table.setRowHeight(30);
		table.getColumn("No").setPreferredWidth(30);
		table.getColumn("체크").setPreferredWidth(30);
		table.getColumn("내용").setPreferredWidth(300);
		table.setBackground(Color.white);
		table.setFont(f3);
		table.setPreferredScrollableViewportSize(new Dimension(410, 470));
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
	public void toTableRead(){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		try{
			ArrayList<todoModel> arr = new ArrayList<todoModel>();
			arr = ldao.readTo();
			
			//항목 추가
			for(int i=0; i<=arr.size(); i++){
				model.addRow(new Object[i]);
				model.setValueAt((Integer)arr.get(i).getTodo_no(), i, 0);
				model.setValueAt((boolean)arr.get(i).isTodoCheck(), i, 1);
				model.setValueAt((String)arr.get(i).getTodoContents(), i, 2);
				model.addRow(new Object[i+1]);
			}
		}catch(IndexOutOfBoundsException e) {System.out.println(e);}
	}
	
	//지정된 날짜를 가져와서 항목 재로드 함수
	public void toTableRead(String Date){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		try{
			ArrayList<todoModel> arr = new ArrayList<todoModel>();
			arr = ldao.readTo(Date);
			
			//항목 추가
			for(int i=0; i<=arr.size(); i++){
				model.addRow(new Object[0]);
				model.setValueAt((Integer)arr.get(i).getTodo_no(), i, 0);
				model.setValueAt((boolean)arr.get(i).isTodoCheck(), i, 1);
				model.setValueAt((String)arr.get(i).getTodoContents(), i, 2);
				model.addRow(new Object[1]);
			}
		}catch(IndexOutOfBoundsException e) {System.out.println(e);}
	}
	
	//0번째 열 가운데 정렬 함수
	public void tableCellCenter(JTable t){
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();
		tcm.getColumn(0).setCellRenderer(dtcr);
	}
	
	//toTable의 선택한 항목의 값을 가져오는 함수(번호, 완료 상태, 내용)
	public Object todoNoValue(){
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 0);
		return value;
	}
	
	public Object todoCheckValue(){
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 1);
		return value;
	}
	
	public Object todoContentsValue(){
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 2);
		return value;
	}
}