package graphpanel;

import java.awt.Color;
import java.util.List;

import datatypes.TimeSerie;

public interface GraphPanelInterface {

	public List<String> getTimeSeriesNames();
	public TimeSerie getTimeSerieByName(String name);
	public boolean addTimeSerie(String name, TimeSerie timeSerie);
	public boolean addTimeSerie(String name, TimeSerie timeSerie, Color color);
	public boolean isTimeSerieWithName(String name);
	public void removeTimeSerie(String name);
	public void removeTimeSeries(List<String> names);
}
