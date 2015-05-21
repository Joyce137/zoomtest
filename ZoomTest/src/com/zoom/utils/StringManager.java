package com.zoom.utils;

import java.util.Random;

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
	
	//�õ��������
	public static int getRandom(){
		Random r = new Random();
		return r.nextInt();
	}
	
	//�Д�һ��string�Ƿ�����λ����
	public static boolean test6digital(String value){
		if(value.length() != 6)
			return false;
		for(int i = 0;i<6;i++){
			if(value.charAt(i)<'0'||value.charAt(i)>'9')
				return false;
		}
		return true;
	}
	
	//�Д�һ��string�Ƿ��Ǻ����password
	public static boolean testPwdOk(String value){
		if(value.length() < 6)
			return false;
		return true;
	}
}
