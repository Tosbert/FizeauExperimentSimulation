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
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setMinimumSize(new Dimension(600,400));
	setMaximumSize(new Dimension(600,400));
	setPreferredSize(new Dimension(600,400));
	setBackground(Color.WHITE);
	
	xMax = getWidth()-35;
	yMax = getHeight()-50;
	
	data = new ArrayList<Point>();
	for(int ii=0; ii<30; ii++)
	    data.add(new Point((x0+ii*10)-2,(y0-300+ ii*10)-2) );
	for(int ii=0; ii<20; ii++)
	    data.add(new Point((x0+300+ii*10)-2,(y0- ii*10)-2) );
/*
	lineChart = ChartFactory.createLineChart(
		"wykres",
		"x","sin(x)",
		createDataset(),
		PlotOrientation.VERTICAL,false,false,false);
	lineChart.setBackgroundPaint(Color.white);
	ChartPanel chartPanel = new ChartPanel( lineChart );
	chartPanel.setPreferredSize( new Dimension( 300 , 300) );
	chartPanel.setBackground(Color.WHITE);
	this.add( chartPanel );
	}

	private DefaultCategoryDataset createDataset( ){
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	    for(int ii = 0; ii<=10; ii++)
		dataset.addValue(  Math.sin(Math.PI*ii/5) , "x" , ""+ ii );
	    return dataset;
*/
	
	    }
    public void paint( Graphics g){
	
	g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
	g.drawString("f(\u03C9)",10,getHeight()/2);
	
	g.drawLine(x0, y0-300, x0, y0); 	// Y axis
	for(int ii=70; ii<=y0; ii+=10)
	    g.drawLine(45, ii, 55, ii);
	
	g.drawString("\u03C9",getWidth()/2,375);
	
	g.drawLine(50, 350, xMax, yMax);	// X axis
	for(int ii=50; ii<=getWidth()-50; ii+=10)
	    g.drawLine(ii, 345, ii, 355); 
	
	drawData(g);
    }
    private void drawData(Graphics g) {
	g.setColor(Color.BLUE);
	for( Point p : data)
	    g.fillOval(p.x,p.y,4,4);
    }
    



}
