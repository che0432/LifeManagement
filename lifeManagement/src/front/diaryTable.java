package front;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import db.diaryModel;
import db.lifeDAO;

	public class diaryTable  extends JPanel {
		DefaultTableModel model;
		
		lifeDAO ldao = new lifeDAO();
		JTable table = null;
		
		public diaryTable(){
			//모델 정해주기
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
			//컬럼넣어주기
			model.addColumn("No");
			model.addColumn("제목");
			model.addColumn("날짜");
			
			table = new JTable(model);
			
			diaryTableRead();
			
			table.getColumn("No").setPreferredWidth(10);
			table.getColumn("제목").setPreferredWidth(500);
			table.getColumn("날짜").setPreferredWidth(10);
			table.setBackground(Color.white);
			table.setPreferredScrollableViewportSize(new Dimension(700, 550));
			table.setFillsViewportHeight(true);
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);
			
			int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
			JScrollPane js = new JScrollPane(table, v, h);
			add(js);
		}
		
		public void diaryTableRead(){
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			
			ArrayList<diaryModel> arr = new ArrayList<diaryModel>();
			arr = ldao.readDiary();
			
			//값 넣어주기
			for(int i=0; i<=arr.size()-1; i++){
				model.addRow(new Object[0]);
				model.setValueAt((Integer)arr.get(i).getDiary_no(), i, 0);
				model.setValueAt((String)arr.get(i).getTitle(), i, 1);
				model.setValueAt((String)arr.get(i).getDiaryDate(), i, 2);
				model.addRow(new Object[1]);
			}
		}
		
		public void diaryTableRead(int year, int month){
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			
			ArrayList<diaryModel> arr = new ArrayList<diaryModel>();
			arr = ldao.readDiary(year, month);	
			
			//값 넣어주기
			for(int i=0; i<=arr.size()-1; i++){
				model.addRow(new Object[0]);
				model.setValueAt((Integer)arr.get(i).getDiary_no(), i, 0);
				model.setValueAt((String)arr.get(i).getTitle(), i, 1);
				model.setValueAt((String)arr.get(i).getDiaryDate(), i, 2);
				model.addRow(new Object[1]);
			}
		}
		
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
