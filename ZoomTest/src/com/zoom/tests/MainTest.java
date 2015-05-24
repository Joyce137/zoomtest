package com.zoom.tests;

import javax.swing.JFrame;

import com.zoom.accessibility.PlayText;

@SuppressWarnings("serial")
public class MainTest extends JFrame{
	//����Web�Զ������Զ���
	public void mainautotest(){
		new AddTestNG().testall();
	}
	//����Web Accessiblity 
	public void mainaccessiblitytest(){
		Accessibility.go();
	}
	
	//�������
	public static void main(String[] args){
		MainTest main = new MainTest();

		String text = "Start: ��sע�ᣬ��l��¼����j�ӻᣬ��h���ᣬ��oע����¼��";
		PlayText.play(text); 
		main.mainaccessiblitytest();
		main.mainautotest();
	}
}
