package com.zoom.tasks;

import org.testng.annotations.Test;

import com.zoom.cons.BrowserAction;
import com.zoom.pages.Webinar;
import com.zoom.pages.WebinarDetails;
import com.zoom.pages.WebinarSetting;
import com.zoom.testdata.WebinarData;

public class WebinarTask {
	private Webinar webinar = new Webinar();
	private WebinarDetails w_detail = new WebinarDetails();
	private WebinarSetting w_setting = new WebinarSetting();
	String filepath1 = WebinarData.getFilepath1();
	String filepath2 = WebinarData.getFilepath2();
	
	//webinar page
	@Test
	public void webinarpage(){
		webinar.testUpcoming();
		webinar.testPrevious();
		webinar.testUpcoming();
		webinar.testPrevious();
		webinar.testStart();
		BrowserAction.back();
		webinar.testPrevious();
		webinar.testEnd();
		webinar.testSchedule();
		BrowserAction.back();
		BrowserAction.refresh();
	}
	
	//webinar detail page
	@Test
	public void webinardetail(){
		w_detail.testWebinarinfo();
		w_detail.testUpload1(filepath1);
		w_detail.testUpload2(filepath2);		
		//edits
		w_detail.testEdit();		
		//start
		w_detail.testStart();
	}
	
	//webinar setting page
	@Test
	public void webianrsetting(){
		w_setting.testUpload1(filepath1);
		w_setting.testDelete1();
		w_setting.testUpload2(filepath2);
		w_setting.testDelete2();
		
		w_setting.testEdits();
		w_setting.testEmailsettingedits();
	}
}
