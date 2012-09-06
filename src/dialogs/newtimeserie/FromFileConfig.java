package dialogs.newtimeserie;

import java.awt.Color;
import java.io.File;

public class FromFileConfig {

	private String timeSerieName;
	private Color color;
	private String fileName;
	private String filePath;
	private File file;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName()).append(":\n");
		sb.append("timeSerieName: ").append(this.timeSerieName).append("\n");
		sb.append("color: ").append(this.color).append("\n");
		sb.append("fileName: ").append(this.fileName).append("\n");
		sb.append("filePath: ").append(this.filePath).append("\n");
		sb.append("file: ").append(this.file).append("\n");
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
