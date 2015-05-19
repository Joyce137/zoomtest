package com.zoom.utils;

import org.openqa.selenium.WebDriver;

import com.zoom.cons.DriverManager;

public class StringManager {
	//�ַ���str1�Ƿ�����ַ���str2
	public static boolean contains(String str1, String str2){
		if(str1.indexOf(str2)>0)
			return true;
		else
			return false;
	}
	
	private static WebDriver driver= DriverManager.getDriver();
	//ͨ�^��ǰurl�ֽ��curmeetingid
	public static String getCurmeetingid(){
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('g');
		return cururl.substring(index+2, cururl.length());
	}	
	
	//ͨ�^��ǰurl�ֽ��curwebinarid
	public static String getCurwebinarid(){
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('r');
		return cururl.substring(index+2, cururl.length());
	}
}
