package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class Billing {
	//目錄菜單組件
	private WebElement plan, billing, invoice;
	//plans相關組件(all users)
	private WebElement baseplan, h323, largemtg, audio, webinar, cmr;
	private WebElement expandbutton1, expandbutton2, expandbutton3, expandbutton4, expandbutton5;
	private WebElement expandbuttons[] = {expandbutton1,expandbutton2,expandbutton3,expandbutton4,expandbutton5};
	
	//billing/payment
	private WebElement firstname, lastname, email, phone, company, paymenttype, cardfirstname, cardlastname, cardnumber, cvv, month, year, address1, address2, city, state, zip, country,submit;
	
	//invoice history
	private WebElement print, document;
	//no invoice user
	//plans
	//free user
	private WebElement freeplanoption, usercount, total, freeplanupdate;
	//coupon code
	private WebElement couponcode, checkcode;
	
	//pro user
	private WebElement baseoption, addional, planupdate, plan_cancel, reactive;
	
	//創建YamlReader實例
	private YamlReader yaml; 
	
	//構造函數初始化所有組件
	public Billing(){
		plan = yaml.getElement("plan");
		billing = yaml.getElement("billing");
		invoice = yaml.getElement("invoice");
		baseplan = yaml.getElement("baseplan");
		h323 = yaml.getElement("h323");
		largemtg = yaml.getElement("largemtg");
		audio = yaml.getElement("audio");
		webinar = yaml.getElement("webinar");
		cmr = yaml.getElement("cmr");
		for(int i = 1;i <= 5;i++){
			expandbuttons[i] = yaml.getElement("expandbutton"+i);
		}
		firstname = yaml.getElement("firstname");
		lastname = yaml.getElement("lastname");
		email = yaml.getElement("email");
		phone = yaml.getElement("phone");
		company = yaml.getElement("company");
		paymenttype = yaml.getElement("paymenttype");
		cardfirstname = yaml.getElement("cardfirstname");
		cardlastname = yaml.getElement("cardlastname");
		cardnumber = yaml.getElement("cardnumber");
		cvv = yaml.getElement("cvv");
		month = yaml.getElement("month");
		year = yaml.getElement("year");
		address1 = yaml.getElement("address1");
		address2 = yaml.getElement("address2");
		city = yaml.getElement("city");
		state = yaml.getElement("state");
		zip = yaml.getElement("zip");
		country = yaml.getElement("country");
		submit = yaml.getElement("submit");
		print = yaml.getElement("print");
		document = yaml.getElement("document");
	}
	
	//各組件的get方法
	public WebElement getPlan() {
		return plan;
	}

	public WebElement getBilling() {
		return billing;
	}

	public WebElement getInvoice() {
		return invoice;
	}

	public WebElement getBaseplan() {
		return baseplan;
	}

	public WebElement getH323() {
		return h323;
	}

	public WebElement getLargemtg() {
		return largemtg;
	}

	public WebElement getAudio() {
		return audio;
	}

	public WebElement getWebinar() {
		return webinar;
	}

	public WebElement getCmr() {
		return cmr;
	}

	public WebElement getExpandbutton1() {
		return expandbutton1;
	}

	public WebElement getExpandbutton2() {
		return expandbutton2;
	}

	public WebElement getExpandbutton3() {
		return expandbutton3;
	}

	public WebElement getExpandbutton4() {
		return expandbutton4;
	}

	public WebElement getExpandbutton5() {
		return expandbutton5;
	}

	public WebElement[] getExpandbuttons() {
		return expandbuttons;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getPaymenttype() {
		return paymenttype;
	}

	public WebElement getCardfirstname() {
		return cardfirstname;
	}

	public WebElement getCardlastname() {
		return cardlastname;
	}

	public WebElement getCardnumber() {
		return cardnumber;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZip() {
		return zip;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getPrint() {
		return print;
	}

	public WebElement getDocument() {
		return document;
	}

	public WebElement getFreeplanoption() {
		return freeplanoption;
	}

	public WebElement getUsercount() {
		return usercount;
	}

	public WebElement getTotal() {
		return total;
	}

	public WebElement getFreeplanupdate() {
		return freeplanupdate;
	}

	public WebElement getCouponcode() {
		return couponcode;
	}

	public WebElement getCheckcode() {
		return checkcode;
	}

	public WebElement getBaseoption() {
		return baseoption;
	}

	public WebElement getAddional() {
		return addional;
	}

	public WebElement getPlanupdate() {
		return planupdate;
	}

	public WebElement getPlan_cancel() {
		return plan_cancel;
	}

	public WebElement getReactive() {
		return reactive;
	}

	public YamlReader getYaml() {
		return yaml;
	}
	
	//各組件的基本測試
	
}
