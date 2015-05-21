package com.zoom.tests;

import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent; 
   

import javax.swing.JFrame; 

import com.zoom.accessibility.PlayText;
   
   
/**
 * 
 */ 
   
/**
 * @author Administrator
 *
 */ 
//窗体类  
public class Accessibility extends JFrame { 
   
    /**
     * @param args
     */ 
    char charA; 
    public Accessibility(){ 
        this.setSize(500,100); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("my jframe"); 
        this.setVisible(true); 
        this.addKeyListener(new KeyAdapter(){ 
            public void keyPressed(KeyEvent e){ 
                char charA=e.getKeyChar(); 
                //PlayText.play("你按了《"+charA+"》键"); 
            } 
        }); 
           
           
    } 
    public static void mains(String[] args) { 
        // TODO Auto-generated method stub  
        new Accessibility(); 
    } 
   
}