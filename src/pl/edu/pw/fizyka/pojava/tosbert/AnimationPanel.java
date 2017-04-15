package pl.edu.pw.fizyka.pojava.tosbert;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnimationPanel extends JPanel { // Hubert Nowakowski

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    boolean animationRunning;
    int vel;
    int n;
    int d;
    final int R = 10000;
    
    ScheduledExecutorService scheduler;
    
    Collection<Rectangle> movingObjects;
    ArrayList<WheelTooth> wheelTeeth;
    ArrayList<Rectangle> lightBeam;
    
    Rectangle wheel;
    Rectangle lightSource;
    Rectangle lightReciever;
    Rectangle fullMirror;
    Rectangle partialMirror;
    
    Rectangle lightBeamBeforeWheel; //always visible
    Rectangle lightBeamToReciever;

    
    AnimationPanel(int vel ,int n ,int d){
	super();
	this.vel=vel;
	this.n=n;
	this.d=d;
	setBackground(Color.WHITE);

	animationRunning = false;

	
	movingObjects = new ArrayList<Rectangle>();
	
	int height = (int) (R*Math.PI/n);
	
	this.wheel = new Rectangle( 250 , 60 , 11 , 200);
	
	this.wheelTeeth = new ArrayList<WheelTooth>();
	
	
	
	for(int ii=0; ii< (wheel.getHeight()+4*height); ii+=2*height){
	    this.wheelTeeth.add(new WheelTooth(
		    this.wheel,
		    (int)this.wheel.getX(),
		    (int)this.wheel.getY()+ii,
		    (int)this.wheel.getWidth(),
		    50) );
	}
	
	
	this.movingObjects.addAll(wheelTeeth);

	
	this.fullMirror = new Rectangle( (int)(this.wheel.getX()+d) , (int)( this.wheel.getY()) ,15 , 200 );

	this.partialMirror = new Rectangle( (int)(this.wheel.getX()-50) , (int)( this.wheel.getY())-100 ,20 , 100 );

	this.lightSource = new Rectangle( 10 , ((int)( this.wheel.getMaxY() + this.wheel.getY() )/2) -15 ,40 , 30 );

	this.lightReciever = new Rectangle(
		(int)this.wheel.getX()-115,
		(int)this.wheel.getY()+250,
		30 , 45);
	
	this.lightBeamBeforeWheel = new Rectangle(
		(int)this.lightSource.getX(),
		((int)( this.lightSource.getY() + this.lightSource.getWidth()/2 -5)) -5,
		(int)( this.wheel.getX()- this.lightSource.getX() ) ,
		4 );

	this.lightBeam = new ArrayList<Rectangle>();
	
				//TODO animate light and detect collisions	
	
	//light beam after wheel
	for(int ii=(int)(this.wheel.getX()+this.wheel.getWidth())+100;ii<=this.fullMirror.getX();ii+=5){
	    this.lightBeam.add( new Rectangle(ii,(int)( this.wheel.getMaxY() + this.wheel.getY() )/2-5,5,4) );
	}
	
	//light beam back from mirror
	for(int ii=(int)(this.fullMirror.getX())-5;ii>=(int)(this.lightReciever.getX()+this.lightReciever.getWidth()/2);ii-=5){
	    this.lightBeam.add( new Rectangle(ii,(int)( this.wheel.getMaxY() + this.wheel.getY() )/2,5,4) );
	}
	
	this.lightBeamToReciever = new Rectangle(
		(int)(this.lightReciever.getX()+this.lightReciever.getWidth()/2),
		(int)(this.wheel.getMaxY() + this.wheel.getY() )/2,
		4,150);
	
	this.movingObjects.addAll(lightBeam);
	
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

	Path2D.Double path = new Path2D.Double();
	path.append(this.partialMirror, false);
	AffineTransform t = new AffineTransform();
	t.rotate(Math.PI / 4);
	path.transform(t);
	g2d.fill(path);

	g2d.setColor(Color.RED);
	g2d.fill(this.lightBeamBeforeWheel);

		
	g2d.fill(this.lightBeamToReciever); //TODO Add lightBeamToReciever to the general lightBeam array

	g2d.setColor(new Color(0,59,111));
	g2d.draw(this.lightSource);
	g2d.fill(this.lightSource);

	g2d.setColor(new Color(0,59,111));
	g2d.draw(this.lightReciever);
	g2d.fill(this.lightReciever);
	
	for(Rectangle r : movingObjects){
	    if(r.getClass()==WheelTooth.class){
		g2d.setColor( Color.BLACK );
		g2d.draw(r);
		g2d.fill(r);
	    }
	    else
	    {
		g2d.setColor(Color.RED);
		g2d.fill(r);
	    }
	}
	g2d.setColor(Color.WHITE);
	g2d.fill(new Rectangle((int)wheel.getX()-5,(int)(wheel.getY()+wheel.getHeight()),
		(int)(wheel.getWidth())+10,this.getHeight() - (int)(wheel.getY()+wheel.getHeight()) ));
	g2d.fill(new Rectangle((int)wheel.getX()-5,(int)wheel.getY()-100,
		(int)(wheel.getWidth())+10,100));


    }

    void startAnimation(){
	scheduler = Executors.newScheduledThreadPool(1);
	scheduler.scheduleAtFixedRate( (new Runnable() {
	    @Override
	    public void run(){
		
		boolean rotate = false;
		int lastToothY = wheelTeeth.get(wheelTeeth.size()-1).y;

		for(WheelTooth t : wheelTeeth)
		{
		    if(lastToothY != t.moveTooth(vel,lastToothY)) {
			rotate = true; 
			lastToothY = t.moveTooth(vel,lastToothY);
		    }
		}
		if(rotate){
		    wheelTeeth.add(wheelTeeth.remove(0)); 
		}

		SwingUtilities.invokeLater(new Runnable(){
		    @Override
		    public void run(){
			repaint();
			}
		    });
		}	        
	    }),  0, 1, MILLISECONDS);
    }
    
    void stopAnimation(){
	scheduler.shutdown();
    }

    public void setVel(int vel) { this.vel = vel; }
    
    public void setN(int n) {this.n = n; }
    
    public void setD(int d) { this.d = d; }
    
    
    
}
