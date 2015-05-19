package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.cons.UrlManager;
import com.zoom.database.DataManager;
import com.zoom.utils.Checkid;
import com.zoom.utils.StringManager;

public class Meeting {
	private WebDriver driver= DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("meeting");
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
	//upcoming, previous
	public void testUpcoming(){
		String currenturl = driver.getCurrentUrl();
		if(currenturl.equals(UrlManager.getUrl("meeting"))){
			return;
		}
		else{
			ElementOperation eo = new ElementOperation(driver, upcoming);
			eo.linkOperation("upcoming_meeting");
		}
	}
	public void testPrevious(){
		ElementOperation eo = new ElementOperation(driver, previous);
		eo.linkOperation("previous_meeting");
	}
	//pmroom, pmidetail
	public void testPmroom(){
		ElementOperation eo = new ElementOperation(driver, pmroom);
		eo.assertText("Personal Meeting Room");
	}
	//get current pmi
	public String getCurrentpmi(int userid){
		return DataManager.getpmi(userid);
	}
	//pmidetail
	public void testPmidetail(int userid){
		ElementOperation eo = new ElementOperation(driver, pmidetail);
		String url = "https://dev.zoom.us/meeting/"+getCurrentpmi(userid);
		eo.linkUrl(url);
	}
	
	String curmeetingid = StringManager.getCurmeetingid();
	
	//start, paring, end, h323, schedule
	public void testStart(){
		start.click();
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('s');
		String starturl = cururl.substring(index+2, cururl.length());
		Assert.assertEquals(starturl, curmeetingid);
	}
	public void testParing(){
		paring.click();
	}
	public void testEnd(){
		if(Checkid.isOpening(curmeetingid)){
			Assert.assertTrue(end.isDisplayed());
			end.click();
			Assert.assertTrue(!end.isDisplayed());
		}
		else{
			Assert.assertTrue(!end.isDisplayed());
		}
	}
	public void testH323(){
		h323.click();
	}
	public void testSchedule(){
		ElementOperation eo = new ElementOperation(driver, schedule);
		eo.linkOperation("schedule");
	}
}
