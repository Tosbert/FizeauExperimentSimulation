package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToothListener implements ItemListener{
	/** 
	 * Hubert Nowakowski
	 * ActionListener do zmiany ilości zębów w kole.
	 */
	Frame frame;
	public ToothListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			int n = (Integer)e.getItemSelectable().getSelectedObjects()[0];

			this.frame.animation.setN(n);
			this.frame.animation.makeWheelTeeth( n );
			this.frame.bottom.graph.clearData();
			this.frame.bottom.graph.updateChart(this.frame.bottom.graph.data);
			this.frame.updateAnimation();
			this.frame.animation.repaint();

		}
	}

}
