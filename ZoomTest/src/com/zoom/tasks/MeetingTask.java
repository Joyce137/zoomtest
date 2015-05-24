package com.zoom.tasks;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.UrlManager;
import com.zoom.pages.MainPage;
import com.zoom.pages.Join;
import com.zoom.pages.Meeting;
import com.zoom.pages.MeetingDetails;
import com.zoom.pages.Schedule;
import com.zoom.testdata.MeetingData;
import com.zoom.utils.StringManager;

public class MeetingTask {
	private MainPage main = new MainPage();
	private Join join = new Join();
	private Meeting meeting = new Meeting();
	private MeetingDetails mtgdetail = new MeetingDetails();
	private Schedule schedule = new Schedule();
	private String meetingids[] = MeetingData.getMtgids();

	// join meeting
	@Test(dataProvider = "meeting")
	public void join() {
		//打開join page
		BrowserAction.openUrl(UrlManager.getUrl("main"));
		main.testSign(2);
		//test join page
		join.testPageheader();
		
		//使用不同的meeting id測試
		for (int i = 0; i < meetingids.length; i++) {
			join.testMeetingid(meetingids[i]);
			join.testErrormsg();
			join.testCheckmsg();
			join.testJoinbtn();
			BrowserAction.openUrl(UrlManager.getUrl("join"));
		}
		//h323link
		join.testH323();
	}

	// host meeting
	@Test
	public void host() {
		BrowserAction.openUrl(UrlManager.getUrl("main"));
		main.testHost(0);
		BrowserAction.back();
		main.testHost(1);
		BrowserAction.back();
		Assert.assertEquals(BrowserAction.getCurrenturl(),
				UrlManager.getUrl("main"));
	}
	
	@Test
	public void host(int i) {
		BrowserAction.openUrl(UrlManager.getUrl("main"));
		main.testHost(i);
		//System.out.println("正在開"+i+"的會");
	}

	// schedule meeting
	@Test
	public void schedule() {
		BrowserAction.openUrl(UrlManager.getUrl("meeting"));
		meeting.testSchedule();
		// topic
		schedule.testTopic("Meeting " + StringManager.getRandom());
		// date time am_pm（默認當前）
		schedule.testSelects(0, null);
		schedule.testSelects(1, null);
		schedule.testSelects(2, null);
		//duration
		schedule.testSelects(3, "2");
		schedule.testSelects(4, "15");
		//schedule for
		schedule.testSelects(5, null);
		//rm
		schedule.testrm();		//check
		schedule.testrm();		//uncheck
		//video, p_video, audio
		schedule.testRadios(0, 0);
		schedule.testRadios(1, 0);
		schedule.testRadios(2, 2);
		//require_pwd, jbh, withpmi, cn
		schedule.testChecks(0);
		schedule.testPassword("123");
		schedule.testChecks(1);
		schedule.testChecks(2);
		schedule.testChecks(3);

		//schedule btn
		schedule.testSchedule();
		
		//cancel btn
		BrowserAction.openUrl(UrlManager.getUrl("schedule"));
		schedule.testCancel();
	}
	
	//meeting page
	@Test
	public void meetingpage(){
		BrowserAction.openUrl(UrlManager.getUrl("meeting"));
		//目錄菜單組件
		meeting.testPrevious();
		meeting.testUpcoming();
		//pmi
		meeting.testPmroom();
		meeting.testPmidetail(0);
		
		//meeting action
		meeting.testStart();
		BrowserAction.openUrl(UrlManager.getUrl("meeting"));
		meeting.testEnd();
		meeting.testParing();
		meeting.testH323();
	}
	
	//meeting detail page
	@Test
	public void meetingdetailpage(){
		//在meeting page點擊某個meetingtopic，進入meeting detail page
		BrowserAction.openUrl(UrlManager.getUrl("meeting"));
		meeting.getMeetingtopic().click();
		
		//meeting details
		mtgdetail.testMeetinginfo();
		mtgdetail.testCopy();
		mtgdetail.testEdit();
		mtgdetail.testStart();
		BrowserAction.openUrl(UrlManager.getUrl("meeting"));
	}
}
