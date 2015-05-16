package com.zoom.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.zoom.cons.BrowserAction;

//Œ¦½Y¹ûßMÐÐ½ØˆD
public class ResultListener extends TestListenerAdapter {	

	public void onTestFailure(ITestResult tr) {		
		BrowserAction.screenshot();
	}

}
