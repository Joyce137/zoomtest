package com.zoom.accessibility;

import com.zoom.tasks.SignTask;

public class SignoutAccessibilty {
	private static String text = "��������Ҫע����¼��";
	public static void siginout(){
		PlayText.play(text);
		new SignTask().signout();
	}
}
