package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Webinar {
	//創建LocatorManager實例
	private LocatorManager yaml; 
	//目錄菜單組件
	private WebElement upcoming, previous;
	//meeting info
	private WebElement webinardate, webinartime, webinartopic, webinarid, start, end, schedule;
	
	//構造函數初始化組件
	public Webinar(){
		upcoming = yaml.getElement("upcoming");
		previous = yaml.getElement("previous");
		webinardate = yaml.getElement("webinardate");
		webinartime = yaml.getElement("webinartime");
		webinartopic = yaml.getElement("webinartopic");
		webinarid = yaml.getElement("webinarid");
		start = yaml.getElement("start");
		end = yaml.getElement("end");
		schedule = yaml.getElement("schedule");
	}

	//組件get函數
	public WebElement getUpcoming() {
		return upcoming;
	}

	public WebElement getPrevious() {
		return previous;
	}

	public WebElement getWebinardate() {
		return webinardate;
	}

	public WebElement getWebinartime() {
		return webinartime;
	}

	public WebElement getWebinartopic() {
		return webinartopic;
	}

	public WebElement getWebinarid() {
		return webinarid;
	}

	public WebElement getStart() {
		return start;
	}

	public WebElement getEnd() {
		return end;
	}

	public WebElement getSchedule() {
		return schedule;
	}

	
	//組件基本測試函數
	
}
