package com.zoom.pages;

import org.openqa.selenium.WebElement;

import com.zoom.cons.YamlReader;

public class MainPage {
	//top�M��
	public WebElement logo, phone,SALES, PLANS;
	//middle�DƬ�M��
	private WebElement why_zoom, photo1, photo2, photo3, number65000;
	//bottom�ˆνM��
	private WebElement about, costomers, download, plan, sales, support, feedback, blog,
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
	private YamlReader yaml;
	
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
		number65000 = yaml.getElement("65000");
		about = yaml.getElement("About");
		costomers = yaml.getElement("Costomers");
		download = yaml.getElement("Download");
		plan = yaml.getElement("Plans");
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
	public WebElement getNumber65000() {
		return number65000;
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
	public WebElement getPlan() {
		return plan;
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
	
}
