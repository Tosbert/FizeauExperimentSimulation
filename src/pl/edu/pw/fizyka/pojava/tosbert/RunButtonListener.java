package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RunButtonListener implements ActionListener{
	/**
	 * Hubert Nowakowski, Antonina Pater
	 * Action listener obsługujący przycisk uruchomienia/zatrzymania animacji.
	 */
	Frame frame;

	public RunButtonListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.frame.animation.animationRunning) {
			this.frame.animation.animationRunning = false;
			frame.bottom.runButtonPanel.runButton.setText("START");
			frame.repaint();
		}
		else{
			this.frame.animation.animationRunning = true;
			frame.bottom.runButtonPanel.runButton.setText("STOP");
			this.frame.startAnimation();
		}

		this.frame.animation.setVel(this.frame.bottom.settings.velSlider.getValue());

		frame.updateAnimation();
	}

}
