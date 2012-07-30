package dialogs.newtimeserie;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NewTimeSerieDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private Component owner;
	
	private JPanel mainPanel;
	
	private JPanel chooseTypePanel = new ChooseTypePanel(this);
	private JPanel fromExistingPanel;
	private JPanel fromFunctionPanel;
	private JPanel fromRandomPanel = new FromRandomPanel(this);
	
	private int innerMargin = 0;
	
	public NewTimeSerieDialog(Component owner) {
		this.owner = owner;
		this.setTitle(NewTimeSerieDialogsConfig.DIALOG_LABEL);
		this.setSize(NewTimeSerieDialogsConfig.DIALOGS_SIZE);
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(this.owner);
		
		this.buildContent();
	}

	private void buildContent() {
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(Color.RED);
		this.mainPanel.setLayout(new FlowLayout());
		this.mainPanel.setBorder(new EmptyBorder(this.innerMargin,
				this.innerMargin, this.innerMargin, this.innerMargin));
		this.mainPanel.add(this.chooseTypePanel);
		this.getContentPane().add(this.mainPanel);
	}
	
	private void swapToPanel(JPanel panel) {
		this.mainPanel.removeAll();
		this.mainPanel.add(panel);
		this.mainPanel.validate();
	}
	
	public void swapToFromRandomPanel() {
		this.swapToPanel(this.fromRandomPanel);
	}


}
