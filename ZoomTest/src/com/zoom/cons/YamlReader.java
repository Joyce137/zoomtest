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
	// ��HashMap�惦yaml�ļ�
	private static HashMap<String, HashMap<String, String>> ml;
	private static HashMap<String, HashMap<String, String>> extendLocator;

	// get yaml file
	@SuppressWarnings("unchecked")
	public static void getYamlFile(String file) {
		File f = new File(file);
		// �浽HashMap ml��
		try {
			FileInputStream fi = new FileInputStream(f.getAbsolutePath());
			ml = Yaml.loadType(fi, HashMap.class);
			extendLocator = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
			ml.putAll(extendLocator);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static HashMap<String, HashMap<String, String>> getml(String filename){
		String yamlPath = "src/com/zoom/locator/";
		getYamlFile(yamlPath + filename + ".yaml");
		return ml;
	}
	public static HashMap<String, HashMap<String, String>> getml(String filepath, String filename){
		getYamlFile(filepath + filename);
		return ml;
	}
}