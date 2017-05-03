package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetectorPanel extends JPanel { // Hubert Nowakowski, Antonina Pater
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JPanel detectorImage;
    Font header = new Font("Liberation Sans", Font.BOLD, 12);
    JLabel detectorLabel;

    public DetectorPanel(){
	setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	setPreferredSize(new Dimension(250,130));
	setBackground(Color.WHITE);

	this.detectorLabel= new JLabel("OBRAZ DETEKTORA");
	c.gridx = 0;
	c.gridy = 0;
	c.anchor=GridBagConstraints.PAGE_START;
	this.detectorLabel.setFont(this.header);
	this.add(this.detectorLabel,c);

	this.detectorImage = new DetectorImage();
	c.gridx = 0;
	c.gridy = 1;
	c.insets = new Insets(5,0,5,0);
	c.anchor=GridBagConstraints.PAGE_START;
	this.add(this.detectorImage,c);

    }

}

