package com.zoom.testdata;

import org.testng.annotations.DataProvider;

import com.zoom.database.DataManager;
import com.zoom.utils.StringManager;

public class AccountData {
	public static String accounts[] = {"clery.cao@zoom.us",
		"caoruijuan13@gmail.com",
		"1010815793@qq.com",
		"free@mailinator.com",
		"new"+StringManager.getRandom()+"@mailinator.com"};
	
	public static int[] accountids = new int [accounts.length];
	
	@DataProvider(name = "account")
	public static int[] getAccountids(){
		for(int i = 0;i <accounts.length;i++){
			accountids[i] = DataManager.getaccountid(accounts[i]);
		}
		return accountids;
	}
}
