package graphpanel;

import junit.framework.Assert;

import org.junit.Test;

import datatypes.TimeSerie;

public class PointConverterTest {
	
	private PointConverter converter = new PointConverter();
	
	@Test
	public void testRecalculateProportions() {
		this.converter.setPanelSize(new Dimension(640, 480));
		this.converter.setTimeSerieSize(new Dimension(20, 10));
		this.converter.recalculateProportions(); 
		
		double proportionHeightExpected = 48.0;
		double proportionHeightActual = this.converter.getProportionHeight();
		Assert.assertEquals(proportionHeightExpected, proportionHeightActual);
		
		double proportionWidthExpected = 32.0;
		double proportionWidthActual = this.converter.getProportionWidth();
		Assert.assertEquals(proportionWidthExpected, proportionWidthActual);
	}
	
	@Test
	public void convertFromTimeSeriePointX() {
		TimeSerie ts = this.generateTimeSerieX(200);
		
		this.converter.setPanelSize(new Dimension(1024, 768));
		this.converter.setTimeSerieRange(ts.getRange());
		this.converter.setTimeSerieSize(ts.getAreaSize());
		this.converter.recalculateProportions();
		
		Double firstXExpected = 0D;
		Double firstXActual = this.converter.convertFromTimeSeriePoint(ts.getFirst()).getX();
		
		Double lastXExpected = 1024D;
		Double lastXActual = this.converter.convertFromTimeSeriePoint(ts.getLast()).getX();
		
		Assert.assertEquals(firstXExpected, firstXActual);
		Assert.assertEquals(lastXExpected, lastXActual);
	}
	
	@Test
	public void convertFromTimeSeriePointY() {
		TimeSerie ts = this.generateTimeSerieY(200);
		
		this.converter.setPanelSize(new Dimension(1024, 768));
		this.converter.setTimeSerieRange(ts.getRange());
		this.converter.setTimeSerieSize(ts.getAreaSize());
		this.converter.recalculateProportions();
		
		Double firstYExpected = 768D;
		Double firstYActual = this.converter.convertFromTimeSeriePoint(ts.getFirst()).getY();
		
		Double lastYExpected = 0D;
		Double lastYActual = this.converter.convertFromTimeSeriePoint(ts.getLast()).getY();
		
		Assert.assertEquals(firstYExpected, firstYActual);
		Assert.assertEquals(lastYExpected, lastYActual);
	}
	
	@Test
	public void convertToTimeSeriePointX() {
		TimeSerie ts = this.generateTimeSerieX(200);
		
		this.converter.setPanelSize(new Dimension(1024, 768));
		this.converter.setTimeSerieRange(ts.getRange());
		this.converter.setTimeSerieSize(ts.getAreaSize());
		this.converter.recalculateProportions();
		
		double firstXExpected = 0;
		double firstXActual = this.converter.convertToTimeSeriePoint(new Point(0, 0)).getX();
		
		double lastXExpected = 199;
		double lastXActual = this.converter.convertToTimeSeriePoint(new Point(1024, 0)).getX();
		
		Assert.assertEquals(firstXExpected, firstXActual);
		Assert.assertEquals(lastXExpected, lastXActual);
	}
	
	@Test
	public void convertToTimeSeriePointY() {
		TimeSerie ts = this.generateTimeSerieY(200);
		
		this.converter.setPanelSize(new Dimension(1024, 768));
		this.converter.setTimeSerieRange(ts.getRange());
		this.converter.setTimeSerieSize(ts.getAreaSize());
		this.converter.recalculateProportions();
		
		double firstYExpected = 199;
		double firstYActual = this.converter.convertToTimeSeriePoint(new Point(0, 0)).getY();
		
		double lastYExpected = 0;
		double lastYActual = this.converter.convertToTimeSeriePoint(new Point(0, 768)).getY();
		
		Assert.assertEquals(firstYExpected, firstYActual);
		Assert.assertEquals(lastYExpected, lastYActual);
	}
	
	private TimeSerie generateTimeSerieX(int numberOfPoints) {
		TimeSerie result = new TimeSerie();
		for ( int i = 0; i < numberOfPoints; i++ ) {
			result.addPoint(new Point(i, 0));
		}
		return result;
	}
	
	private TimeSerie generateTimeSerieY(int numberOfPoints) {
		TimeSerie result = new TimeSerie();
		for ( int i = 0; i < numberOfPoints; i++ ) {
			result.addPoint(new Point(0, i));
		}
		return result;
	}
}
