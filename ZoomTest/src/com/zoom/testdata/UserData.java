package com.zoom.testdata;

import org.testng.annotations.DataProvider;

import com.zoom.database.DataManager;
import com.zoom.utils.StringManager;

public class UserData {

	public static String users[] = {"clery.cao@zoom.us",
			"caoruijuan13@gmail.com",
			"1010815793@qq.com",
			"free@mailinator.com",
			"new"+StringManager.getRandom()+"@mailinator.com"};
	
	public static String pwd[];
	
	@DataProvider(name = "users")
	public static String[] getUsers(){
		return users;
	}
	
	@DataProvider(name = "pwd")
	public static String[] getPassword(){
		for(int i = 0;i<users.length;i++){
			pwd[i] = DataManager.getuserinfo(users[i], "pwd");
		}
		return pwd;
	}
	
	@DataProvider(name = "pmiurls")
	public static String[] getPmiurls() {
		String pmiurls[] = {"a","abc","abcd","abcde","sdfs"};
		return pmiurls;
	}

	@DataProvider(name = "hostkeys")
	public static String[] getHostkeys() {
		String hostkeys[] = {"agdgsd","2332","123456","330606","134234252"};
		return hostkeys;
	}

	@DataProvider(name = "testpwd")
	public static String[] getTestpwd() {
		String testpwd[] = {"123","123456","safsdge","abcdef","password"};
		return testpwd;
	}
}
