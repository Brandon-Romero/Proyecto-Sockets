package control;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import models.IGame;
import models.entities.client.Client;
import models.entitties.server.Server;
import models.modelFigures.entity.Figure;
import models.modelFigures.entity.FigureType;
import models.modelFigures.model.Threads;
import view.GamePanel;
import view.JFramePrincipal;
import view.viewFigures.JFrameColor;
import view.viewFigures.JFrameFigure;

public class Controller implements ActionListener {

	private JFramePrincipal jFramePrincipal;
	private Server server;
	private Client client;
	private IGame data;
	private GamePanel gamePanel;
	//private PresenterImpI presenterImpI;//
	private Threads gameThread;
	String optionSelected = "";
	private JFrameColor JFColor;
	private JFrameFigure JFFigure;

	public Controller() {
		gamePanel = new GamePanel();
		jFramePrincipal = new JFramePrincipal(this, data);
		server = new Server();
		client = new Client();
		//presenterImpI = new PresenterImpI();
		gameThread = new Threads(jFramePrincipal);
		initialFigures();
		jFramePrincipal.setVisible(true);

		updateUi();
	}

	private void updateUi() {
		final Timer timerUpdate = new Timer(10, e -> {
			if (optionSelected == Commands.C_RUN_CLIENT.toString()) {
				jFramePrincipal.refreshViewServer(server);
				jFramePrincipal.refreshViewClient(client);
			}
		});
		timerUpdate.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
			case C_CLIENT:
				optionSelected = "C_CLIENT";
				jFramePrincipal.visibilityDialogClient(true);
				break;

			case C_SERVER:
				optionSelected = "C_SERVER";
				server.runnerConnectionThreads(5050);
				// jFramePrincipal.visibilityDialogServer(true);

				break;

			case C_EXIT:
				System.out.println("close");
				break;

			case C_RUN_SERVER:
				// rescatar datos

				server.runnerConnectionThreads(5050);
				optionSelected = "C_RUN_SERVER";

				jFramePrincipal.visibilityDialogServer(false);
				break;

			case C_CANCEL_SERVER:
				jFramePrincipal.visibilityDialogServer(false);
				break;

			case C_RUN_CLIENT:
				// rescatar datos
				client.runConnection(jFramePrincipal.getIpClient(), jFramePrincipal.getPortClient());
				optionSelected = "C_RUN_CLIENT";
				jFramePrincipal.visibilityDialogClient(false);
				break;

			case C_CANCEL_CLIENT:
				jFramePrincipal.visibilityDialogClient(false);
				break;

			case C_START:
				startGame();
				break;
			case C_STOP_FIGURES:
				stopGame();
				break;
			case C_NEW_FIGURE:
				showJFigure();
				break;

			case C_ADD_FIGURE:
				newfigureAdd();
				break;

			case C_CONFIGURATION:
				showJFrameColor();
				break;
			case C_CHOSE_COLOR:
				changeColors();
				break;

			case C_CLOSE_WINDOW:
				exitFigureFrame();
				break;

			default:
				break;
		}

	}

	private void initialFigures() {
		Figure figure1 = new Figure("Figura 1", FigureType.CIRCLE, 90, 2, new Dimension(25, 25), 200, 200);
		jFramePrincipal.addComponent(figure1);
		gameThread = new Threads(jFramePrincipal.mainPanel);
		gameThread.creatThread(figure1);

	}

	private void startGame() {
		for (int i = 0; i < gameThread.sizeArray(); i++) {
			gameThread.getThread(i).start();
			;
		}
	}

	private void stopGame() {
		for (int i = 0; i < gameThread.sizeArray(); i++) {
			gameThread.getThread(i).stop();
		}
	}

	private void showJFigure() {
		JFFigure = new JFrameFigure(this);
		JFFigure.setVisible(true);
		JFFigure.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void newfigureAdd() {
		Figure figure = new Figure();
		figure.setName(JFFigure.getTxtName());
		setFigureType(figure);
		figure.setDimension(new Dimension(JFFigure.getTxtWidth(), JFFigure.getTxtheight()));
		figure.setPointX(JFFigure.getWidth() / 2);
		figure.setPointY(JFFigure.getHeight() / 2);
		figure.setSpeed((int) JFFigure.getTxtSpeed());
		figure.setAngle(Double.parseDouble(JFFigure.getTxtAngle()));
		jFramePrincipal.mainPanel.add(figure);
		gameThread = new Threads(jFramePrincipal.mainPanel);
		gameThread.creatThread(figure);
	}

	private void showJFrameColor() {
		JFColor = new JFrameColor(this);
		JFColor.setVisible(true);
		JFColor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void changeColors() {
		jFramePrincipal.mainPanel.setBackground(JFColor.getColor());
		JFColor.getColor();
	}

	private void setFigureType(Figure figure) {
		switch (JFFigure.getComboText()) {
			case "Ovalo":
				figure.setTypeFigure(FigureType.CIRCLE);
			case "Cuadrado":
				figure.setTypeFigure(FigureType.RECTANGLE);
			case "String":
				figure.setTypeFigure(FigureType.STRING);
		}
	}

	private void exitFigureFrame() {
		JFFigure.setVisible(false);
	}

}
