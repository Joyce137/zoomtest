package com.zoom.cons;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoom.utils.Log;

public class LocatorManager {
	private WebDriver driver;		
	// yaml文件
	private String yamlFile;

	// 用HashMap存儲yaml文件
	private HashMap<String, HashMap<String, String>> ml;
	
	//構造函數
	public LocatorManager(){
		this.driver = DriverManager.getDriver();
		this.yamlFile = null;
		ml = YamlReader.getml(yamlFile);
	}	

	public LocatorManager(String yamlFile) {		
		this.driver = DriverManager.getDriver();
		// yaml
		this.yamlFile = yamlFile;
		ml = YamlReader.getml(yamlFile);
	}

	public void setLocatorVariableValue(String variable, String value) {
		Set<String> keys = ml.keySet();
		for (String key : keys) {
			String v = ml.get(key).get("value")
					.replaceAll("%" + variable + "%", value);
			ml.get(key).put("value", v);
		}
	}

	private String getLocatorString(String locatorString, String[] ss) {
		for (String s : ss) {
			locatorString = locatorString.replaceFirst("%s", s);
		}
		return locatorString;
	}

	private By getBy(String type, String value) {
		By by = null;
		if (type.equals("id")) {
			by = By.id(value);
		}
		if (type.equals("name")) {
			by = By.name(value);
		}
		if (type.equals("xpath")) {
			by = By.xpath(value);
		}
		if (type.equals("className")) {
			by = By.className(value);
		}
		if (type.equals("linkText")) {
			by = By.linkText(value);
		}
		if(type.equals("css")){
			by = By.cssSelector(value);
		}
		return by;
	}

	private WebElement watiForElement(final By by) {
		WebElement element = null;
		int waitTime = Integer.parseInt(Config.getConfig("waitTime"));
		try {
			element = new WebDriverWait(driver, waitTime)
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(by);
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			Log.comment(by.toString() + " is not exist until " + waitTime);
		}
		return element;
	}

	private boolean waitElementToBeDisplayed(final WebElement element) {
		boolean wait = false;
		if (element == null)
			return wait;
		try {
			wait = new WebDriverWait(driver, Integer.parseInt(Config
					.getConfig("waitTime")))
					.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver d) {
							return element.isDisplayed();
						}
					});
		} catch (Exception e) {
			Log.comment(element.toString() + " is not displayed");
		}
		return wait;
	}

	public boolean waitElementToBeNonDisplayed(final WebElement element) {
		boolean wait = false;
		if (element == null)
			return wait;
		try {
			wait = new WebDriverWait(driver, Integer.parseInt(Config
					.getConfig("waitTime")))
					.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver d) {
							return !element.isDisplayed();
						}
					});
		} catch (Exception e) {
			Log.comment("Locator [" + element.toString()
					+ "] is also displayed");
		}
		return wait;
	}


	@SuppressWarnings("unused")
	private WebElement getLocator(String key, String[] replace, boolean wait) {		
		if (ml == null){
			ml = YamlReader.getml(yamlFile);
		}
		WebElement element = null;
		if (ml.containsKey(key)) {
			HashMap<String, String> m = ml.get(key);
			String type = m.get("type");
			String value = m.get("value");
			if (replace != null)
				value = this.getLocatorString(value, replace);
			By by = this.getBy(type, value);
			if (wait) {
				element = this.watiForElement(by);
				boolean flag = this.waitElementToBeDisplayed(element);
				if (!flag)
					element = null;
			} else {
				try {
					element = driver.findElement(by);
				} catch (Exception e) {
					element = null;
				}
			}
		} else
			Log.comment("Locator " + key + " is not exist in " + yamlFile + ".yaml");
		return element;
	}

	// 得到各種WebElement
	public WebElement getElement(String key) {
		String type = ml.get(key).get("type");
		String value = ml.get(key).get("value");
		return driver.findElement(this.getBy(type, value));
	}

	// 处理RadioBox等控件,得到WebElements(List<Element>)
	public List<WebElement> getElements(String key) {
		String type = ml.get(key).get("type");
		String value = ml.get(key).get("value");
		return driver.findElements(this.getBy(type, value));
	}
}
