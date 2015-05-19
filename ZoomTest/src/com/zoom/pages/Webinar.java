package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.cons.UrlManager;
import com.zoom.utils.Checkid;

public class Webinar {
	private WebDriver driver= DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("webinar"); 
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
	//upcoming, previous
	public void testUpcoming(){
		String currenturl = driver.getCurrentUrl();
		if(currenturl.equals(UrlManager.getUrl("webinar"))){
			return;
		}
		else{
			ElementOperation eo = new ElementOperation(driver, upcoming);
			eo.linkOperation("upcoming_webinar");
		}
	}
	public void testPrevious(){
		ElementOperation eo = new ElementOperation(driver, previous);
		eo.linkOperation("previous_webinar");
	}
	//通過當前url分解出curmeetingid
	public String getCurmeetingid(){
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('r');
		return cururl.substring(index+2, cururl.length());
	}
	String curmeetingid = getCurmeetingid();
	
	//start, paring, end, h323, schedule
	public void testStart(){
		start.click();
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('s');
		String starturl = cururl.substring(index+2, cururl.length());
		Assert.assertEquals(starturl, curmeetingid);
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
	
	public void testSchedule(){
		ElementOperation eo = new ElementOperation(driver, schedule);
		eo.linkOperation("schedule_webinar");
	}
}
