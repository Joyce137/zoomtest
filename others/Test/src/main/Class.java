package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Class {

	public static void main(String[] args){
		//System.setProperty("webdriver.ie.driver","D:\\°²×°°ü\\²âÊÔTest\\Selenium\\IEDriverServer.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.caoruijuan.com/demo.html");
		WebElement e = driver.findElement(By.id("user"));
		e.sendKeys("Hello");
	}
}
