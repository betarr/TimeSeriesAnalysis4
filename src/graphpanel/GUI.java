package graphpanel;


import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import datatypes.TimeSerie;

public class GUI {
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.buildGui();
		
		
	}
	
	public static final String appName = "Graph Panel";
	public static final Dimension appSize = new Dimension(640, 480);
	
	private JFrame appFrame;
	private GraphPanel graphPanel;
	
	public void buildGui() {
		this.appFrame = new JFrame(GUI.appName);
		this.appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.appFrame.setPreferredSize(GUI.appSize);
		
		this.addGraphPanel();
//		this.addTimeSerieToGraphPanel("test", this.generateTimeSerie(20, -5, -5, 5), Color.GREEN);
//		this.addTimeSerieToGraphPanel("test", this.generateTimeSerie(30, -10, -7, 7), Color.RED);
//		this.addTimeSerieToGraphPanel("test", this.generateTimeSerie(15, -15, -10, 10), Color.BLUE);
		
		this.addTimeSerieToGraphPanel("test", this.generateSinTimeSerie(5, 15, 0.1), Color.RED);
		
		this.appFrame.pack();
		this.appFrame.setLocationRelativeTo(null);
		this.appFrame.setVisible(true);
	}

	private void addGraphPanel() {
		this.graphPanel = new GraphPanel();
		this.appFrame.add(new JScrollPane(this.graphPanel));
//		this.appFrame.add(GraphPanel.getInstance());
		
	}
	
	public void addTimeSerieToGraphPanel(String name, TimeSerie timeSerie, Color color) {
		this.graphPanel.addTimeSerie(name, timeSerie, color);
	}
	
	public TimeSerie generateTimeSerie(int points, int startX, int minY, int maxY) {
		Random r = new Random();
		TimeSerie result = new TimeSerie();
		for (int i = 0; i < points; i++) {
			Point p = new Point();
			p.setX(startX++);
			int y = r.nextInt(maxY - minY);
			y += minY;
			p.setY(y);
			result.addPoint(p);
		}
		return result;
	}
	
	public TimeSerie generateSinTimeSerie(double startX, double endX, double iterationStep) {
		TimeSerie result = new TimeSerie();
		for (double x = startX; x <= endX; x += iterationStep) {
			Point p = new Point();
			p.setX(x);
			p.setY(Math.sin(x));
			result.addPoint(p);
		}
		return result;
	}
}
