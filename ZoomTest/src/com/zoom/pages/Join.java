package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.utils.Checkid;

public class Join {
	private WebDriver driver = DriverManager.getDriver();
	//����LocatorManager����
	private LocatorManager yaml;
	
	private WebElement pageheader, meetingid, joinbtn, h323, error_meeting, check_msg;
	
	public Join(){
		pageheader = yaml.getElement("pageheader");
		meetingid = yaml.getElement("meetingid");
		joinbtn = yaml.getElement("joinbtn");
		h323 = yaml.getElement("h323");
		error_meeting = yaml.getElement("error_meeting");
		check_msg = yaml.getElement("check_msg");
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
	
	//�M���Ļ����yԇ����
	String currentmid = null;
	//pageheader
	public void testPageheader(){
		ElementOperation eo = new ElementOperation(driver,pageheader);
		eo.assertText("Join a Meeting");
	}
	//meetingid
	public void testMeetingid(String value){
		ElementOperation eo = new ElementOperation(driver,meetingid);
		eo.inputOperation(value);
		currentmid = value;
	}
	//joinbtn
	public void testJoinbtn(){
		
	}
	//h323
	public void testH323(){
		
	}
	//error_meeting
	public void testErrormsg(){
		if(Checkid.isExisted(currentmid)){
			ElementOperation eo = new ElementOperation(driver,pageheader);
			eo.assertText("This meeting has ended or ID is not valid. Please check and re-enter again.");
		}
	}
	//check_msg
	public void testCheckmsg(){
		ElementOperation eo = new ElementOperation(driver,check_msg);
		eo.assertText("Your meeting ID is a 9, 10, or 11-digit number");
	}
	
}
