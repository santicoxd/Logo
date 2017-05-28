package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Turtle {
    @SuppressWarnings("deprecation")
	public Turtle() {
    	try {
    	angle=0;
    	up=false;
    	visible=true;
    	x=350;
    	
    	y=200;
    	
    	
    	
    	//img = ImageIO.read(getClass().getResource("Imagen2.png"));
        img = ImageIO.read(new FileInputStream("Imagenes/Imagen2.png"));
    	xcola=-7+x+img.getWidth()/2;
    	ycola=y+img.getHeight()/2;
    	
    	}
    	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
    	}
  
    }
	public void paint(Graphics2D g) {
		
		if (visible){
		AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(angle),img.getWidth()/2, img.getHeight()/2 );
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g.drawImage(op.filter(img, null),x, y,null);}
		
		
	}
	BufferedImage  img;
	int x;
	int xcola;
	int ycola;
	int y;
	
	int angle;
	boolean up;
	boolean visible;
	
	public void upPencil(){
		this.up=true;
	}
	
	public void downPencil(){
		this.up=false;
	}
	
	public void turn(int angle) throws IOException{
		this.angle=this.angle+angle;
		this.angle=this.angle%360;
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		App.getInstance().mframe.canvas.repaint();
	}
	
	public void hide () throws IOException{
		this.visible=false;
		App.getInstance().mframe.canvas.repaint();
	}
	
	public void show () throws IOException{
		this.visible=true;
		App.getInstance().mframe.canvas.repaint();
	}
	public void move(int dist) throws IOException{
		
		int dx=0;
		int dy=0;
		if( angle==0 || angle==180 ){
			 dy =(int) (dist*5* Math.cos(Math.toRadians(angle)));
		}else if( angle==90|| angle==270){
			 dx = (int)(dist*5* Math.sin(Math.toRadians(angle)));
		}else{
			dy = (int)(dist*5* Math.cos(Math.toRadians(angle)));
			dx = (int)(dist*5* Math.sin(Math.toRadians(angle)));
		}
		
		
		
		if (!up){
			try {
				App.getInstance().addLine(new RectLine(new Point(xcola,ycola), new Point(xcola+dx, ycola-dy)));
			} catch (IOException e) {
				System.out.println("error agrenado");
				e.printStackTrace();
			}
		}
		xcola=xcola+dx;
		ycola=ycola-dy;
		x = x+dx;
		y = y-dy;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		App.getInstance().mframe.canvas.repaint();
		
	}

}
