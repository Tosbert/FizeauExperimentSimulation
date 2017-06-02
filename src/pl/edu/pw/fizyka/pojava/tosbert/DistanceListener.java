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
	    this.frame.animation.fullMirror.x=(int)(this.frame.animation.wheel.getX() + 
		    (this.frame.animation.getWidth()-this.frame.animation.wheel.getX())*(d/15000.0) );


	    this.frame.animation.makeLightBeam();

	    for(int ii=0; ii<this.frame.bottom.graph.data.length; ii++){
		this.frame.bottom.graph.data[ii]=-1;
	    }
	    this.frame.bottom.graph.updateChart(this.frame.bottom.graph.data);

	    this.frame.animation.repaint();



	    int vel = this.frame.bottom.settings.velSlider.getValue();
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

}
