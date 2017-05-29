package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class Canvas extends JPanel {
		public Canvas() {
			
			this.setBackground(Color.blue);
			
		}
		/*public void paintComponent (Graphics g){
                    super.paintComponent(g);
                    try {
				App.getInstance().paint((Graphics2D) g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                }*/
                /*public void paintComponent( Graphics g )
		{	
                        System.out.println("repaint");
                        super.paint( g );
			/*try {
                            App.getInstance().paint((Graphics2D)g);
                        }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/*try {
				App.getInstance().paint((Graphics2D) g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
                
                public void paint( Graphics g )
		{	
                        //System.out.println("paint");
                        super.paint( g );
			try {
                            App.getInstance().paint((Graphics2D)g);
                        }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				App.getInstance().paint((Graphics2D) g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}

}
