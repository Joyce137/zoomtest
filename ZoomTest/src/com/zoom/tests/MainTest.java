package com.zoom.tests;

import java.awt.event.KeyAdapter;

import javax.swing.JFrame;

import org.openqa.selenium.WebDriver;

import java.awt.event.KeyEvent;

import com.zoom.accessibility.MainAction;
import com.zoom.accessibility.PlayText;
import com.zoom.cons.BrowserAction;
import com.zoom.cons.DriverManager;
import com.zoom.cons.UrlManager;

public class MainTest extends JFrame{
	private char ch;
	private String s;
	//依託一個frame監聽鍵盤行為
	public MainTest(){
		 this.setSize(500,100); 
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	     this.setTitle("my jframe"); 
	     this.setVisible(true); 
	     this.addKeyListener(new KeyAdapter(){ 
	    	 public void keyPressed(KeyEvent e){
	    		 	ch=e.getKeyChar(); 
	    		 	if(ch == 's'){
	    		 		new PlayText().play("如果你想登录，请按L键.");
	    		 	}
	    		 	if(ch == 'l'){
	    		 		new PlayText().play("如果你想注册，请按S键.");
	    		 	}
	    		 	if(ch == '0'){
	    		 		new PlayText().play("请输入.");
	    		 	}
	    		 	//new PlayText().play(ch+"\n");
	            } 
	     }); 
	}

	//整合Web自动化测试动作
	public void mainautotest(){
		new AddTestNG().testall();
	}
	
	//工程入口
	public static void main(String[] args){
		new MainTest();
		//new PlayText().play("按1键开始"); 
		new PlayText().play("start"); 
	}
}
