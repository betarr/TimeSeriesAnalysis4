package controllers;

import graphpanel.GraphPanel;
import graphpanel.Point;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import utils.Validation;
import datatypes.TimeSerie;
import dialogs.newtimeserie.FromFileConfig;
import dialogs.newtimeserie.FromFunctionConfig;
import dialogs.newtimeserie.FromRandomConfig;

public class GraphController {

	private GraphPanel graphPanel;

	public GraphController(GraphPanel graphPanel) {
		this.graphPanel = graphPanel;
	}
	
	public void addTimeSerieFromFunction(FromFunctionConfig config) {
		TimeSerie timeSerie = new TimeSerie();
		for (double x = config.getStartX(); x <= config.getEndX(); x += config.getIterationStep()) {
			Point p = new Point();
			p.setX(x);
			double y = Math.sin(x);
			if (config.isUseNoise()) {
				double noise = (Math.random() * config.getNoise()*2) - config.getNoise();
				y += noise;
			}
			p.setY(y);
			timeSerie.addPoint(p);
		}
		System.out.println(timeSerie);
		this.graphPanel.addTimeSerie(config.getTimeSerieName(), timeSerie, config.getColor());
	}
	
	public void addTimeSerieFromRandom(FromRandomConfig config) {
		Random r = new Random();
		TimeSerie timeSerie = new TimeSerie();
		for (double x = config.getStartX(); x <= config.getEndX(); x += config.getIterationStep()) {
			Point p = new Point();
			p.setX(x);
			double y = config.getMinY() + (config.getMaxY() - config.getMinY()) * r.nextDouble();
			p.setY(y);
			timeSerie.addPoint(p);
		}
		System.out.println(timeSerie);
		this.graphPanel.addTimeSerie(config.getTimeSerieName(), timeSerie, config.getColor());
	}

	public void addTimeSerieFromFile(FromFileConfig config) {
		try {
			TimeSerie timeSerie = new TimeSerie();
			Scanner scanner = new Scanner(config.getFile());
			double x = 0;
			while (scanner.hasNextLine()) {
				String fileLine = scanner.nextLine();
				if (Validation.isValidDouble(fileLine)) {
					timeSerie.addPoint(new Point(x++, Double.valueOf(fileLine)));
				}
			}
			System.out.println(timeSerie);
			this.graphPanel.addTimeSerie(config.getTimeSerieName(), timeSerie, config.getColor());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
