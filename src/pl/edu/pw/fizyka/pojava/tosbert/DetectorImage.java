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
	int Q; //intensity

	public DetectorImage() {

		setPreferredSize(new Dimension(101,101));
		Q = 0;
	}

	@Override
	public void paintComponent(Graphics g ){

		Graphics2D g2d = (Graphics2D) g;


		g2d.setColor(Color.LIGHT_GRAY);
		g2d.drawRect(0, 0, 100,100);

		g2d.setColor( new Color( 255, 255-Q , 255-Q));
		g2d.drawOval(25,25, 50, 50);
		g2d.fillOval(25,25, 50, 50);

	}

	public void setQ(int Q){ this.Q = Q; } 
}
