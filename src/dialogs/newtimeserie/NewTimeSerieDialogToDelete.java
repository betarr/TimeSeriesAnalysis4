package dialogs.newtimeserie;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialogs.Dialog;

public class NewTimeSerieDialogToDelete extends Dialog {
	
	private JPanel contentPanel;
	
	private JButton fromFunctionButton;
	private JButton fromExistingButton;
	private JButton fromRandomButton;
	
	private int spaceBetweenButtons = 15;
	
	public NewTimeSerieDialogToDelete() {
		super(NewTimeSerieDialogsConfig.DIALOG_LABEL, NewTimeSerieDialogsConfig.DIALOGS_SIZE);
		this.setInnerMargin(25);
	}
	
	@Override
	protected JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		JLabel instructionLabel = new JLabel(NewTimeSerieDialogsConfig.INSTRUCTION);
		labelPanel.add(instructionLabel);
		return labelPanel;
	}

	@Override
	protected JPanel buildContentPanel() {
		this.contentPanel = new JPanel();
		this.contentPanel.setBorder(new EmptyBorder(
				this.spaceBetweenButtons, 
				this.spaceBetweenButtons,
				this.spaceBetweenButtons,
				this.spaceBetweenButtons));
		this.contentPanel.setLayout(new GridLayout(1, 3, this.spaceBetweenButtons, this.spaceBetweenButtons));
		
		this.initButtons();
		return this.contentPanel;
	}
	
	@Override
	protected JPanel buildControlPanel() {
		return null;
	}

	private void initButtons() {
		this.contentPanel.add(this.buildJButton(this.fromFunctionButton, NewTimeSerieDialogsConfig.FROM_FUNCTION_BUTTON_LABEL, null));
		this.contentPanel.add(this.buildJButton(this.fromExistingButton, NewTimeSerieDialogsConfig.FROM_EXISTING_BUTTON_LABEL, null));
		this.contentPanel.add(this.buildJButton(this.fromRandomButton, NewTimeSerieDialogsConfig.FROM_RANDOM_BUTTON_LABEL, null));
	}
}
