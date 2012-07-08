package graphpanel.listeners;

import graphpanel.GraphPanel;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;

public class GraphPanelListener implements MouseMotionListener, MouseListener, MouseWheelListener {

	private GraphPanel graphPanel;
	
	private int px = 0;
	private int py = 0;

	public GraphPanelListener(GraphPanel graphPanel) {
		this.graphPanel = graphPanel;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int mouseRotation = e.getWheelRotation();
			if (mouseRotation != 0) {
			Point point = e.getPoint();
			double d = (double) mouseRotation * 1.2;
			d = (mouseRotation > 0) ? 1 / d : -d;
	
			int w = (int) (this.graphPanel.getWidth() * d);
			int h = (int) (this.graphPanel.getHeight() * d);
			this.graphPanel.getPreferredSize().setSize(w, h);
	
			int offX = (int) (point.x * d) - point.x;
			int offY = (int) (point.y * d) - point.y;
			this.graphPanel.setLocation(this.graphPanel.getLocation().x - offX, this.graphPanel.getLocation().y - offY);
	
			this.graphPanel.getParent().doLayout();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.px = e.getPoint().x;
		this.py = e.getPoint().y;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point point = e.getPoint();
		int diffX = point.x - this.px;
		int diffY = point.y - this.py;
		Point oldLocation = this.graphPanel.getLocation();
		Point newLocation = new Point(oldLocation.x+diffX, oldLocation.y+diffY);
		if (this.canMoveGraph(newLocation)) {
			this.graphPanel.setLocation(newLocation);
			this.px = point.x;
			this.py = point.y;
		}
	}
	
	private boolean canMoveGraph(Point newLocation) {
		Rectangle graphPosition = SwingUtilities.calculateInnerArea(this.graphPanel, new Rectangle());
		Point rightDownPoint = new Point(graphPosition.x+graphPosition.width, graphPosition.y+graphPosition.height);
		java.awt.Dimension viewScreen = this.graphPanel.getParent().getSize();
		Point lastAvailablePoint = new Point((int)viewScreen.getWidth(), (int)viewScreen.getHeight());
		
		return (newLocation.x <= 0 && newLocation.y <= 0) && (lastAvailablePoint.x < rightDownPoint.x && lastAvailablePoint.y < rightDownPoint.y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
