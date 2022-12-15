package models.modelFigures.model;

import models.modelFigures.entity.Figure;

public class PlayAreaImpl {

	private Threads threads;

	public PlayAreaImpl() {
		threads = new Threads(null);
	}

	// public void createThread(Figure figure) {
	// threads.creatThread(figure);
	// }

	public void createFigure(Figure figure) {
		threads.creatThread(figure);
	}

}
