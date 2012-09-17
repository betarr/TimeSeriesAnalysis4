package dialogs.timeserieinfo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerService;

import dialogs.DialogsConfig;
import dialogs.deletetimeserie.DeleteTimeSerieDialogConfig;
import dialogs.deletetimeserie.ListPanel;
import dialogs.deletetimeserie.SwapButtonsPanel;

public class TimeSeriesInfoDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private Component owner;
	
	private JPanel mainPanel;
	
	private JButton cancelButton;
	
	private int innerMargin = 0;
	
	public TimeSeriesInfoDialog(Component owner) {
		this.owner = owner;
		this.setTitle(TimeSeriesInfoDialogConfig.DIALOG_LABEL);
		this.setSize(TimeSeriesInfoDialogConfig.DIALOGS_SIZE);
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(this.owner);
		
		this.buildContent();
	}
	
	private void buildContent() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		controlPanel.setBorder(new EmptyBorder(0, 0, 0, 7));

		this.cancelButton = new JButton(DialogsConfig.BUTTON_LABEL_CANCEL);
		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		controlPanel.add(this.cancelButton);
		
		this.mainPanel.add(controlPanel, BorderLayout.SOUTH);
		
		this.getContentPane().add(this.mainPanel);
	}

}
