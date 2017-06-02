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
		int vel = this.frame.bottom.settings.velSlider.getValue();
		this.frame.bottom.settings.velLabel.setText( Integer.toString(vel) );

		this.frame.animation.setVel(this.frame.bottom.settings.velSlider.getValue());

		int w0 = this.frame.animation.calculateW0(this.frame.animation);	
		int Qmax = 255;
		int Q = 255;

		int x = (int) (vel/ 5.0);
		while(vel>2*w0){
			vel-=2*w0;
		}

		double ratio = (double) vel/w0;

		for(int ii = 0; ii < (int)(2000/w0); ii+=3 )
		{
			if( (vel >= w0*ii ) &&( vel <= w0*(ii+1) ) ){
				Q = (int) (Qmax * ( 1 - ratio ));
				break;
			}
			if( vel >= w0*(ii+1) && vel <= w0*(ii+2) ){
				Q = (int)(Qmax * ( ratio - 1) );
				break;
			}
		}
		int y = Q;		
		this.frame.bottom.detectorPanel.detectorImage.setQ(Q);

		if(this.frame.animation.animationRunning){
			this.frame.bottom.graph.setData(x,y);
			this.frame.bottom.graph.updateChart(this.frame.bottom.graph.data);
		}

	}

}
