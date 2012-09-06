package dialogs.newtimeserie;

import java.awt.Color;

import enums.GenerateFunction;

public class FromFunctionConfig {

	private String timeSerieName;
	private Color color;
	private GenerateFunction generateFunction;
	private double startX;
	private double endX;
	private double iterationStep;
	private boolean useNoise;
	private double noise;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(":\n");
		sb.append("timeSerieName: ").append(this.timeSerieName).append("\n");
		sb.append("color: ").append(this.color).append("\n");
		sb.append("startX: ").append(this.startX).append("\n");
		sb.append("endX: ").append(this.endX).append("\n");
		sb.append("iterationStep: ").append(this.iterationStep).append("\n");
		sb.append("useNoise: ").append(this.useNoise).append("\n");
		sb.append("noise: ").append(this.noise).append("\n");
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
	public GenerateFunction getGenerateFunction() {
		return generateFunction;
	}
	public void setGenerateFunction(GenerateFunction generateFunction) {
		this.generateFunction = generateFunction;
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
	public double getIterationStep() {
		return iterationStep;
	}
	public void setIterationStep(double iterationStep) {
		this.iterationStep = iterationStep;
	}
	public boolean isUseNoise() {
		return useNoise;
	}
	public void setUseNoise(boolean useNoise) {
		this.useNoise = useNoise;
	}
	public double getNoise() {
		return noise;
	}
	public void setNoise(double noise) {
		this.noise = noise;
	}
}
