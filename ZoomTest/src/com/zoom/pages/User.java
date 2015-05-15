package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class User {
	//創建YamlReader實例
	private YamlReader yaml; 
	//目錄菜單組件
	private WebElement users, pending, advanced;
	//search組件
	private WebElement ssoonly, searchemail, usertype, domain, search;
	//user list
	private WebElement checkall, selection, edit, delete, pages, total, pagesize;
	//user action
	private WebElement addnew, importuser, exportuser, setadmin, batchedit, assign;
	//advanced
	private WebElement totaluser, changefrom, changeto, change, removetype, remove, defaultuser, save, 
		usergroupfrom, usergroupto, changegroup, document;
	//構造函數初始化組件
	public User(){
		users = yaml.getElement("");
		pending = yaml.getElement("");
		advanced = yaml.getElement("");
		ssoonly = yaml.getElement("");
		searchemail = yaml.getElement("");
		usertype = yaml.getElement("");
		domain = yaml.getElement("");
		search = yaml.getElement("");
		checkall = yaml.getElement("");
		selection = yaml.getElement("");
		edit = yaml.getElement("");
		delete = yaml.getElement("");
		pages = yaml.getElement("");
		total = yaml.getElement("");
		pagesize = yaml.getElement("");
		addnew = yaml.getElement("");
		importuser = yaml.getElement("");
		exportuser = yaml.getElement("");
		setadmin = yaml.getElement("");
		batchedit = yaml.getElement("");
		assign = yaml.getElement("");
		totaluser = yaml.getElement("");
		changefrom = yaml.getElement("");
		changeto = yaml.getElement("");
		change = yaml.getElement("");
		removetype = yaml.getElement("");
		remove = yaml.getElement("");
		defaultuser = yaml.getElement("");
		save  = yaml.getElement("");
		usergroupfrom = yaml.getElement("");
		usergroupto = yaml.getElement("");
		changegroup = yaml.getElement("");
		document = yaml.getElement("");
	}
	
	//組件get函數
	public WebElement getUsers() {
		return users;
	}
	public WebElement getPending() {
		return pending;
	}
	public WebElement getAdvanced() {
		return advanced;
	}
	public WebElement getSsoonly() {
		return ssoonly;
	}
	public WebElement getSearchemail() {
		return searchemail;
	}
	public WebElement getUsertype() {
		return usertype;
	}
	public WebElement getDomain() {
		return domain;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getCheckall() {
		return checkall;
	}
	public WebElement getSelection() {
		return selection;
	}
	public WebElement getEdit() {
		return edit;
	}
	public WebElement getDelete() {
		return delete;
	}
	public WebElement getPages() {
		return pages;
	}
	public WebElement getTotal() {
		return total;
	}
	public WebElement getPagesize() {
		return pagesize;
	}
	public WebElement getAddnew() {
		return addnew;
	}
	public WebElement getImportuser() {
		return importuser;
	}
	public WebElement getExportuser() {
		return exportuser;
	}
	public WebElement getSetadmin() {
		return setadmin;
	}
	public WebElement getBatchedit() {
		return batchedit;
	}
	public WebElement getAssign() {
		return assign;
	}
	public WebElement getTotaluser() {
		return totaluser;
	}
	public WebElement getChangefrom() {
		return changefrom;
	}
	public WebElement getChangeto() {
		return changeto;
	}
	public WebElement getChange() {
		return change;
	}
	public WebElement getRemovetype() {
		return removetype;
	}
	public WebElement getRemove() {
		return remove;
	}
	public WebElement getDefaultuser() {
		return defaultuser;
	}
	public WebElement getSave() {
		return save;
	}
	public WebElement getUsergroupfrom() {
		return usergroupfrom;
	}
	public WebElement getUsergroupto() {
		return usergroupto;
	}
	public WebElement getChangegroup() {
		return changegroup;
	}
	public WebElement getDocument() {
		return document;
	}
	
	//組件基本測試函數
	
}
