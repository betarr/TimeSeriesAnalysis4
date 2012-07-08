package datatypes;

import java.awt.Color;

import datatypes.TimeSerie;



public class TimeSerieConfig {

	private String name = "";
	private TimeSerie timeSerie = null;
	private Color color = null;
	
	public TimeSerieConfig(String name, TimeSerie timeSerie, Color color) {
		this.name = name;
		this.timeSerie = timeSerie;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public TimeSerie getTimeSerie() {
		return timeSerie;
	}

	public Color getColor() {
		return color;
	}
}
