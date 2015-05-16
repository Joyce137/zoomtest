package com.zoom.cons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserAction {
	private static WebDriver driver;

	//���_�g�[��
	public static void OpenBrowser(String name){
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
	public static void OpenUrl(String url){
		//����һ��get
		driver.get(url);
		//�������� navigate to
		driver.navigate().to(url);
		//���_�����
		driver.manage().window().maximize();
	}
	
	//��ǰһ�
	public static void Farward(){
		driver.navigate().forward();
	}
	
	//������һ�
	public static void Back(){
		driver.navigate().back();
	}
	
	//Windows �� Frames֮����л�
	public static void Windows_Frames(String name){
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
	public static String GetTitle(String url){
		driver.get(url);
		return driver.getTitle();
	}
	
	//���������ͼ (Ĭ�J��ZoomTest��screenshot�ļ��A��)
	public static void Screenshot(String photoname){
		String path = "screenshot/";
		try {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
            FileUtils.copyFile(srcFile,new File(path + photoname+".png"));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	} 
    
	//���ȴ�
	public static void waitForPageToLoad(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	//�P�]�g�[��
	public static void CloseUrl(){
		//quit��������ȱ��
		//driver.quit();
		//����close����
		driver.close();
	}
}
