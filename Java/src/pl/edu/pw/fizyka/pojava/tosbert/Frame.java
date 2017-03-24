package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	BottomPanel bottom;

	public Frame() throws HeadlessException {
		
		super("Symulacja Efektu Fizeau");
		
		setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		bottom = new BottomPanel();
		this.add(bottom, BorderLayout.SOUTH);
	}	


	public static void main(String[] args) {
		
		Frame frame = new Frame();
		frame.setVisible(true);

	}

}
