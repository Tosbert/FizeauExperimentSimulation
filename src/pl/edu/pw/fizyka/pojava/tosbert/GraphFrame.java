package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;


public class GraphFrame extends JFrame { //Hubert Nowakowski

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //JFreeChart lineChart;
    ArrayList<Point> data;
    int x0 = 50;
    int xMax;
    int y0 = 350;
    int yMax;


    public GraphFrame() {
	super("tytuł wykresu");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setMinimumSize(new Dimension(600,400));
	setMaximumSize(new Dimension(600,400));
	setPreferredSize(new Dimension(600,400));
	setBackground(Color.WHITE);

	this.xMax = getWidth()-35;
	this.yMax = 50;
	
	this.data = new ArrayList<Point>();
	for(int ii=0; ii<200; ii++)
	    this.data.add(new Point((this.x0+(ii*1))-2,((this.y0-200)+ (ii*1))-2) );
	for(int ii=0; ii<200; ii++)
	    this.data.add(new Point((this.x0+200+(ii*1))-2,((this.y0)- (ii*1))-2) );

    }
    @Override
    public void paint( Graphics g){

	g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
	g.drawString("f(\u03C9)",10,getHeight()/2); //opis osi y

	g.drawLine(this.x0, this.y0, this.x0, this.yMax+5); 	// Y axis
	for(int ii=70; ii<=this.y0; ii+=10)
	    g.drawLine(45, ii, 55, ii);
	g.fillPolygon(new int[]{x0-5,x0,x0+5}, new int[]{yMax+10,yMax,yMax+10},3);
	
	
	
	g.drawString("\u03C9",getWidth()/2,375); //opis osi x

	g.drawLine(x0, this.y0, xMax-5, this.y0);	// X axis
	for(int ii=50; ii<=(getWidth()-50); ii+=10)
	    g.drawLine(ii, 345, ii, 355);
	g.fillPolygon(new int[]{xMax-10,xMax,xMax-10}, new int[]{y0-5,y0,y0+5},3);
	
	
	
	drawData(g);
    }
    private void drawData(Graphics g) {
	g.setColor(Color.BLUE);
	for( Point p : this.data)
	    g.fillOval(p.x,p.y,4,4);
    }




}
