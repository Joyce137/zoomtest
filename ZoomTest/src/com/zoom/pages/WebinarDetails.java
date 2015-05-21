package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.database.DataManager;
import com.zoom.utils.StringManager;

public class WebinarDetails {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("webinar_details"); 
	//webinar info組件
	private WebElement topic, time, calendar, id, audio, disbleqa, edit;
	//branding
	private WebElement upload1, upload2;
	//panelist
	private WebElement panelist_edit;
	//attendee
	private WebElement attendee_view, invite_edit, copy_invitation, copy_email, attendees;
	//email settings
	private WebElement emailsettingedit1, emailsettingedit2, emailsettingedit3, emailsettingedit4, emailsettingedit5, emailsettingedit6;
	private WebElement emailsettingedits[] = {emailsettingedit1, emailsettingedit2, emailsettingedit3, emailsettingedit4, emailsettingedit5, emailsettingedit6};
	//poll
	private WebElement polledit;
	private WebElement start;
	
	//構造函數初始化組件
	public WebinarDetails(){
		topic = yaml.getElement("topic");
		time = yaml.getElement("time");
		calendar = yaml.getElement("calendar");
		id = yaml.getElement("id");
		audio = yaml.getElement("audio");
		disbleqa = yaml.getElement("disbleqa");
		edit = yaml.getElement("edit");
		upload1 = yaml.getElement("upload1");
		upload2 = yaml.getElement("upload2");
		panelist_edit = yaml.getElement("panelist_edit");
		attendee_view = yaml.getElement("attendee_view");
		invite_edit = yaml.getElement("invite_edit");
		copy_invitation = yaml.getElement("copy_invitation");
		copy_email = yaml.getElement("copy_email");
		attendees = yaml.getElement("attendees");
		for(int i = 1;i <= 6;i++){
			emailsettingedits[i] = yaml.getElement("emailsettingedit" + i);
		}
		polledit = yaml.getElement("polledit");
		start = yaml.getElement("start");
	}
	
	//組件get函數
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

	public WebElement getAudio() {
		return audio;
	}

	public WebElement getDisbleqa() {
		return disbleqa;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getUpload1() {
		return upload1;
	}

	public WebElement getUpload2() {
		return upload2;
	}

	public WebElement getPanelist_edit() {
		return panelist_edit;
	}

	public WebElement getAttendee_view() {
		return attendee_view;
	}

	public WebElement getInvite_edit() {
		return invite_edit;
	}

	public WebElement getCopy_invitation() {
		return copy_invitation;
	}

	public WebElement getCopy_email() {
		return copy_email;
	}

	public WebElement getAttendees() {
		return attendees;
	}

	public WebElement getEmailsettingedit1() {
		return emailsettingedit1;
	}

	public WebElement getEmailsettingedit2() {
		return emailsettingedit2;
	}

	public WebElement getEmailsettingedit3() {
		return emailsettingedit3;
	}

	public WebElement getEmailsettingedit4() {
		return emailsettingedit4;
	}

	public WebElement getEmailsettingedit5() {
		return emailsettingedit5;
	}

	public WebElement getEmailsettingedit6() {
		return emailsettingedit6;
	}

	public WebElement[] getEmailsettingedits() {
		return emailsettingedits;
	}

	public WebElement getPolledit() {
		return polledit;
	}

	public WebElement getStart() {
		return start;
	}

	//組件基本測試函數
	//webinar info
	String webinarid = StringManager.getCurmeetingid();
	WebElement webinarinfo[] = {topic, time, calendar, id, audio, disbleqa};
	String webinarinfostr[] = {"topic", "time", "calendar", "id", "audio", "disbleqa"};
	public void testWebinarinfo(){
		for(int i = 0;i < webinarinfo.length; i++){
			String sql = "select "+webinarinfostr[i]+" from webinar where id = "+webinarid;
			String value = DataManager.query(sql);
			Assert.assertEquals(webinarinfo[i].getText(), value);
		}
	}

	//upload1, upload2
	public void testUpload1(String filepath){
		ElementOperation eo = new ElementOperation(driver, upload1);
		eo.uploadOperation(filepath);
	}
	public void testUpload2(String filepath){
		ElementOperation eo = new ElementOperation(driver, upload2);
		eo.uploadOperation(filepath);
	}
	
	//edits(13)
	WebElement edits[] = {panelist_edit, attendee_view, invite_edit, copy_invitation, copy_email, attendees,
			emailsettingedit1, emailsettingedit2, emailsettingedit3, emailsettingedit4, emailsettingedit5, 
			emailsettingedit6, polledit};
	public void testEdit(){
		for(int i = 0;i<edits.length;i++){
			ElementOperation eo = new ElementOperation(driver, edits[i]);
			eo.alertOperation(0);
			BrowserAction.refresh();
		}
	}
	
	public void testStart(){
		start.click();
		String cururl = driver.getCurrentUrl();
		int index = cururl.indexOf('s');
		String starturl = cururl.substring(index+2, cururl.length());
		Assert.assertEquals(starturl, webinarid);
	}
}
