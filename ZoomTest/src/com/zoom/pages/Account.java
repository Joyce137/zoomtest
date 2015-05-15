package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.*;

public class Account {
	//account info組件
	private WebElement type, dashboard, role, changeowner, name, alias, domains, vanityurl, update;
	//meeting option組件
	private WebElement e2e, onhold, chat, autosavechat, feedback, jbhreminder, teleconf, teleconfinfo, pac;
	//recording option組件
	private WebElement recording, cmr, cmrdownload;	
	//other option組件
	private WebElement hidebilling, autoanswer, upcomingalert, googlecalendar, googledriver, dropbox, box, onedrive, saveoptions;
	//獲取Yaml文件
	private YamlReader yaml;
		
	//構造函數，初始化所有組件
	public Account(){
		type = yaml.getElement("type");
		dashboard = yaml.getElement("dashboard");
		role = yaml.getElement("role");
		changeowner = yaml.getElement("changeowner");
		name = yaml.getElement("name");
		alias = yaml.getElement("alias");
		domains = yaml.getElement("domains");
		vanityurl = yaml.getElement("vanityurl");
		update = yaml.getElement("update");
		e2e = yaml.getElement("E2E");
		onhold = yaml.getElement("onhold");
		chat = yaml.getElement("chat");
		autosavechat = yaml.getElement("autosavechat");
		feedback = yaml.getElement("feedback");
		jbhreminder = yaml.getElement("jbhreminder");
		teleconf = yaml.getElement("teleconf");
		teleconfinfo = yaml.getElement("teleconfinfo");
		pac = yaml.getElement("pac");
		recording = yaml.getElement("recording");
		cmr = yaml.getElement("cmr");
		cmrdownload = yaml.getElement("cmrdownload");
		hidebilling = yaml.getElement("hidebilling");
		autoanswer = yaml.getElement("autoanswer");
		upcomingalert = yaml.getElement("upcomingalert");
		googlecalendar = yaml.getElement("googlecalendar");
		googledriver = yaml.getElement("googledriver");
		dropbox = yaml.getElement("dropbox");
		box = yaml.getElement("box");
		onedrive = yaml.getElement("onedrive");
		saveoptions = yaml.getElement("saveoptions");
	}
	
	//組件get函數
	public WebElement getType() {
		return type;
	}
	public WebElement getDashboard() {
		return dashboard;
	}
	public WebElement getRole() {
		return role;
	}
	public WebElement getChangeowner() {
		return changeowner;
	}
	public WebElement getName() {
		return name;
	}
	public WebElement getAlias() {
		return alias;
	}
	public WebElement getDomains() {
		return domains;
	}
	public WebElement getVanityurl() {
		return vanityurl;
	}
	public WebElement getUpdate() {
		return update;
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
	public WebElement getFeedback() {
		return feedback;
	}
	public WebElement getJbhreminder() {
		return jbhreminder;
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
	public WebElement getCmrdownload() {
		return cmrdownload;
	}
	public WebElement getHidebilling() {
		return hidebilling;
	}
	public WebElement getAutoanswer() {
		return autoanswer;
	}
	public WebElement getUpcomingalert() {
		return upcomingalert;
	}
	public WebElement getGooglecalendar() {
		return googlecalendar;
	}
	public WebElement getGoogledriver() {
		return googledriver;
	}
	public WebElement getDropbox() {
		return dropbox;
	}
	public WebElement getBox() {
		return box;
	}
	public WebElement getOnedrive() {
		return onedrive;
	}
	public WebElement getSaveoptions() {
		return saveoptions;
	}
	public YamlReader getYaml() {
		return yaml;
	}
	
	//組件基本測試函數
	
}
