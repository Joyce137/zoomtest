package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.database.DataManager;
import com.zoom.utils.Checkid;

public class Profile {
	private WebDriver driver = DriverManager.getDriver();
	
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("profile");
	private int userid;
	//userinfo
	private WebElement username, email, user_type, pmi, changePMI, pmiurl, vanityURL, changeurl, hostkey, 
		showkey, changehostkey, newHostKey, hostkey_submit, hostkey_cancel, pmitext, pmi_submit, pmi_cancel, newpv, pv_submit, pv_cancel;
	//profileinfo
	private WebElement headphoto, changephoto, firstname, lastname, phonecode, phonenumber, companyname, timezone, defaultcall;
	//meeting options
	private WebElement e2e, onhold, chat, autosavechat, privatechat, feedback, jbhreminder, cameracontrol, group, chime, chimeall, chimehost, teleconf, teleconfinfo, pac;
	//recording options
	private WebElement recording, cmr, autorecording, savechanged;
	//change password
	private WebElement changepassword, oldpassword, newpassword, confirmpassword;
	//password strength
	private WebElement meter1, meter2, meter3, meter4;
	private WebElement meters[] = {meter1, meter2, meter3, meter4};
	//schedule priviledge
	private WebElement assistant, assistantlist, remove, edit, assistant1, remove1, assistant2, remove2;
	//lti credential
	private WebElement ltikey, ltisecret, ltiregenerate; 
	//meeting
	private WebElement meetings;
	
	//構造函數初始化組件
	public Profile(int userid){
		this.userid = userid;
		username = yaml.getElement("username");
		email = yaml.getElement("email");
		user_type = yaml.getElement("user_type");
		pmi = yaml.getElement("pmi");
		changePMI = yaml.getElement("changePMI");
		pmiurl = yaml.getElement("pmiurl");
		vanityURL = yaml.getElement("vanityURL");
		changeurl = yaml.getElement("changeurl");
		hostkey = yaml.getElement("hostkey");
		changehostkey = yaml.getElement("changehostkey");
		headphoto = yaml.getElement("headphoto");
		changephoto = yaml.getElement("changephoto");
		firstname = yaml.getElement("firstname");
		lastname = yaml.getElement("lastname");
		phonecode = yaml.getElement("phonecode");
		phonenumber = yaml.getElement("phonenumber");
		companyname = yaml.getElement("companyname");
		timezone = yaml.getElement("timezone");
		defaultcall = yaml.getElement("defaultcall");
		e2e = yaml.getElement("E2E");
		onhold = yaml.getElement("onhold");
		chat = yaml.getElement("chat");
		autosavechat = yaml.getElement("autosavechat");
		privatechat = yaml.getElement("privatechat");
		feedback = yaml.getElement("feedback");
		jbhreminder = yaml.getElement("jbhreminder");
		cameracontrol = yaml.getElement("cameracontrol");
		group = yaml.getElement("group");
		chime = yaml.getElement("chime");
		chimeall = yaml.getElement("chimeall");
		chimehost = yaml.getElement("chimehost");
		teleconf = yaml.getElement("teleconf");
		teleconfinfo = yaml.getElement("teleconfinfo");
		pac = yaml.getElement("pac");
		recording = yaml.getElement("recording");
		cmr = yaml.getElement("cmr");
		autorecording = yaml.getElement("autorecording");
		savechanged = yaml.getElement("savechanged");
		changepassword = yaml.getElement("changepassword");
		oldpassword = yaml.getElement("oldpassword");
		newpassword = yaml.getElement("newpassword");
		confirmpassword = yaml.getElement("confirmpassword");
		for(int i = 1;i <= 4;i++){
			meters[i] = yaml.getElement("meter"+i);
		}
		assistant = yaml.getElement("assistant");
		assistantlist = yaml.getElement("assistantlist");
		remove = yaml.getElement("remove");
		edit = yaml.getElement("edit");
		assistant1 = yaml.getElement("assistant1");
		remove1 = yaml.getElement("remove1");
		assistant2 = yaml.getElement("assistant2");
		remove2 = yaml.getElement("remove2");
		ltikey = yaml.getElement("ltikey");
		ltisecret = yaml.getElement("ltisecret");
		ltiregenerate = yaml.getElement("ltiregenerate");
		meetings = yaml.getElement("meetings");
		showkey = yaml.getElement("showkey"); 
		changehostkey = yaml.getElement("changehostkey");
		newHostKey = yaml.getElement("newHostKey");
		hostkey_submit = yaml.getElement("hostkey_submit");
		hostkey_cancel = yaml.getElement("hostkey_cancel");
		pmitext = yaml.getElement("pmitext");
		pmi_submit = yaml.getElement("pmi_submit");
		pmi_cancel = yaml.getElement("pmi_cancel");
		newpv = yaml.getElement("newpv");
		pv_submit = yaml.getElement("pv_submit");
		pv_cancel = yaml.getElement("pv_cancel");
	}
	
	//組件get函數
	public WebElement getUsername() {
		return username;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getUser_type() {
		return user_type;
	}

	public WebElement getPmi() {
		return pmi;
	}

	public WebElement getChangePMI() {
		return changePMI;
	}

	public WebElement getPmiurl() {
		return pmiurl;
	}

	public WebElement getVanityURL() {
		return vanityURL;
	}

	public WebElement getChangeurl() {
		return changeurl;
	}

	public WebElement getHostkey() {
		return hostkey;
	}

	public WebElement getChangehostkey() {
		return changehostkey;
	}

	public WebElement getHeadphoto() {
		return headphoto;
	}

	public WebElement getChangephoto() {
		return changephoto;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPhonecode() {
		return phonecode;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getTimezone() {
		return timezone;
	}

	public WebElement getDefaultcall() {
		return defaultcall;
	}

	public WebElement getE2e() {
		return e2e;
	}

	public WebElement getOnhold() {
		return onhold;
	}

	public WebElement getChat() {
		return chat;
	}

	public WebElement getAutosavechat() {
		return autosavechat;
	}

	public WebElement getPrivatechat() {
		return privatechat;
	}

	public WebElement getFeedback() {
		return feedback;
	}

	public WebElement getJbhreminder() {
		return jbhreminder;
	}

	public WebElement getCameracontrol() {
		return cameracontrol;
	}

	public WebElement getGroup() {
		return group;
	}

	public WebElement getChime() {
		return chime;
	}

	public WebElement getChimeall() {
		return chimeall;
	}

	public WebElement getChimehost() {
		return chimehost;
	}

	public WebElement getTeleconf() {
		return teleconf;
	}

	public WebElement getTeleconfinfo() {
		return teleconfinfo;
	}

	public WebElement getPac() {
		return pac;
	}

	public WebElement getRecording() {
		return recording;
	}

	public WebElement getCmr() {
		return cmr;
	}

	public WebElement getAutorecording() {
		return autorecording;
	}

	public WebElement getSavechanged() {
		return savechanged;
	}

	public WebElement getChangepassword() {
		return changepassword;
	}

	public WebElement getOldpassword() {
		return oldpassword;
	}

	public WebElement getNewpassword() {
		return newpassword;
	}

	public WebElement getConfirmpassword() {
		return confirmpassword;
	}

	public WebElement getMeter1() {
		return meter1;
	}

	public WebElement getMeter2() {
		return meter2;
	}

	public WebElement getMeter3() {
		return meter3;
	}

	public WebElement getMeter4() {
		return meter4;
	}

	public WebElement[] getMeters() {
		return meters;
	}

	public WebElement getAssistant() {
		return assistant;
	}

	public WebElement getAssistantlist() {
		return assistantlist;
	}

	public WebElement getRemove() {
		return remove;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getAssistant1() {
		return assistant1;
	}

	public WebElement getRemove1() {
		return remove1;
	}

	public WebElement getAssistant2() {
		return assistant2;
	}

	public WebElement getRemove2() {
		return remove2;
	}

	public WebElement getLtikey() {
		return ltikey;
	}

	public WebElement getLtisecret() {
		return ltisecret;
	}

	public WebElement getLtiregenerate() {
		return ltiregenerate;
	}

	public WebElement getMeetings() {
		return meetings;
	}
	//組件基本測試函數
	//userinfo assert組件(5)
	WebElement asserts[] = {username, email, user_type, pmi, pmiurl};
	String assertstr[] = {"username", "email", "user_type", "pmi", "pmiurl"};
	public void testAsserts(int userid, int i){
		ElementOperation eo = new ElementOperation(driver, asserts[i]);
		eo.assertText(DataManager.getuserinfo(userid, assertstr[i]));
	}
	//change
	public void testChangeURL(){
		changePMI.click();
	}
	//pmitext
	public void testPMIText(String value){
		ElementOperation eo = new ElementOperation(driver, pmitext);
		eo.assertText(value);
	}
	//pmi_submit
	public void testPMIsubmit(){
		pmi_submit.click();
		String newpmi = pmitext.getText();
		if(Checkid.isPMIOK(newpmi)){
			DataManager.updateuser(userid, "pmi", newpmi);
		}
	}
	//pmi_cancel
	public void testPMIcancel(){
		pmi_cancel.click();
		Assert.assertTrue(!pmi_submit.isDisplayed());
		Assert.assertTrue(!pmi_cancel.isDisplayed());
		Assert.assertTrue(changePMI.isDisplayed());
	}
	//changeurl
	public void testChangeurl(){
		changeurl.click();
		Assert.assertTrue(pv_submit.isDisplayed());
		Assert.assertTrue(pv_cancel.isDisplayed());
		Assert.assertTrue(!changeurl.isDisplayed());
	}
	//newpv, oldpv, pv_submit, pv_cancel
	public void testnewpv(String value){
		ElementOperation eo = new ElementOperation(driver, newpv);
		eo.assertText(value);
	}
	public void testpvsubmit(){
		pv_submit.click();
		String newpvstr = newpv.getText();
		DataManager.updateuser(userid, "pv", newpvstr);
	}
	public void testpvcancel(){
		pv_cancel.click();
		Assert.assertTrue(!pv_submit.isDisplayed());
		Assert.assertTrue(!pv_cancel.isDisplayed());
		Assert.assertTrue(changeurl.isDisplayed());
	}	
	//hostkey;
	public void testHostkey(boolean first){
		//first -- 不直接顯示，用*
		if(first)
			Assert.assertEquals(hostkey.getText(), "********");
		//點擊show之後，便一直顯示
		else
			Assert.assertEquals(hostkey.getText(), DataManager.getuserinfo(userid, "hostkey"));
	}
	public void testChangekey(){
		changehostkey.click();
		Assert.assertTrue(hostkey_submit.isDisplayed());
		Assert.assertTrue(hostkey_cancel.isDisplayed());
		Assert.assertTrue(!changehostkey.isDisplayed());
	}
	public void testShowkey(boolean first){
		//first -- 不顯示
		if(first)
			Assert.assertTrue(!hostkey.isDisplayed());
		//點擊show之後，便一直顯示
		else{
			showkey.click();
			Assert.assertEquals(hostkey.getText(), DataManager.getuserinfo(userid, "hostkey"));
		}					
	}
	public void testnewHostkey(String value){
		ElementOperation eo = new ElementOperation(driver, newHostKey);
		eo.assertText(value);
	}
	public void testhostkeysubmit(){
		hostkey_submit.click();
		String newhostkeystr = newHostKey.getText();
		DataManager.updateuser(userid, "hostkey", newhostkeystr);
	}
	public void testhostkeycancel(){
		hostkey_cancel.click();
		Assert.assertTrue(!hostkey_submit.isDisplayed());
		Assert.assertTrue(!hostkey_cancel.isDisplayed());
		Assert.assertTrue(changehostkey.isDisplayed());
	}	
	//headphoto, changephoto, firstname, lastname, phonecode, phonenumber, companyname, timezone, defaultcall;
	WebElement useroptions[]={e2e, onhold, chat, autosavechat, feedback, jbhreminder, teleconf, pac,
			recording, cmr, privatechat, cameracontrol, group, chime, chimeall, chimehost};
	String useroptionstr[]={"e2e", "onhold", "chat", "autosavechat", "feedback", "jbhreminder",
			"teleconf", "pac","recording", "cmr", "cameracontrol", "group", "chime", "chimeall", "chimehost"};
	//options as above, i-第幾個，accountid-accountid
	public void testOptions(int i,int accountid, int userid){
		WebElement el = useroptions[i];
		String sql = null;
		//測試組件是否顯示、是否可選
		sql = "select "+useroptionstr[i] +" from accountoption where accountid = "+accountid;
		String is = DataManager.query(sql).toString();
		if(is == "1"){
			Assert.assertTrue(useroptions[i].isDisplayed()||useroptions[i].isEnabled());
		}
		else{
			Assert.assertTrue(!useroptions[i].isDisplayed());
		}
		//修改setting選項
		el.click();
		if(el.isSelected()){
			sql = "update useroption set "+useroptionstr[i]+" = 1 where userid = "+accountid;
		}
		else{
			sql = "update useroption set "+useroptionstr[i]+" = 1 where userid = "+accountid;
		}
		DataManager.executesql(sql);
	}
	//autorecording
	
	//teleconfinfo
	public void testTeleconfinfo(String value){
		ElementOperation eo = new ElementOperation(driver, teleconfinfo);
		eo.assertText(value);
	}
	
	//changepassword, oldpassword, newpassword, confirmpassword;meters[];
	public void testChangepassword(){
		changehostkey.click();
		Assert.assertTrue(oldpassword.isDisplayed());
		Assert.assertTrue(newpassword.isDisplayed());
		Assert.assertTrue(confirmpassword.isDisplayed());
		Assert.assertTrue(!changepassword.isDisplayed());
	}
	public void testoldpassword(String value){
		ElementOperation eo = new ElementOperation(driver, oldpassword);
		eo.assertText(value);
	}
	public void testnewpassword(String value){
		ElementOperation eo = new ElementOperation(driver, newpassword);
		eo.assertText(value);
	}
	public void testConfirmpassword(String value){
		ElementOperation eo = new ElementOperation(driver, newpassword);
		eo.assertText(value);
	}
	//savechanged;
	public void testSaveChanged(){
		savechanged.click();
		//oldpassword要正確
		String pwdstr = DataManager.getuserinfo(userid, "pwd").toString();
		if(oldpassword.getText() != pwdstr)	
			return;
		//newpassword不能太簡單
		if(!meters[0].isSelected())
			return;
		//confirmpassword要與newpassword相同
		if(newpassword.getText() != confirmpassword.getText())
			return;
		Assert.assertTrue(!oldpassword.isDisplayed());
		Assert.assertTrue(!newpassword.isDisplayed());
		Assert.assertTrue(!confirmpassword.isDisplayed());
		Assert.assertTrue(changepassword.isDisplayed());
		String newpwd = confirmpassword.getText();
		DataManager.updateuser(userid, "pwd", newpwd);
	}
	
	//assistant, assistantlist, remove, edit, assistant1, remove1, assistant2, remove2;
	
	//ltikey, ltisecret, ltiregenerate; 
	String ltikeystr = ltikey.getText();
	String ltisecretstr = ltisecret.getText();
	public void testltiregenerate(){
		ltiregenerate.click();
		String newltisecretstr = ltisecret.getText();
		Assert.assertFalse(ltisecretstr == newltisecretstr);
	}
	//meeting
	public void testmeetings(){
		ElementOperation eo = new ElementOperation(driver, meetings);
		eo.linkOperation("meeting");
	}
}
