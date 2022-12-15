package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Commands;
import models.IGame;

import java.awt.*;

import java.awt.event.ActionListener;

public class JDialogServer extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel JLIp, JLPort;
	private JTextField JTPort;
	private JButton JBRun, JBStop, JBCancel;
	private JPanel dataPanel, footerPanel;

	public JDialogServer(ActionListener actionListener, JFramePrincipal jFramePrincipal) {
		setModal(true);
		this.setTitle("Conexión Servidor");
		this.setLayout(new BorderLayout());
		dataPanel = new JPanel();
		footerPanel = new JPanel();
		this.setBackground(Color.WHITE);
		this.setSize(300, 200);
		this.getContentPane().setBackground(Color.WHITE);
		this.initComponents(actionListener);
		this.setLocationRelativeTo(jFramePrincipal);
	}

	public void initComponents(ActionListener actionListener) {
		this.add(initDataPanel(), BorderLayout.CENTER);
		this.add(footerButtons(actionListener), BorderLayout.SOUTH);

	}

	public JPanel initDataPanel() {
		dataPanel.setBackground(Color.WHITE);
		dataPanel.setLayout(new GridLayout(3, 3, 20, 20));

		JLIp = new JLabel();
		dataPanel.add(Utilities.text(JLIp, Constants.GAME_FONT, "Ip: Localhost", Color.BLACK));

		JLPort = new JLabel();
		dataPanel.add(Utilities.text(JLPort, Constants.GAME_FONT, "Ingrese el puerto:", Color.BLACK));

		JTPort = new JTextField();
		dataPanel.add(Utilities.textField(JTPort, Constants.GAME_FONT, "", Color.GRAY, new Dimension(20, 10)));

		return dataPanel;
	}

	public JPanel footerButtons(ActionListener actionListener) {
		footerPanel.setBackground(Color.WHITE);
		footerPanel.setLayout(new FlowLayout());

		JBRun = new JButton();
		JBRun.addActionListener(actionListener);
		JBRun.setActionCommand(Commands.C_RUN_SERVER.toString());
		footerPanel.add(Utilities.button(JBRun, new Dimension(70, 20), "Run"));

		JBStop = new JButton();
		footerPanel.add(Utilities.button(JBStop, new Dimension(70, 20), "Stop"));

		JBCancel = new JButton();
		JBCancel.addActionListener(actionListener);
		JBCancel.setActionCommand(Commands.C_CANCEL_SERVER.toString());
		footerPanel.add(Utilities.button(JBCancel, new Dimension(90, 20), "Cancel"));

		return footerPanel;
	}

	public int getPort() {
		int port = Integer.parseInt(JTPort.getText());
		return port;
	}

	public void visibleDialogServer(Boolean visibility) {
		this.setVisible(visibility);
	}

}