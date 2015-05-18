package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class MeetingDetails {
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("meeting_datails");;
	//meeting info
	private WebElement topic, time, calendar, id;
	//meeting setting
	private WebElement hostradio, hoston, hostoff, videoradio, videoon, videooff, audioradio;
	//meeting option
	private WebElement jbh, hostcn;
	//meeting action
	private WebElement copy, edit, start;
	
	public MeetingDetails(){
		topic = yaml.getElement("topic");
		time = yaml.getElement("time");
		calendar = yaml.getElement("calendar");
		id = yaml.getElement("id");
		hostradio = yaml.getElement("hostradio");
		hoston = yaml.getElement("hoston");
		hostoff = yaml.getElement("hostoff");
		videoradio = yaml.getElement("videoradio");
		videoon = yaml.getElement("videoon");
		videooff = yaml.getElement("videooff");
		audioradio = yaml.getElement("audioradio");
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

	public WebElement getHostradio() {
		return hostradio;
	}

	public WebElement getHoston() {
		return hoston;
	}

	public WebElement getHostoff() {
		return hostoff;
	}

	public WebElement getVideoradio() {
		return videoradio;
	}

	public WebElement getVideoon() {
		return videoon;
	}

	public WebElement getVideooff() {
		return videooff;
	}

	public WebElement getAudioradio() {
		return audioradio;
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
	
}
