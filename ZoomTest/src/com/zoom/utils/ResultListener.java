package com.zoom.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.zoom.cons.BrowserAction;

//���Y���M�н؈D
public class ResultListener extends TestListenerAdapter {	

	public void onTestFailure(ITestResult tr) {		
		BrowserAction.screenshot();
	}

}
