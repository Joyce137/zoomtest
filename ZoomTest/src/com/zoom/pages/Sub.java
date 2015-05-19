package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.KeyActions;
import com.zoom.cons.LocatorManager;

public class Sub {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("sub"); 
	//目錄菜單組件
	private WebElement dashboard, accountlist, totalinfo;
	//sub account list
	private WebElement searchkey, searchbtn, addnew, export, accountname, accounttype, disassociate;
	
	//構造函數初始化組件
	public Sub(){
		dashboard = yaml.getElement("dashboard");
		accountlist = yaml.getElement("accountlist");
		totalinfo = yaml.getElement("totalinfo");
		searchkey = yaml.getElement("searchkey");
		searchbtn = yaml.getElement("searchbtn");
		addnew = yaml.getElement("addnew");
		export = yaml.getElement("export");
		accountname = yaml.getElement("accountname");
		accounttype = yaml.getElement("accounttype");
		disassociate = yaml.getElement("disassociate");
	}

	//組件get函數
	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getAccountlist() {
		return accountlist;
	}

	public WebElement getTotalinfo() {
		return totalinfo;
	}

	public WebElement getSearchkey() {
		return searchkey;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getAddnew() {
		return addnew;
	}

	public WebElement getExport() {
		return export;
	}

	public WebElement getAccountname() {
		return accountname;
	}

	public WebElement getAccounttype() {
		return accounttype;
	}

	public WebElement getDisassociate() {
		return disassociate;
	}
	//組件基本測試函數
	//dashboard, accountlist, totalinfo;
	//searchkey, searchbtn, addnew, export, accountname, accounttype, disassociate;
	public void testDashboard(){
		ElementOperation eo = new ElementOperation(driver, dashboard);
		eo.linkOperation("sub");
	}
	public void testAccountlist(){
		ElementOperation eo = new ElementOperation(driver, accountlist);
		eo.linkOperation("sublist");
	}
	public void testSearchkey(String value){
		ElementOperation eo = new ElementOperation(driver, searchkey);
		eo.assertText(value);
	}
	public void testSearchbtn(){
		searchbtn.click();
	}
	//addnew, export, accountname, accounttype, disassociate
	public void testAddnew(){
		ElementOperation eo = new ElementOperation(driver, addnew);
		eo.linkOperation("addnewsub");;
	}
	public void testExport(){
		export.click();
		KeyActions.onekey("enter");
	}
	public void testDisassociate(){
		disassociate.click();
	}
}
