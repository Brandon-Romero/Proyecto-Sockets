package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.net.UnknownHostException;

import models.IGame;
import models.modelFigures.entity.Figure;

public class CenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private RegisterPanel registerPanel;
	private GamePanel gamePanel;

	public CenterPanel(IGame data) {
		registerPanel = new RegisterPanel(data);
		gamePanel = new GamePanel();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		this.add(gamePanel);
		this.add(registerPanel);
	}

	public void updateGameServer(IGame gameData) throws UnknownHostException {
		registerPanel.updateGameServer(gameData);
	}

	public void updateGameClient(IGame gameData) {
		gamePanel.updateGameClient(gameData);
	}

	public void addComponent(Figure figure) {
		gamePanel.addComponent(figure);
	}
}
