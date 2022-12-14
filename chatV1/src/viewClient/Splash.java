package viewClient;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class Splash extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jpanelImage;
	private JButton jButton;
	private JLabel jLabelInfo;
	
	public Splash() throws Exception{
		super();
		this.jpanelImage = new JPanel();
		this.jLabelInfo = new JLabel();
		this.jButton = new JButton();
		init();
	}
	
	private void init() throws Exception{
		this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		this.jButton.setName("config");
		this.jButton.setSize(90, 20);
		this.add(jButton, BorderLayout.PAGE_START);
		
		this.add(this.jpanelImage, BorderLayout.NORTH);
		
		this.jLabelInfo.setText("algo");
		this.add(this.jLabelInfo,BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}
	
	
}
