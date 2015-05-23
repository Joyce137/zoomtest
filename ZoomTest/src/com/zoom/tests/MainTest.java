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
	//��Ӛһ��frame�O �I�P�О�
	public MainTest(){
		 this.setSize(500,100); 
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	     this.setTitle("my jframe"); 
	     this.setVisible(true); 
	     this.addKeyListener(new KeyAdapter(){ 
	    	 public void keyPressed(KeyEvent e){
	    		 	ch=e.getKeyChar(); 
	    		 	if(ch == 's'){
	    		 		new PlayText().play("��������¼���밴L��.");
	    		 	}
	    		 	if(ch == 'l'){
	    		 		new PlayText().play("�������ע�ᣬ�밴S��.");
	    		 	}
	    		 	if(ch == '0'){
	    		 		new PlayText().play("������.");
	    		 	}
	    		 	//new PlayText().play(ch+"\n");
	            } 
	     }); 
	}

	//����Web�Զ������Զ���
	public void mainautotest(){
		new AddTestNG().testall();
	}
	
	//�������
	public static void main(String[] args){
		new MainTest();
		//new PlayText().play("��1����ʼ"); 
		new PlayText().play("start"); 
	}
}
