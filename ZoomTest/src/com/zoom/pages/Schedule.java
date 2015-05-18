package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Schedule {
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("schedule");;
	//meeting info
	private WebElement topic, startdate, starttime, am_pm, durationhour, durationmin, timezone, rm, schdulefor;
	//meeting option
	private WebElement video, p_video, audio, requre_pwd, password, jbh, withpmi, cn;
	private WebElement schedule, cancel;
	public Schedule(){
		topic = yaml.getElement("topic");
		startdate = yaml.getElement("startdate");
		starttime = yaml.getElement("starttime");
		am_pm = yaml.getElement("am_pm");
		durationhour = yaml.getElement("durationhour");
		durationmin = yaml.getElement("durationmin");
		timezone = yaml.getElement("timezone");
		rm = yaml.getElement("rm");
		schdulefor = yaml.getElement("schdulefor");
		video = yaml.getElement("video");
		p_video = yaml.getElement("p_video");
		audio = yaml.getElement("audio");
		requre_pwd = yaml.getElement("requre_pwd");
		password = yaml.getElement("password");
		jbh = yaml.getElement("jbh");
		withpmi = yaml.getElement("withpmi");
		cn = yaml.getElement("cn");
		schedule = yaml.getElement("schedule");
		cancel = yaml.getElement("cancel");
	}
	public WebElement getTopic() {
		return topic;
	}
	public WebElement getStartdate() {
		return startdate;
	}
	public WebElement getStarttime() {
		return starttime;
	}
	public WebElement getAm_pm() {
		return am_pm;
	}
	public WebElement getDurationhour() {
		return durationhour;
	}
	public WebElement getDurationmin() {
		return durationmin;
	}
	public WebElement getTimezone() {
		return timezone;
	}
	public WebElement getRm() {
		return rm;
	}
	public WebElement getSchdulefor() {
		return schdulefor;
	}
	public WebElement getVideo() {
		return video;
	}
	public WebElement getP_video() {
		return p_video;
	}
	public WebElement getAudio() {
		return audio;
	}
	public WebElement getRequre_pwd() {
		return requre_pwd;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getJbh() {
		return jbh;
	}
	public WebElement getWithpmi() {
		return withpmi;
	}
	public WebElement getCn() {
		return cn;
	}
	public WebElement getSchedule() {
		return schedule;
	}
	public WebElement getCancel() {
		return cancel;
	}
	
	//各組件的基本測試函數
	
}
