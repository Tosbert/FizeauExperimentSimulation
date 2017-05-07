package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
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
	Rectangle partialMirror;

	Rectangle lightBeamBeforeWheel; //always visible
	Rectangle lightBeamToReciever;


	AnimationPanel(int vel ,int n ,int d){
		super();
		this.vel=vel;
		this.n=n;
		this.d=d;
		this.R = 10000;
		setBackground(Color.WHITE);

		this.animationRunning = false;


		this.movingObjects = new ArrayList<Rectangle>();

		int height = (int) ((this.R*Math.PI)/n);

		this.wheel = new Rectangle( 250 , 60 , 11 , 200);

		this.wheelTeeth = new ArrayList<WheelTooth>();


		makeWheelTeeth( height , this);

		this.movingObjects.addAll(this.wheelTeeth);


		this.fullMirror = new Rectangle( (int)(this.wheel.getX()+d) , (int)( this.wheel.getY()) ,15 , 200 );

		this.partialMirror = new Rectangle( (int)(this.wheel.getX()-50) , (int)( this.wheel.getY())-100 ,20 , 100 );

		this.lightSource = new Rectangle( 10 , ((int)( this.wheel.getMaxY() + this.wheel.getY() )/2) -15 ,40 , 30 );

		this.lightReciever = new Rectangle(
				(int)this.wheel.getX()-115,
				(int)this.wheel.getY()+250,
				30 , 45);


		this.lightBeamBeforeWheel = new Rectangle(
				(int)this.lightSource.getX(),
				(  (int)(this.wheel.getY()+this.wheel.getHeight()/2)-5 ),
				(int)( this.wheel.getX()- this.lightSource.getX() ) ,
				4 );

		this.lightBeam = new ArrayList<Rectangle>();
		this.lightBeam.add( new Rectangle( (int)this.wheel.getX() , 
				(int)(this.wheel.getY()+this.wheel.getHeight()/2)-5  ,
				(int) (this.fullMirror.getX()-(int)this.wheel.getX()) , 3) 
				);
		this.lightBeam.add( new Rectangle( (int)(this.lightReciever.getX()+(this.lightReciever.getWidth()/2)) , 
				(int)(this.wheel.getY()+this.wheel.getHeight()/2) -2  ,
				(int) (this.fullMirror.getX()-(int)(this.lightReciever.getX()+(this.lightReciever.getWidth()/2))) , 3) 
				);

		this.lightBeamToReciever = new Rectangle(
				(int)(this.lightReciever.getX()+(this.lightReciever.getWidth()/2)),
				(int)(this.wheel.getMaxY() + this.wheel.getY() )/2,
				4,150);

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

		g2d.setColor(new Color(0,59,111));
		g2d.draw(this.lightSource);
		g2d.fill(this.lightSource);

		g2d.setColor(new Color(0,59,111));
		g2d.draw(this.lightReciever);
		g2d.fill(this.lightReciever);

		if( !detectCollision(this) )
		{
			g2d.setColor(Color.RED);

			for(Rectangle r : this.lightBeam){
				g2d.draw(r);
				g2d.fill(r);
			}

			g2d.fill(this.lightBeamToReciever);
		}

		for(Rectangle r : this.movingObjects)
			if(r.getClass()==WheelTooth.class){
				g2d.setColor( Color.BLACK );
				g2d.draw(r);
				g2d.fill(r);
			}


		g2d.setColor(Color.WHITE);
		g2d.fill(new Rectangle((int)this.wheel.getX()-5,(int)(this.wheel.getY()+this.wheel.getHeight()),
				(int)(this.wheel.getWidth())+10,getHeight() - (int)(this.wheel.getY()+this.wheel.getHeight()) ));
		g2d.fill(new Rectangle((int)this.wheel.getX()-5,(int)this.wheel.getY()-100,
				(int)(this.wheel.getWidth())+10,100));


	}

	void makeWheelTeeth(int height , AnimationPanel animation){

		animation.wheelTeeth.clear();

		for(int ii=0; ii< (this.wheel.getHeight()+(4*height)); ii+=2*height)
			animation.wheelTeeth.add(new WheelTooth(
					this.wheel,
					(int)animation.wheel.getX(),
					(int)animation.wheel.getY()+ii,
					(int)animation.wheel.getWidth(),
					height) );
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
			
			if( tmp < w0 + 30 &&  tmp > w0 - 30 )
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
