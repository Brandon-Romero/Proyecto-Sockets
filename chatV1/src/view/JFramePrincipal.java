package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import control.Controller;
import view.JFramePrincipal;
import view.viewFigures.MyPanel;
import models.IGame;
import models.entities.client.Client;
import models.modelFigures.entity.Figure;

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jPanelPrincipal;
	private MenuBarr menuBarr;
	private CenterPanel centerPanel;
	private JDialogClient jDialogClient;
	private JDialogServer jDialogServer;
	public MyPanel mainPanel;
	private static String option = "";
	private static String tittleFrame = "BALL GAME";
	private Controller controller;

	public JFramePrincipal(ActionListener actionListener, IGame data) {
		super(tittleFrame + option);
		jPanelPrincipal = new JPanel();
		menuBarr = new MenuBarr(this, actionListener);
		centerPanel = new CenterPanel(data);
		jDialogClient = new JDialogClient(actionListener, this);
		jDialogServer = new JDialogServer(actionListener, this);
		mainPanel = new MyPanel();
		this.setSize(400, 800);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		this.add(jPanelPrincipal);
		jPanelPrincipal.setLayout(new BorderLayout());
		jPanelPrincipal.setBackground(Color.BLUE);
		jPanelPrincipal.add(centerPanel, BorderLayout.CENTER);
	}

	public void visibilityDialogClient(Boolean visibility) {
		jDialogClient.visibleDialogClient(visibility);
	}

	public int getPortClient() {
		return jDialogClient.getPort();
	}

	public String getIpClient() {
		return jDialogClient.getIp();
	}

	public void visibilityDialogServer(boolean visibility) {
		jDialogServer.visibleDialogServer(visibility);
	}

	public int getPortServer() {
		return jDialogServer.getPort();
	}

	public void refreshViewServer(IGame gameData) {
		try {
			centerPanel.updateGameServer(gameData);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void refreshViewClient(IGame gameData) {

		centerPanel.updateGameClient(gameData);
	}

	public void refreshFrame(IGame gameData) {
		option = gameData.getTittLeServer();
		repaint();
	}

	public void addComponent(Figure figure) {
		centerPanel.addComponent(figure);
	}
}
