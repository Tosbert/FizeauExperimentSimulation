package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DetectorImage extends JPanel { //Hubert Nowakowski

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    boolean detected;

    public DetectorImage() {

	setPreferredSize(new Dimension(101,101));
	this.detected=true;
    }

    @Override
    public void paintComponent(Graphics g ){
	Graphics2D g2d = (Graphics2D) g;


	g2d.setColor(Color.LIGHT_GRAY);
	g2d.drawRect(0, 0, 100,100);

	if(this.detected){
	    g2d.setColor(Color.RED);
	    g2d.drawOval(25,25, 50, 50);
	    g2d.fillOval(25,25, 50, 50);
	}


    }

}
