package graphpanel;

import datatypes.TimeSerieRange;


public class PointConverter {

	private Dimension panelSize = null;
	private Dimension timeSerieSize = null;
	private TimeSerieRange timeSerieRange = null;
	private double proportionWidth = 0;
	private double proportionHeight = 0;
	
	public PointConverter() {
	}
	
	public void recalculateProportions() {
		this.proportionWidth = (this.panelSize.getWidth())
				/ (float) (this.timeSerieSize.getWidth());
		this.proportionHeight = (this.panelSize.getHeight())
				/ (float) (this.timeSerieSize.getHeight());
	}

	public void setPanelSize(Dimension panelSize) {
		this.panelSize = panelSize;
	}

	public void setTimeSerieSize(Dimension timeSerieSize) {
		this.timeSerieSize = timeSerieSize;
	}

	public void setTimeSerieRange(TimeSerieRange timeSerieRange) {
		this.timeSerieRange = timeSerieRange;
	}
	
	public double getProportionWidth() {
		return proportionWidth;
	}

	public double getProportionHeight() {
		return proportionHeight;
	}

	public Point convertFromTimeSeriePoint(Point p) {
		Point result = null;
		if (this.timeSerieSize != null) {
			result = new Point();
			result.setX((int) (this.proportionWidth * (p.getX() - this.timeSerieRange.getMinX())));
			double newY = (int) (this.proportionHeight * (p.getY() - this.timeSerieRange.getMinY()));
			result.setY(this.panelSize.getHeight() - newY);
		}
		return result;
	}
	
	public Point convertToTimeSeriePoint(Point p) {
		Point result = null;
		if (this.timeSerieSize != null) {
			result = new Point();
			double newX = p.getX()/this.proportionWidth + this.timeSerieRange.getMinX();
			result.setX(newX);
			double newY = (this.panelSize.getHeight()-p.getY())/this.proportionHeight + this.timeSerieRange.getMinY();
			result.setY(newY);
		}
		return result;
	}
}
