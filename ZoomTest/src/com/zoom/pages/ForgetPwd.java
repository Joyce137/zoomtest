package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class ForgetPwd {
	//創建LocatorManager實例
	private LocatorManager yaml; 
	//組件
	private WebElement pageheader, check_msg, email, send, pageheader2, check_email, resend;
	
	//構造函數初始化組件
	public ForgetPwd(){
		pageheader = yaml.getElement("pageheader");
		check_msg = yaml.getElement("check_msg");
		email = yaml.getElement("email");
		send = yaml.getElement("send");
		pageheader2 = yaml.getElement("pageheader2");
		check_email = yaml.getElement("check_email");
		resend = yaml.getElement("resend");
	}

	//組件get函數
	public WebElement getPageheader() {
		return pageheader;
	}

	public WebElement getCheck_msg() {
		return check_msg;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSend() {
		return send;
	}

	public WebElement getPageheader2() {
		return pageheader2;
	}

	public WebElement getCheck_email() {
		return check_email;
	}

	public WebElement getResend() {
		return resend;
	}
	
	//組件基本測試函數
	
}
