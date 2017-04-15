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
	frame.bottom.settings.velLabel.setText( Integer.toString(frame.bottom.settings.velSlider.getValue()) );
	
	frame.animation.setVel(frame.bottom.settings.velSlider.getValue());
    }

}
