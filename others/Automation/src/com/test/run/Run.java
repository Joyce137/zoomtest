package com.test.run;

public class Run {

	public static void main(String[] args) {
		RunControl r = new RunControl();
		r.setTestCaseName("TestBaidu");
		r.setThreadCount(1);
		r.setReRun(false);
		r.runTestNG();
	}

}
