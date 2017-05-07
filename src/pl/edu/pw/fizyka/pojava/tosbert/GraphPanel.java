package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraphPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraphPanel() {
		
		setLayout(new BorderLayout());
		XYSeries series = new XYSeries("XYGraph");
		 series.add(1, 1);
		 series.add(2, 2);
		 series.add(3, 3);
		 series.add(4,4);
		 series.add(5,5);
		 
		 XYSeriesCollection dataset = new XYSeriesCollection();
		 dataset.addSeries(series);

		 JFreeChart chart = ChartFactory.createXYLineChart(
		 null, // Title
		 "t/ s", // x-axis Label
		 "ω/ rad", // y-axis Label
		 dataset, // Dataset
		 PlotOrientation.VERTICAL, 
		 false, // Show Legend
		 true, // Use tooltips
		 false // Configure chart to generate URLs?
		 );
		 chart.getPlot().setBackgroundPaint( Color.WHITE );
		 ChartPanel cp = new ChartPanel(chart);
		 cp.setBackground(Color.WHITE);
		
		 add(cp, BorderLayout.CENTER);
	}

}
