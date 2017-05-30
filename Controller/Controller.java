/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.Frame;
import classes.MyVisitor;
import classes.logoLexer;
import classes.logoParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Santiago
 */
public class Controller {
    private Course course;
    
    public Controller(){
        course = new Course();
    }
    
    
    public InfoObject getLessonInfo(int cIndex, int lIndex) {

        Lesson l = getLesson(cIndex, lIndex);
        String clName = buildLessonHeader(cIndex, lIndex);
        String solution = l.getSolution();
        String content = l.getContent();
        String message = "";
        
        return new InfoObject(cIndex, lIndex, clName, solution, content, message);
    }
    
    //Modificar dependiendo los contenidos
    public void updateButtons(int cIndex, int lIndex){
        
        Frame.l11.setEnabled(getLesson(0, 0).isActive());
        Frame.l12.setEnabled(getLesson(0, 1).isActive());
        Frame.l13.setEnabled(getLesson(0, 2).isActive());
        Frame.l14.setEnabled(getLesson(0, 3).isActive());
        Frame.l15.setEnabled(getLesson(0, 4).isActive());
        Frame.l16.setEnabled(getLesson(0, 5).isActive());
        Frame.l17.setEnabled(getLesson(0, 6).isActive());
        Frame.l21.setEnabled(getLesson(1, 0).isActive());
        Frame.l31.setEnabled(getLesson(2, 0).isActive());
        Frame.l32.setEnabled(getLesson(2, 1).isActive());
        Frame.l33.setEnabled(getLesson(2, 2).isActive());
        Frame.back.setEnabled(true);
        Frame.next.setEnabled(true);
        if(cIndex == 0 && lIndex == 0){
            Frame.back.setEnabled(false);
        }
        int nextLessonIndex[] = new int[2];
        nextLessonIndex = getNextLesson(cIndex, lIndex);
        if(nextLessonIndex[0] == -1 || !getLesson(nextLessonIndex[0], nextLessonIndex[1]).isActive()){
            Frame.next.setEnabled(false);
        }
    }
    
    public int[] getNextLesson(int cIndex, int lIndex){
        int result[] = new int[2];
        if(!hasMoreLessons(cIndex, lIndex)){
            if(!hasMoreChapters(cIndex, lIndex)){
                result [0] = -1;
                result[1] = -1;
            }else{
                result[0] = cIndex + 1;
                result[1] = 0;
            }
        }else{
            result[0] = cIndex;
            result[1] = lIndex + 1;
        }
        return result;
    }
    
    public int[] getPrevoiusLesson(int cIndex, int lIndex){
        int result[] = new int[2];
        if(!hasPreviousLessons(cIndex, lIndex)){
            if(!hasPreviousChapters(cIndex, lIndex)){
                result [0] = -1;
                result[1] = -1;
            }else{
                result[0] = cIndex - 1;
                result[1] = getChapter(cIndex - 1).getLessons().size() - 1;
            }
        }else{
            result[0] = cIndex;
            result[1] = lIndex - 1;
        }
        return result;
    }
    
    public boolean hasMoreLessons(int cIndex, int lIndex){
        if(lIndex+1 < getChapter(cIndex).getLessons().size() ) return true;
        return false;
    }
    
    public boolean hasMoreChapters(int cIndex, int lIndex){
        if(cIndex+1 < course.getChapters().size() ) return true;
        return false;
    }
    
    public boolean hasPreviousLessons(int cIndex, int lIndex){
        if(lIndex > 0 ) return true;
        return false;
    }
    
    public boolean hasPreviousChapters(int cIndex, int lIndex){
        if(cIndex > 0 ) return true;
        return false;
    }
    
    public void runInterpreter(String answer){
        answer = answer + "\n";
        try {
            PrintWriter writer = new PrintWriter("input.txt", "UTF-8");
            writer.print(answer);
            writer.close();
            
            System.setIn(new FileInputStream(new File("input.txt")));
            ANTLRInputStream input = new ANTLRInputStream(System.in);
            logoLexer lexer = new logoLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            logoParser parser = new logoParser(tokens);
            ParseTree tree = parser.prog();

        MyVisitor<Object> loader = new MyVisitor<Object>();
        loader.visit(tree);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String checkSolution(int cIndex, int lIndex, String answer){
        String solution = getLesson(cIndex, lIndex).getSolution();
        answer = deleteSpaces(answer);
        if(answer.equals(solution)){
            int nextLesson[] = getNextLesson(cIndex, lIndex);
            getLesson(nextLesson[0], nextLesson[1]).setActive(true);
            updateButtons(cIndex, lIndex);
            return "Genial, lo hiciste perfecto!. Cada vez aprenderas más y más \n Ya puedes pasar a la siguiente Lección pulsando el boton SIGUIENTE";
        }else{
           return "INCORRECTO!\nVuelve a leer las instrucciones y revisa tu código, algo estas haciendo mal";  
        }
    }
    
    public String deleteSpaces(String s) {
        /*Matcher m = Pattern.compile("\\w+").matcher(s);
        String result = "";
        while (m.find()) {
            result=result + m.group(0);
            //System.out.println("Found: " + m.group(0));
        }*/
        String result = s.replaceAll("(\\s|\\n)", "");
        //System.out.println(result);
        return result;
    }
    
   public Chapter getChapter(int index){
       return course.getChapters().get(index);
   }
   
   public Lesson getLesson(int cIndex, int lIndex){
       return course.getChapters().get(cIndex).getLessons().get(lIndex);
   }
   
   public String buildLessonHeader(int cIndex, int lIndex){
       return "<html><h3>C" + (cIndex+1) + " - L" + (lIndex+1) + " - " + getLesson(cIndex, lIndex).getName() + "</h3>";
   }
}
