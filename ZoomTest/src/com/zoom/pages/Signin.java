package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.database.DataManager;

public class Signin {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("signin"); 
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
	String currentmid = null;
	//pageheader, email, password, signin, google, facebook, signup, forgot;
	public void testPageheader(){
		ElementOperation eo = new ElementOperation(driver,pageheader);
		eo.assertText("Sign In");
	}
	public void testEmail(String value){
		ElementOperation eo = new ElementOperation(driver, email);
		eo.assertText(value);
	}
	public void testPassword(String value){
		ElementOperation eo = new ElementOperation(driver, password);
		eo.assertText(value);
	}
	public void testSignin(){
		String sql = "select * from user where email = "+email.getText();
		String result = DataManager.query(sql);
		if(result == null){
			return;
		}
		else{
			ElementOperation eo = new ElementOperation(driver, signin);
			eo.linkOperation("meeting");
		}
	}
	WebElement links[] = {google, facebook, signup};
	String linkstr[] = {"google", "facebook", "signup"};
	public void testLinks(){
		for(int i = 0;i<links.length;i++){
			ElementOperation eo = new ElementOperation(driver, links[i]);
			eo.linkOperation(linkstr[i]);
			BrowserAction.back();
		}
	}
	
	//forgot password
	public void testForget(){
		ElementOperation eo = new ElementOperation(driver, forgot);
		eo.linkOperation("forget_pwd");
	}
	
}
