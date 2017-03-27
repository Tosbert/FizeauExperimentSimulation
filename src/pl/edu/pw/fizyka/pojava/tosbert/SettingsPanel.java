package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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

	setLayout(new FlowLayout());
	setMinimumSize(new Dimension(250,125));
	setMaximumSize(new Dimension(250,125));
	setPreferredSize(new Dimension(250,125));
	setBackground(Color.WHITE);

	this.settingsLabel = new JLabel("USTAWIENIA PARAMETRÓW ANIMACJI");
	this.settingsLabel.setFont(this.header);
	this.add(this.settingsLabel);

	this.teethLabel = new JLabel("Liczba ząbków: ");
	this.teethLabel.setFont(this.mainFont);
	this.add(this.teethLabel);
	String[] teeth = {"600", "500", "700", "800"};
	this.nTeeth = new JComboBox<String>(teeth);
	this.nTeeth.setFont(this.mainFont);
	this.nTeeth.addActionListener(this.nTeeth);
	this.add(this.nTeeth);

	this.distanceLabel = new JLabel("Odległość od lustra: ");
	this.distanceLabel.setFont(this.mainFont);
	this.add(this.distanceLabel);
	String[] dist = {"600", "500", "700", "800"};
	this.distance = new JComboBox<String>(dist);
	this.distance.setFont(this.mainFont);
	this.distance.addActionListener(this.distance);
	this.add(this.distance);


	this.velSliderLabel = new JLabel("Prędkośc obrotu koła: ");
	this.velSliderLabel.setFont(this.mainFont);
	this.add(this.velSliderLabel);
	this.velSlider = new JSlider(0,10000,0);
	this.velSlider.setBackground(Color.WHITE);
	
	velSlider.setMinorTickSpacing(10);
	velSlider.setSnapToTicks(true);

	this.add(this.velSlider);
	this.velLabel = new JLabel(" ");
	this.velLabel.setFont(this.mainFont);
	this.add(this.velLabel);
	this.velSlider.addChangeListener( new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent ce) {
		SettingsPanel.this.velLabel.setText( Integer.toString(SettingsPanel.this.velSlider.getValue()) );
	    }
	});


    }



}
