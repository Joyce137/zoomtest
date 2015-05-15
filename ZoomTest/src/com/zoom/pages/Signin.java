package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Signin {
	//創建YamlReader實例
	private YamlReader yaml; 
	//組件
	private WebElement pageheader, email, password, signin, google, facebook, signup, forgot;
	
	//構造函數初始化組件
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

	//組件get函數
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

	//組件基本測試函數
	
}
