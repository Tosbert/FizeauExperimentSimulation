package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraphPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    double[] data;
    XYSeries series;
    XYSeriesCollection dataset;
    JFreeChart chart;
    public GraphPanel() {

	setLayout(new BorderLayout());
	setBackground(Color.WHITE);

	data = new double[401];
	for(int ii=0; ii<data.length; ii++){
	    data[ii]=-1;
	}


	series = new XYSeries("XYGraph");

	/*
	dataset = new XYSeriesCollection();
	dataset.addSeries(series);


	chart = ChartFactory.createScatterPlot(
		null, // Title
		"ω [rad/s]", // x-axis Label
		"Q / Qmax", // y-axis Label
		dataset, // Dataset
		PlotOrientation.VERTICAL, 
		false, // Show Legend
		true, // Use tooltips
		false // Configure chart to generate URLs?
		);
	XYPlot plot = (XYPlot) chart.getPlot();
	plot.setBackgroundPaint( Color.WHITE );

	XYItemRenderer renderer = plot.getRenderer();
	renderer.setSeriesPaint(0, Color.RED);
	double delta = 2;
	Shape shape1 = new Rectangle2D.Double(-delta, -delta, delta, delta);
	renderer.setSeriesShape(0, shape1);

	ValueAxis yAxis = plot.getRangeAxis();
	yAxis.setRange(0, 1.1);
	ValueAxis xAxis = plot.getDomainAxis();
	xAxis.setRange(0, 2000);

	
	cp.setBackground(Color.WHITE);
	*/
	
	updateChart(data);
	
	ChartPanel cp = new ChartPanel(chart);
	add(cp, BorderLayout.CENTER);

    }


    public void setData(int x, int y){ data[x]= y; }

    public void updateChart(double[] data) {

	this.removeAll();
	this.revalidate();

	series = new XYSeries("XYGraph");
	for(int i=0; i<data.length;i++){
	    if(data[i]>-1){
		series.add(5*i , data[i]/255 );
	    }
	}

	dataset = new XYSeriesCollection();
	dataset.addSeries(series);


	chart = ChartFactory.createScatterPlot(
		null, // Title
		"ω [rad/s]", // x-axis Label
		"Q / Qmax", // y-axis Label
		dataset, // Dataset
		PlotOrientation.VERTICAL, 
		false, // Show Legend
		true, // Use tooltips
		false // Configure chart to generate URLs?
		);
	XYPlot plot = (XYPlot) chart.getPlot();
	plot.setBackgroundPaint( Color.WHITE );

	XYItemRenderer renderer = plot.getRenderer();
	renderer.setSeriesPaint(0, Color.RED);
	double delta = 2;
	Shape shape1 = new Rectangle2D.Double(-delta, -delta, delta, delta);
	renderer.setSeriesShape(0, shape1);
	
	ValueAxis yAxis = plot.getRangeAxis();
	yAxis.setRange(0, 1.1);
	ValueAxis xAxis = plot.getDomainAxis();
	xAxis.setRange(0, 2000);

	ChartPanel cp = new ChartPanel(chart);
	cp.setBackground(Color.WHITE);

	this.setLayout(new BorderLayout());
	this.add(cp, BorderLayout.CENTER);
	this.repaint();

    }

}
