package com.zoom.accessibility;

import com.zoom.tasks.SignTask;

public class SignoutAccessibilty {
	private static String text = "现在您将要注销登录。";
	public static void siginout(){
		PlayText.play(text);
		new SignTask().signout();
	}
}
