package view;

import java.awt.*;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel gamePanel, buttonPanel;
	private JButton JBAddBubble;

	public GamePanel() {
		gamePanel = new JPanel();
		buttonPanel = new JPanel();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(200, 800));
		this.initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		this.add(gamePanel(), BorderLayout.CENTER);
		this.add(buttonPanel(), BorderLayout.SOUTH);

	}

	public Component gamePanel() {
		gamePanel.setBackground(Color.decode("#DEF9F8"));
		gamePanel.setVisible(true);
		return gamePanel;
	}
	
	public Component buttonPanel() {
		JBAddBubble = new JButton();
		buttonPanel.add(Utilities.button(JBAddBubble, new Dimension(100,20), "Add"));
		buttonPanel.setVisible(true);
		return buttonPanel;
	}

}