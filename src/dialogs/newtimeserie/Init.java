package dialogs.newtimeserie;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Init {
	
	public static void main(String... args) {
		Init init = new Init();
	}

	private JFrame frame;
	
	public Init() {
		this.buildInit();
	}

	private void buildInit() {
		this.frame = new JFrame();
		this.frame.setPreferredSize(new Dimension(640, 480));
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
		NewTimeSerieDialog dialog = new NewTimeSerieDialog(this.frame);
		dialog.setVisible(true);
	}
}
