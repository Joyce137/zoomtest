package com.zoom.utils;

public class StringManager {
	//×Ö·û´®str1ÊÇ·ñ°üº¬×Ö·û´®str2
	public static boolean contains(String str1, String str2){
		if(str1.indexOf(str2)>0)
			return true;
		else
			return false;
	}
}
