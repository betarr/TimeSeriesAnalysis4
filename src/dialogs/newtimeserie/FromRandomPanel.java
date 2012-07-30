package dialogs.newtimeserie;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FromRandomPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private NewTimeSerieDialog parent;
	
	private JPanel labelPanel;
	private JPanel contentPanel;
	private JPanel controlPanel;
	
	public FromRandomPanel(NewTimeSerieDialog parent) {
		this.parent = parent;
		this.labelPanel = this.buildLabelPanel();
		this.contentPanel = this.buildContentPanel();
		this.controlPanel = this.buildControlPanel();
		
		this.setLayout(new BorderLayout());
		this.add(this.labelPanel, BorderLayout.NORTH);
		this.add(this.contentPanel, BorderLayout.CENTER);
		this.add(this.controlPanel, BorderLayout.SOUTH);
	}
	
	private JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		labelPanel.add(new JLabel("from random label"));
		return labelPanel;
	}

	private JPanel buildContentPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(new JLabel("from random content"));
		return contentPanel;
	}

	private JPanel buildControlPanel() {
		JPanel control = new JPanel();
		control.setLayout(new FlowLayout());
		control.add(new JLabel("from random control"));
		return control;
	}
}
