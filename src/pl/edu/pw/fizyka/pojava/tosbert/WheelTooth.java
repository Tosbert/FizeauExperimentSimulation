package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Rectangle;

public class WheelTooth extends Rectangle {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    Rectangle wheel;
    int maxHeight;
    int height;
    int width;
    public WheelTooth( Rectangle wheel, int x, int y, int width,int height) {
	super(x, y, width, height);
	this.wheel = wheel;
	this.maxHeight =height;
	this.height = height;
	this.width = width;
    }
    
    int moveTooth(int vel, int lastToothY){ 
	y-=vel%(2*maxHeight);
	if( y<wheel.getY()-maxHeight ){ 
	    this.y= lastToothY+2*maxHeight;
	    return y;  
	}   
	return lastToothY;
    }

}
