package datatypes;

import graphpanel.Dimension;
import graphpanel.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TimeSerie implements Iterable<Point> {

	private List<Point> points;
	
	public TimeSerie() {
		this.points = new ArrayList<Point>();
	}
	
	public TimeSerie(List<Point> points) {
		this();
		Collections.copy(this.points, points);
	}
	
	public void addPoint(Point point) {
		this.points.add(point);
	}
	
	public Point getPoint(int index) throws IndexOutOfBoundsException {
		return this.points.get(index);
	}
	
	public Point getFirst() {
		if ( !this.isEmpty() ) {
			return this.getPoint(0);
		}
		return null;
	}
	
	public Point getLast() {
		if ( !this.isEmpty() ) {
			return this.getPoint(this.size()-1);
		}
		return null;
	}
	
	public int size() {
		return this.points.size();
	}
	
	public boolean isEmpty() {
		return this.points.isEmpty();
	}
	
	public TimeSerieRange getRange() {
		TimeSerieRange range = null;
		if ( !this.isEmpty() ) {
			range = new TimeSerieRange();
			range.setMinX(Integer.MAX_VALUE);
			range.setMinY(Integer.MAX_VALUE);
			range.setMaxX(Integer.MIN_VALUE);
			range.setMaxY(Integer.MIN_VALUE);
			for ( Point p : this.points ) {
				if ( p.getX() < range.getMinX() ) range.setMinX(p.getX());
				if ( p.getY() < range.getMinY() ) range.setMinY(p.getY());
				if ( p.getX() > range.getMaxX() ) range.setMaxX(p.getX());
				if ( p.getY() > range.getMaxY() ) range.setMaxY(p.getY());
			}
		}
		return range;
	}
	
	public Dimension getAreaSize() {
		Dimension areaSize = null;
		TimeSerieRange range = this.getRange();
		if ( range != null ) {
			areaSize = new Dimension();
			areaSize.setWidth(range.getMaxX() - range.getMinX());
			areaSize.setHeight(range.getMaxY() - range.getMinY());
		}
		return areaSize;
	}

	@Override
	public String toString() {
		String result = "";
		for ( Point p : this.points ) {
			result += "[" + p.getX() + ", " + p.getY() + "]\n";
		}
		return result;
	}
	
	
	
	@Override
	public Iterator<Point> iterator() {
		return this.points.iterator();
	}
}
