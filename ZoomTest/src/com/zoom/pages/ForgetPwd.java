package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;

public class ForgetPwd {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("forgot-pwd"); 
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
	//pageheader
	public void testPageheader(){		
		ElementOperation eo = new ElementOperation(driver,pageheader);
		eo.assertText("Forgot your password?");
	}
	
	//check_msg
	public void testCheckmsg(){		
		ElementOperation eo = new ElementOperation(driver,check_msg);
		eo.assertText("Don't worry. Resetting your password is easy, just tell us the email address you registered with Zoom.");
	}
	
	String currentemail = email.getText();
	//email
	public void testEmail(String value){
		ElementOperation eo = new ElementOperation(driver,email);
		eo.inputOperation(value);
		currentemail = value;
	}
	
	//send
	public void testSend(){
		send.click();
	}
	
	//pageheader2
	public void testPageheader2(){		
		ElementOperation eo = new ElementOperation(driver,pageheader2);
		eo.assertText("Reset your password");
	}
	//check_email
	public void testCheckemail(){		
		String emailstr = check_email.getText();
		boolean is = emailstr.indexOf(currentemail)>0?true:false;
		Assert.assertEquals(is, true);
	}
	
	//resend
	public void testResend(){
		resend.click();
	}
}
