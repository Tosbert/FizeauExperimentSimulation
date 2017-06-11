package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DistanceListener implements ItemListener{ 
	/**
	 * Hubert Nowakowski
	 * ActionListener ustawiający położenie lustra na ekranie.
	 */
	Frame frame;
	public DistanceListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			int d = (Integer)e.getItemSelectable().getSelectedObjects()[0];

			this.frame.animation.setD(d);
			this.frame.animation.fullMirror.x=(int)(this.frame.animation.wheel.getX() + 
					(this.frame.animation.getWidth()-this.frame.animation.wheel.getX())*(d/15000.0) );

			this.frame.animation.makeLightBeam();
			this.frame.bottom.graph.clearData();
			this.frame.bottom.graph.updateChart(this.frame.bottom.graph.data);
			this.frame.updateAnimation();
			this.frame.animation.repaint();

		}
	}

}
