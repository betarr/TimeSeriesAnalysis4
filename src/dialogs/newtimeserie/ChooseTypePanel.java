package dialogs.newtimeserie;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dialogs.DialogsConfig;

public class ChooseTypePanel extends NewTimeSerieDialogPanels {
	private static final long serialVersionUID = 1L;
	
	private NewTimeSerieDialog parent;
	
	private int spaceBetweenButtons = 15;
	
	public ChooseTypePanel(NewTimeSerieDialog parent) {
		this.parent = parent;
		this.labelPanel = this.buildLabelPanel();
		this.contentPanel = this.buildContentPanel();
		this.controlPanel = this.buildControlPanel();
	}

	private JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		this.setMarginToPanel(labelPanel, this.spaceBetweenButtons);
		labelPanel.setLayout(new FlowLayout());
		labelPanel.add(new JLabel("choose.... "));
		return labelPanel;
	}

	private JPanel buildContentPanel() {
		JPanel contentPanel = new JPanel();
		this.setMarginToPanel(contentPanel, this.spaceBetweenButtons);
		contentPanel.setLayout(new GridLayout(1, 3, this.spaceBetweenButtons, this.spaceBetweenButtons));
		
		JButton fromFunctionButton = new JButton(NewTimeSerieDialogsConfig.FROM_FUNCTION_BUTTON_LABEL);
		fromFunctionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.swatToFromFunctionPanel();
			}
		});
		contentPanel.add(fromFunctionButton);
		
		JButton fromExistingButton = new JButton(NewTimeSerieDialogsConfig.FROM_EXISTING_BUTTON_LABEL);
		fromExistingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				System.out.println("From Existing button pressed");
			}
		});
		contentPanel.add(fromExistingButton);
		
		JButton fromRandomButton = new JButton(NewTimeSerieDialogsConfig.FROM_RANDOM_BUTTON_LABEL);
		fromRandomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.swapToFromRandomPanel();
			}
		});
		contentPanel.add(fromRandomButton);
		
		JButton fromFileButton = new JButton(NewTimeSerieDialogsConfig.FROM_FILE_BUTTON_LABEL);
		fromFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.swapToFromFilePanel();
			}
		});
		contentPanel.add(fromFileButton);
		
		return contentPanel;
	}
	
	private JPanel buildControlPanel() {
		JPanel controlPanel = new JPanel();
		this.setMarginToPanel(controlPanel, 0, 10, 0, 0);
		controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton cancelButton = new JButton(DialogsConfig.BUTTON_LABEL_CANCEL);
		cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.cancelDialog();
			}
		});
		controlPanel.add(cancelButton);
		return controlPanel;
	}
}
