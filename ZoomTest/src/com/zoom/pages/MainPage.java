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
	//top�M��
	public WebElement logo, phone,SALES, PLANS;
	//middle�DƬ�M��
	private WebElement why_zoom, photo1, photo2, photo3, costomercount;
	//bottom�ˆνM��
	private WebElement about, costomers, download, plans, sales, support, feedback, blog,
		privacy, terms;
	//bottom�D�˽M��
	private WebElement blogicon, linkedin, twitter, youtube, facebook, supporticon;
	//�ˆ��ГQ�M��
	private WebElement vc, rc, zp, ms, im;
	//sign in&sign up
	private WebElement signin, signup;
	//join&host
	private WebElement join, host;
	//�@ȡYaml�ļ�
	private LocatorManager yaml = new LocatorManager("main");
	
	public MainPage(){
		//��ʼ�����M��
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
		join = yaml.getElement("join");
		host = yaml.getElement("host");
	}	
	
	//���M����get����
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
	public WebElement getJoin() {
		return join;
	}
	public WebElement getHost() {
		return host;
	}
	
	//���M���Ļ����yԇ����
	//���Y�M��
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
	//�ˆ��ГQ�M���� vc, rc, zp, ms, im
	WebElement menus[] = {vc, rc, zp, ms, im};
	WebElement vc_title, rc_title, zp_title, ms_title, im_title;
	WebElement menustitle[] = {vc_title, rc_title, zp_title, ms_title, im_title};
	String menustr[] = {"vc", "rc", "zp", "ms", "im"};
	public void testMenus(int i){
		menus[i].click();
		Assert.assertEquals(menustitle[i].isDisplayed(), true);
	}
	//���ܽM����signin, signup, join, host
	//signin, signup, join
	WebElement actions[] = {signin, signup, join};
	String actionstr[] = {"signin", "signup", "join"};
	public void testSignin(int i){
		ElementOperation eo = new ElementOperation(driver, actions[i]);
		eo.linkOperation(actionstr[i]);
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
