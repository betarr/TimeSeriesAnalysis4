package dialogs.newtimeserie;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dialogs.DialogsConfig;
import enums.GenerateFunction;

public class FromFunctionPanel extends NewTimeSerieDialogPanels {
	private static final long serialVersionUID = 1L;
	
	private NewTimeSerieDialog parent;
	
	private int spaceBetweenFields = 10;

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
		JPanel contentPanel = new JPanel();
		this.setMarginToPanel(contentPanel, this.spaceBetweenFields);
		contentPanel.setLayout(new GridLayout(7, 2, this.spaceBetweenFields, this.spaceBetweenFields));
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_NAME_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_FUNCTION_LABEL));
		contentPanel.add(this.buildJComboBoxWithFunctionNames());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_START_X_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_END_X_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_ITERATION_STEP_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_USE_NOISE_LABEL));
		contentPanel.add(new JCheckBox());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.FUNCTION_NOISE_LABEL));
		contentPanel.add(new JTextField());
		
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
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("finish from function");
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
	
	private JComboBox<String> buildJComboBoxWithFunctionNames() {
		List<String> functionsNamesList = GenerateFunction.getNames();
		String[] functionsNames = new String[functionsNamesList.size()];
		for (int i = 0; i < functionsNamesList.size(); i++) {
			functionsNames[i] = functionsNamesList.get(i);
		}
		return new JComboBox<String>(functionsNames);
	}
}
