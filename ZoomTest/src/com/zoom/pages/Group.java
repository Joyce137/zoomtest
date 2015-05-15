package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Group {
	//����YamlReader����
	private YamlReader yaml;
	
	//�����M��
	private WebElement searchgroup, searchbtn, addnew, linkdetial, edit, delete;
	//detail group info
	private WebElement email, detaildelete, detailmove;
	
	//���캯����ʼ���M��
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
	//�M��get����
	public YamlReader getYaml() {
		return yaml;
	}

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
	
	//�M���Ļ����yԇ����
	
}
