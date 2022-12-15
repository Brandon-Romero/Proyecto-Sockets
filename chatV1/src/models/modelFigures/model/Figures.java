package models.modelFigures.model;

import java.util.ArrayList;

import models.modelFigures.entity.Figure;

public class Figures {

	private ArrayList<Figure> figures;

	public Figures() {
		figures = new ArrayList<>();
	}

	public void addFigure(Figure figure) {
		figures.add(figure);
	}

}
