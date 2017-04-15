package pl.edu.pw.fizyka.pojava.tosbert;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {

    Frame frame;

    public SliderListener(Frame frame) {
	this.frame = frame;
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
	this.frame.bottom.settings.velLabel.setText( Integer.toString(this.frame.bottom.settings.velSlider.getValue()) );

	this.frame.animation.setVel(this.frame.bottom.settings.velSlider.getValue());
    }

}
