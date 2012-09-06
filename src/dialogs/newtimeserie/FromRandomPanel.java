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

import controllers.ControllerService;

import utils.Validation;

import dialogs.DialogsConfig;

public class FromRandomPanel extends NewTimeSerieDialogPanels {
	private static final long serialVersionUID = 1L;
	
	private NewTimeSerieDialog parent;
	
	private int spaceBetweenFields = 10;
	
	private JTextField timeSerieNameTextField = new JTextField();
	private JPanel timeSerieColorPanel;
	private JButton timeSerieColorButton;
	private Color timeSerieColor = NewTimeSerieDialogsConfig.TIME_SERIE_DEFAULT_COLOR;
	private JTextField startXTextField = new JTextField();
	private JTextField endXTextField = new JTextField();
	private JTextField minYTextField = new JTextField();
	private JTextField maxYTextField = new JTextField();
	private JTextField iterationStepTextField = new JTextField();
	
	public FromRandomPanel(NewTimeSerieDialog parent) {
		this.parent = parent;
		this.labelPanel = this.buildLabelPanel();
		this.contentPanel = this.buildContentPanel();
		this.controlPanel = this.buildControlPanel();
	}
	
	private JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		labelPanel.add(new JLabel(NewTimeSerieDialogsConfig.FROM_RANDOM_LABEL));
		return labelPanel;
	}

	private JPanel buildContentPanel() {
		final JPanel contentPanel = new JPanel();
		this.setMarginToPanel(contentPanel, this.spaceBetweenFields);
		contentPanel.setLayout(new GridLayout(7, 2, this.spaceBetweenFields, this.spaceBetweenFields));
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_NAME_LABEL));
		contentPanel.add(this.timeSerieNameTextField);
		
		contentPanel.add(new JLabel(
				NewTimeSerieDialogsConfig.RANDOM_COLOR_LABEL));
		this.timeSerieColorPanel = new JPanel();
		this.timeSerieColorPanel.setBackground(NewTimeSerieDialogsConfig.TIME_SERIE_DEFAULT_COLOR);
		this.timeSerieColorButton = new JButton(NewTimeSerieDialogsConfig.COLOR_CHOOSER_BUTTON_LABEL);
		this.timeSerieColorButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color color = JColorChooser.showDialog(contentPanel,
						NewTimeSerieDialogsConfig.COLOR_CHOOSER_DIALOG_LABEL,
						NewTimeSerieDialogsConfig.TIME_SERIE_DEFAULT_COLOR);
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
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_START_X_LABEL));
		contentPanel.add(this.startXTextField);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_END_X_LABEL));
		contentPanel.add(this.endXTextField);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_MIN_Y_LABEL));
		contentPanel.add(this.minYTextField);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_MAX_Y_LABEL));
		contentPanel.add(this.maxYTextField);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_ITERATION_STEP_LABEL));
		contentPanel.add(this.iterationStepTextField);
		
		this.rightBorder = this.timeSerieNameTextField.getBorder();
		return contentPanel;
	}

	private JPanel buildControlPanel() {
		JPanel controlPanel = new JPanel();
		this.setMarginToPanel(controlPanel, 0, this.spaceBetweenFields, 0, 0);
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
			public void actionPerformed(ActionEvent arg0) {
				if (isFormValid()) {
					FromRandomConfig config = new FromRandomConfig();
					config.setTimeSerieName(timeSerieNameTextField.getText());
					config.setColor(timeSerieColor);
					config.setStartX(Double.valueOf(startXTextField.getText()));
					config.setEndX(Double.valueOf(endXTextField.getText()));
					config.setMinY(Double.valueOf(minYTextField.getText()));
					config.setMaxY(Double.valueOf(maxYTextField.getText()));
					config.setIterationStep(Double.valueOf(iterationStepTextField.getText()));
					ControllerService.getGraphController().addTimeSerieFromRandom(config);
					parent.dispose();
				}
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
	
	private boolean isFormValid() {
		boolean isValid = true;
		
		if (!Validation
				.isStringNotEmpty(this.timeSerieNameTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.timeSerieNameTextField);
		} else {
			this.markJTextFieldAsValid(this.timeSerieNameTextField);
		}
		
		if (!Validation.isValidDouble(this.startXTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.startXTextField);
		} else {
			this.markJTextFieldAsValid(this.startXTextField);
		}
		
		if (!Validation.isValidDouble(this.endXTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.endXTextField);
		} else {
			this.markJTextFieldAsValid(this.endXTextField);
		}
		
		if (!Validation.isValidDouble(this.minYTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.minYTextField);
		} else {
			this.markJTextFieldAsValid(this.minYTextField);
		}
		
		if (!Validation.isValidDouble(this.maxYTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.maxYTextField);
		} else {
			this.markJTextFieldAsValid(this.maxYTextField);
		}
		
		if (!Validation.isValidDouble(this.iterationStepTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.iterationStepTextField);
		} else {
			this.markJTextFieldAsValid(this.iterationStepTextField);
		}
		return isValid;
	}
}
