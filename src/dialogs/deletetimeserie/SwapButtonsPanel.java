package dialogs.deletetimeserie;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SwapButtonsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private DeleteTimeSerieDialog owner;
	
	private JButton fromActualToDeleteButton = new JButton(">>");
	private JButton fromDeleteToActualButton = new JButton("<<");
	
	public SwapButtonsPanel(DeleteTimeSerieDialog owner) {
		this.owner = owner;
		this.buildPanel();
	}
	
	private void buildPanel() {
		GridBagConstraints fromActualToDeleteConstraints = new GridBagConstraints();
		fromActualToDeleteConstraints.gridx = 0;
		fromActualToDeleteConstraints.gridy = 0;
		fromActualToDeleteConstraints.anchor = GridBagConstraints.PAGE_END;
		fromActualToDeleteConstraints.insets = new Insets(10, 10, 10, 10);
		
		GridBagConstraints fromDeleteToActualConstraints = new GridBagConstraints();
		fromDeleteToActualConstraints.gridx = 0;
		fromDeleteToActualConstraints.gridy = 1;
		fromDeleteToActualConstraints.anchor = GridBagConstraints.PAGE_START;
		fromDeleteToActualConstraints.insets = new Insets(10, 10, 10, 10);
		
		this.setLayout(new GridBagLayout());
		
		this.fromActualToDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				owner.swapFromActualToDelete();
			}
			
		});
		
		this.fromDeleteToActualButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				owner.swapFromToDeleteToActual();
			}
			
		});
		
		this.add(this.fromActualToDeleteButton, fromActualToDeleteConstraints);
		this.add(this.fromDeleteToActualButton, fromDeleteToActualConstraints);
	}
}
