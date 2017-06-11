package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Frame extends JFrame { 

	/**
	 * Antonina Pater, Hubert Nowakowski
	 * Główna klasa programu zawierająca funkcje main()
	 * Ustawia wymiary ramki, Look&Feel oraz pętle animacji.
	 */
	private static final long serialVersionUID = 1L;

	double WIDTH;
	double HEIGHT;

	BottomPanel bottom;
	AnimationPanel animation;

	JFileChooser chooser;
	File to;

	Timer timer;

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
		setPreferredSize(new Dimension((int)WIDTH,(int)HEIGHT));
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());

		chooser = new JFileChooser();

		this.animation = new AnimationPanel(200,500,5000,WIDTH,HEIGHT);
		this.bottom = new BottomPanel();

		this.add(this.animation, BorderLayout.CENTER);
		this.add(this.bottom, BorderLayout.SOUTH);
		pack();

		this.bottom.runButtonPanel.runButton.addActionListener(new RunButtonListener(this));
		this.bottom.settings.velSlider.addChangeListener(new SliderListener(this));
		this.bottom.runButtonPanel.fizeauButton.addActionListener(new FizeauButtonListener(this));
		this.bottom.settings.distance.addItemListener(new DistanceListener(this));
		this.bottom.settings.nTeeth.addItemListener(new ToothListener(this));
		this.bottom.runButtonPanel.saveButton.addActionListener(new SaveButtonListener(this));
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

		int delay = 10;
		final Timer timer = new Timer(delay, null);
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(!animation.animationRunning){
					timer.stop();
				}
				else
				{
					boolean rotate = false;
					int lastToothY = Frame.this.animation.wheelTeeth.get(Frame.this.animation.wheelTeeth.size()-1).y;
					for(WheelTooth t : Frame.this.animation.wheelTeeth)
						if(lastToothY != t.moveTooth(Frame.this.animation.vel,lastToothY)) {
							rotate = true;
							lastToothY = t.moveTooth(Frame.this.animation.vel,lastToothY);
						}
					if(rotate){
						Frame.this.animation.wheelTeeth.add(Frame.this.animation.wheelTeeth.remove(0));
					}

					SwingUtilities.invokeLater(new Runnable(){
						@Override
						public void run(){
							Frame.this.animation.repaint();
							Frame.this.bottom.detectorPanel.detectorImage.repaint();
						}
					});
				}

			}
		});

		if(!timer.isRunning()) { timer.start(); }
	}

	void updateAnimation(){
		int vel = Frame.this.bottom.settings.velSlider.getValue();
		Frame.this.bottom.settings.velLabel.setText( Integer.toString(vel) );
		Frame.this.animation.setVel(vel);

		int w0 = Frame.this.animation.calculateW0(Frame.this.animation);	
		int IntensityMax = 255;
		int Intensity = IntensityMax;

		int x = (int) (vel/ 5.0);

		while(vel>2*w0){
			vel-=2*w0;
		}
		double ratio = (double) vel/w0;

		if( (vel >= 0 ) &&( vel <= w0) ){
			Intensity = (int) (IntensityMax * ( 1 - ratio ));

		}
		if( vel >= w0 && vel <= w0*2 ){
			Intensity = (int)(IntensityMax * ( ratio - 1) );
		}
		
		int y = Intensity;		
		Frame.this.bottom.detectorPanel.detectorImage.setIntensity(Intensity);

		if(Frame.this.animation.animationRunning){
			Frame.this.bottom.graph.setData(x,y);
			Frame.this.bottom.graph.updateChart(Frame.this.bottom.graph.data);
		}
	}



}




