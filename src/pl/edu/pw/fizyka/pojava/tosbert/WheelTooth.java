package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Rectangle;

public class WheelTooth extends Rectangle {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    Rectangle wheel;
    int height;
    int width;
    public WheelTooth( Rectangle wheel,int x, int y, int height, int width) {
	super(x, y, height, width);
	this.wheel = wheel;
	this.height = height;
	this.width = width;
    }
    
    void moveTooth(int vel){ 
	y-=vel;
	if( y<wheel.getY() ){
	    height -= wheel.getY() - y;
	    y = (int) wheel.getY();	    
	    this.setSize(height,width);
	}	
    }

}
