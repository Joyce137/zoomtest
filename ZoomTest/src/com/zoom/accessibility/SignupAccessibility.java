package com.zoom.accessibility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.zoom.utils.AccessibilityFrame;

public class SignupAccessibility {
	private static String text = "现在您将要注册,请输入用户名";
	public static void signup(){
		PlayText.play(text);
		AccessibilityFrame frame = new AccessibilityFrame();
		frame.getJt().addKeyListener(new KeyAdapter(){ 
            public void keyPressed(KeyEvent e){ 
                char ch=e.getKeyChar(); 
                PlayText.play(ch+"\n");
            } 
        }); 
	}
}
