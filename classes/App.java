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
		try {
			Thread.sleep(1000);
			//app.drawing.turtle.turn(45);
			
		//fd 60 rt 120 fd 60 rt 120 fd 60 rt 120 
			
			app.drawing.turtle.turn(180-120);
			app.drawing.turtle.move(40);
			app.drawing.turtle.turn(120);
			app.drawing.turtle.hide();
			app.drawing.turtle.move(40);
			app.drawing.turtle.turn(120);
			
			app.drawing.turtle.move(40);
			app.drawing.turtle.turn(120);
			
			
			
			
			
		
			
		Thread.sleep(1000);
		app.drawing.clearscreen();
		app.drawing.turtle.show();	
		
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void paint(Graphics2D g){
		drawing.paint(g);
	}
	

	
	private static App instance;
	public Frame mframe;
	public Drawing drawing;
	public void addLine(RectLine rectLine) {
		this.drawing.addLine(rectLine);
		
	}
	
	
	
}
