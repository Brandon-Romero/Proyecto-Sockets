package view.viewFigures;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

public class JMenuBarrr {

	private JMenu menu;
	private JMenuItem start, stop, newFigure, settings;
	private ActionListener actionListener;
	private MainFrame mainFrame;
	private JMenuBar jMenuBar;

	public JMenuBarrr(MainFrame mainFrame, ActionListener actionListener) {
		this.actionListener = actionListener;
		this.mainFrame = mainFrame;
		this.initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		createJMenuBar();
		createMenu();

		createItemStart();
		menu.addSeparator();

		createItemStop();
		menu.addSeparator();

		createItemNewFigure();
		menu.addSeparator();

		createItemSetting();
		menu.addSeparator();

	}

	private void createJMenuBar() {
		jMenuBar = new JMenuBar();
		mainFrame.setJMenuBar(jMenuBar);
	}

	private void createMenu() {
		menu = new JMenu("MENU");
		jMenuBar.add(menu);
	}

	private void createItemStart() {
		start = new JMenuItem("Start");
		start.addActionListener(actionListener);
		start.setActionCommand("iniciar");
		menu.add(start);
	}

	private void createItemStop() {
		stop = new JMenuItem("Stop");
		stop.addActionListener(actionListener);
		stop.setActionCommand("parar");
		menu.add(stop);
	}

	private void createItemNewFigure() {
		newFigure = new JMenuItem("New Figure");
		newFigure.addActionListener(actionListener);
		newFigure.setActionCommand("nueva");
		menu.add(newFigure);
	}

	private void createItemSetting() {
		settings = new JMenuItem("Settings");
		settings.addActionListener(actionListener);
		settings.setActionCommand("configuracion");
		menu.add(settings);
	}

}
