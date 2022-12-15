package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Commands;

import java.awt.FlowLayout;

import java.awt.*;

import java.awt.event.ActionListener;

public class JDialogClient extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel JLIp, JLPort, JLColor;
	private JTextField JTIp, JTPort;
	private JButton JBRun, JBStop, JBCancel;
	private JPanel dataPanel, footerPanel;

	public JDialogClient(ActionListener actionListener, JFramePrincipal jFramePrincipal) {
		setModal(true);
		this.setTitle("Conexión cliente");
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
		dataPanel.add(Utilities.text(JLIp, Constants.GAME_FONT, "Ingrese la Ip:", Color.BLACK));

		JTIp = new JTextField();
		dataPanel.add(Utilities.textField(JTIp, Constants.GAME_FONT, "", Color.GRAY, new Dimension(20, 10)));

		JLPort = new JLabel();
		dataPanel.add(Utilities.text(JLPort, Constants.GAME_FONT, "Ingrese el puerto:", Color.BLACK));

		JTPort = new JTextField();
		dataPanel.add(Utilities.textField(JTPort, Constants.GAME_FONT, "", Color.GRAY, new Dimension(20, 10)));

		JLColor = new JLabel();
		dataPanel.add(Utilities.text(JLColor, Constants.GAME_FONT, "Seleccione un color", Color.BLACK));

		// selector de color
		return dataPanel;
	}

	public JPanel footerButtons(ActionListener actionListener) {
		footerPanel.setBackground(Color.WHITE);
		footerPanel.setLayout(new FlowLayout());

		JBRun = new JButton();
		JBRun.addActionListener(actionListener);
		JBRun.setActionCommand(Commands.C_RUN_CLIENT.toString());
		footerPanel.add(Utilities.button(JBRun, new Dimension(70, 20), "Run"));

		JBStop = new JButton();
		footerPanel.add(Utilities.button(JBStop, new Dimension(70, 20), "Stop"));

		JBCancel = new JButton();
		JBCancel.addActionListener(actionListener);
		JBCancel.setActionCommand(Commands.C_CANCEL_CLIENT.toString());
		footerPanel.add(Utilities.button(JBCancel, new Dimension(90, 20), "Cancel"));

		return footerPanel;
	}

	public String getIp() {
		String ip = JTIp.getText();
		return ip;
	}

	public int getPort() {
		int port = Integer.parseInt(JTPort.getText());
		return port;
	}

	public void visibleDialogClient(Boolean visibility) {
		this.setVisible(visibility);
	}

}