package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class GraphFrame extends JFrame { //Hubert Nowakowski

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JFreeChart lineChart;
    
    public GraphFrame() {
	super("tytuł wykresu");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setMinimumSize(new Dimension(400,400));
	setMaximumSize(new Dimension(400,400));
	setPreferredSize(new Dimension(400,400));
	setBackground(Color.WHITE);
	
	

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

	
	    }
    




}
