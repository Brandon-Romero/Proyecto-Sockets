package view.viewFigures;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaneButtonsColor extends JPanel {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;

	private JButton btnAccept;
	private JButton btnCancel;

	public PaneButtonsColor(ActionListener listener) {
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);

		btnAccept = new JButton("Aceptar");
		btnAccept.addActionListener(listener);
		btnAccept.setActionCommand("cambiarColor");
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(btnAccept, gbc);

		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(listener);
		btnCancel.setActionCommand("cerrarVentana");
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(btnCancel, gbc);
	}

}
