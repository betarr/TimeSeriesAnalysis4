package dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public abstract class Dialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private String dialogTitle = "";
	private Dimension dialogSize = new Dimension(0, 0);
	private Image dialogIcon = null;
	
	private JPanel mainPanel;
	
	private JPanel labelPanel = null;
	private JPanel contentPanel = null;
	private JPanel controlPanel = null;
	
	protected int innerMargin = 0;
	
	public Dialog(String dialogName, Dimension dialogSize) {
		this.dialogTitle = dialogName;
		this.dialogSize = dialogSize;
	}

	public Dialog(String dialogName, Dimension dialogSize, Image dialogIcon) {
		this(dialogName, dialogSize);
		this.dialogIcon = dialogIcon;
	}
	
	public void buildDialog(Component owner) {
		this.setTitle(this.dialogTitle);
		this.setSize(this.dialogSize);
		
		if ( this.dialogIcon != null ) {
			this.setIconImage(this.dialogIcon);
		}
		
		this.mainPanel = new JPanel();
		this.mainPanel.setBorder(new EmptyBorder(this.innerMargin,
				this.innerMargin, this.innerMargin, this.innerMargin));
		
		this.mainPanel.setLayout(new BorderLayout());
		
		this.labelPanel = this.buildLabelPanel();
		if (this.labelPanel != null) {
			this.mainPanel.add(this.labelPanel, BorderLayout.NORTH);
		}
		
		this.contentPanel = this.buildContentPanel();
		if (this.contentPanel != null) {
			this.mainPanel.add(contentPanel, BorderLayout.CENTER);
		}
		this.controlPanel = this.buildControlPanel();
		if (this.controlPanel != null) {
			this.mainPanel.add(this.controlPanel, BorderLayout.SOUTH);
		}
		
		this.contentPanel.add(this.mainPanel);
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(owner);
	}
	
	protected abstract JPanel buildLabelPanel();
	
	protected abstract JPanel buildContentPanel();
	
	protected abstract JPanel buildControlPanel();
	
	protected void swapPanels() {
		this.mainPanel.removeAll();
		this.mainPanel.add(this.labelPanel, BorderLayout.NORTH);
		this.mainPanel.add(this.contentPanel, BorderLayout.CENTER);
		this.mainPanel.add(this.controlPanel, BorderLayout.SOUTH);
		this.mainPanel.validate();
	}
	
	protected JButton buildJButton(JButton jButton, String label, ActionListener listener) {
		jButton = new JButton(label);
		jButton.addActionListener(listener);
		return jButton;
	}

	public void setInnerMargin(int innerMargin) {
		this.innerMargin = innerMargin;
	}



	class DefaultCancelListener implements ActionListener {
		private Dialog dialog;
		
		public DefaultCancelListener(Dialog dialog) {
			this.dialog = dialog;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.dialog.dispose();
		}
		
	}

}
