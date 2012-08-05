package dialogs.newtimeserie;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class NewTimeSerieDialogPanels {
	
	protected JPanel labelPanel = new JPanel();
	protected JPanel contentPanel = new JPanel();
	protected JPanel controlPanel = new JPanel();

	public JPanel getLabelPanel() {
		return this.labelPanel;
	}
	
	public JPanel getContentPanel() {
		return this.contentPanel;
	}
	
	public JPanel getControlPanel() {
		return this.controlPanel;
	}
	
	protected void setMarginToPanel(JPanel panel, int margin) {
		panel.setBorder(new EmptyBorder(
				margin, 
				margin,
				margin,
				margin));
	}
	
	protected void setMarginToPanel(JPanel panel, int top, int right,
			int bottom, int left) {
		panel.setBorder(new EmptyBorder(top, left, bottom, right));
	}
}
