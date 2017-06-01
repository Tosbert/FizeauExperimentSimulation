package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RunButtonListener implements ActionListener{
    Frame frame;

    public RunButtonListener(Frame frame) {
	this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if(this.frame.animation.animationRunning) {
	    this.frame.animation.animationRunning = false;
	    System.out.println("Animation stopped.");
	    frame.bottom.runButtonPanel.runButton.setText("START");
	    this.frame.stopAnimation();
	}
	else{
	    this.frame.animation.animationRunning = true;
	    System.out.println("Animation started.");
	    frame.bottom.runButtonPanel.runButton.setText("STOP");
	    this.frame.startAnimation();
	}


	int vel = this.frame.bottom.settings.velSlider.getValue();
	int w0 = this.frame.animation.calculateW0(this.frame.animation);	
	System.out.println(w0);
	int Qmax = 255;
	int Q = 255;

	int x = (int) (vel/ 25.0);
	while(vel>2*w0){
	    vel-=2*w0;
	}

	double ratio = (double) vel/w0;

	for(int ii = 0; ii < (double) 10000/w0; ii+=3 )
	{
	    if( (vel > w0*ii ) &&( vel < w0*(ii+1) ) ){
		Q = (int) (Qmax * ( 1 - ratio ));
		break;
	    }
	    if( vel > w0*(ii+1) && vel < w0*(ii+2) ){
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
