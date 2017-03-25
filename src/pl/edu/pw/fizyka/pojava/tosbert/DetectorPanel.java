package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetectorPanel extends JPanel { // Hubert Nowakowski
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    boolean detected;
    Font header = new Font("Liberation Sans", Font.BOLD, 12);
    JLabel detectorLabel;
    
    DetectorPanel(){
    	setLayout(new FlowLayout());
	setMinimumSize(new Dimension(250,125));
	setMaximumSize(new Dimension(250,125));
	setPreferredSize(new Dimension(250,125));
	setBackground(Color.WHITE);
	detected=true;
	detectorLabel= new JLabel("obraz detektora",JLabel.CENTER);
	this.add(detectorLabel);

    }
    
    public void paintComponent(Graphics g ){
	Graphics2D g2d = (Graphics2D) g;
	
	g2d.drawRect(75, 20, 100,100);
	
	if(detected){
	    g2d.setColor(Color.RED);
	    g2d.drawOval(100, 45, 50, 50);
	    g2d.fillOval(100, 45, 50, 50);
	}
	
	
    }
}
