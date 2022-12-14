package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.*;
import java.awt.event.ActionListener;

public class JFramePrincipal extends JFrame  {

	private static final long serialVersionUID = 1L;
	
	private JPanel jPanelPrincipal;
	private MenuBarr menuBarr;
	private CenterPanel centerPanel;
	private static String option = "";
	private static String tittleFrame = "BALL GAME" + option ;
	
	public JFramePrincipal(ActionListener actionListener) {
		super(tittleFrame);
		jPanelPrincipal = new JPanel();
		menuBarr = new MenuBarr(this,actionListener);
		centerPanel = new CenterPanel();
		this.setSize(400, 800);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.initComponents();
		this.setVisible(true);
	}
	
	public void initComponents() {
		this.add(jPanelPrincipal);
		jPanelPrincipal.setLayout(new BorderLayout());
		jPanelPrincipal.setBackground(Color.BLUE);
		jPanelPrincipal.add(centerPanel, BorderLayout.CENTER);
	}

}
