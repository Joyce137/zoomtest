package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Meeting {
	//創建YamlReader實例
	private YamlReader yaml;
	//目錄菜單組件
	private WebElement upcoming, previous;
	//pmi
	private WebElement pmroom, pmidetail;
	//meeting info
	private WebElement meetingdate, meetingtime, meetingtopic, meetingid;
	//meeting action
	private WebElement start, paring, end, h323, schedule;
	
	public Meeting(){
		upcoming = yaml.getElement("upcoming");
		previous = yaml.getElement("previous");
		pmroom = yaml.getElement("pmroom");
		pmidetail = yaml.getElement("pmidetail");
		meetingdate = yaml.getElement("meetingdate");
		meetingtime = yaml.getElement("meetingtime");
		meetingtopic = yaml.getElement("meetingtopic");
		meetingid = yaml.getElement("meetingid");
		start = yaml.getElement("start");
		paring = yaml.getElement("paring");
		end = yaml.getElement("end");
		h323 = yaml.getElement("h323");
		schedule = yaml.getElement("schedule");
	}

	public YamlReader getYaml() {
		return yaml;
	}

	public WebElement getUpcoming() {
		return upcoming;
	}

	public WebElement getPrevious() {
		return previous;
	}

	public WebElement getPmroom() {
		return pmroom;
	}

	public WebElement getPmidetail() {
		return pmidetail;
	}

	public WebElement getMeetingdate() {
		return meetingdate;
	}

	public WebElement getMeetingtime() {
		return meetingtime;
	}

	public WebElement getMeetingtopic() {
		return meetingtopic;
	}

	public WebElement getMeetingid() {
		return meetingid;
	}

	public WebElement getStart() {
		return start;
	}

	public WebElement getParing() {
		return paring;
	}

	public WebElement getEnd() {
		return end;
	}

	public WebElement getH323() {
		return h323;
	}

	public WebElement getSchedule() {
		return schedule;
	}
	
	//組件的基本測試函數
	
}
