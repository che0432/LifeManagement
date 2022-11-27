package front;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import db.lifeDAO;
import db.todoModel;

public class doTable  extends JPanel {
	DefaultTableModel model;
	
	lifeDAO ldao = new lifeDAO();
	JTable table = null;
	
	public doTable(){
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
		table = new JTable(model);
		
		//�÷��־��ֱ�
		model.addColumn("No");
		model.addColumn("Check");
		model.addColumn("Do");
		
		doTableRead();
		
		table.getColumn("No").setPreferredWidth(1);
		table.getColumn("Check").setPreferredWidth(20);
		table.getColumn("Do").setPreferredWidth(320);
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
	
	public void doTableRead(){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		
		ArrayList<todoModel> arr = new ArrayList<todoModel>();
		arr = ldao.readTodo();
		
		//목록 조회
		for(int i=0; i<=arr.size()-1; i++){
			if((boolean)arr.get(i).isTodoCheck() == true){
				model.addRow(new Object[0]);
				model.setValueAt((Integer)arr.get(i).getTodo_no(), i, 0);
				model.setValueAt((boolean)arr.get(i).isTodoCheck(), i, 1);
				model.setValueAt((String)arr.get(i).getTodoContents(), i, 2);
				model.addRow(new Object[1]);
			}
		}
	}
	
	public void doTableRead(String Date){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		
		ArrayList<todoModel> arr = new ArrayList<todoModel>();
		arr = ldao.readTodo(Date);
		System.out.println("doTableRead내부"+Date);
		
		//목록 조회
		for(int i=0; i<=arr.size()-1; i++){
			if((boolean)arr.get(i).isTodoCheck() == true){
				model.addRow(new Object[0]);
				model.setValueAt((Integer)arr.get(i).getTodo_no(), i, 0);
				model.setValueAt((boolean)arr.get(i).isTodoCheck(), i, 1);
				model.setValueAt((String)arr.get(i).getTodoContents(), i, 2);
				model.addRow(new Object[1]);
			}
		}
	}
	
	public int todoNoValue(){
		int row = table.getSelectedRow();
		int value = (int) table.getValueAt(row, 0);
		return value;
	}
	
	public Object todoCheckValue(){
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 2);
		return value;
	}
	
	public Object todoContentsValue(){
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 2);
		return value;
	}
}