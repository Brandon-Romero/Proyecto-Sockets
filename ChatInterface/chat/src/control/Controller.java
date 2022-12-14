package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.JFramePrincipal;

public class Controller implements ActionListener {
	
	private JFramePrincipal jFramePrincipal;
	
	public Controller() {
		jFramePrincipal = new JFramePrincipal(this);
		jFramePrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case C_CLIENT:
			System.out.println("cliente entro");
			break;
		case C_SERVER:
			System.out.println("servidor");
			break;
			
		case C_EXIT:
			System.out.println("close");
			break;

		default:
			break;
		}
		
	}

}
