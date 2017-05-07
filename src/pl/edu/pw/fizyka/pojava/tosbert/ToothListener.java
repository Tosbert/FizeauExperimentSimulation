package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToothListener implements ItemListener{
	Frame frame;
	public ToothListener(Frame frame) {
		this.frame = frame;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			int n = (Integer)e.getItemSelectable().getSelectedObjects()[0];

			this.frame.animation.setN(n);
			this.frame.animation.makeWheelTeeth( (int)(this.frame.animation.R * Math.PI/n) , frame.animation );
			this.frame.animation.repaint();
		}
	}

}
