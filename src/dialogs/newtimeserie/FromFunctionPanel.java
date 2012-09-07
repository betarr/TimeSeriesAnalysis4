package dialogs.newtimeserie;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Validation;
import controllers.ControllerService;
import dialogs.DialogsConfig;
import enums.GenerateFunction;

public class FromFunctionPanel extends NewTimeSerieDialogPanels {
	private NewTimeSerieDialog parent;
	
	private int spaceBetweenFields = 10;
	
	private JTextField timeSerieNameTextField = new JTextField();
	private JPanel timeSerieColorPanel;
	private JButton timeSerieColorButton;
	private Color timeSerieColor = NewTimeSerieDialogsConfig.TIME_SERIE_DEFAULT_COLOR;
	private JComboBox<GenerateFunction> functionComboBox;
	private JTextField startXTextField = new JTextField();
	private JTextField endXTextField = new JTextField();
	private JTextField iterationStepTextField = new JTextField();
	private JCheckBox useNoiseCheckBox = new JCheckBox();
	private JTextField noiseTextField = new JTextField();

	public FromFunctionPanel(NewTimeSerieDialog parent) {
		this.parent = parent;
		this.labelPanel = this.buildLabelPanel();
		this.contentPanel = this.buildContentPanel();
		this.controlPanel = this.buildControlPanel();
	}

	private JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		labelPanel.add(new JLabel(NewTimeSerieDialogsConfig.FROM_FUNCTION_LABEL));
		return labelPanel;
	}

	private JPanel buildContentPanel() {
		final JPanel contentPanel = new JPanel();
		this.setMarginToPanel(contentPanel, this.spaceBetweenFields);
		contentPanel.setLayout(new GridLayout(8, 2, this.spaceBetweenFields, this.spaceBetweenFields));
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_NAME_LABEL));
		contentPanel.add(this.timeSerieNameTextField);
		
		contentPanel.add(new JLabel(
				NewTimeSerieDialogsConfig.FUNCTION_COLOR_LABEL));
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
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_FUNCTION_LABEL));
		this.buildJComboBoxWithFunctionNames();
		contentPanel.add(this.functionComboBox);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_START_X_LABEL));
		contentPanel.add(this.startXTextField);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_END_X_LABEL));
		contentPanel.add(this.endXTextField);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_ITERATION_STEP_LABEL));
		contentPanel.add(this.iterationStepTextField);
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_USE_NOISE_LABEL));
		contentPanel.add(this.useNoiseCheckBox);
		this.useNoiseCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				noiseTextField.setEnabled(e.getStateChange()==ItemEvent.SELECTED ? true : false);
			}
		});
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_NOISE_LABEL));
		this.noiseTextField.setEnabled(false);
		contentPanel.add(this.noiseTextField);
		
		this.rightBorder = this.timeSerieNameTextField.getBorder();
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
				if (isFormValid()) {
					FromFunctionConfig config = new FromFunctionConfig();
					config.setTimeSerieName(timeSerieNameTextField.getText());
					config.setGenerateFunction((GenerateFunction)functionComboBox.getSelectedItem());
					config.setColor(timeSerieColor);
					config.setStartX(Double.valueOf(startXTextField.getText()));
					config.setEndX(Double.valueOf(endXTextField.getText()));
					config.setIterationStep(Double.valueOf(iterationStepTextField.getText()));
					config.setUseNoise(useNoiseCheckBox.isSelected());
					if (useNoiseCheckBox.isSelected()) {
						config.setNoise(Double.valueOf(noiseTextField.getText()));
					}
					ControllerService.getGraphController().addTimeSerieFromFunction(config);
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
	
	private void buildJComboBoxWithFunctionNames() {
		this.functionComboBox = new JComboBox<GenerateFunction>(GenerateFunction.values());
	}
	
	private boolean isFormValid() {
		boolean isFormValid = true;
		
		if (!Validation.isStringNotEmpty(this.timeSerieNameTextField.getText())) {
			isFormValid &= false;
			this.markJTextFieldAsInvalid(this.timeSerieNameTextField);
		} else {
			this.markJTextFieldAsValid(this.timeSerieNameTextField);
		}
		
		if (!Validation.isValidDouble(this.startXTextField.getText())) {
			isFormValid &= false;
			this.markJTextFieldAsInvalid(this.startXTextField);
		} else {
			this.markJTextFieldAsValid(this.startXTextField);
		}
		
		if (!Validation.isValidDouble(this.endXTextField.getText())) {
			isFormValid &= false;
			this.markJTextFieldAsInvalid(this.endXTextField);
		} else {
			this.markJTextFieldAsValid(this.endXTextField);
		}
		
		if (!Validation.isValidDouble(this.iterationStepTextField.getText())) {
			isFormValid &= false;
			this.markJTextFieldAsInvalid(this.iterationStepTextField);
		} else {
			this.markJTextFieldAsValid(this.iterationStepTextField);
		}
		
		if (this.useNoiseCheckBox.isSelected()) {
			if (!Validation.isValidDouble(this.noiseTextField.getText())) {
				isFormValid &= false;
				this.markJTextFieldAsInvalid(this.noiseTextField);
			} else {
				this.markJTextFieldAsValid(this.noiseTextField);
			}
		} else {
			this.markJTextFieldAsValid(this.noiseTextField);
		}
		
		return isFormValid;
	}
}
