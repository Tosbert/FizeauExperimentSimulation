package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Color;
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
	setMinimumSize(new Dimension(300,125));
	setMaximumSize(new Dimension(300,125));
	setPreferredSize(new Dimension(300,125));
	setBackground(Color.WHITE);

	this.fizeauButton =new JButton("Zrób to \n jak Fizeau");
	this.fizeauButton.setFont(this.mainFont);
	this.fizeauButton.setPreferredSize(new Dimension(150, 50));
	this.add(this.fizeauButton,BorderLayout.NORTH);

	this.runButton = new JButton ("START/ STOP");
	this.runButton.setFont(this.mainFont);
	this.runButton.setPreferredSize(new Dimension(150, 50));
	this.add(this.runButton,BorderLayout.SOUTH);
    }



}
