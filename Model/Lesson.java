/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author Santiago
 */
public class Lesson {
    private boolean active;
    private String name;
    private String content;
    private String solution;
    
    public Lesson( String name, String content, String solution) {
        this.active = false;
        this.name = name;
        this.content = content;
        this.solution = solution;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    
    @Override
    public String toString(){
        return name;
    }


    
}
