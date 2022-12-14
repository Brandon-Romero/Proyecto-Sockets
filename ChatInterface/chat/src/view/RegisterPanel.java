package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;

public class RegisterPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel JLClient, JLChat, JLSend;
	private JTextArea JTClients, JTChat, JTSend;
	private JButton JBSend;
	
	public RegisterPanel() {
		this.setBackground(Color.decode("#BEE2FF"));
		this.setPreferredSize(new Dimension(200,800));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.initComponents();
		this.setVisible(true);
	}
	
	public void initComponents() {
		this.add(Utilities.space(new Dimension(20, 20)));
		JLClient = new JLabel();
		this.add(Utilities.text(JLClient, Constants.GAME_FONT, "Clients", Color.BLACK));
		this.add(Utilities.space(new Dimension(20, 20)));
		
		JTClients = new JTextArea();
		this.add(Utilities.textArea(JTClients, new Dimension(100,70)));
		this.add(Utilities.space(new Dimension(40, 40)));
		
		JLChat = new JLabel();
		this.add(Utilities.text(JLChat, Constants.GAME_FONT, "Chat", Color.BLACK));
		this.add(Utilities.space(new Dimension(20, 20)));
		
		JTChat = new JTextArea();
		this.add(Utilities.textArea(JTChat, new Dimension(100,70)));
		this.add(Utilities.space(new Dimension(40, 40)));
		
		JLSend = new JLabel();
		this.add(Utilities.text(JLSend, Constants.GAME_FONT, "Send Message", Color.BLACK));
		this.add(Utilities.space(new Dimension(20, 20)));
		
		JTSend = new JTextArea();
		this.add(Utilities.textArea(JTSend, new Dimension(100,20)));
		this.add(Utilities.space(new Dimension(40, 40)));
		
		JBSend = new JButton();
		this.add(Utilities.button(JBSend, new Dimension(50,30),"Send"));
		this.add(Utilities.space(new Dimension(40, 40)));
	}

}
