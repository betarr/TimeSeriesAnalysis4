package dialogs.newtimeserie;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseTypePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private NewTimeSerieDialog parent;
	
	private JPanel labelPanel;
	private JPanel contentPanel;
	private JPanel controlPanel;
	
	public ChooseTypePanel(NewTimeSerieDialog parent) {
		this.parent = parent;
		this.labelPanel = this.buildLabelPanel();
		this.contentPanel = this.buildContentPanel();
		this.controlPanel = this.buildControlPanel();
		
		this.setLayout(new BorderLayout());
		this.add(this.labelPanel, BorderLayout.NORTH);
		this.add(this.contentPanel, BorderLayout.CENTER);
		this.add(this.controlPanel, BorderLayout.SOUTH);
	}

	private JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		labelPanel.add(new JLabel("choose.... "));
		return labelPanel;
	}

	private JPanel buildContentPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(1, 3));
		JButton fromFunctionButton = new JButton(NewTimeSerieDialogsConfig.FROM_FUNCTION_BUTTON_LABEL);
		fromFunctionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("From Function button pressed");
			}
		});
		contentPanel.add(fromFunctionButton);
		
		JButton fromExistingButton = new JButton(NewTimeSerieDialogsConfig.FROM_EXISTING_BUTTON_LABEL);
		fromExistingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				System.out.println("From Existing button pressed");
			}
		});
		contentPanel.add(fromExistingButton);
		
		JButton fromRandomButton = new JButton(NewTimeSerieDialogsConfig.FROM_RANDOM_BUTTON_LABEL);
		fromRandomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("From Random panel pressed");
				parent.swapToFromRandomPanel();
			}
		});
		contentPanel.add(fromRandomButton);
		return contentPanel;
	}

	private JPanel buildControlPanel() {
		return new JPanel();
	}
}
