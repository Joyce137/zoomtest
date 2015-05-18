package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Profile {
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("profile");; 
	
	//userinfo
	private WebElement username, email, user_type, pmi, changePMI, pmiurl, vanityURL, changeurl, hostkey, changehostkey;
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
	public Profile(){
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
		meetings = yaml.getElement("");
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
	
}
