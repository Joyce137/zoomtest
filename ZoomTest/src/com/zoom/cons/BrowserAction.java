package com.zoom.cons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.zoom.utils.Log;
import com.zoom.utils.TimeString;

public class BrowserAction {
	private static WebDriver driver;

	//打開瀏覽器
	public static void openBrowser(String name){
		//Firefox瀏覽器
		if(name == "firefox"){
			driver = DriverManager.getDriver();
		}
		//IE瀏覽器
		else if(name == "ie"){
			System.setProperty("webdriver.ie.driver","G:\\goodbye\\app\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		//google chrome瀏覽器
		else if(name == "chrome"){
			System.setProperty("webdriver.chrome.driver","G:\\goodbye\\app\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//其他，暫不考慮
		else{
			System.out.println("暫不考慮這種瀏覽器，請選擇Firefox、IE或Chrome.");
		}
	}
	
	//打開特定的Url
	public static void openUrl(String url){
		//方法一：get
		driver.get(url);
		//方法二： navigate to
		driver.navigate().to(url);
		//打開并最大化
		driver.manage().window().maximize();
	}
	
	//向前一頁
	public static void farward(){
		driver.navigate().forward();
	}
	
	//返回上一頁
	public static void back(){
		driver.navigate().back();
	}
	
	//Windows 和 Frames之间的切换
	public static void windows_frames(String name){
		//根據name情況處理:
		//一般来说，登录后建议
		if(name == null){
			driver.switchTo().defaultContent();
		}
		//window to frame
		else if(name.substring(0, 1) == "f"){
			driver.switchTo().frame(name);
		}
		else if(name.substring(0, 1) == "w"){
			driver.switchTo().window(name);
		}
		else{
			System.out.println("請輸入可行的name,f..-frame,w..-window,or null");
		}
	}
	
	//返回Url的title
	public static String getTitle(String url){
		driver.get(url);
		return driver.getTitle();
	}
	
	//保存网面截图 (默認在ZoomTest的screenshot文件夾中)
	public static void screenshot(){ 
		//以時間為截圖圖片名
		String screenName = new TimeString().getTimeString() + ".jpg";
		//創建截圖文件路徑
		File dir = new File("test-output/screenshot");
		if (!dir.exists())
			dir.mkdirs();
		String screenPath = dir.getAbsolutePath() + "/" + screenName;
		//截圖
		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenPath));
		} catch (IOException e) {
			Log.comment("Screen shot error: " + screenPath);
		}
		Log.comment(screenName, true, true);
	} 
    
	//頁面等待
	public static void waitForPageToLoad(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	
	//页面刷新
	public static void refresh(){
		driver.navigate().refresh();
	}
	
	public static String getCurrenturl(){
		return driver.getCurrentUrl();
	}
	//關閉瀏覽器
	public static void closeBrowser(){
		//quit方法，有缺陷
		//driver.quit();
		//採用close方法
		driver.close();
	}
}
