package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
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
	
	ValueAxis yAxis = plot.getRangeAxis();
	yAxis.setRange(0, 1.1);
	ValueAxis xAxis = plot.getDomainAxis();
	xAxis.setRange(0, 10000);
	
	ChartPanel cp = new ChartPanel(chart);
	cp.setBackground(Color.WHITE);

	add(cp, BorderLayout.CENTER);

    }


    public void setData(int x, int y){ data[x]= y; }

    public void updateChart(double[] data) {

	this.removeAll();
	this.revalidate();

	series = new XYSeries("XYGraph");
	for(int i=0; i<data.length;i++){
	    if(data[i]>-1){
		series.add(25*i , data[i]/255 );
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
	
	ValueAxis yAxis = plot.getRangeAxis();
	yAxis.setRange(0, 1.1);
	ValueAxis xAxis = plot.getDomainAxis();
	xAxis.setRange(0, 10000);
	
	ChartPanel cp = new ChartPanel(chart);
	cp.setBackground(Color.WHITE);

	this.setLayout(new BorderLayout());
	this.add(cp, BorderLayout.CENTER);
	this.repaint();
	/*
	    jPanel_GraphicsTop.removeAll();
	    jPanel_GraphicsTop.revalidate(); // This removes the old chart 
	    aChart = createChart(); 
	    aChart.removeLegend(); 
	    ChartPanel chartPanel = new ChartPanel(aChart); 
	    jPanel_GraphicsTop.setLayout(new BorderLayout()); 
	    jPanel_GraphicsTop.add(chartPanel); 
	    jPanel_GraphicsTop.repaint(); // This method makes the new chart appear
	 */
    }

}
