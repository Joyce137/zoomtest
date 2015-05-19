package com.zoom.utils;

import org.openqa.selenium.WebDriver;

import com.zoom.cons.DriverManager;

public class StringManager {
	//字符串str1是否包含字符串str2
	public static boolean contains(String str1, String str2){
		if(str1.indexOf(str2)>0)
			return true;
		else
			return false;
	}
	
	private static WebDriver driver= DriverManager.getDriver();
	//通過當前url分解出curmeetingid
	public static String getCurmeetingid(){
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('g');
		return cururl.substring(index+2, cururl.length());
	}	
	
	//通過當前url分解出curwebinarid
	public static String getCurwebinarid(){
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('r');
		return cururl.substring(index+2, cururl.length());
	}
}
