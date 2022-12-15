package view.viewFigures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.IGame;
import models.modelFigures.entity.Figure;

public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Figure> figures;

	public MyPanel() {
		figures = new ArrayList<>();
	}

	public void add(Figure f) {
		figures.add(f);
	}

	public ArrayList<Figure> figureList() {
		return figures;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Figure figure : figures) {
			selectShape(g2, figure);
		}
	}

	private void selectShape(Graphics2D g2, Figure figure) {
		switch (figure.getTypeFigure()) {
			case CIRCLE:
				drawCircle(g2, figure);
			case RECTANGLE:
				drawRectangle(g2, figure);
			case STRING:
				drawString(g2, figure);
		}
	}

	private void drawString(Graphics2D g2, Figure figure) {
		g2.setFont(new Font("Georgian", Font.BOLD, (figure.getDimension().height)));
		g2.setColor(Color.BLACK);
		g2.drawString(figure.getName(), (int) figure.getPointX(), (int) figure.getPointY());
		g2.drawRect((int) figure.getPointX(), (int) figure.getPointY(), figure.getDimension().height,
				figure.getDimension().width);
	}

	private void drawRectangle(Graphics2D g2, Figure figure) {
		g2.setColor(figure.getColor());
		g2.fillRect((int) figure.getPointX(), (int) figure.getPointY(), figure.getDimension().width,
				figure.getDimension().height);
	}

	private void drawCircle(Graphics2D g2, Figure figure) {
		g2.setColor(figure.getColor());
		g2.fillOval((int) figure.getPointX(), (int) figure.getPointY(), figure.getDimension().width,
				figure.getDimension().height);
	}

	public void addComponent(Figure figure) {
		this.add(figure);
	}

	public void updateGameClient(IGame gameData) {
		paintComponent(getGraphics());
		repaint();
	}

}
