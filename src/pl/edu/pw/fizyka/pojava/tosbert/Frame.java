package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Frame extends JFrame { //Antonina Pater, Hubert Nowakowski

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
		}
		SwingUtilities.updateComponentTreeUI(Frame.this);

		setExtendedState(MAXIMIZED_BOTH); 
		setUndecorated(false);

		setPreferredSize(new Dimension(1200,900));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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




		this.animation = new AnimationPanel(0,600,600);


		this.bottom = new BottomPanel();

		this.add(this.animation, BorderLayout.CENTER);
		this.add(this.bottom, BorderLayout.SOUTH);
		pack();

		this.bottom.runButtonPanel.runButton.addActionListener(new RunButtonListener(this));
		this.bottom.settings.velSlider.addChangeListener(new SliderListener(this));
		this.bottom.settings.distance.addItemListener(new DistanceListener(this));
		//this.bottom.settings.nTeeth.addItemListener(new ToothListener(this));
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Frame frame = new Frame();
				frame.setVisible(true);
			}
		});

	}
}
