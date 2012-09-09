package dialogs.deletetimeserie;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class ListPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<String> names;
	private String label;
	
	private DefaultListModel<String> listModel;
	private JList<String> namesListBox;
	
	private int innerMargin = 10;

	public ListPanel(List<String> names, String label) {
		this.names = names;
		this.label = label;
		this.buildPanel();
	}

	private void buildPanel() {
		this.setBorder(new EmptyBorder(this.innerMargin,
				this.innerMargin, this.innerMargin, this.innerMargin));
		
		this.setLayout(new BorderLayout());
		if (label != null && !label.isEmpty()) {
			JPanel labelPanel = new JPanel();
			labelPanel.setLayout(new FlowLayout());
			labelPanel.add(new JLabel(label));
			this.add(labelPanel, BorderLayout.NORTH);
		}
		this.listModel = new DefaultListModel<String>();
		this.addNamesToList(this.names);
		
		this.namesListBox = new JList<String>(this.listModel);
		this.namesListBox.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.namesListBox.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane listScroller = new JScrollPane(this.namesListBox);
		listScroller.setPreferredSize(new Dimension(200, 200));
		this.add(listScroller, BorderLayout.CENTER);
		
	}
	
	public List<String> popSelectedNames() {
		List<String> result = this.namesListBox.getSelectedValuesList();
		for (String name : result) {
			this.listModel.removeElement(name);
		}
		return result;
	}
	
	public void addNamesToList(List<String> names) {
		if (names != null) {
			List<String> elements = this.getNames();
			elements.addAll(names);
			this.listModel.clear();
			Collections.sort(elements);
			for (String name : elements) {
				this.listModel.add(this.listModel.getSize(), name);
			}
		}
	}
	
	public List<String> getNames() {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < this.listModel.getSize(); i++) {
			result.add(this.namesListBox.getModel().getElementAt(i));
		}
		return (result == null) ? new ArrayList<String>(0) : result;
	}
	
	
}
