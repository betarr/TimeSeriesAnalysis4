package controllers;

import graphpanel.GraphPanel;
import app.App;

public class ControllerService {

	private static AppController appController;
	private static GraphController graphController;
	
	public static void init(App app, GraphPanel graphPanel) {
		appController = new AppController(app);
		graphController = new GraphController(graphPanel);
	}
	
	public static AppController getAppController() {
		return appController;
	}
	
	public static GraphController getGraphController() {
		return graphController;
	}
}
