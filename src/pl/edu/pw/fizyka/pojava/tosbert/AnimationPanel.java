package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

public class AnimationPanel extends JPanel { // Hubert Nowakowski

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    boolean animationRunning;
    int vel;
    int n;
    int d;
    int R;

    Collection<Rectangle> movingObjects;
    ArrayList<WheelTooth> wheelTeeth;
    ArrayList<Rectangle> lightBeam;

    Rectangle wheel;
    Rectangle lightSource;
    Rectangle lightReciever;
    Rectangle fullMirror;
    Polygon partialMirror;

    Rectangle lightBeamBeforeWheel;
    Rectangle lightBeamToReciever;

    double height;
    double width;


    AnimationPanel(int vel ,int n ,int d, double width, double height){
	super();


	this.vel=vel;
	this.n=n;
	this.d=d;
	this.R = 10000;
	setBackground(Color.WHITE);

	this.animationRunning = false;


	this.movingObjects = new ArrayList<Rectangle>();

	this.wheel = new ResizeableRectangle( 0.45 , 0.1, 0.007, 0.4, width, height );

	this.wheelTeeth = new ArrayList<WheelTooth>();

	makeWheelTeeth(n);

	this.movingObjects.addAll(this.wheelTeeth);

	int fullMirrorX = (int)(this.wheel.getX() + (width-this.wheel.getX()) *(d/15000.0) );

	this.fullMirror = new Rectangle( fullMirrorX , (int)( this.wheel.getY()+this.wheel.getHeight()/4) ,15 , (int)(height*0.2) );

	this.lightSource = new ResizeableRectangle( 0.01 , 0.280 , 0.03 , 0.035, width, height  );

	this.lightReciever = new ResizeableRectangle( 0.3 , 0.55 , 0.02 , 0.05, width, height  );




	this.lightBeamBeforeWheel = new Rectangle(
		(int)this.lightSource.getX(),
		(  (int)(this.wheel.getY()+this.wheel.getHeight()/2)-5 ),
		(int)( this.wheel.getX()- this.lightSource.getX() ) ,
		4 );

	this.lightBeam = new ArrayList<Rectangle>();
	this. makeLightBeam();

	this.lightBeamToReciever = new Rectangle(
		(int)(this.lightReciever.getX()+(this.lightReciever.getWidth()/2)),
		(int)(this.wheel.getMaxY() + this.wheel.getY() )/2,
		4,
		(int)(this.lightReciever.getY()-this.lightSource.getY())
		);
	
	 int partialMirrorTopHeight = (int)( this.lightSource.getY()-height*0.08 );
	
	 int xPoly[] = {(int)( this.lightReciever.getX()+width*0.03 ) ,(int)( this.lightReciever.getX()-width*0.03 ) ,(int)( this.lightReciever.getX()-width*0.02 ),(int)( this.lightReciever.getX()+width*0.04 )};
	 int yPoly[] = {partialMirrorTopHeight ,partialMirrorTopHeight + (int)(height*0.2) ,partialMirrorTopHeight + (int)(height*0.2),partialMirrorTopHeight};


	
	/*
	int xPoly[] = { (int)( this.lightReciever.getX()+width*0.05 ),(int)( this.lightReciever.getX()-width*0.1 ),(int)( this.lightReciever.getX()+width*0.05 ),(int)( this.lightReciever.getX()-width*0.1 )};
	int yPoly[] = {(int)( this.lightSource.getY()-height*0.15 ),(int)( this.lightSource.getY()+height*0.15 ),(int)( this.lightSource.getY()-height*0.15 ),(int)( this.lightSource.getY()+height*0.15 )};
	
	*/
	this.partialMirror = new Polygon(xPoly, yPoly, xPoly.length);
	//this.partialMirror = new Rectangle( (int)(this.wheel.getX()-50) , (int)( this.wheel.getY())-100 ,20 , 100 );


    }



    @Override
    public void paintComponent(Graphics g ){
	Graphics2D g2d = (Graphics2D) g;

	g2d.setColor( Color.white);
	g2d.fill(new Rectangle(getWidth(),getHeight()));

	g2d.setColor(Color.GRAY);
	g2d.draw(this.wheel);
	g2d.fill(this.wheel);

	g2d.setColor(Color.LIGHT_GRAY);
	g2d.draw(this.fullMirror);
	g2d.fill(this.fullMirror);

	g2d.draw(this.partialMirror);
	g2d.fill(this.partialMirror);


	g2d.setColor(Color.RED);
	g2d.fill(this.lightBeamBeforeWheel);



	if( !detectCollision(this) )
	{
	    g2d.setColor(Color.RED);

	    for(Rectangle r : this.lightBeam){
		g2d.draw(r);
		g2d.fill(r);
	    }

	    g2d.fill(this.lightBeamToReciever);
	}


	g2d.setColor( Color.BLACK );
	for(Rectangle r : this.wheelTeeth)
	{
	    g2d.draw(r);
	    g2d.fill(r);
	}


	g2d.setColor(Color.WHITE);
	g2d.fill(new Rectangle((int)this.wheel.getX()-5,(int)(this.wheel.getY()+this.wheel.getHeight()),
		(int)(this.wheel.getWidth())+10,getHeight() - (int)(this.wheel.getY()+this.wheel.getHeight()) ));
	g2d.fill(new Rectangle((int)this.wheel.getX()-5,(int)this.wheel.getY()-100,
		(int)(this.wheel.getWidth())+10,100));

	g2d.setColor(new Color(0,59,111));
	g2d.draw(this.lightSource);
	g2d.fill(this.lightSource);

	g2d.setColor(new Color(0,59,111));
	g2d.draw(this.lightReciever);
	g2d.fill(this.lightReciever);

    }

    void makeWheelTeeth(int n){

	wheelTeeth.clear();

	int height = (int)(R * Math.PI/n);

	for(int ii=0; ii< (this.wheel.getHeight()+(4*height)); ii+=2*height)
	    wheelTeeth.add(new WheelTooth(
		    this.wheel,
		    (int)wheel.getX(),
		    (int)wheel.getY()+ii,
		    (int)wheel.getWidth(),
		    height) );
	repaint();

    }

    public void makeLightBeam(){
	this.lightBeam.clear();

	this.lightBeam.add( new Rectangle( (int)this.wheel.getX() , 
		(int)(this.wheel.getY()+this.wheel.getHeight()/2)-5  ,
		(int) (this.fullMirror.getX()-(int)this.wheel.getX()) , 3) 
		);
	this.lightBeam.add( new Rectangle( (int)(this.lightReciever.getX()+(this.lightReciever.getWidth()/2)) , 
		(int)(this.wheel.getY()+this.wheel.getHeight()/2) -2  ,
		(int) (this.fullMirror.getX()-(int)(this.lightReciever.getX()+(this.lightReciever.getWidth()/2))) , 3) 
		);
    }

    boolean detectCollision (AnimationPanel animation){

	if(!animation.animationRunning){
	    for(WheelTooth t : animation.wheelTeeth){
		if( ( (int)t.getY() < (int)(animation.wheel.getY() + animation.wheel.getHeight()/2 -5 ) ) &&
			( (int)(t.getY() + t.height) > (int)(animation.wheel.getY() + animation.wheel.getHeight()/2 -5 ) )	){
		    return true;
		}
	    }
	}
	else{

	    int w0 = calculateW0(this);

	    int tmp = animation.getVel();
	    while(tmp>2*w0){
		tmp-=2*w0;
	    }

	    if( tmp < w0 + 5 &&  tmp > w0 - 5 )
		return true;
	}
	return false;
    }

    int calculateW0(AnimationPanel animation){
	long c = 300000000;
	return (int) (c*Math.PI)/(2*animation.getD()*animation.getN()) ;
    }

    public void setVel(int vel) { this.vel = vel; }

    public void setN(int n) {this.n = n; }

    public void setD(int d) { this.d = d; }

    public int getVel() { return vel; }
    public int getD() { return d; }
    public int getN() { return n; }
}
