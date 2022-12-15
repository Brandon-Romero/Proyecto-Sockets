package models.modelFigures.entity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

public class Figure {

	private String name;
	private FigureType typeFigure;

	private double pointX = 0;
	private double pointY = 0;
	private double dx = 1;
	private double dy = -1;

	private double angle;
	private Color color;
	private Dimension dimension;
	private int speed;

	public Figure() {
		this.color = Color.BLACK;
	}

	public Figure(String name, FigureType typeFigure, double pointX, double pointY, Dimension dimension, double angle,
			int speed) {

		this.name = name;
		this.typeFigure = typeFigure;
		this.pointX = pointX;
		this.pointY = pointY;
		this.dimension = dimension;
		this.speed = speed;
		this.angle = angle;
		calculateDegree(angle);
	}

	public void calculateDegree(double angle) {
		this.dx = (double) (Math.cos(Math.toRadians(angle)));
		this.dy = (double) (Math.sin(Math.toRadians(angle)));
	}

	public void movement(Rectangle2D limit) {
		pointX += dx;
		pointY += -dy;

		if (pointX < limit.getMinX()) {
			pointX = limit.getMinX();
			dx = -dx;
		}
		if (pointX + dimension.getWidth() >= limit.getMaxX()) {
			pointX = limit.getMaxX() - dimension.getWidth();
			dx = -dx;
		}
		if (pointY < limit.getMinY()) {
			pointY = limit.getMinY();
			dy = -dy;
		}
		if (pointY + dimension.getHeight() >= limit.getMaxY()) {
			pointY = limit.getMaxY() - dimension.getHeight();
			dy = -dy;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FigureType getTypeFigure() {
		return typeFigure;
	}

	public void setTypeFigure(FigureType typeFigure) {
		this.typeFigure = typeFigure;
	}

	public double getPointX() {
		return pointX;
	}

	public void setPointX(double pointX) {
		this.pointX = pointX;
	}

	public double getPointY() {
		return pointY;
	}

	public void setPointY(double pointY) {
		this.pointY = pointY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
