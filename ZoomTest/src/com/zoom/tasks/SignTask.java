package com.zoom.tasks;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoom.cons.BrowserAction;
import com.zoom.cons.UrlManager;
import com.zoom.database.DataManager;
import com.zoom.pages.ForgetPwd;
import com.zoom.pages.MainPage;
import com.zoom.pages.Signin;
import com.zoom.pages.Signup;
import com.zoom.testdata.UserData;

public class SignTask {
	private Signin signin = new Signin(); 
	private Signup signup = new Signup();
	private MainPage main = new MainPage();
	private ForgetPwd forget = new ForgetPwd();
	
	String users[] = UserData.getUsers();
	String pwd[] = UserData.getPassword();
	
	//mainpage中直接輸入郵箱，點擊sign up,不進入signup page.
	@Test(dataProvider = "users")
	public void signup1(){
		BrowserAction.openUrl(UrlManager.getUrl("main"));
		for(int i = 0;i<users.length;i++){
			main.testEmail(users[i]);
			main.testSignup();
			Assert.assertEquals(BrowserAction.getCurrenturl(), UrlManager.getUrl("main"));
		}
	}
	
	//mainpage中點擊菜單欄中的sign up，進入signup page.
	@Test(dataProvider = "users")
	public void signup2(){
		BrowserAction.openUrl(UrlManager.getUrl("main"));
		main.testSign(1);
		signup.testPageheader();
		for(int i = 0;i<users.length;i++){
			signup.testEmail(users[i]);
			signup.testSignup();
		}
		signup.testLinks();
	}
	
	//mainpage中點擊sign in
	public void signin(int userid){
		String email = DataManager.getuserinfo(userid, "email");
		String pwd = DataManager.getuserinfo(userid, "pwd");
		signin.testEmail(email);
		signin.testPassword(pwd);
		signin.testSignin();
	}
	
	@Test(dataProvider = "users")
	public void signin(){
		BrowserAction.openUrl(UrlManager.getUrl("main"));
		main.testSign(0);
		signin.testPageheader();
		for(int i = 0;i<users.length;i++){
			signin.testEmail(users[i]);
			signin.testPassword(pwd[i]);
			signin.testSignin();
		}
		signin.testLinks();
	}
	
	//forgot password
	@Test
	public void forgetpwd(){
		BrowserAction.openUrl(UrlManager.getUrl("signin"));
		signin.testForget();
		//forget_pwd page測試
		forget.testPageheader();
		forget.testCheckemail();
		forget.testCheckmsg();
		for(int i = 0;i<users.length;i++){
			forget.testEmail(users[i]);
			forget.testSend();
			forget.testPageheader2();
			forget.testResend();
		}
	}
	
	@Test
	public void signout(){
		BrowserAction.openUrl(UrlManager.getUrl("meeting"));
		main.testSign(2);
	}
}
