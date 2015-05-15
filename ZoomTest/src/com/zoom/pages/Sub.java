package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Sub {
	//����YamlReader����
	private YamlReader yaml; 
	//Ŀ䛲ˆνM��
	private WebElement dashboard, accountlist, totalinfo;
	//sub account list
	private WebElement searchkey, searchbtn, addnew, export, accountname, accounttype, disassociate;
	
	//���캯����ʼ���M��
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

	//�M��get����
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
	//�M�������yԇ����
	
}
