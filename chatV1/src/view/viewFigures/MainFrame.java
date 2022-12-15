package view.viewFigures;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import models.modelFigures.entity.Figure;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBarrr jMenuBar;
	public MyPanel mainPanel;

	public MainFrame(ActionListener actionListener) {
		super("Figuras");
		jMenuBar = new JMenuBarrr(this, actionListener);
		this.setSize(new Dimension(600, 500));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		initComponents(actionListener);
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener) {
		mainPanel = new MyPanel();
		this.getContentPane().add(mainPanel);
	}
}
