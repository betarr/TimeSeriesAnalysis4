package dialogs.newtimeserie;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dialogs.DialogsConfig;

public class FromRandomPanel extends NewTimeSerieDialogPanels {
	private static final long serialVersionUID = 1L;
	
	private NewTimeSerieDialog parent;
	
	private int spaceBetweenFields = 10;
	
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
		JPanel contentPanel = new JPanel();
		this.setMarginToPanel(contentPanel, this.spaceBetweenFields);
		contentPanel.setLayout(new GridLayout(6, 1, this.spaceBetweenFields, this.spaceBetweenFields));
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_NAME_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_START_X_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_END_X_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_MIN_Y_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_MAX_Y_LABEL));
		contentPanel.add(new JTextField());
		
		contentPanel.add(new JLabel(NewTimeSerieDialogsConfig.RANDOM_ITERATION_STEP_LABEL));
		contentPanel.add(new JTextField());
		
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
				System.out.println("finish from random");
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
