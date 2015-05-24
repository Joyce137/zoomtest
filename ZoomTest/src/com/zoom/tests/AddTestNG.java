package com.zoom.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.DriverManager;
import com.zoom.cons.UrlManager;
import com.zoom.tasks.AccountTask;
import com.zoom.tasks.MeetingTask;
import com.zoom.tasks.SignTask;
import com.zoom.tasks.UITask;
import com.zoom.tasks.UserTask;
import com.zoom.tasks.WebinarTask;

public class AddTestNG {
	private DriverManager dirver;
	//基本测试
	@BeforeSuite
	public void openDriver(){
		dirver = new DriverManager();
	}
	
	@AfterSuite
	public void quitDriver(){
		dirver.quitdriver();
	}
	
	@BeforeClass
	public void openBrowser(String type){
		BrowserAction.openBrowser(type);;
	}
	
	@AfterClass
	public void openBrowser(){
		BrowserAction.closeBrowser();
		System.out.println("注解的方法将只运行一次，被注释的方法将在测试运行后运行。");
	}
	
    @BeforeMethod  
    public void setUp() {    
        System.out.println("@BeforeMethod - setUp");  
    }  
   
    @AfterMethod  
    public void tearDown() {   
        System.out.println("@AfterMethod - tearDown");  
    }  
   
    //超时测试
  	 @Test(timeOut = 1000)
  	 public void tout(){
  		 while(true);
  	 }
  	 
  	//Browser unit
  	@Test  
  	public void testBrowser(){
  		String browsers[] = {"firefox","ie","chrome"};
  		for(int i = 0;i<browsers.length;i++){
  			BrowserAction.openBrowser("firefox");
  			BrowserAction.openUrl(UrlManager.getUrl("main"));
  			BrowserAction.closeBrowser();
  		}
  	}
  	
  	//UI unit
    @Test  
    public void testUITask() {  
    	new UITask().mainpage();
        System.out.println("@Test - testEmptyCollection");  
    }  
   
    //Sign unit
    @Test  
    public void testSignTask() {  
    	SignTask signtask = new SignTask();
    	signtask.signup1();
    	signtask.signup2();
    	signtask.signin(0);
    	signtask.signout();
        System.out.println("@Test - testOneItemCollection");  
    }
    
    //account unit
    @Test
    public void testAccountTask(){
    	AccountTask accounttask = new AccountTask();
    	accounttask.accountpage();
    	accounttask.billingpage();
    	accounttask.subpage();
    	accounttask.grouppage();
    }
    
    //user unit
    @Test
    public void testUserTask(){
    	UserTask usertask = new UserTask();
    	usertask.profile();
    	usertask.recording();
    	usertask.report();
    	usertask.userpage();
    }
    
    //meeting unit
    @Test
    public void testMeetingTask(){
    	MeetingTask meetingtask = new MeetingTask();
    	meetingtask.join();
    	meetingtask.host();
    	meetingtask.meetingpage();
    	meetingtask.meetingdetailpage();
    	meetingtask.schedule();
    }
    
    //webinar unit
    @Test
    public void testWebinarTask(){
    	WebinarTask webinartask = new WebinarTask();
    	webinartask.webinarpage();
    	webinartask.webinardetail();
    	webinartask.webianrsetting();
    }
    
     //期待异常测试
	 @Test(expectedExceptions = ArithmeticException.class)  
	    public void divisionWithException() {  
	        @SuppressWarnings("unused")
			int i = 1 / 0;  
	 }
	 
	 //忽略测试
	 @Test(enabled = false)
	 public void test(){
		 System.out.println("It is ignored.");
	 }
	 
	 @Test
	 public void testall(){
		 testBrowser();
		 testUITask();
		 testSignTask();
		 testAccountTask();
		 testUserTask();
		 testMeetingTask();
		 testWebinarTask();
	 }
}
