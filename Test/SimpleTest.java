/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Santiago
 */
public class SimpleTest {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("prueba")); 
            String line = br.readLine();
            System.out.println(line);
            System.out.println(br.readLine()==null);
            System.out.println(br.readLine()==null);
            System.out.println(br.readLine()==null);
        }catch(Exception e){
            System.out.println("Error");
        }
        
    }
}
