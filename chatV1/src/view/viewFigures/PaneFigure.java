package view.viewFigures;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaneFigure extends JPanel {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;

	private JLabel lblName;
	private JLabel lblTypeFigure;
	private JLabel lblWidth;
	private JLabel lblHeight;
	private JLabel lblSpeed;
	private JLabel lblAngle;

	private JTextField txtName;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtSpeed;
	private JTextField txtAngle;

	private JComboBox<String> CBTypeFigure;

	public String getTxtName() {
		return txtName.getText();
	}

	public int getTxtWidth() {
		return Integer.parseInt(txtWidth.getText());
	}

	public int getTxtheight() {
		return Integer.parseInt(txtHeight.getText());
	}

	public double getTxtSpeed() {
		return Double.parseDouble(txtSpeed.getText());
	}

	public String getTxtAngle() {
		return txtSpeed.getText();
	}

	public String getComboText() {
		return (String) CBTypeFigure.getSelectedItem();
	}

	public PaneFigure() {
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);

		lblName = new JLabel("<html>Nombre:<hr>");
		lblName.setFont(new Font("Calibri", Font.BOLD, 16));
		gbc.insets = new Insets(0, 20, 0, 30);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(lblName, gbc);

		txtName = new JTextField(7);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(txtName, gbc);

		lblTypeFigure = new JLabel("<html>Tipo de figura:<hr>");
		lblTypeFigure.setFont(new Font("Calibri", Font.BOLD, 16));
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(lblTypeFigure, gbc);

		CBTypeFigure = new JComboBox<String>();
		gbc.gridx = 1;
		gbc.gridy = 1;
		CBTypeFigure.addItem("Ovalo");
		CBTypeFigure.addItem("Cuadrado");
		CBTypeFigure.addItem("String");
		this.add(CBTypeFigure, gbc);

		lblWidth = new JLabel("<html>Ancho:<hr>", JLabel.LEFT);
		lblWidth.setFont(new Font("Calibri", Font.BOLD, 16));
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(lblWidth, gbc);

		txtWidth = new JTextField(7);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(txtWidth, gbc);

		lblHeight = new JLabel("<html>Alto:<hr>", JLabel.LEFT);
		lblHeight.setFont(new Font("Calibri", Font.BOLD, 16));
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(lblHeight, gbc);

		txtHeight = new JTextField(7);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(txtHeight, gbc);

		lblSpeed = new JLabel("<html>Velocidad:<hr>", JLabel.LEFT);
		lblSpeed.setFont(new Font("Calibri", Font.BOLD, 16));
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(lblSpeed, gbc);

		txtSpeed = new JTextField(7);
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.add(txtSpeed, gbc);

		lblAngle = new JLabel("<html>Angulo:<hr>", JLabel.LEFT);
		lblAngle.setFont(new Font("Calibri", Font.BOLD, 16));
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(lblAngle, gbc);

		txtAngle = new JTextField(7);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(txtAngle, gbc);

	}

}
