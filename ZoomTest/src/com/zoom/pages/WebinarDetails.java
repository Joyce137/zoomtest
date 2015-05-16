package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class WebinarDetails {
	//創建LocatorManager實例
	private LocatorManager yaml; 
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
	
}
