package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.Rectangle;

public class ResizeableRectangle extends Rectangle { 

	/**
	 * Hubert Nowakowski
	 * Klasa tworząca prostokąty zależne procentowo od szerokości i wyskokości ekranu urzytkownika.
	 */
	private static final long serialVersionUID = 1L;

	public ResizeableRectangle(double xPercent, double yPercent, double widthPercent, double heightPercent, double width,double height){
		super(
				(int)(xPercent*width),
				(int)(yPercent*height),
				(int)(widthPercent*width),
				(int)(heightPercent*height)
				);
	}

}
