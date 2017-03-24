package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsPanel extends JPanel {

	
	JLabel settingsLabel;
	JComboBox nTeeth;
	JLabel teethLabel;
	JComboBox distance;
	JLabel distanceLabel;
	JSlider velocity;
	JLabel velocityLabel;
	JLabel vLabel;
	Font mainFont = new Font("Liberation Sans", Font.PLAIN, 12);
	
	public SettingsPanel() {
		
		setLayout(new FlowLayout());
		this.setMinimumSize(new Dimension(250,120));
		this.setMaximumSize(new Dimension(250,120));
		this.setPreferredSize(new Dimension(250,120));
		
		settingsLabel = new JLabel("USTAWIENIA PARAMETRÓW ANIMACJI");
		settingsLabel.setFont(mainFont);
		this.add(settingsLabel);
		
		teethLabel = new JLabel("Liczba ząbków: ");
		teethLabel.setFont(mainFont);
		this.add(teethLabel); 
		String[] teeth = {"600", "500", "700", "800"}; 
		nTeeth = new JComboBox(teeth);
		nTeeth.setFont(mainFont);
		nTeeth.addActionListener(nTeeth);
		this.add(nTeeth);
		
		distanceLabel = new JLabel("Odległość od lustra: ");
		distanceLabel.setFont(mainFont);
		this.add(distanceLabel);
		String[] dist = {"600", "500", "700", "800"}; 
		distance = new JComboBox(dist);
		distance.setFont(mainFont);
		distance.addActionListener(distance);
		this.add(distance);
		 
		
		velocityLabel = new JLabel("Prędkośc obrotu koła: ");
		velocityLabel.setFont(mainFont);
		this.add(velocityLabel);
		velocity = new JSlider(0,100,0); 
		this.add(velocity);
		vLabel = new JLabel(" ");
		vLabel.setFont(mainFont);
		this.add(vLabel);
		velocity.addChangeListener( new ChangeListener() {
		       @Override
		       public void stateChanged(ChangeEvent ce) {
		    	   vLabel.setText( Integer.toString(velocity.getValue()) );
		       }
		      });
		
		
	}



}
