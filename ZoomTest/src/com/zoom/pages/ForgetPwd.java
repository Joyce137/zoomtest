package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class ForgetPwd {
	//����LocatorManager����
	private LocatorManager yaml; 
	//�M��
	private WebElement pageheader, check_msg, email, send, pageheader2, check_email, resend;
	
	//���캯����ʼ���M��
	public ForgetPwd(){
		pageheader = yaml.getElement("pageheader");
		check_msg = yaml.getElement("check_msg");
		email = yaml.getElement("email");
		send = yaml.getElement("send");
		pageheader2 = yaml.getElement("pageheader2");
		check_email = yaml.getElement("check_email");
		resend = yaml.getElement("resend");
	}

	//�M��get����
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
	
	//�M�������yԇ����
	
}