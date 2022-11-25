package front;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class doTable  extends JPanel {
	DefaultTableModel model;
	
	public doTable(){
		JTable table = null;
		String[] title = {"Check", "Done"};
		String[][] data = {
				{"true", "������"},
				{"true", "��Ʈ��Ī"},
				{"true", "��Ʈ��Ī"}
		};
		
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		table.getColumn("Check").setPreferredWidth(10);
		table.getColumn("Done").setPreferredWidth(350);
		table.setBackground(Color.white);
		table.setPreferredScrollableViewportSize(new Dimension(410, 650));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
		JScrollPane js = new JScrollPane(table, v, h);
		add(js);
	}
}