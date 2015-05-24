package com.zoom.accessibility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.zoom.utils.AccessibilityFrame;

public class SigninAccessibility {
	private static String text = "��������Ҫ��¼���������û��������롣";
	public static void signin(){
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
