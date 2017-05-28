/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


/**
 *
 * @author Santiago
 */
public class Course {
    private String name;
    private ArrayList<Chapter> chapters;
 
    public Course(){
        chapters = new ArrayList();
        loadContents();
    }
    
    //Load the content from the .txt file. The content must be well formated
    private void loadContents(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("contenido.txt"));
            name = br.readLine();
            int numberOfChapters = Integer.parseInt(br.readLine());
            for(int i = 0; i < numberOfChapters; i++){
                String chapName = br.readLine();
                chapters.add(new Chapter(chapName));
            }
            
            while(br.readLine() != null){
                int chapter = Integer.parseInt(br.readLine());
                String LessonName = br.readLine();
                String LessonContent = br.readLine();
                String LessonSolution = br.readLine();
                Chapter c = chapters.get(chapter);
                c.getLessons().add(new Lesson(LessonName, LessonContent, LessonSolution));
            }
            chapters.get(0).getLessons().get(0).setActive(true);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in content file , please check that the information is structured like in the file plantilla.txt");
        }
        
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
}

