package dialogs.deletetimeserie;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerService;

public class DeleteTimeSerieDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private Component owner;
	private List<String> actualTimeSeriesNames;

	private JPanel mainPanel;
	private ListPanel actualListPanel;
	private ListPanel toDeleteListPanel;
	private SwapButtonsPanel swapButtonsPanel;
	
	private JButton confirmButton;
	private JButton cancelButton;
	
	private int innerMargin = 0;
	
	public DeleteTimeSerieDialog(Component owner, List<String> actualTimeSeriesNames) {
		this.owner = owner;
		this.actualTimeSeriesNames = actualTimeSeriesNames;
		this.setTitle(DeleteTimeSerieDialogConfig.DIALOG_LABEL);
		this.setSize(DeleteTimeSerieDialogConfig.DIALOGS_SIZE);
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(this.owner);
		
		this.buildContent();
	}

	private void buildContent() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());
		
		JPanel deletePanel = new JPanel();
		deletePanel.setLayout(new GridLayout(1, 3));
		deletePanel.setBorder(new EmptyBorder(this.innerMargin,
				this.innerMargin, this.innerMargin, this.innerMargin));
		
		this.actualListPanel = new ListPanel(this.actualTimeSeriesNames, DeleteTimeSerieDialogConfig.TIME_SERIES_NAMES_ACTUAL);
		this.toDeleteListPanel = new ListPanel(null, DeleteTimeSerieDialogConfig.TIME_SERIES_NAMES_TO_DELETE);
		this.swapButtonsPanel = new SwapButtonsPanel(this);
		
		deletePanel.add(this.actualListPanel);
		deletePanel.add(this.swapButtonsPanel);
		deletePanel.add(this.toDeleteListPanel);
		
		this.mainPanel.add(deletePanel, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		controlPanel.setBorder(new EmptyBorder(0, 0, 0, 7));
		this.confirmButton = new JButton(DeleteTimeSerieDialogConfig.DIALOG_CONFIRM_LABEL);
		this.confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerService.getGraphController().removeTimeSeries(toDeleteListPanel.getNames());
				dispose();
			}
			
		});
		this.cancelButton = new JButton(DeleteTimeSerieDialogConfig.DIALOG_CANCEL_LABEL);
		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		controlPanel.add(this.confirmButton);
		controlPanel.add(this.cancelButton);
		
		this.mainPanel.add(controlPanel, BorderLayout.SOUTH);
		
		this.getContentPane().add(this.mainPanel);
	}
	
	public void swapFromActualToDelete() {
		List<String> selected = this.actualListPanel.popSelectedNames();
		this.toDeleteListPanel.addNamesToList(selected);
	}
	
	public void swapFromToDeleteToActual() {
		List<String> selected = this.toDeleteListPanel.popSelectedNames();
		this.actualListPanel.addNamesToList(selected);
	}
	
}
