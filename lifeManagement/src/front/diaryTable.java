package front;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

	public class diaryTable  extends JPanel {
		DefaultTableModel model;
		
		public diaryTable(){
			JTable table = null;

			//모델 정해주기
			model = new DefaultTableModel(){
				public Class<?> getColumnClass(int column){
					switch(column){
					case 0: return String.class;
					case 1: return String.class;
					default: return String.class;
					}
				}
			};
			table = new JTable(model);
			
			//컬럼넣어주기
			model.addColumn("제목");
			model.addColumn("날짜");
			
			//값 넣어주기
			for(int i=0; i<=7; i++){
				model.addRow(new Object[0]);
				model.setValueAt("일기 제목", i, 0);
				model.setValueAt("2022-11-11", i, 1);
			}
			
			table.getColumn("제목").setPreferredWidth(500);
			table.getColumn("날짜").setPreferredWidth(10);
			table.setBackground(Color.white);
			table.setPreferredScrollableViewportSize(new Dimension(800, 600));
			table.setFillsViewportHeight(true);
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);
			
			int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
			JScrollPane js = new JScrollPane(table, v, h);
			add(js);
		}
}