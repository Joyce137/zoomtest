package com.zoom.tests;

import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent; 

import com.zoom.accessibility.HostAccessibilty;
import com.zoom.accessibility.JoinAccessibilty;
import com.zoom.accessibility.PlayText;
import com.zoom.accessibility.SigninAccessibility;
import com.zoom.accessibility.SignoutAccessibilty;
import com.zoom.accessibility.SignupAccessibility;
import com.zoom.utils.AccessibilityFrame;
   
//Accessiblity总结类
public class Accessibility{ 
	public static void go(){
		AccessibilityFrame frame = new AccessibilityFrame();
		frame.getJt().addKeyListener(new KeyAdapter(){ 
            public void keyPressed(KeyEvent e){ 
                char ch=e.getKeyChar(); 
                String text;
                if(ch == 'h'){             	
                	new HostAccessibilty().host();             	
                }
                if(ch == 's'){
					SignupAccessibility.signup();
                }
                if(ch == 'l'){
                	SigninAccessibility.signin();
                }
                if(ch == 'j'){
                	JoinAccessibilty.join();
                }
                if(ch == 'o'){
                	SignoutAccessibilty.siginout();
                }
                if(ch == 'x'){
                	text = "你按了"+ch+",窗口已关闭。";
                	PlayText.play(text);
                	frame.setVisible(false);
                }
            } 
        }); 
	}
}