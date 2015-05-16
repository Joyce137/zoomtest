package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Signup {
	//����LocatorManager����
	private LocatorManager yaml; 
	//�M��
	private WebElement pageheader, email, signup, google, facebook, signin;
	
	//���캯����ʼ���M��
	public Signup(){
		pageheader = yaml.getElement("pageheader");
	    email = yaml.getElement("email");
	    signup = yaml.getElement("signup");
	    google = yaml.getElement("google");
	    facebook = yaml.getElement("facebook");
	    signin = yaml.getElement("signin");
	}

	//�M��get����
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

	//�M�������yԇ����
	
}
