package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FizeauButtonListener implements ActionListener{

	Frame frame;
	public FizeauButtonListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.bottom.settings.nTeeth.setSelectedItem(720);
		frame.bottom.settings.distance.setSelectedItem(800);
		frame.bottom.settings.velSlider.setValue(800);

	}

}
