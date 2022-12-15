package view;

import java.awt.*;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.IGame;
import models.modelFigures.entity.Figure;
import view.viewFigures.MyPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	public MyPanel myPanel;
	private JLabel JLStart;
	private JButton JBAddBubble;

	public GamePanel() {
		// gamePanel = new JPanel();
		myPanel = new MyPanel();
		buttonPanel = new JPanel();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(200, 800));
		this.initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		this.add(myPanel, BorderLayout.CENTER);
		this.add(buttonPanel(), BorderLayout.SOUTH);

	}

	/*
	 * public Component gamePanel() {
	 * gamePanel.setBackground(Color.decode("#DEF9F8"));
	 * gamePanel.setVisible(true);
	 * return gamePanel;
	 * }
	 */
	public Component buttonPanel() {
		JBAddBubble = new JButton();
		buttonPanel.add(Utilities.button(JBAddBubble, new Dimension(100, 20), "Add"));
		buttonPanel.setVisible(true);

		JLStart = new JLabel();
		buttonPanel.add(Utilities.text(JLStart, Constants.GAME_FONT, "", Color.BLACK));
		return buttonPanel;
	}

	public void updateGameClient(IGame gameData) {
		JLStart.setText("Start Client");
		myPanel.update(getGraphics());
		repaint();
	}

	public void addComponent(Figure figure) {
		myPanel.addComponent(figure);
	}

}
