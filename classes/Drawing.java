package classes;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    void bailar() {
    try {
			Thread.sleep(1000);
			//app.drawing.turtle.turn(45);
			
		//fd 60 rt 120 fd 60 rt 120 fd 60 rt 120 
			
			
                //app.moveTurtle(10);
                App.getInstance().rotateTurtle(45);
                //app.moveTurtle(10);
                App.getInstance().rotateTurtle(45);
                //app.moveTurtle(10);
                App.getInstance().rotateTurtle(45);
                //app.moveTurtle(10);
                App.getInstance().rotateTurtle(45);
			
			
			
			
			
			
			
		
			
			
		
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ex) {
                Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
