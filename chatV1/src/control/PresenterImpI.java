package control;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import models.modelFigures.entity.Figure;
import models.modelFigures.entity.FigureType;
import models.modelFigures.model.Threads;
import view.*;
import view.viewFigures.JFrameColor;
import view.viewFigures.JFrameFigure;
import view.viewFigures.MainFrame;

public class PresenterImpI implements ActionListener {

	private JFrameColor JFColor;
	private JFrameFigure JFFigure;
	private MainFrame JFMain;

	private Threads gameThread;

	public PresenterImpI() {
		JFMain = new MainFrame(this);
		JFMain.setVisible(true);
		JFMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameThread = new Threads(JFMain);
		initialFigures();
	}

	private void initialFigures() {
		Figure figure1 = new Figure("Figura 1", FigureType.CIRCLE, 90, 2, new Dimension(25, 25), 200, 200);
		JFMain.mainPanel.add(figure1);
		gameThread = new Threads(JFMain.mainPanel);
		gameThread.creatThread(figure1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "iniciar":
				startGame();
			case "parar":
				stopGame();
			case "nueva":
				showJFigure();
			case "agregarFigura":
				newfigureAdd();
			case "configuracion":
				showJFrameColor();
			case "cambiarColor":
				changeColors();
			case "cerrarVentana":
				exitFigureFrame();
		}
	}

	private void startGame() {
		for (int i = 0; i < gameThread.sizeArray(); i++) {
			gameThread.getThread(i).resume();
		}
	}

	private void stopGame() {
		for (int i = 0; i < gameThread.sizeArray(); i++) {
			gameThread.getThread(i).suspend();
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
		JFMain.mainPanel.add(figure);
		gameThread = new Threads(JFMain.mainPanel);
		gameThread.creatThread(figure);
	}

	private void showJFrameColor() {
		JFColor = new JFrameColor(this);
		JFColor.setVisible(true);
		JFColor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void changeColors() {
		JFMain.mainPanel.setBackground(JFColor.getColor());
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

	public static void main(String[] args) {
		new PresenterImpI();
	}

}
