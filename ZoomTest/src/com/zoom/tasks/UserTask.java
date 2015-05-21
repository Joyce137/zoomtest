package com.zoom.tasks;

import org.testng.annotations.Test;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.UrlManager;
import com.zoom.database.DataManager;
import com.zoom.pages.Profile;
import com.zoom.pages.Recording;
import com.zoom.pages.Report;
import com.zoom.pages.User;
import com.zoom.testdata.MeetingData;
import com.zoom.testdata.UserData;
import com.zoom.testdata.WebinarData;

public class UserTask {
	private Profile profile;
	private Recording recording = new Recording();
	private Report report = new Report();
	private User user = new User();
	private String pmis[] = MeetingData.getMtgids();
	private String pmiurls[] = UserData.getPmiurls();
	private String hostkeys[] = UserData.getHostkeys();
	private String webinarids[] = WebinarData.getWebinarids();
	
	//profile(以clery為例）
	@Test
	public void profile(){
		//先登錄
		BrowserAction.openUrl(UrlManager.getUrl("signin"));
		SignTask sign = new SignTask();
		sign.signin(0);
		BrowserAction.openUrl(UrlManager.getUrl("profile"));
		profile = new Profile(0);
		//asserts: username, email, user_type, pmi, pmiurl
		for(int i = 0;i<5;i++){
			profile.testAsserts(0, i);
		}
		//changeurl
		for(int i = 0;i<5;i++){
			profile.testChangePMI();
			profile.testPMIText(pmis[i]);
			profile.testPMIsubmit();
		}
		profile.testChangePMI();
		profile.testPMIcancel();
		
		//changeurl
		for(int i = 0;i<5;i++){
			profile.testChangeurl();
			profile.testnewpv(pmiurls[i]);
			profile.testpvsubmit();
		}
		profile.testChangeurl();
		profile.testpvcancel();
	
		//changehostkey
		profile.testShowkey(true);
		profile.testShowkey(false);
		for(int i = 0;i<5;i++){
			profile.testChangekey();
			profile.testnewHostkey(hostkeys[i]);
			profile.testhostkeysubmit();
		}
		profile.testChangekey();
		profile.testhostkeycancel();
		
		//testOptions
		for(int i = 0;i<16;i++){
			profile.testOptions(0, 0, 0);
		}
		profile.testTeleconfinfo("teleconfinfo test------");
		
		//changepassword(測試不同的密碼組合)
		//true pwd
		String truepwd = DataManager.getuserinfo(0, "pwd");
		//testoldpwd 
		String oldpwds[] = {truepwd, truepwd+"0"};
		String newpwds[] = UserData.getTestpwd();
		for(int i = 0;i<oldpwds.length;i++){
			String oldpwd = oldpwds[i];
			for(int j = 0;j<newpwds.length;j++){
				String newpwd = newpwds[j];
				String confirmpwds[] = {newpwd, newpwd+"0"};
				for(int k = 0;k<confirmpwds.length;k++){
					String confirmpwd = confirmpwds[i];
					profile.testChangepassword();
					profile.testoldpassword(oldpwd);
					profile.testnewpassword(newpwd);
					profile.testConfirmpassword(confirmpwd);
					profile.testSaveChanged();
					profile.testChangepassword();
				}
			}
		}
		//testltiregenerate
		profile.testltiregenerate();
		//meetings
		profile.testmeetings();
	}	
	
	//recording
	@Test
	public void recording(){
		//打開recording page
		BrowserAction.openUrl(UrlManager.getUrl("recording"));
		recording.testDatefrom();
		recording.testDateto();
		recording.testGo();
		recording.testDetail();
		BrowserAction.back();
		recording.testDelete();
	}
	
	//report
	@Test
	public void report(){
		//打開report page
		BrowserAction.openUrl(UrlManager.getUrl("report"));
		//目錄菜單組件: daily, usage, inactive, telephony, webinar;
		for(int i = 0;i<5;i++){
			report.testMeuns(i);
		}		
		BrowserAction.refresh();
		
		//daily report
		report.testMeuns(0);
		report.testSelectmonth(null);
		report.testExport1();
		report.testBacktotop();
		
		//usage report
		report.testMeuns(1);
		report.testDatefrom(null);
		report.testDateto(null);
		report.testgo();
		report.testExport2();
		
		//telephony report
		report.testMeuns(3);
		report.testDate(null);
		report.testExport3();
		report.testDetailrate();
		
		//webinar report
		report.testMeuns(4);
		report.testSelect(0);
		report.testwebinarDatefrom(null);
		report.testwebinarDateto(null);
		report.testfilter();
		for(int i = 0;i<3;i++){
			report.testwebinarid(webinarids[i]);
		}
		report.testsearch();
		report.testselect_webinar();
		report.testgeneratereport();
	}
	
	//user page
	@Test
	public void userpage(){
		//打開user page
		BrowserAction.openUrl(UrlManager.getUrl("user"));
		//users
		user.testLinks(0);
		user.testSSO();
		user.testSearchemail("c");
		user.testUsertype(null);
		user.testDomain("zoom");
		user.testSearch();
		//test buttons
		//checkall, selection, edit, delete, addnew, importuser, setadmin, batchedit, assign
		for(int i = 0;i<9;i++){
			user.testButtons(i);
			BrowserAction.refresh();
		}
		user.testExportuser();

		//pending
		user.testLinks(1);
		
		//advanced
		user.testLinks(2);
		user.testTotaluser();
		//changefrom, changeto, change,
		user.testSelcts(0, null);
		user.testSelcts(1, null);
		user.testAdvancedbtns(0);
		//removetype, remove
		user.testSelcts(2, null);
		user.testAdvancedbtns(1);
		//defaultuser, save
		user.testSelcts(3, null);
		user.testAdvancedbtns(2);
		user.testSelcts(3, "1");
		user.testAdvancedbtns(2);
		//usergroupfrom, usergroupto, changegroup
		user.testSelcts(4, null);
		user.testSelcts(5, null);
		user.testAdvancedbtns(3);
	}
}
