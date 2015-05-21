package com.zoom.testdata;

import org.testng.annotations.DataProvider;

public class WebinarData {
	private static String webinarids[] = {"9876543212","98765432","649-402-572","273-500-347","sdgg"};
	private static String filepath1 = "/res/a.jpg";
	private static String filepath2 = "/res/b.jpg";
	
	@DataProvider(name = "webinar")
	public static String[] getWebinarids(){
		return webinarids;
	}
	
	@DataProvider(name = "filepath1")
	public static String getFilepath1(){
		return filepath1;
	}

	@DataProvider(name = "filepath2")
	public static String getFilepath2(){
		return filepath2;
	}
}
