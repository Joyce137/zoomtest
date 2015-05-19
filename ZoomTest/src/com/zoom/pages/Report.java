package com.zoom.pages;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.KeyActions;
import com.zoom.cons.LocatorManager;

public class Report {
	private WebDriver driver = DriverManager.getDriver();
	//創建LocatorManager實例
	private LocatorManager yaml = new LocatorManager("report"); 
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
	private WebElement select, webinardatefrom, webinardateto, filter, webinarid, search, select_webinar,generatereport;
	
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
		webinardatefrom = yaml.getElement("weninardatefrom");
		webinardateto = yaml.getElement("weninardateto");
		filter = yaml.getElement("filter");
		webinarid = yaml.getElement("webinarid");
		search = yaml.getElement("search");
		select_webinar = yaml.getElement("select_webinar");
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

	public WebElement getWebinardatefrom() {
		return webinardatefrom;
	}

	public WebElement getWebinardateto() {
		return webinardateto;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getWebinarid() {
		return webinarid;
	}

	public WebElement getSelect_webinar() {
		return select_webinar;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getGeneratereport() {
		return generatereport;
	}

	//組件基本測試函數
	//目錄菜單組件: daily, usage, inactive, telephony, webinar;
	WebElement menus[] = {daily, usage, inactive, telephony, webinar};
	String menustr[] = {"report", "usage_report", "inactive_report", "telephony_report", "webinar_report"};
	public void testMeuns(int i){
		ElementOperation eo = new ElementOperation(driver, menus[i]);
		eo.linkOperation(menustr[i]);
	}
	//daily report: selectmonth, export1, backtotop1, backtotop2;
	public void testSelectmonth(String value){
		ElementOperation eo = new ElementOperation(driver, selectmonth);
		eo.selectorOperation(value);
	}
	public void testExport1(){
		export1.click();
		KeyActions.onekey("enter");
	}
	public void testBacktotop(){
		Assert.assertTrue(backtotop1.isDisplayed());
		backtotop1.click();
		Assert.assertTrue(backtotop2.isDisplayed());
		backtotop2.click();
	}
	//usage report: datefrom, dateto, go, export2;
	public void testDatefrom(String value){
		ElementOperation eo = new ElementOperation(driver, datefrom);
		eo.selectorOperation(value);
	}
	public void testDateto(String value){
		ElementOperation eo = new ElementOperation(driver, dateto);
		eo.selectorOperation(value);
	}
	public void testgo(){
		go.click();
	}
	public void testExport2(){
		export2.click();
		KeyActions.onekey("enter");
	}
	//inactive users: page;
	//telephony report: date, export3, detailrate;
	public void testDate(String value){
		ElementOperation eo = new ElementOperation(driver, date);
		eo.selectorOperation(value);
	}
	public void testExport3(){
		export3.click();
		KeyActions.onekey("enter");
	}
	public void testDetailrate(){
		ElementOperation eo = new ElementOperation(driver, detailrate);
		eo.linkOperation("detailrate");
	}
	//webinar report: select, webinardatefrom, webinardateto, filter, webinarid, search, generatereport;
	public void testSelect(int index){
		ElementOperation eo = new ElementOperation(driver, select);
		eo.radioOperation(index);;
	}
	//選擇webinar
	public void testwebinarDatefrom(String value){
		ElementOperation eo = new ElementOperation(driver, webinardatefrom);
		eo.selectorOperation(value);
	}
	public void testwebinarDateto(String value){
		ElementOperation eo = new ElementOperation(driver, webinardateto);
		eo.selectorOperation(value);
	}
	public void testfilter(){
		filter.click();
	}
	public void testwebinarid(String value){		
		ElementOperation eo = new ElementOperation(driver, webinarid);
		eo.assertText(value);
	}
	public void testsearch(){
		search.click();
	}
	public void testselect_webinar(){
		search.click();
	}
	public void testgeneratereport(){
		generatereport.click();
		KeyActions.onekey("enter");
	}
}
