package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SouthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel JLDescription;

	public SouthPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.initComponents();
		this.setVisible(true);
	}
	
	public void initComponents() {
		JLDescription = new JLabel();
		this.add(Utilities.text(JLDescription, Constants.GAME_FONT, "Description", Color.BLACK));
	}
}
