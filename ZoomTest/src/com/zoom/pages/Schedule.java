package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.database.DataManager;

public class Schedule {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("schedule");
	private int meetingid;
	//meeting info
	private WebElement topic, startdate, starttime, am_pm, durationhour, durationmin, timezone, rm, schedulefor;
	//meeting option
	private WebElement video, p_video, audio, require_pwd, password, jbh, withpmi, cn;
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
		schedulefor = yaml.getElement("schedulefor");
		video = yaml.getElement("video");
		p_video = yaml.getElement("p_video");
		audio = yaml.getElement("audio");
		require_pwd = yaml.getElement("require_pwd");
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
	public WebElement getSchedulefor() {
		return schedulefor;
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
	public WebElement getRequire_pwd() {
		return require_pwd;
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
	public Schedule(int meetingid){
		topic = yaml.getElement("topic");
		startdate = yaml.getElement("startdate");
		starttime = yaml.getElement("starttime");
		am_pm = yaml.getElement("am_pm");
		durationhour = yaml.getElement("durationhour");
		durationmin = yaml.getElement("durationmin");
		timezone = yaml.getElement("timezone");
		rm = yaml.getElement("rm");
		schedulefor = yaml.getElement("schedulefor");
		video = yaml.getElement("video");
		p_video = yaml.getElement("p_video");
		audio = yaml.getElement("audio");
		require_pwd = yaml.getElement("require_pwd");
		password = yaml.getElement("password");
		jbh = yaml.getElement("jbh");
		withpmi = yaml.getElement("withpmi");
		cn = yaml.getElement("cn");
		schedule = yaml.getElement("schedule");
		cancel = yaml.getElement("cancel");
	}
	
	//各組件的基本測試函數
	//meeting info: topic, startdate, starttime, am_pm, durationhour, durationmin, timezone, rm, schdulefor;
	public void testTopic(String value){
		ElementOperation eo = new ElementOperation(driver, topic);
		eo.assertText(value);
	}
	WebElement selects[] = {startdate, starttime, am_pm, durationhour, durationmin, schedulefor};
	//String selectstr[] = {"startdate", "starttime", "am_pm", "durationhour", "durationmin", "schdulefor"};
	public void testSelects(int i, String value){
		ElementOperation eo = new ElementOperation(driver, selects[i]);
		eo.selectorOperation(value);
	}
	public void testrm(){
		rm.click();
	}
	//meeting option: video, p_video, audio, requre_pwd, password, jbh, withpmi, cn;
	WebElement radios[] = {video, p_video, audio};
	public void testRadios(int i, int index){
		ElementOperation eo = new ElementOperation(driver, radios[i]);
		eo.radioOperation(index);
	}
	WebElement checks[] = {require_pwd, jbh, withpmi, cn};
	public void testChecks(int i){
		checks[i].click();
	}
	public void testPassword(String value){
		ElementOperation eo = new ElementOperation(driver, password);
		eo.assertText(value);
	}
	//meeting option(14): schedule, cancel;
	WebElement meetinginfo[] = {topic, starttime, durationhour, timezone, rm, schedulefor, 
			video, p_video, audio, require_pwd, password, jbh, withpmi, cn};
	String meetinginfostr[] = {"topic", "time", "duration", "zone", "isrecurring", "schedulefor", 
			"video", "p_video", "audio", "require_pwd", "password", "jbh", "withpmi", "cn"};
	String mtgvalue[] = new String [14];
	public void testSchedule(){
		schedule.click();
		//topic, startdate, starttime, am_pm, durationhour, durationmin, timezone, rm, schdulefor;
		//video, p_video, audio, require_pwd, password, jbh, withpmi, cn;
		mtgvalue[0] = topic.getText();
		String time = startdate.getText()+" "+starttime.getText()+am_pm.getAttribute("value");
		mtgvalue[1] = time;
		String duration = durationhour.getText()+" "+durationmin;
		mtgvalue[2] = duration;
		for(int i = 3;i<meetinginfo.length;i++){
			mtgvalue[i] = meetinginfo[i].getText();
		}
		for(int i = 0;i<meetinginfo.length;i++){
			String sql = "update meetinginfo set "+meetinginfostr[i]+"= "+mtgvalue[i]+" where id = "+meetingid;
			DataManager.executesql(sql);
		}
	}
	public void testCancel(){
		ElementOperation eo = new ElementOperation(driver, cancel);
		eo.linkOperation("upcoming_meeting");
	}
}
