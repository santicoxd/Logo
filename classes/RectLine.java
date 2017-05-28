package classes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class RectLine {
	public RectLine (Point inicio, Point fin){
		this.inicio=inicio;
		this.fin=fin;
	}
	public void paint(Graphics2D g) {
		g.setColor(this.color);
		g.drawLine( inicio.x, inicio.y, fin.x, fin.y );	
	}

	private Point inicio;
	private Point fin;
	private Color color;

}
