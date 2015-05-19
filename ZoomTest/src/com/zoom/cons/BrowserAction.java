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

	//���_�g�[��
	public static void openBrowser(String name){
		//Firefox�g�[��
		if(name == "firefox"){
			driver = DriverManager.getDriver();
		}
		//IE�g�[��
		else if(name == "ie"){
			System.setProperty("webdriver.ie.driver","G:\\goodbye\\app\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		//google chrome�g�[��
		else if(name == "chrome"){
			System.setProperty("webdriver.chrome.driver","G:\\goodbye\\app\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//�������������]
		else{
			System.out.println("�������]�@�N�g�[����Ո�x��Firefox��IE��Chrome.");
		}
	}
	
	//���_�ض���Url
	public static void openUrl(String url){
		//����һ��get
		driver.get(url);
		//�������� navigate to
		driver.navigate().to(url);
		//���_�����
		driver.manage().window().maximize();
	}
	
	//��ǰһ�
	public static void farward(){
		driver.navigate().forward();
	}
	
	//������һ�
	public static void back(){
		driver.navigate().back();
	}
	
	//Windows �� Frames֮����л�
	public static void windows_frames(String name){
		//����name��r̎��:
		//һ����˵����¼����
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
			System.out.println("Ոݔ����е�name,f..-frame,w..-window,or null");
		}
	}
	
	//����Url��title
	public static String getTitle(String url){
		driver.get(url);
		return driver.getTitle();
	}
	
	//���������ͼ (Ĭ�J��ZoomTest��screenshot�ļ��A��)
	public static void screenshot(){ 
		//�ԕr�g��؈D�DƬ��
		String screenName = new TimeString().getTimeString() + ".jpg";
		//�����؈D�ļ�·��
		File dir = new File("test-output/screenshot");
		if (!dir.exists())
			dir.mkdirs();
		String screenPath = dir.getAbsolutePath() + "/" + screenName;
		//�؈D
		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenPath));
		} catch (IOException e) {
			Log.comment("Screen shot error: " + screenPath);
		}
		Log.comment(screenName, true, true);
	} 
    
	//���ȴ�
	public static void waitForPageToLoad(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	
	//ҳ��ˢ��
	public static void refresh(){
		driver.navigate().refresh();
	}
	
	//�P�]�g�[��
	public static void closeUrl(){
		//quit��������ȱ��
		//driver.quit();
		//����close����
		driver.close();
	}
}
