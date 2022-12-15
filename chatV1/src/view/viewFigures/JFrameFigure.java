package view.viewFigures;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class JFrameFigure extends JFrame {

	private static final long serialVersionUID = 1L;

	private PaneFigure paneOptions;
	private PaneButtonsFigure paneButtons;

	public JFrameFigure(ActionListener listener) {
		super("Agregar una figura");
		this.setSize(new Dimension(300, 320));
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		initComponents(listener);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initComponents(ActionListener listener) {
		paneOptions = new PaneFigure();
		this.add(paneOptions, BorderLayout.CENTER);

		paneButtons = new PaneButtonsFigure(listener);
		this.add(paneButtons, BorderLayout.SOUTH);
	}

	public String getTxtName() {
		return paneOptions.getTxtName();
	}

	public int getTxtWidth() {
		return paneOptions.getTxtWidth();
	}

	public int getTxtheight() {
		return paneOptions.getTxtheight();
	}

	public double getTxtSpeed() {
		return paneOptions.getTxtSpeed();
	}

	public String getTxtAngle() {
		return paneOptions.getTxtAngle();
	}

	public String getComboText() {
		return paneOptions.getComboText();
	}

}
