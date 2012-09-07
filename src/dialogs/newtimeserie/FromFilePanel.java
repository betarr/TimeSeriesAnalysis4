package dialogs.newtimeserie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Validation;
import controllers.ControllerService;
import dialogs.DialogsConfig;

public class FromFilePanel extends NewTimeSerieDialogPanels {
	private NewTimeSerieDialog parent;

	private int spaceBetweenFields = 10;
	private static File actualDirectory = null;

	private JTextField timeSerieNameTextField;
	private JTextField fileNameTextField;
	private JTextField filePathTextField;
	
	private File selectedFile = null;
	
	private JPanel timeSerieColorPanel;
	private JButton timeSerieColorButton;
	private Color timeSerieColor = NewTimeSerieDialogsConfig.TIME_SERIE_DEFAULT_COLOR;

	public FromFilePanel(NewTimeSerieDialog parent) {
		this.parent = parent;
		this.labelPanel = this.buildLabelPanel();
		this.contentPanel = this.buildContentPanel();
		this.controlPanel = this.buildControlPanel();
	}

	private JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		labelPanel.add(new JLabel(NewTimeSerieDialogsConfig.FROM_FILE_LABEL));
		return labelPanel;
	}

	private JPanel buildContentPanel() {
		JPanel contentPanel = new JPanel();
		this.setMarginToPanel(contentPanel, this.spaceBetweenFields);
		contentPanel.setLayout(new BorderLayout());

		final JPanel contentPanel1 = new JPanel();
		contentPanel1.setLayout(new GridLayout(4, 2, this.spaceBetweenFields,
				this.spaceBetweenFields));

		contentPanel1
				.add(new JLabel(NewTimeSerieDialogsConfig.FILE_NAME_LABEL));
		this.timeSerieNameTextField = new JTextField();
		contentPanel1.add(this.timeSerieNameTextField);
		
		contentPanel1.add(new JLabel(
				NewTimeSerieDialogsConfig.FILE_COLOR_LABEL));
		this.timeSerieColorPanel = new JPanel();
		this.timeSerieColorPanel.setBackground(NewTimeSerieDialogsConfig.TIME_SERIE_DEFAULT_COLOR);
		this.timeSerieColorButton = new JButton(NewTimeSerieDialogsConfig.COLOR_CHOOSER_BUTTON_LABEL);
		this.timeSerieColorButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color color = JColorChooser.showDialog(contentPanel1,
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
		contentPanel1.add(colorChoosePanel);

		contentPanel1.add(new JLabel(
				NewTimeSerieDialogsConfig.FILE_FILE_NAME_LABEL));
		this.fileNameTextField = new JTextField();
		this.fileNameTextField.setEditable(false);
		contentPanel1.add(this.fileNameTextField);
		
		contentPanel1.add(new JLabel(
				NewTimeSerieDialogsConfig.FILE_FILE_PATH_LABEL));
		this.filePathTextField = new JTextField();
		this.filePathTextField.setEditable(false);
		contentPanel1.add(this.filePathTextField);

		contentPanel.add(contentPanel1, BorderLayout.CENTER);

		JPanel contentPanel2 = new JPanel();
		JButton chooseFileButton = new JButton(
				NewTimeSerieDialogsConfig.FILE_CHOOSE_FILE_LABEL);
		chooseFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser(actualDirectory);
				int returnValue = fileChooser.showOpenDialog(parent
						.getOwnerOfDialog());
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					actualDirectory = selectedFile;
					fileNameTextField.setText(selectedFile.getName());
					filePathTextField.setText(selectedFile.getPath());
				}
			}
		});
		contentPanel2.add(chooseFileButton);
		contentPanel.add(contentPanel2, BorderLayout.SOUTH);

		this.rightBorder = this.timeSerieNameTextField.getBorder();
		return contentPanel;
	}

	private JPanel buildControlPanel() {
		JPanel controlPanel = new JPanel();
		this.setMarginToPanel(controlPanel, 0, 10, 0, 0);
		controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton backButton = new JButton(DialogsConfig.BUTTON_LABEL_BACK);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.swapToChooseTypePanel();
			}
		});
		controlPanel.add(backButton);

		JButton finishButton = new JButton(DialogsConfig.BUTTON_LABEL_FINISH);
		finishButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isFormValid()) {
					FromFileConfig config = new FromFileConfig();
					config.setTimeSerieName(timeSerieNameTextField.getText());
					config.setFileName(fileNameTextField.getText());
					config.setFilePath(filePathTextField.getText());
					config.setFile(selectedFile);
					config.setColor(timeSerieColor);
					ControllerService.getGraphController().addTimeSerieFromFile(config);
					parent.dispose();
				}
			}
		});
		controlPanel.add(finishButton);

		JButton cancelButton = new JButton(DialogsConfig.BUTTON_LABEL_CANCEL);
		cancelButton.addActionListener(new ActionListener() {
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

		if (!Validation.isStringNotEmpty(this.fileNameTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.fileNameTextField);
		} else {
			this.markJTextFieldAsValid(this.fileNameTextField);
		}

		if (!Validation.isStringNotEmpty(this.filePathTextField.getText())) {
			isValid &= false;
			this.markJTextFieldAsInvalid(this.filePathTextField);
		} else {
			this.markJTextFieldAsValid(this.filePathTextField);
		}

		return isValid;
	}
}
