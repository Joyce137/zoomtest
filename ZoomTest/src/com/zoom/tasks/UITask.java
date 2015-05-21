package com.zoom.tasks;

import org.testng.annotations.Test;
import com.zoom.pages.MainPage;

public class UITask {
	private MainPage mainpage = new MainPage();
		
	//main page UI
	@Test
	public void mainpage(){
		//logo&phone
		mainpage.testLogo();
		mainpage.testPhone();
		//links&menus
		for(int i = 0;i<23;i++){
			mainpage.testLinks(i);
		}
		for(int i = 0;i<5;i++){
			mainpage.testMenus(i);
		}
	}
	

}
