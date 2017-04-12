package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsPanel extends JPanel { //Antonina Pater, Hubert Nowakowski
    /**
     *
     */
    private static final long serialVersionUID = 1L;



    JLabel settingsLabel;
    JComboBox<String> nTeeth;
    JLabel teethLabel;
    JComboBox<String> distance;
    JLabel distanceLabel;
    JSlider velSlider;
    JLabel velSliderLabel;
    JLabel velLabel;
    Font mainFont = new Font("Liberation Sans", Font.PLAIN, 12);
    Font header = new Font("Liberation Sans", Font.BOLD, 12);

    public SettingsPanel() {

	    this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	
		setPreferredSize(new Dimension(250,120));
		setBackground(Color.WHITE);
	
		this.settingsLabel = new JLabel("USTAWIENIA PARAMETRÓW ANIMACJI");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(0,0,2,0);
		this.settingsLabel.setFont(this.header);
		this.add(this.settingsLabel,c);
	
		this.teethLabel = new JLabel("Liczba ząbków: ");
		c.gridx = 0;
		c.gridy = 1;
		c.anchor=GridBagConstraints.LINE_START;
		this.teethLabel.setFont(this.mainFont);
		this.add(this.teethLabel,c);
		String[] teeth = {"600", "500", "700", "800"};
		this.nTeeth = new JComboBox<String>(teeth);
		c.gridx = 2;
		c.gridy = 1;
		c.anchor=GridBagConstraints.LINE_END;
		this.nTeeth.setFont(this.mainFont);
		this.nTeeth.addActionListener(this.nTeeth);
		this.add(this.nTeeth,c);
	
		this.distanceLabel = new JLabel("Odległość od lustra: ");
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(2,0,0,0);
		c.anchor=GridBagConstraints.LINE_START;	
		this.distanceLabel.setFont(this.mainFont);
		this.add(this.distanceLabel,c);
		String[] dist = {"600", "500", "700", "800"};
		this.distance = new JComboBox<String>(dist);
		c.gridx = 2;
		c.gridy = 2;
		c.anchor=GridBagConstraints.LINE_END;
		this.distance.setFont(this.mainFont);
		this.distance.addActionListener(this.distance);
		this.add(this.distance,c);
	
	
		this.velSliderLabel = new JLabel("Prędkośc obrotu koła: ");
		c.gridx = 0;
		c.gridy = 3;
		c.anchor=GridBagConstraints.LINE_START;	
		this.velSliderLabel.setFont(this.mainFont);
		this.add(this.velSliderLabel,c);
		this.velSlider = new JSlider(0,10000,0);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.insets = new Insets(0,0,7,0);
		c.fill= GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.LINE_END;	
		
		velSlider.setMinorTickSpacing(10);
		velSlider.setSnapToTicks(true);
		this.add(this.velSlider,c);

	

    }



}
