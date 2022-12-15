package view.viewFigures;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class JFrameColor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5456908179037985347L;

	private PaneColorSelector colorSelector;
	private PaneButtonsColor paneBtnColor;

	public JFrameColor(ActionListener listener) {
		super("Cambia el color");
		this.setSize(new Dimension(630, 430));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		initComponents(listener);
		this.setVisible(true);

	}

	private void initComponents(ActionListener listener) {
		colorSelector = new PaneColorSelector();
		this.add(colorSelector, BorderLayout.CENTER);

		paneBtnColor = new PaneButtonsColor(listener);
		this.add(paneBtnColor, BorderLayout.SOUTH);

	}

	public Color getColor() {
		return colorSelector.getColor();
	}

}
