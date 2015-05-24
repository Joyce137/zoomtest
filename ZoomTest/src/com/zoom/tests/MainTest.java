package com.zoom.tests;

import javax.swing.JFrame;

import com.zoom.accessibility.PlayText;

@SuppressWarnings("serial")
public class MainTest extends JFrame{
	//整合Web自动化测试动作
	public void mainautotest(){
		new AddTestNG().testall();
	}
	//整合Web Accessiblity 
	public void mainaccessiblitytest(){
		Accessibility.go();
	}
	
	//工程入口
	public static void main(String[] args){
		MainTest main = new MainTest();

		String text = "Start: 按s注册，按l登录，按j加会，按h开会，按o注销登录。";
		PlayText.play(text); 
		main.mainaccessiblitytest();
		main.mainautotest();
	}
}
