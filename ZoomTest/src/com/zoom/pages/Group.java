package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Group {
	//創建LocatorManager實例
	private LocatorManager yaml;
	
	//基本組件
	private WebElement searchgroup, searchbtn, addnew, linkdetial, edit, delete;
	//detail group info
	private WebElement email, detaildelete, detailmove;
	
	//構造函數初始化組件
	public Group(){
		searchgroup = yaml.getElement("searchgroup");
		searchbtn = yaml.getElement("searchbtn");
		addnew = yaml.getElement("addnew");
		linkdetial = yaml.getElement("linkdetial");
		edit = yaml.getElement("edit");
		delete = yaml.getElement("delete");
		email = yaml.getElement("email");
		detaildelete = yaml.getElement("detaildelete");
		detailmove = yaml.getElement("detailmove");
	}
	//組件get函數
	public WebElement getSearchgroup() {
		return searchgroup;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getAddnew() {
		return addnew;
	}

	public WebElement getLinkdetial() {
		return linkdetial;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getDetaildelete() {
		return detaildelete;
	}

	public WebElement getDetailmove() {
		return detailmove;
	}
	
	//組件的基本測試函數
	
}
