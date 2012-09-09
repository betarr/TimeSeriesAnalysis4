package controllers;

import java.awt.Component;
import java.util.List;

import app.App;
import dialogs.deletetimeserie.DeleteTimeSerieDialog;
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
	
	public void showDeteleTimeSerieDialog(Component parent) {
		List<String> actualTimeSeriesNames = ControllerService.getGraphController().getTimeSeriesNames();
		DeleteTimeSerieDialog deleteTimeSerieDialog = new DeleteTimeSerieDialog(parent, actualTimeSeriesNames);
		deleteTimeSerieDialog.setVisible(true);
	}
	
	public void closeApplication() {
		System.exit(0);
	}
}
