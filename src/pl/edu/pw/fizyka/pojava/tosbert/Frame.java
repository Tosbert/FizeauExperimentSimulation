package pl.edu.pw.fizyka.pojava.tosbert;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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



	double WIDTH;
	double HEIGHT;
	
	BottomPanel bottom;
	AnimationPanel animation;

	JMenuBar menuBar;
	JMenu menu;
	JMenuItem chartMenu;
	JMenuItem timeMenu;

	//Timer timer;
	
	ScheduledExecutorService scheduler;


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
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = screenSize.getWidth();
		HEIGHT = screenSize.getHeight();
		

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

		/*
		setJMenuBar(this.menuBar);
		this.menuBar.add(this.menu);
		this.menu.setText("Menu");
		this.menu.add(this.chartMenu);
		this.chartMenu.setText("Pokaż wykres");
		this.chartMenu.setToolTipText("Wyświetla okno z wykresem");
		this.menu.add(this.timeMenu);
		this.timeMenu.setText("Wybierz tempo symulacji");
		this.timeMenu.setToolTipText("Zmień opcje czasu symulacji, by obserwować bieg promieni świetlnych");
		 */



		this.animation = new AnimationPanel(0,600,600,WIDTH,HEIGHT);


		this.bottom = new BottomPanel();

		this.add(this.animation, BorderLayout.CENTER);
		this.add(this.bottom, BorderLayout.SOUTH);
		pack();

		this.bottom.runButtonPanel.runButton.addActionListener(new RunButtonListener(this));
		this.bottom.settings.velSlider.addChangeListener(new SliderListener(this));
		this.bottom.runButtonPanel.fizeauButton.addActionListener(new FizeauButtonListener(this));
		this.bottom.settings.distance.addItemListener(new DistanceListener(this));
		this.bottom.settings.nTeeth.addItemListener(new ToothListener(this));
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


	void startAnimation(){
		this.scheduler = Executors.newScheduledThreadPool(1);
		this.scheduler.scheduleAtFixedRate( (new Runnable() {
			@Override
			public void run(){

				boolean rotate = false;
				int lastToothY = Frame.this.animation.wheelTeeth.get(Frame.this.animation.wheelTeeth.size()-1).y;
				for(WheelTooth t : Frame.this.animation.wheelTeeth)
					if(lastToothY != t.moveTooth(Frame.this.animation.vel,lastToothY)) {
						rotate = true;
						lastToothY = t.moveTooth(Frame.this.animation.vel,lastToothY);
					}
				if(rotate)
					Frame.this.animation.wheelTeeth.add(Frame.this.animation.wheelTeeth.remove(0));

				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run(){
						Frame.this.animation.repaint();
						Frame.this.bottom.detectorPanel.detectorImage.repaint();
					}
				});
			}
		}),  0, 10, MILLISECONDS);
	}

	void stopAnimation(){
		this.scheduler.shutdown();
		this.repaint();
	}



}




