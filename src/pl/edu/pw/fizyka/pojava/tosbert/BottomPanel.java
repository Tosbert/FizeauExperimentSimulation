package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JPanel;

public class BottomPanel extends JPanel { //Antonina Pater

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    SettingsPanel settings;
    RunButtonPanel runButtonPanel;
    DetectorPanel detectorPanel;
    GraphPanel graph;
 //   GraphFrame graph;


    public BottomPanel() throws HeadlessException {
	setBackground(Color.WHITE);

	setLayout(new GridLayout(1,3,3,3));


	setPreferredSize(new Dimension(800,130));

	this.settings = new SettingsPanel();
	this.add(this.settings);

	this.runButtonPanel = new RunButtonPanel();
	this.add(this.runButtonPanel);

	this.detectorPanel = new DetectorPanel();
	this.add(this.detectorPanel);

	this.graph = new GraphPanel();
	this.add(graph);
	//this.graph.setLocation(getX()+800, (getY()));
	//this.graph.setVisible(true);
    }


}
