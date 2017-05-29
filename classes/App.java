package classes;

import View.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;

public class App {

	public App() throws IOException {
		mframe = new Frame();
		drawing = new Drawing();
		
		
	}

	private void run() {
		
		//mframe.setBounds(10, 10, 800, 600 );
		//mframe.setExtendedState( JFrame.MAXIMIZED_BOTH );
		//mframe.setResizable(false);
		//mframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//mframe.setVisible( true );
                 
                 mframe.setVisible(true);
                 mframe.setResizable(false);
	}
	
	public static App getInstance() throws IOException
	{
		if ( instance == null )
		{
			instance = new App();
		}
		
		return instance;
	}
	public static void main(String[] args) throws IOException {
		
		
		App app = getInstance();
		app.run();
                //app.mframe.canvas.pintar();
		try {
			Thread.sleep(1000);
			//app.drawing.turtle.turn(45);
			
		//fd 60 rt 120 fd 60 rt 120 fd 60 rt 120 
			
			
                app.moveTurtle(10);
                app.rotateTurtle(90);
                app.moveTurtle(10);
                app.rotateTurtle(90);
                app.moveTurtle(10);
                app.rotateTurtle(90);
                app.moveTurtle(10);
                app.rotateTurtle(90);
			
			
			
			
			
			
			
		
			
			
		
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
               // app.bailar();
		
	}
	
	public void paint(Graphics2D g){
		drawing.paint(g);
	}
	
 public void moveTurtle(int pasos) throws IOException
        {
            instance.drawing.turtle.move(pasos);
        }
        
public void rotateTurtle(int angle) throws IOException, InterruptedException
        {
            instance.drawing.turtle.turn(angle);
        }
	
	private static App instance;
	public Frame mframe;
	public Drawing drawing;
	public void addLine(RectLine rectLine) {
		this.drawing.addLine(rectLine);
		
	}

    private void bailar() {
    this.drawing.bailar();
    
    }
       
	
	
	
}
