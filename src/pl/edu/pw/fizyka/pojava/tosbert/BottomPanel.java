package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BottomPanel extends JPanel { //Antonina Pater
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SettingsPanel settings;
	RunButtonPanel runButton;
	GraphPanel graph;


	public BottomPanel() throws HeadlessException {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		settings = new SettingsPanel();
		this.add(settings);
		
		runButton = new RunButtonPanel();
		this.add(runButton);
		
		graph = new GraphPanel();
		this.add(graph);
		
		
		
		
	}
		

}
