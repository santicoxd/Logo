package classes;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Drawing {
	public Drawing() throws IOException {
		elements = new LinkedList<RectLine>();
		turtle=new Turtle();
		
	}
	
	public void paint(Graphics2D g  )
	{  	
		for ( RectLine rl : elements )
		{
			rl.paint( g );
		}
		turtle.paint(g);
		
	}
	
	public void addLine(RectLine f){
		elements.add( f );
	}
	public void clearscreen() throws IOException{
		elements.clear();
		App.getInstance().mframe.canvas.repaint();
	}
	
	private List<RectLine> elements;
	public Turtle turtle;
}
