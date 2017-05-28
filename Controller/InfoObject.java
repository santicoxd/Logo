/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Santiago
 */
public class InfoObject {
    public int cIndex;
    public int lIndex;
    public String clName;
    public String solution;
    public String content;
    public String message;
    
    public InfoObject(int cIndex, int lIndex, String clName, String solution, String content, String message) {
        this.cIndex = cIndex;
        this.lIndex = lIndex;
        this.clName = clName;
        this.solution = solution;
        this.content = content;
        this.message = message;
    }
    
   
}
