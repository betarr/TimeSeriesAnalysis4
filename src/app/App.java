package app;

import graphpanel.GraphPanel;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controllers.ControllerService;

import menubar.TSAMenuBar;

public class App {
	
	private JFrame appFrame;
	private GraphPanel graphPanel;
	
	public static void main(String... args) {
		App app = new App();
		app.buildApp();
	}
	
	public void buildApp() {
		this.graphPanel = new GraphPanel();
		ControllerService.init(this, this.graphPanel);
		this.appFrame = new JFrame(AppConfig.APP_TITLE);
		this.appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.appFrame.setPreferredSize(AppConfig.APP_SIZE);
		
		this.appFrame.setJMenuBar(new TSAMenuBar(this.appFrame));
		this.addGraphPanel();
		
		this.appFrame.pack();
		this.appFrame.setLocationRelativeTo(null);
		this.appFrame.setVisible(true);
	}

	private void addGraphPanel() {
		this.appFrame.add(new JScrollPane(this.graphPanel));
	}
}
