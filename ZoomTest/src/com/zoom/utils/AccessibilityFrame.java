package com.zoom.utils;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AccessibilityFrame extends JFrame{
	private JPanel jp;
	public JTextField getJt() {
		return jt;
	}
	public void setJt(JTextField jt) {
		this.jt = jt;
	}
	private JTextField jt;
	public AccessibilityFrame(){
		jp = new JPanel();
		jt = new JTextField(20);
		jp.add(jt);
		
		this.setLayout(new GridLayout(1, 1));
		this.add(jp);
		
		this.setSize(300,100); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("Accessibilty Frame"); 
        this.setVisible(true); 
        this.setResizable(false);
	}
}
