package com.zoom.cons;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyActions {
	private static WebDriver driver = DriverManager.getDriver();
	//Ä£”MæI±P•rég
	public static void onekey(String keystr){
		Keys k = null;
		if(keystr == "enter"){
			k = Keys.ENTER;
		}
		Actions builder = new Actions(driver);
		builder.keyDown(k).perform();
	}
}
