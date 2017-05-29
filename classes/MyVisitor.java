/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 * cmd
   : repeat
   | fd
   | bk
   | rt
   | lt
   | cs
   | pu
   | pd
   | ht
   | st
   | home
   | label
   | setxy
   | make
   | procedureInvocation
   | ife
   | stop
   | fore
   ;
 */
public class MyVisitor<T> extends logoBaseVisitor<T>  {

    
   
    @Override
    public T visitCmd(logoParser.CmdContext ctx) {
       
        try {
        if (ctx.fd()!= null){
           
            int pasos = 10;
            App.getInstance().moveTurtle(pasos);
            
            
        }else if (ctx.bk()!= null){
            int pasos = 10;
            App.getInstance().moveTurtle(-pasos);
        }else if (ctx.rt()!= null){
         
            int angle = 45;
            //Thread.currentThread().sleep(400);
            App.getInstance().rotateTurtle(angle);
            
            //this.pause();
            
        }else if (ctx.lt()!= null){
            int angle = 45;
            App.getInstance().rotateTurtle(-angle);
        }
        else if (ctx.cs()!= null){
 
            App.getInstance().getInstance().drawing.clearscreen();
        }
        
        } catch (IOException ex) {
                Logger.getLogger(MyVisitor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void pause(){
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
