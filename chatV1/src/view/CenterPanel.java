package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;

import models.IGame;

public class CenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private RegisterPanel registerPanel;
	private GamePanel gamePanel;
	

	public CenterPanel(IGame data) {
		registerPanel= new RegisterPanel(data);
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
}
