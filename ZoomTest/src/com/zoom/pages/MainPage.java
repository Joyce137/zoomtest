package com.zoom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.cons.DriverManager;
import com.zoom.utils.Checkid;

public class MainPage {
	private WebDriver driver = DriverManager.getDriver();
	//top組件
	public WebElement logo, phone,SALES, PLANS;
	//middle圖片組件
	private WebElement why_zoom, photo1, photo2, photo3, costomercount;
	//bottom菜單組件
	private WebElement about, costomers, download, plans, sales, support, feedback, blog,
		privacy, terms;
	//bottom圖標組件
	private WebElement blogicon, linkedin, twitter, youtube, facebook, supporticon;
	//菜單切換組件
	private WebElement vc, rc, zp, ms, im;
	//sign in&sign up
	private WebElement signin, signup, email, signout;
	//join&host
	private WebElement join, host;
	//獲取Yaml文件
	private LocatorManager yaml = new LocatorManager("main");
	
	public MainPage(){
		//初始化各組件
		logo = yaml.getElement("logo");
		phone = yaml.getElement("phone");
		SALES = yaml.getElement("SALES");
		PLANS = yaml.getElement("PLANS");
		why_zoom = yaml.getElement("why_zoom");
		photo1 = yaml.getElement("photo1");
		photo2 = yaml.getElement("photo2");
		photo3 = yaml.getElement("photo3");
		costomercount = yaml.getElement("costomercount");
		about = yaml.getElement("About");
		costomers = yaml.getElement("Costomers");
		download = yaml.getElement("Download");
		plans = yaml.getElement("Plans");
		sales = yaml.getElement("Sales");
		support = yaml.getElement("Support");
		feedback = yaml.getElement("Feedback");
		blog = yaml.getElement("Blog");
		privacy = yaml.getElement("privacy");
		terms = yaml.getElement("Terms");
		blogicon = yaml.getElement("blog");
		linkedin = yaml.getElement("linkedin");
		twitter = yaml.getElement("twitter");
		youtube = yaml.getElement("youtube");
		facebook = yaml.getElement("facebook");
		supporticon = yaml.getElement("support");
		vc = yaml.getElement("vc");
		rc = yaml.getElement("rc");
		zp = yaml.getElement("zp");
		ms = yaml.getElement("ms");
		im = yaml.getElement("im");
		signin = yaml.getElement("signin");
		signup = yaml.getElement("signup");
		signout = yaml.getElement("signout");
		join = yaml.getElement("join");
		host = yaml.getElement("host");
		email = yaml.getElement("email");
	}	
	
	//各組件的get函數
	public WebElement getLogo() {
		return logo;
	}
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getSALES() {
		return SALES;
	}
	public WebElement getPLANS() {
		return PLANS;
	}
	public WebElement getWhy_zoom() {
		return why_zoom;
	}
	public WebElement getPhoto1() {
		return photo1;
	}
	public WebElement getPhoto2() {
		return photo2;
	}
	public WebElement getPhoto3() {
		return photo3;
	}
	public WebElement getCostomercount() {
		return costomercount;
	}
	public WebElement getAbout() {
		return about;
	}
	public WebElement getCostomers() {
		return costomers;
	}
	public WebElement getDownload() {
		return download;
	}
	public WebElement getPlans() {
		return plans;
	}
	public WebElement getSales() {
		return sales;
	}
	public WebElement getSupport() {
		return support;
	}
	public WebElement getFeedback() {
		return feedback;
	}
	public WebElement getBlog() {
		return blog;
	}
	public WebElement getPrivacy() {
		return privacy;
	}
	public WebElement getTerms() {
		return terms;
	}
	public WebElement getBlogicon() {
		return blogicon;
	}
	public WebElement getLinkedin() {
		return linkedin;
	}
	public WebElement getTwitter() {
		return twitter;
	}
	public WebElement getYoutube() {
		return youtube;
	}
	public WebElement getFacebook() {
		return facebook;
	}
	public WebElement getSupporticon() {
		return supporticon;
	}
	public WebElement getVc() {
		return vc;
	}
	public WebElement getRc() {
		return rc;
	}
	public WebElement getZp() {
		return zp;
	}
	public WebElement getMs() {
		return ms;
	}
	public WebElement getIm() {
		return im;
	}
	public WebElement getSignin() {
		return signin;
	}
	public WebElement getSignup() {
		return signup;
	}
	public WebElement getSignout() {
		return signout;
	}
	public WebElement getJoin() {
		return join;
	}
	public WebElement getHost() {
		return host;
	}
	
	//各組件的基本測試函數
	//總結組件
	//asserts: logo, phone
	public void testLogo(){
		Assert.assertEquals(logo.isDisplayed(), true);
	}
	public void testPhone(){
		ElementOperation eo = new ElementOperation(driver, phone);
		eo.assertText("1.888.799.9666");
	}
	//links(23): SALES, PLANS, why_zoom, photo1, photo2, photo3, number65000
		//about, costomers, download, plan, sales, support, feedback, blog,privacy, terms
		//blogicon, linkedin, twitter, youtube, facebook, supporticon
	WebElement links[] = {SALES, PLANS, why_zoom, photo1, photo2, photo3, costomercount,
		about, costomers, download, plans, sales, support, feedback, blog,privacy, terms,
		blogicon, linkedin, twitter, youtube, facebook, supporticon};
	String linkstr[] = {"sales", "plans", "why_zoom", "why_zoom", "feature", "plans", "customers",
			"about", "costomers", "download", "plans", "sales", "support", "feedback", "blog", "privacy", 
			"terms", "blog", "linkedin", "twitter", "youtube", "facebook", "support"};
	public void testLinks(int i){
		Assert.assertEquals(links[i].isDisplayed(), true);
		ElementOperation eo = new ElementOperation(driver, links[i]);
		eo.linkOperation(linkstr[i]);
	}
	//菜單切換組件(5)： vc, rc, zp, ms, im
	WebElement menus[] = {vc, rc, zp, ms, im};
	WebElement vc_title, rc_title, zp_title, ms_title, im_title;
	WebElement menustitle[] = {vc_title, rc_title, zp_title, ms_title, im_title};
	String menustr[] = {"vc", "rc", "zp", "ms", "im"};
	public void testMenus(int i){
		menus[i].click();
		Assert.assertEquals(menustitle[i].isDisplayed(), true);
	}
	//功能組件：signin, signup, signout, join, host
	//signin, signup, signout, join
	WebElement actions[] = {signin, signup, signout, join};
	String actionstr[] = {"signin", "signup", "main", "join"};
	public void testSign(int i){
		ElementOperation eo = new ElementOperation(driver, actions[i]);
		eo.linkOperation(actionstr[i]);
	}
	public void testEmail(String value){
		ElementOperation eo = new ElementOperation(driver, email);
		eo.inputOperation(value);
	}
	public void testSignup(){
		ElementOperation eo = new ElementOperation(driver, signup);
		eo.alertOperation(1);
	}
	//host
	public void testHost(int i){
		ElementOperation eo = new ElementOperation(driver, host);
		//video meeting
		if(i == 1){
			BrowserAction.openUrl("https://dev.zoom.us/start/webmeeting");
		}
		else{
			BrowserAction.openUrl("https://dev.zoom.us/start/videomeeting");
		}
		if(signin.isDisplayed()){
			eo.linkOperation("signin");
		}
		else{
			host.click();
			String currenturl = driver.getCurrentUrl();
			String hostid = currenturl.substring(currenturl.length()-9, currenturl.length());
			Assert.assertEquals(Checkid.isOK(hostid), true);
		}
	}
}
