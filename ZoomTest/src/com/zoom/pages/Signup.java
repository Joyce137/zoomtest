package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.KeyActions;
import com.zoom.cons.LocatorManager;
import com.zoom.database.DataManager;

public class Signup {
	private WebDriver driver = DriverManager.getDriver();
	//����LocatorManager����
	private LocatorManager yaml = new LocatorManager("signup"); 
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
	//pageheader, email, signup, google, facebook, signin
	public void testPageheader(){
		ElementOperation eo = new ElementOperation(driver,pageheader);
		eo.assertText("Sign Up Free");
	}
	public void testEmail(String value){
		ElementOperation eo = new ElementOperation(driver, email);
		eo.assertText(value);
	}
	public void testSignup(){
		String sql = "select * from user where email = "+email.getText();
		String result = DataManager.query(sql);
		if(result != null){
			return;
		}
		else{
			ElementOperation eo = new ElementOperation(driver, signup);
			eo.linkOperation("signup");
			KeyActions.onekey("enter");
			String emailstr = email.getText();
			String sql1 = "insert user(email) values("+emailstr;
			DataManager.executesql(sql1);
		}
	}
	WebElement links[] = {google, facebook, signin};
	String linkstr[] = {"google", "facebook", "signin"};
	public void testLinks(int i){
		ElementOperation eo = new ElementOperation(driver, links[i]);
		eo.linkOperation(linkstr[i]);
	}
}
