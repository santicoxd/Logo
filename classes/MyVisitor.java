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
    public T visitNumber(logoParser.NumberContext ctx) {
      
        Integer a = Integer.valueOf(ctx.NUMBER().getText());
        
        return (T)a;
    }
    
    @Override public T visitSignExpression(logoParser.SignExpressionContext ctx) {
        
        Integer number = (Integer) visit(ctx.number());
 
        
        if (ctx.op!=null){
           if(ctx.op.getText().equals("+")){
               number = number;
           }else
           {    number = number * (-1);
                    
         
           }
              
        }
        
        return (T)number;
    }

    @Override
    public T visitMultiplyingExpression(logoParser.MultiplyingExpressionContext ctx) {
        
        Integer rigth = (Integer) visit(ctx.signExpression(0));
        
        Integer resultado = rigth;
        if (ctx.op!=null){
            Integer left = (Integer) visit(ctx.signExpression(1));
            if(ctx.op.getText().equals("*")){
                resultado= left*rigth;
           }else{
                
               resultado=(int)rigth/left;
               
                
           }
            
        }
        return (T)resultado;
    }
 
    public T visitExpression(logoParser.ExpressionContext ctx) {
      
        Integer rigth = (Integer) visit(ctx.multiplyingExpression(0));
        
        Integer resultado = rigth;
        if (ctx.op!=null){
            Integer left = (Integer) visit(ctx.multiplyingExpression(1));
            if(ctx.op.getText().equals("+")){
                resultado= left+rigth;
           }else{
               resultado=rigth-left;
              
           }
            
        }
      
        return (T)resultado;
    }
    
    @Override
    public T visitCmd(logoParser.CmdContext ctx) {
       
        try {
        if (ctx.fd()!= null){
           
            Integer pasos = (Integer) visit(ctx.fd().expression());
            App.getInstance().moveTurtle(pasos);
            
            
        }else if (ctx.bk()!= null){
            Integer pasos = (Integer) visit(ctx.bk().expression());
            App.getInstance().moveTurtle(-pasos);
        }else if (ctx.rt()!= null){
         
            //int angle = 90;
            Integer angle = (Integer) visit(ctx.rt().expression());
            //Thread.currentThread().sleep(400);
            App.getInstance().rotateTurtle(angle);
            
            //this.pause();
            
        }else if (ctx.lt()!= null){
            Integer angle = (Integer) visit(ctx.rt().expression());
            App.getInstance().rotateTurtle(-angle);
        }
        else if (ctx.cs()!= null){
 
            App.getInstance().drawing.clearscreen();
        }
        else if (ctx.pu()!= null){
 
            App.getInstance().drawing.turtle.upPencil();
        }
        else if (ctx.pd()!= null){
 
            App.getInstance().drawing.turtle.downPencil();
        }
        else if (ctx.pd()!= null){
 
            App.getInstance().drawing.turtle.downPencil();
        }
        else if (ctx.ht()!= null){
 
            App.getInstance().drawing.turtle.hide();
        }
        else if (ctx.st()!= null){
 
            App.getInstance().drawing.turtle.show();
        }
        if (ctx.home()!= null){
 
            App.getInstance().drawing.turtle.home();
        }else if (ctx.repeat()!= null){
            Integer number = (Integer) visit(ctx.repeat().number());
            for (int i = 0 ; i<number;i++){
                visit(ctx.repeat().block());
            }
            //System.out.println("Veces: "+number);
            
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
