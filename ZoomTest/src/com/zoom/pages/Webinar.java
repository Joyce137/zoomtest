package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Webinar {
	//����LocatorManager����
	private LocatorManager yaml; 
	//Ŀ䛲ˆνM��
	private WebElement upcoming, previous;
	//meeting info
	private WebElement webinardate, webinartime, webinartopic, webinarid, start, end, schedule;
	
	//���캯����ʼ���M��
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

	//�M��get����
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

	
	//�M�������yԇ����
	
}
