package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Signup {
	//創建LocatorManager實例
	private LocatorManager yaml; 
	//組件
	private WebElement pageheader, email, signup, google, facebook, signin;
	
	//構造函數初始化組件
	public Signup(){
		pageheader = yaml.getElement("pageheader");
	    email = yaml.getElement("email");
	    signup = yaml.getElement("signup");
	    google = yaml.getElement("google");
	    facebook = yaml.getElement("facebook");
	    signin = yaml.getElement("signin");
	}

	//組件get函數
	public WebElement getPageheader() {
		return pageheader;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSignup() {
		return signup;
	}

	public WebElement getGoogle() {
		return google;
	}

	public WebElement getFacebook() {
		return facebook;
	}

	public WebElement getSignin() {
		return signin;
	}

	//組件基本測試函數
	
}
