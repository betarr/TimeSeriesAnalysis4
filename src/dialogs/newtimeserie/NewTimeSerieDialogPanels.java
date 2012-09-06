package dialogs.newtimeserie;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public abstract class NewTimeSerieDialogPanels {
	
	protected JPanel labelPanel = new JPanel();
	protected JPanel contentPanel = new JPanel();
	protected JPanel controlPanel = new JPanel();
	
	Border rightBorder = null;
	Border wrongBorder = BorderFactory
			.createLineBorder(NewTimeSerieDialogsConfig.WRONG_FIELD_VALUE_COLOR);

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
	
	protected void markJTextFieldAsInvalid(JTextField textField) {
		textField.setBorder(wrongBorder);
	}
	
	protected void markJTextFieldAsValid(JTextField textField) {
		textField.setBorder(rightBorder);
	}
}
