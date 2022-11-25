package front;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class toTable  extends JPanel {
	DefaultTableModel model;
	
	public toTable(){
		JTable table = null;

		//�� �����ֱ�
		model = new DefaultTableModel(){
			public Class<?> getColumnClass(int column){
				switch(column){
				case 0: return Boolean.class;
				case 1: return String.class;
				default: return String.class;
				}
			}
		};
		table = new JTable(model);
		
		//�÷��־��ֱ�
		model.addColumn("Check");
		model.addColumn("Do");
		
		//�� �־��ֱ�
		for(int i=0; i<=7; i++){
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt("������Ʈ �ϼ�", i, 1);
			model.addRow(new Object[1]);
		}
		
		table.getColumn("Check").setPreferredWidth(10);
		table.getColumn("Do").setPreferredWidth(350);
		table.setBackground(Color.white);
		table.setPreferredScrollableViewportSize(new Dimension(410, 470));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
		JScrollPane js = new JScrollPane(table, v, h);
		add(js);
	}
}