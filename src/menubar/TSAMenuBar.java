package menubar;

import java.awt.Color;
import java.awt.Event;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class TSAMenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 1L;

	public TSAMenuBar() {
		this.buildMenuBar();
	}

	private void buildMenuBar() {
		JMenu programMenu = new JMenu(MenuBarConfig.JMENU_TIMESERIES);
		programMenu.add(this.buildJMenuItem(MenuBarConfig.JMENUITEM_TIMESERIES_NEW,
				KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK),
				null));
		programMenu.addSeparator();
		this.add(programMenu);
		programMenu.add(this.buildJMenuItem(MenuBarConfig.JMENUITEM_TIMESERIES_IMPORT,
				KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK),
				null));
		programMenu.add(this.buildJMenuItem(MenuBarConfig.JMENUITEM_TIMESERIES_EXPORT,
				KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK),
				null));
		programMenu.addSeparator();
		programMenu.add(this.buildJMenuItem(MenuBarConfig.JMENUITEM_TIMESERIES_CLOSE,
				KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK),
				null));
	}
	
	private JMenuItem buildJMenuItem(String label, KeyStroke keyStroke,
			ActionListener listener) {
		JMenuItem jMenuItem = new JMenuItem(label);
		jMenuItem.setAccelerator(keyStroke);
		jMenuItem.addActionListener(listener);
		return jMenuItem;
	}

	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.getWidth();
		int height = this.getHeight();

		Graphics2D g2d = (Graphics2D) g;

		Color color1 = Color.WHITE;
		Color color2 = new Color(72, 118, 255);

		GradientPaint gp = new GradientPaint(0, 0, color1, width, height,
				color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);
	}
}
