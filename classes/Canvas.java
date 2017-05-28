package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;

public class Canvas extends JPanel {
		public Canvas() {
			
			this.setBackground(Color.blue);
			
		}
		public void paint( Graphics g )
		{	//System.out.println("canvas");
			//this.removeAll();
			super.paint( g );super.paint( g );
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
			}
			*/
		}

}
