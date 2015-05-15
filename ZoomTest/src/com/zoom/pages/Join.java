package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Join {
	//創建YamlReader實例
	private YamlReader yaml;
	
	private WebElement pageheader, meetingid, joinbtn, h323, error_meeting, check_msg;
	
	public Join(){
		pageheader = yaml.getElement("pageheader");
		meetingid = yaml.getElement("meetingid");
		joinbtn = yaml.getElement("joinbtn");
		h323 = yaml.getElement("h323");
		error_meeting = yaml.getElement("error_meeting");
		check_msg = yaml.getElement("check_msg");
	}

	public YamlReader getYaml() {
		return yaml;
	}

	public WebElement getPageheader() {
		return pageheader;
	}

	public WebElement getMeetingid() {
		return meetingid;
	}

	public WebElement getJoinbtn() {
		return joinbtn;
	}

	public WebElement getH323() {
		return h323;
	}

	public WebElement getError_meeting() {
		return error_meeting;
	}

	public WebElement getCheck_msg() {
		return check_msg;
	}
	
	//組件的基本測試函數
	
}
