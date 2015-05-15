package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Report {
	//創建YamlReader實例
	private YamlReader yaml; 
	//目錄菜單組件
	private WebElement daily, usage, inactive, telephony, webinar;
	//daily report
	private WebElement selectmonth, export1, backtotop1, backtotop2;
	//usage report
	private WebElement datefrom, dateto, go, export2;
	//inactive users
	private WebElement page;
	//telephony report
	private WebElement date, export3, detailrate;
	//webinar report
	private WebElement select, weninardatefrom, weninardateto, filter, webinarid, search, generatereport;
	
	//構造函數初始化組件
	public Report(){
		daily = yaml.getElement("daily");
		usage = yaml.getElement("usage");
		inactive = yaml.getElement("inactive");
		telephony = yaml.getElement("telephony");
		webinar = yaml.getElement("webinar");
		selectmonth = yaml.getElement("selectmonth");
		export1 = yaml.getElement("export1");
		backtotop1 = yaml.getElement("backtotop1");
		backtotop2 = yaml.getElement("backtotop2");
		datefrom = yaml.getElement("datefrom");
		dateto = yaml.getElement("dateto");
		go = yaml.getElement("go");
		export2 = yaml.getElement("export2");
		page = yaml.getElement("page");
		date = yaml.getElement("date");
		export3 = yaml.getElement("export3");
		detailrate = yaml.getElement("detailrate");
		select = yaml.getElement("select");
		weninardatefrom = yaml.getElement("weninardatefrom");
		weninardateto = yaml.getElement("weninardateto");
		filter = yaml.getElement("filter");
		webinarid = yaml.getElement("webinarid");
		search = yaml.getElement("search");
		generatereport = yaml.getElement("generatereport");
	}

	//組件get函數
	public WebElement getDaily() {
		return daily;
	}

	public WebElement getUsage() {
		return usage;
	}

	public WebElement getInactive() {
		return inactive;
	}

	public WebElement getTelephony() {
		return telephony;
	}

	public WebElement getWebinar() {
		return webinar;
	}

	public WebElement getSelectmonth() {
		return selectmonth;
	}

	public WebElement getExport1() {
		return export1;
	}

	public WebElement getBacktotop1() {
		return backtotop1;
	}

	public WebElement getBacktotop2() {
		return backtotop2;
	}

	public WebElement getDatefrom() {
		return datefrom;
	}

	public WebElement getDateto() {
		return dateto;
	}

	public WebElement getGo() {
		return go;
	}

	public WebElement getExport2() {
		return export2;
	}

	public WebElement getPage() {
		return page;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getExport3() {
		return export3;
	}

	public WebElement getDetailrate() {
		return detailrate;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getWeninardatefrom() {
		return weninardatefrom;
	}

	public WebElement getWeninardateto() {
		return weninardateto;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getWebinarid() {
		return webinarid;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getGeneratereport() {
		return generatereport;
	}

	//組件基本測試函數
	
}
