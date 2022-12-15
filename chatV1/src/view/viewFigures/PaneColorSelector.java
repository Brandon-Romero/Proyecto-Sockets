package view.viewFigures;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PaneColorSelector extends JPanel {

	private static final long serialVersionUID = 1L;

	private JColorChooser colorChooser;

	public PaneColorSelector() {
		colorChooser = new JColorChooser();
		this.setBackground(Color.white);
		this.add(colorChooser);
	}

	public Color getColor() {
		return colorChooser.getColor();
	}

}
