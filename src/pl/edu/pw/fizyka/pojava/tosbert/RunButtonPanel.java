package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RunButtonPanel extends JPanel { //Antonina Pater
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	JButton fizeauButton;
	JButton runButton;
	JButton saveButton;
	Font mainFont = new Font("Liberation Sans", Font.PLAIN, 12);

	public RunButtonPanel() {

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setPreferredSize(new Dimension(300,150));
		setBackground(Color.WHITE);

		this.fizeauButton =new JButton("Zrób to jak Fizeau");
		c.gridx = 0;
		c.gridy = 0;
		c.anchor=GridBagConstraints.PAGE_START;
		this.fizeauButton.setFont(this.mainFont);
		this.fizeauButton.setPreferredSize(new Dimension(200, 35));
		this.add(this.fizeauButton,c);

		this.runButton = new JButton ("START/ STOP");
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,0,0,0);
	//	c.anchor=GridBagConstraints.PAGE_END;
		this.runButton.setFont(this.mainFont);
		this.runButton.setPreferredSize(new Dimension(200, 35));
		this.add(this.runButton,c);
		
		this.saveButton = new JButton("Zapisz do pliku tekstowego");
		c.gridy = 2;
		this.saveButton.setFont(mainFont);
		this.saveButton.setPreferredSize(new Dimension(200, 35));
		this.add(saveButton,c); 
	}



}
