package com.zoom.testdata;

import org.testng.annotations.DataProvider;

import com.zoom.utils.StringManager;

public class MeetingData {
	public static String[] meetingids = new String [5];
	
	@DataProvider(name = "meeting")
	public static String[] getMtgids(){
		for(int i = 0;i<meetingids.length;i++){
			meetingids[i] = StringManager.getRandom()+"\n";
		}
		meetingids[0] = "9876543212";
		meetingids[1] = "987654321";
		meetingids[2] = "9876543211";
		return meetingids;
	}
	
}
