/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

/**
 *
 * @author Santiago
 */
public class Controller {
    private Course course;
    
    public Controller(){
        course = new Course();
    }
    
    public InfoObject getInitialInfo() {
        int cIndex = 0;
        int lIndex = 0;
        Lesson l = getLesson(cIndex, lIndex);
        String clName = buildLessonHeader(cIndex, lIndex);
        String solution = l.getSolution();
        String content = l.getContent();
        String message = "";
        
        return new InfoObject(cIndex, lIndex, clName, solution, content, message);
    }
    
   public Chapter getChapter(int index){
       return course.getChapters().get(index);
   }
   
   public Lesson getLesson(int cIndex, int lIndex){
       return course.getChapters().get(cIndex).getLessons().get(lIndex);
   }
   
   public String buildLessonHeader(int cIndex, int lIndex){
       return "<html><h3>Capítulo " + (cIndex+1) + " - Leccion " + lIndex + " - " + getLesson(cIndex, lIndex).getName() + "</h3>";
   }
}
