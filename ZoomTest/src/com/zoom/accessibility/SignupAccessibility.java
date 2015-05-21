package com.zoom.accessibility;

import org.openqa.selenium.WebDriver;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.DriverManager;
import com.zoom.cons.UrlManager;
import com.zoom.pages.Signup;

public class SignupAccessibility {
	public SignupAccessibility(){
		WebDriver driver = DriverManager.getDriver();
		BrowserAction.openUrl(UrlManager.getUrl("signup"));
		Signup signup = new Signup();
		
	}
}
