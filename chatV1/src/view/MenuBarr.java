package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

import control.Commands;

public class MenuBarr {

	private JMenu config, help;
	private JMenuItem client, server, exit;
	private ActionListener actionListener;
	private JFramePrincipal jFramePrincipal;
	private JMenuBar jMenuBar;

	public MenuBarr(JFramePrincipal jFramePrincipal, ActionListener actionListener) {
		this.actionListener = actionListener;
		this.jFramePrincipal = jFramePrincipal;
		this.initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		createJMenuBar();
		createMenuConfig();
		createMenuHelp();

		createItemClient();
		config.addSeparator();

		createItemServer();
		config.addSeparator();

		createItemExit();
		config.addSeparator();
	}

	private void createJMenuBar() {
		jMenuBar = new JMenuBar();
		jFramePrincipal.setJMenuBar(jMenuBar);
	}

	private void createMenuConfig() {
		config = new JMenu(Constants.OPTION_BARR_MENU_CONFIG);
		jMenuBar.add(config);
	}

	private void createMenuHelp() {
		help = new JMenu(Constants.OPTION_BARR_MENU_HELP);
		jMenuBar.add(help);
	}

	private void createItemClient() {
		client = new JMenuItem(Constants.OPTION_MENU_CONFIG_CLIENT);
		client.addActionListener(actionListener);
		client.setActionCommand(Commands.C_CLIENT.toString());
		config.add(client);
	}

	private void createItemServer() {
		server = new JMenuItem(Constants.OPTION_MENU_CONFIG_SERVER);
		server.addActionListener(actionListener);
		server.setActionCommand(Commands.C_SERVER.toString());
		config.add(server);
	}

	private void createItemExit() {
		exit = new JMenuItem(Constants.OPTION_MENU_CONFIG_EXIT);
		exit.addActionListener(actionListener);
		exit.setActionCommand(Commands.C_EXIT.toString());
		config.add(exit);
	}

}
