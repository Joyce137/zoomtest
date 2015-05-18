package com.zoom.pages;

import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.*;
import com.zoom.database.DatabaseManager;

public class Account {
	private Statement stmt = DatabaseManager.getMySqlstate();
	private WebDriver driver = DriverManager.getDriver();
	//account info組件
	private WebElement type, dashboard, role, changeowner, name, alias, domains, vanityurl, update;
	//meeting option組件
	private WebElement e2e, onhold, chat, autosavechat, feedback, jbhreminder, teleconf, teleconfinfo, pac;
	//recording option組件
	private WebElement recording, cmr, cmrdownload;	
	//other option組件
	private WebElement hidebilling, autoanswer, upcomingalert, googlecalendar, googledriver, dropbox, box, onedrive, saveoptions;
	//獲取Yaml文件
	private LocatorManager yaml = new LocatorManager("account");
		
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

	//組件基本測試函數
	//account info組件： type, dashboard, role, changeowner, name, alias, domains, vanityurl, update;
	
	//type： i表示什麼用戶(0-clery,1-gmail,2-qq,3-free)
	public void testType(int i){
		ElementOperation eo = new ElementOperation(driver, type);
		//從數據庫中獲取account type
		String accounttype = null;
		Statement stmt = DatabaseManager.getMySqlstate();
		try {
			accounttype = stmt.executeQuery("select type from account where id = "+i).toString();
		} catch (SQLException e) {
			System.out.println("fail to execute query.");
			e.printStackTrace();
		}
		eo.assertText(accounttype);
	}
	
	//dashboard
	public void testDashboard(){
		ElementOperation eo = new ElementOperation(driver, dashboard);
		eo.linkOperation("dashboard");
	}
	
	//role
	public void testRole(int i){
		ElementOperation eo = new ElementOperation(driver, role);
		//從數據庫中獲取account role
		String accountrole = null;
		Statement stmt = DatabaseManager.getMySqlstate();
		try {
			accountrole = stmt.executeQuery("select role from account where id = "+i).toString();
		} catch (SQLException e) {
			System.out.println("fail to execute query.");
			e.printStackTrace();
		}
		eo.assertText(accountrole);
	}
	
	//changeowner
	public void testChangeowner(){
		//如果是owner，有此選項，否則沒有
		if(role.getText() == "Owner"){
			//ElementOperation eo = new ElementOperation(driver, changeowner);
			//按鈕可見
			Assert.assertTrue(role.isDisplayed());
			//對話框處理
			//？？？？？？
		}
		else{
			Assert.assertFalse(role.isDisplayed());
		}
	}
	
	//name
	public void testName(int i){
		String currentname = name.getText();
		//從數據庫中獲取account name
		String accountname = null;
		try {
			accountname = stmt.executeQuery("select name from account where id = "+i).toString();
		} catch (SQLException e) {
			System.out.println("fail to execute query.");
			e.printStackTrace();
		}
		Assert.assertEquals(currentname, accountname);
	}
	//alias
	public void testAlias(int i){
		String currentalias = name.getText();
		//從數據庫中獲取account alias
		String accountalias = null;
		try {
			currentalias = stmt.executeQuery("select alias from account where id = "+i).toString();
		} catch (SQLException e) {
			System.out.println("fail to execute query.");
			e.printStackTrace();
		}
		Assert.assertEquals(accountalias, currentalias);
	}
	//domains
	public void testDomains(){
		ElementOperation eo = new ElementOperation(driver, domains);
		eo.buttonOperation();
	}
	//vanityurl
	public void testVanityurl(){
		ElementOperation eo = new ElementOperation(driver, vanityurl);
		eo.buttonOperation();
	}
	//update
	public void testUpdate(){
		ElementOperation eo = new ElementOperation(driver, update);
		eo.buttonOperation();
	}
	
	//meeting option組件： e2e, onhold, chat, autosavechat, feedback, jbhreminder, teleconf, pac;
	//recording option組件： recording, cmr, cmrdownload;	
		//other option組件： hidebilling, autoanswer, upcomingalert, googlecalendar, googledriver, dropbox, box, onedrive;
	WebElement accountoptions[]={e2e, onhold, chat, autosavechat, feedback, jbhreminder, teleconf, pac,
			recording, cmr, cmrdownload, hidebilling, autoanswer, upcomingalert,
			googlecalendar, googledriver, dropbox, box, onedrive};
	String accountoptionstr[]={"e2e", "onhold", "chat", "autosavechat", "feedback", "jbhreminder",
			"teleconf", "pac","recording", "cmr", "cmrdownload", "hidebilling", "autoanswer",
			"upcomingalert","googlecalendar", "googledriver", "dropbox", "box", "onedrive"};
	
	//options as above, i-第幾個，accountid-accountid
	public void testOptions(int i,int accountid){
		WebElement el = accountoptions[i];
		el.click();
		try {
			if(el.isSelected()){
				stmt.execute("update accountoption set "+accountoptionstr[i]+" = 1 where accountid = "+accountid);
			}
			else{
				stmt.execute("update accountoption set "+accountoptionstr[i]+" = 0 where accountid = "+accountid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	//teleconfinfo
	public void testTeleconfinfo(int accountid,String value){
		ElementOperation eo = new ElementOperation(driver, teleconfinfo);
		eo.inputOperation(value);
		try {
			stmt.execute("update accountoption set teleconfinfo = "+value+" where accountid = "+accountid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//saveoptions
	public void testSaveoptions(){
		ElementOperation eo = new ElementOperation(driver, saveoptions);
		eo.buttonOperation();
	}
}
