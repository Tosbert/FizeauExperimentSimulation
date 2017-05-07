package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DistanceListener implements ItemListener{
	Frame frame;
	public DistanceListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			int d = (Integer)e.getItemSelectable().getSelectedObjects()[0];
			this.frame.animation.setD(d);
			this.frame.animation.fullMirror.x=(int)this.frame.animation.wheel.getX()+d;

			this.frame.animation.repaint();
		}
	}

}
