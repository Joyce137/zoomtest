package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.DriverManager;
import com.zoom.cons.LocatorManager;
import com.zoom.database.DataManager;
import com.zoom.utils.StringManager;

public class MeetingDetails {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("meeting_datails");;
	//meeting info
	private WebElement topic, time, calendar, id;
	//meeting setting
	private WebElement video, p_video, audio;
	//meeting option
	private WebElement jbh, hostcn;
	//meeting action
	private WebElement copy, edit, start;
	
	public MeetingDetails(){
		topic = yaml.getElement("topic");
		time = yaml.getElement("time");
		calendar = yaml.getElement("calendar");
		id = yaml.getElement("id");
		video = yaml.getElement("video");
		p_video = yaml.getElement("p_video");
		audio = yaml.getElement("audio");
		jbh = yaml.getElement("jbh");
		hostcn = yaml.getElement("hostcn");
		copy = yaml.getElement("copy");
		edit = yaml.getElement("edit");
		start = yaml.getElement("start");
	}

	public WebElement getTopic() {
		return topic;
	}

	public WebElement getTime() {
		return time;
	}

	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getId() {
		return id;
	}

	public WebElement getJbh() {
		return jbh;
	}

	public WebElement getHostcn() {
		return hostcn;
	}

	public WebElement getCopy() {
		return copy;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getStart() {
		return start;
	}
	
	//組件的基本測試函數
	String meetingid = StringManager.getCurmeetingid();
	WebElement meetinginfo[] = {topic, time, calendar, id, video, p_video, audio, jbh, hostcn};
	String meetinginfostr[] = {"topic", "time", "calendar", "id", "video", "p_video", "audio", "jbh", "hostcn"};
	//String meetinginfovalues[] = new String[meetinginfo.length];
	public void testMeetinginfo(){
		for(int i = 0;i < meetinginfo.length; i++){
			String sql = "select "+meetinginfostr[i]+" from meetinginfo where id = "+meetingid;
			String value = DataManager.query(sql);
			Assert.assertEquals(meetinginfo[i].getText(), value);
		}
	}
	
	public void testCopy(){
		copy.click();
		BrowserAction.refresh();
	}
	
	public void testEdit(){
		edit.click();
		String cururl = driver.getCurrentUrl();
		String starturl = "https://dev.zoom.us/meeting/"+meetingid+"/edit";
		Assert.assertEquals(starturl, cururl);
	}
	
	public void testStart(){
		start.click();
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('s');
		String starturl = cururl.substring(index+2, cururl.length());
		Assert.assertEquals(starturl, meetingid);
	}
}
