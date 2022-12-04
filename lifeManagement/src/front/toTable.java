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
		JTableHeader header = table.getTableHeader();
	    header.setBackground(Color.black);
	    header.setForeground(Color.white);
	    header.setFont(f3);
		
		//�÷��־��ֱ�
		model.addColumn("No");
		model.addColumn("체크");
		model.addColumn("내용");
		
		toTableRead();
		tableCellCenter(table);
		
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
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
		JScrollPane js = new JScrollPane(table, v, h);
		add(js);
	}
	
	public void toTableRead(){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		try{
			ArrayList<todoModel> arr = new ArrayList<todoModel>();
			arr = ldao.readTo();
			
			//목록 조회
			for(int i=0; i<=arr.size(); i++){
				System.out.println(arr.size());
				model.addRow(new Object[i]);
				model.setValueAt((Integer)arr.get(i).getTodo_no(), i, 0);
				model.setValueAt((boolean)arr.get(i).isTodoCheck(), i, 1);
				model.setValueAt((String)arr.get(i).getTodoContents(), i, 2);
				model.addRow(new Object[i+1]);
			}
		}catch(IndexOutOfBoundsException e) {System.out.println(e);}
	}
	
	public void toTableRead(String Date){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		try{
			ArrayList<todoModel> arr = new ArrayList<todoModel>();
			arr = ldao.readTo(Date);
			
			//목록 조회
			for(int i=0; i<=arr.size(); i++){
				model.addRow(new Object[0]);
				model.setValueAt((Integer)arr.get(i).getTodo_no(), i, 0);
				model.setValueAt((boolean)arr.get(i).isTodoCheck(), i, 1);
				model.setValueAt((String)arr.get(i).getTodoContents(), i, 2);
				model.addRow(new Object[1]);
			}
		}catch(IndexOutOfBoundsException e) {System.out.println(e);}
	}
	
	public void tableCellCenter(JTable t){
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();
		tcm.getColumn(0).setCellRenderer(dtcr);
	}
	
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