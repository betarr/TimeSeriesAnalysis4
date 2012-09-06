package dialogs.newtimeserie;

import java.awt.Color;

public class FromRandomConfig {

	private String timeSerieName;
	private Color color;
	private double startX;
	private double endX;
	private double minY;
	private double maxY;
	private double iterationStep;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(":\n");
		sb.append("timeSerieName: ").append(this.timeSerieName).append("\n");
		sb.append("timeSerieColor: ").append(this.color).append("\n");
		sb.append("startX: ").append(this.startX).append("\n");
		sb.append("endX: ").append(this.endX).append("\n");
		sb.append("minY: ").append(this.minY).append("\n");
		sb.append("maxY: ").append(this.maxY).append("\n");
		sb.append("iterationStep: ").append(this.iterationStep).append("\n");
		return sb.toString();
	}
	
	public String getTimeSerieName() {
		return timeSerieName;
	}
	public void setTimeSerieName(String timeSerieName) {
		this.timeSerieName = timeSerieName;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public double getStartX() {
		return startX;
	}
	public void setStartX(double startX) {
		this.startX = startX;
	}
	public double getEndX() {
		return endX;
	}
	public void setEndX(double endX) {
		this.endX = endX;
	}
	public double getMinY() {
		return minY;
	}
	public void setMinY(double minY) {
		this.minY = minY;
	}
	public double getMaxY() {
		return maxY;
	}
	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}
	public double getIterationStep() {
		return iterationStep;
	}
	public void setIterationStep(double iterationStep) {
		this.iterationStep = iterationStep;
	}
}
