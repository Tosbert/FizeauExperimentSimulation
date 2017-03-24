package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RunButtonPanel extends JPanel { //Antonina Pater
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	JButton fizeauButton;
	JButton runButton;
	Font mainFont = new Font("Liberation Sans", Font.PLAIN, 12);
	
	public RunButtonPanel() {
		
		setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(150,120));
		this.setMaximumSize(new Dimension(120,120));
		this.setPreferredSize(new Dimension(250,120));
		
		
		fizeauButton =new JButton("Zrób to \n jak Fizeau");
		fizeauButton.setFont(mainFont);
		fizeauButton.setPreferredSize(new Dimension(150, 50));
		this.add(fizeauButton,BorderLayout.NORTH);
		
		runButton = new JButton ("START/ STOP");
		runButton.setFont(mainFont);
		runButton.setPreferredSize(new Dimension(150, 50));
		this.add(runButton,BorderLayout.SOUTH);
	}



}
