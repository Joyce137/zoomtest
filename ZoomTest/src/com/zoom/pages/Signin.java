package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Signin {
	//����YamlReader����
	private YamlReader yaml; 
	//�M��
	private WebElement pageheader, email, password, signin, google, facebook, signup, forgot;
	
	//���캯����ʼ���M��
	public Signin(){
		pageheader = yaml.getElement("pageheader");
		email = yaml.getElement("email");
		password = yaml.getElement("password");
		signin = yaml.getElement("signin");
		google = yaml.getElement("google");
		facebook = yaml.getElement("facebook");
		signup = yaml.getElement("signup");
		forgot = yaml.getElement("forgot");
	}

	//�M��get����
	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignin() {
		return signin;
	}

	public WebElement getGoogle() {
		return google;
	}

	public WebElement getFacebook() {
		return facebook;
	}

	public WebElement getSignup() {
		return signup;
	}

	public WebElement getForgot() {
		return forgot;
	}

	public WebElement getPageheader() {
		return pageheader;
	}

	public WebElement getEmail() {
		return email;
	}

	//�M�������yԇ����
	
}
