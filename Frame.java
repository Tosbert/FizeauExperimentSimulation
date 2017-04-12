package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Frame extends JFrame { //Antonina Pater

    /**
     *
     */
    private static final long serialVersionUID = 1L;



    BottomPanel bottom;
    AnimationPanel animation;

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem chartMenu;
    JMenuItem timeMenu;

    public Frame() throws HeadlessException {

	super("Symulacja Efektu Fizeau");
	
	try {
		UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
		
	} catch (Exception e1) {
		
		e1.printStackTrace();
		System.out.println("błąd LF");
	;
	}
	 SwingUtilities.updateComponentTreeUI(Frame.this);

	setPreferredSize(new Dimension(800,700));
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setBackground(Color.WHITE);
	setLayout(new BorderLayout());


	this.menuBar = new JMenuBar();
	this.menu = new JMenu();
	this.chartMenu = new JMenuItem();
	this.timeMenu = new JMenuItem();

	setJMenuBar(this.menuBar);
	this.menuBar.add(this.menu);
	this.menu.setText("Menu");
	this.menu.add(this.chartMenu);
	this.chartMenu.setText("Pokaż wykres");
	this.chartMenu.setToolTipText("Wyświetla okno z wykresem");
	this.menu.add(this.timeMenu);
	this.timeMenu.setText("Wybierz tempo symulacji");
	this.timeMenu.setToolTipText("Zmień opcje czasu symulacji, by obserwować bieg promieni świetlnych");



	this.chartMenu.addActionListener( new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		Frame.this.bottom.graph.setVisible(true);
	    }
	} );


	this.animation = new AnimationPanel();
	this.bottom = new BottomPanel();

	this.add(this.animation, BorderLayout.CENTER);
	this.add(this.bottom, BorderLayout.SOUTH);
	pack();
    }


    public static void main(String[] args) {

	Frame frame = new Frame();
	frame.setVisible(true);

    }

}
