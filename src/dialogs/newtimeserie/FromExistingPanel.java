package dialogs.newtimeserie;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dialogs.DialogsConfig;

public class FromExistingPanel extends NewTimeSerieDialogPanels {
private NewTimeSerieDialog parent;
	
	private int spaceBetweenFields = 10;
	
	private JTextField timeSerieNameTextField = new JTextField();
	private JPanel timeSerieColorPanel;
	private JButton timeSerieColorButton;
	private Color timeSerieColor = NewTimeSerieDialogConfig.TIME_SERIE_DEFAULT_COLOR;
	
	public FromExistingPanel(NewTimeSerieDialog parent) {
		this.parent = parent;
		this.labelPanel = this.buildLabelPanel();
		this.contentPanel = this.buildContentPanel();
		this.controlPanel = this.buildControlPanel();
	}
	
	private JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		labelPanel.add(new JLabel(NewTimeSerieDialogConfig.FROM_EXISTING_LABEL));
		return labelPanel;
	}
	
	private JPanel buildContentPanel() {
		final JPanel contentPanel = new JPanel();
		this.setMarginToPanel(contentPanel, this.spaceBetweenFields);
		contentPanel.setLayout(new GridLayout(2, 2, this.spaceBetweenFields, this.spaceBetweenFields));
		
		contentPanel.add(new JLabel(NewTimeSerieDialogConfig.EXISTING_NAME_LABEL));
		contentPanel.add(this.timeSerieNameTextField);
		
		contentPanel.add(new JLabel(
				NewTimeSerieDialogConfig.EXISTING_COLOR_LABEL));
		this.timeSerieColorPanel = new JPanel();
		this.timeSerieColorPanel.setBackground(NewTimeSerieDialogConfig.TIME_SERIE_DEFAULT_COLOR);
		this.timeSerieColorButton = new JButton(NewTimeSerieDialogConfig.COLOR_CHOOSER_BUTTON_LABEL);
		this.timeSerieColorButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color color = JColorChooser.showDialog(contentPanel,
						NewTimeSerieDialogConfig.COLOR_CHOOSER_DIALOG_LABEL,
						NewTimeSerieDialogConfig.TIME_SERIE_DEFAULT_COLOR);
				if (color != null) {
					timeSerieColorPanel.setBackground(color);
					timeSerieColor = color;
				}
			}
		});
		JPanel colorChoosePanel = new JPanel();
		colorChoosePanel.add(this.timeSerieColorPanel);
		colorChoosePanel.add(this.timeSerieColorButton);
		contentPanel.add(colorChoosePanel);
		
		return contentPanel;
	}
	
	private JPanel buildControlPanel() {
		JPanel controlPanel = new JPanel();
		this.setMarginToPanel(controlPanel, 0, 10, 0, 0);
		controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton backButton = new JButton(DialogsConfig.BUTTON_LABEL_BACK);
		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.swapToChooseTypePanel();
			}
		});
		controlPanel.add(backButton);
		
		JButton finishButton = new JButton(DialogsConfig.BUTTON_LABEL_FINISH);
		finishButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
//				if (isFormValid()) {
//					FromFunctionConfig config = new FromFunctionConfig();
//					config.setTimeSerieName(timeSerieNameTextField.getText());
//					config.setGenerateFunction((GenerateFunction)functionComboBox.getSelectedItem());
//					config.setColor(timeSerieColor);
//					config.setStartX(Double.valueOf(startXTextField.getText()));
//					config.setEndX(Double.valueOf(endXTextField.getText()));
//					config.setIterationStep(Double.valueOf(iterationStepTextField.getText()));
//					config.setUseNoise(useNoiseCheckBox.isSelected());
//					if (useNoiseCheckBox.isSelected()) {
//						config.setNoise(Double.valueOf(noiseTextField.getText()));
//					}
//					ControllerService.getGraphController().addTimeSerieFromFunction(config);
//					parent.dispose();
//				}
			}
		});
		controlPanel.add(finishButton);
		
		JButton cancelButton = new JButton(DialogsConfig.BUTTON_LABEL_CANCEL);
		cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				parent.cancelDialog();
			}
		});
		controlPanel.add(cancelButton);
		
		return controlPanel;
	}
}
