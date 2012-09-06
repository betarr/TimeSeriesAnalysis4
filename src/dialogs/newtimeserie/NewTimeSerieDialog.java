package dialogs.newtimeserie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NewTimeSerieDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private Component owner;
	
	private JPanel mainPanel;
	
	private NewTimeSerieDialogPanels chooseTypePanel;
	private NewTimeSerieDialogPanels fromExistingPanel;
	private NewTimeSerieDialogPanels fromFunctionPanel;
	private NewTimeSerieDialogPanels fromRandomPanel;
	private NewTimeSerieDialogPanels fromFilePanel;
	
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
		this.mainPanel.setLayout(new BorderLayout());
		this.mainPanel.setBorder(new EmptyBorder(this.innerMargin,
				this.innerMargin, this.innerMargin, this.innerMargin));
		this.getContentPane().add(this.mainPanel);
		this.swapToChooseTypePanel();
	}
	
	public Dimension getInnerSize() {
		return this.getSize();
	}
	
	private void swapToPanel(NewTimeSerieDialogPanels panels) {
		this.mainPanel.removeAll();
		this.mainPanel.add(panels.getLabelPanel(), BorderLayout.NORTH);
		this.mainPanel.add(panels.getContentPanel(), BorderLayout.CENTER);
		this.mainPanel.add(panels.getControlPanel(), BorderLayout.SOUTH);
		this.mainPanel.validate();
		this.mainPanel.repaint();
	}
	
	public void swapToChooseTypePanel() {
		if (this.chooseTypePanel == null) {
			this.chooseTypePanel = new ChooseTypePanel(this);
		}
		this.swapToPanel(this.chooseTypePanel);
	}
	
	public void swatToFromFunctionPanel() {
		if (this.fromFunctionPanel == null) {
			this.fromFunctionPanel = new FromFunctionPanel(this);
		}
		this.swapToPanel(this.fromFunctionPanel);
	}
	
	public void swapToFromRandomPanel() {
		if (this.fromRandomPanel == null) {
			this.fromRandomPanel = new FromRandomPanel(this);
		}
		this.swapToPanel(this.fromRandomPanel);
	}
	
	public void swapToFromFilePanel() {
		if (this.fromFilePanel == null) {
			this.fromFilePanel = new FromFilePanel(this);
		}
		this.swapToPanel(this.fromFilePanel);
	}
	
	public void cancelDialog() {
		this.dispose();
	}

	public Component getOwnerOfDialog() {
		return owner;
	}
}
