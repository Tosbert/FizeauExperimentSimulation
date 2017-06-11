package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FizeauButtonListener implements ActionListener{	
	/**
	 * Antonina Pater
	 * ActionListener ustawiający parametry takiej jak w ogryginalnym eksperymencie.
	 */

	Frame frame;
	public FizeauButtonListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.bottom.settings.nTeeth.setSelectedItem(720);
		frame.bottom.settings.distance.setSelectedItem(8633);
		frame.bottom.settings.velSlider.setValue(75);

		this.frame.bottom.graph.clearData();
		this.frame.bottom.graph.updateChart(this.frame.bottom.graph.data);

		this.frame.animation.repaint();

	}

}
