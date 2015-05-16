package com.zoom.cons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YamlReader {
	private WebDriver driver = DriverManager.getDriver();
	// yaml文件
	private String yamlPath;
	private String yamlFile;

	//get&set files
	public String getYamlPath() {
		return yamlPath;
	}
	
	public void setYamlFile(String yamlFile) {
		this.yamlFile = yamlFile;
	}

	// 用HashMap存儲yaml文件
	private HashMap<String, HashMap<String, String>> ml;
	private HashMap<String, HashMap<String, String>> extendLocator;

	// 構造函數
	public YamlReader(String yamlFile) {
		// yaml
		this.yamlFile = yamlFile;
		this.getYamlFile();
	}

	// get yaml file
	@SuppressWarnings("unchecked")
	public void getYamlFile() {
		File f = new File(yamlPath + yamlFile + ".yaml");
		// 存到HashMap ml中
		try {
			FileInputStream fi = new FileInputStream(f.getAbsolutePath());
			ml = Yaml.loadType(fi, HashMap.class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void loadExtendLocator(String fileName) {
		File f = new File(yamlPath + fileName + ".yaml");
		try {
			extendLocator = Yaml.loadType(
					new FileInputStream(f.getAbsolutePath()), HashMap.class);
			ml.putAll(extendLocator);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 統一處理各種type
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
		if (type.equals("classname")) {
			by = By.className(value);
		}
		if (type.equals("linkText")) {
			by = By.linkText(value);
		}
		return by;
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