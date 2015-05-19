package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;

public class WebinarSetting {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("webinar_setting"); ; 
	//branding
	private WebElement upload1, delete1, upload2, delete2;
	//info setting edits
	private WebElement edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9;
	private WebElement edits[] = {edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9};
	//email setting edit
	private WebElement emailsettingedit1, emailsettingedit2, emailsettingedit3, emailsettingedit4, emailsettingedit5;
	private WebElement emailsettingedits[] = {emailsettingedit1, emailsettingedit2, emailsettingedit3, emailsettingedit4, emailsettingedit5};
	
	//構造函數初始化組件
	public WebinarSetting(){
		upload1 = yaml.getElement("upload1");
		delete1 = yaml.getElement("delete1");
		upload2 = yaml.getElement("upload2");
		delete2 = yaml.getElement("delete2");
		for(int i = 1;i <= 2;i++){
			edits[i] = yaml.getElement("edit"+i);
		}
		for(int i = 1;i <= 2;i++){
			emailsettingedits[i] = yaml.getElement("emailsettingedit"+i);
		}
	}
	
	//組件get函數
	public WebElement getUpload1() {
		return upload1;
	}

	public WebElement getDelete1() {
		return delete1;
	}

	public WebElement getUpload2() {
		return upload2;
	}

	public WebElement getDelete2() {
		return delete2;
	}

	public WebElement getEdit1() {
		return edit1;
	}

	public WebElement getEdit2() {
		return edit2;
	}

	public WebElement getEdit3() {
		return edit3;
	}

	public WebElement getEdit4() {
		return edit4;
	}

	public WebElement getEdit5() {
		return edit5;
	}

	public WebElement getEdit6() {
		return edit6;
	}

	public WebElement getEdit7() {
		return edit7;
	}

	public WebElement getEdit8() {
		return edit8;
	}

	public WebElement getEdit9() {
		return edit9;
	}

	public WebElement[] getEdits() {
		return edits;
	}

	public WebElement getEmailsettingedit1() {
		return emailsettingedit1;
	}

	public WebElement getEmailsettingedit2() {
		return emailsettingedit2;
	}

	public WebElement getEmailsettingedit3() {
		return emailsettingedit3;
	}

	public WebElement getEmailsettingedit4() {
		return emailsettingedit4;
	}

	public WebElement getEmailsettingedit5() {
		return emailsettingedit5;
	}

	public WebElement[] getEmailsettingedits() {
		return emailsettingedits;
	}
	
	//組件基本測試函數
	//upload1, upload2
	public void testUpload1(String filepath){
		ElementOperation eo = new ElementOperation(driver, upload1);
		eo.uploadOperation(filepath);
	}
	public void testUpload2(String filepath){
		ElementOperation eo = new ElementOperation(driver, upload2);
		eo.uploadOperation(filepath);
	}
	//delete1, delete2
	public void testDelete1(){
		ElementOperation eo = new ElementOperation(driver, delete1);
		eo.alertOperation(1);
	}
	public void testDelete2(){
		ElementOperation eo = new ElementOperation(driver, delete2);
		eo.alertOperation(1);
	}
	
	//edits
	public void testEdits(){
		for(int i = 0;i<edits.length;i++){
			edits[i].click();
			BrowserAction.refresh();
		}
	}
	//emailsettingedits
	public void testEmailsettingedits(){
		for(int i = 0;i<emailsettingedits.length;i++){
			emailsettingedits[i].click();
			BrowserAction.refresh();
		}
	}
}
