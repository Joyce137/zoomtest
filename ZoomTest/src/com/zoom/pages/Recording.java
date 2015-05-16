package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.LocatorManager;

public class Recording {
	//����LocatorManager����
	private LocatorManager yaml; 
	//�����M��
	private WebElement dateFrom, dateTo, go;
	//recording info
	private WebElement topic, id, starttime, size, limit, detail, delete;
	//page
	private WebElement page, total;
	
	//���캯����ʼ���M��
	public Recording(){
		dateFrom = yaml.getElement("dateFrom");
		dateTo = yaml.getElement("dateTo");
		go = yaml.getElement("go");
		topic = yaml.getElement("topic");
		id = yaml.getElement("id");
		starttime = yaml.getElement("starttime");
		size = yaml.getElement("size");
		limit = yaml.getElement("limit");
		detail = yaml.getElement("detail");
		delete = yaml.getElement("delete");
		page = yaml.getElement("page");
		total = yaml.getElement("total");
	}

	//�M��get����
	public WebElement getDateFrom() {
		return dateFrom;
	}

	public WebElement getDateTo() {
		return dateTo;
	}

	public WebElement getGo() {
		return go;
	}

	public WebElement getTopic() {
		return topic;
	}

	public WebElement getId() {
		return id;
	}

	public WebElement getStarttime() {
		return starttime;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getLimit() {
		return limit;
	}

	public WebElement getDetail() {
		return detail;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getPage() {
		return page;
	}

	public WebElement getTotal() {
		return total;
	}

	//�M�������yԇ����
	
}
