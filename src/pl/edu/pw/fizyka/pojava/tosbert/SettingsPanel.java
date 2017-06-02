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

public class SettingsPanel extends JPanel { //Antonina Pater, Hubert Nowakowski
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	JLabel settingsLabel;
	JComboBox<Integer> nTeeth;
	JLabel teethLabel;
	JComboBox<Integer> distance;
	JLabel distanceLabel;
	JSlider velSlider;
	JLabel velSliderLabel;
	JLabel velLabel;
	Font mainFont = new Font("Liberation Sans", Font.PLAIN, 12);
	Font header = new Font("Liberation Sans", Font.BOLD, 12);

	public SettingsPanel() {

		setLayout(new GridBagLayout());
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
		Integer[] teeth = {500, 600, 700, 720, 800, 1000};
		this.nTeeth = new JComboBox<Integer>(teeth);
		c.gridx = 2;
		c.gridy = 1;
		c.anchor=GridBagConstraints.LINE_END;
		this.nTeeth.setFont(this.mainFont);
		this.add(this.nTeeth,c);

		this.distanceLabel = new JLabel("Odległość od lustra: ");
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(2,0,0,0);
		c.anchor=GridBagConstraints.LINE_START;
		this.distanceLabel.setFont(this.mainFont);
		this.add(this.distanceLabel,c);
		Integer[] dist = {5000, 6000, 7000, 8000, 8633 , 9000, 10000};
		this.distance = new JComboBox<Integer>(dist);
		c.gridx = 2;
		c.gridy = 2;
		c.anchor=GridBagConstraints.LINE_END;
		this.distance.setFont(this.mainFont);
		this.add(this.distance,c);


		this.velSliderLabel = new JLabel("Prędkośc obrotu koła: ");
		c.gridx = 0;
		c.gridy = 3;
		c.anchor=GridBagConstraints.LINE_START;
		this.velSliderLabel.setFont(this.mainFont);
		this.add(this.velSliderLabel,c);

		this.velLabel = new JLabel("200");
		this.velLabel.setFont(this.mainFont);
		c.gridx = 1;
		c.gridy = 3;
		c.anchor=GridBagConstraints.LINE_END;
		this.add(this.velLabel,c);

		this.velSlider = new JSlider(0,2000,200);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.insets = new Insets(0,0,7,0);
		c.fill= GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.LINE_END;

		this.velSlider.setBackground(Color.WHITE);

		this.velSlider.setMajorTickSpacing(5);
		this.velSlider.setSnapToTicks(true);
		this.add(this.velSlider,c);


	}



}
