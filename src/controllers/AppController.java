package controllers;

import java.awt.Component;

import app.App;
import dialogs.newtimeserie.NewTimeSerieDialog;

public class AppController {

	private App app;

	public AppController(App app) {
		this.app = app;
	}

	public void showNewTimeSerieDialog(Component parent) {
		NewTimeSerieDialog newTimeSerieDialog = new NewTimeSerieDialog(parent);
		newTimeSerieDialog.setVisible(true);
	}
	
	public void closeApplication() {
		System.exit(0);
	}
	
}
