package models.modelFigures.model;

import java.awt.Component;
import java.util.ArrayList;

import models.modelFigures.entity.Figure;

public class Threads {

	private ArrayList<Thread> thread;
	private Component component;

	public Threads(Component component) {
		this.thread = new ArrayList<>();
		this.component = component;
	}

	public int sizeArray() {
		return thread.size();
	}

	public Thread getThread(int i) {
		return thread.get(i);
	}

	public void movedFigure(Figure figure) {
		figure.movement(component.getBounds());
	}

	public void creatThread(Figure figure) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				super.run();
				while (true) {
					try {
						movedFigure(figure);
						component.repaint();
						Thread.sleep(figure.getSpeed());
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		};
		thread.start();
		this.thread.add(thread);
	}

}
