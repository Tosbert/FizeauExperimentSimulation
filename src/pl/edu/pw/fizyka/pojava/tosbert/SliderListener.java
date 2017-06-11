package pl.edu.pw.fizyka.pojava.tosbert;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener { 

	/**
	 * Hubert Nowakowski, Antonina Pater
	 * Action listener obsługujący ustawienia prędkości obrotu koła.
	 */
	Frame frame;

	public SliderListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		frame.updateAnimation();
	}

}
