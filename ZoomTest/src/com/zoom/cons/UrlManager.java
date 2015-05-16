package com.zoom.cons;

import java.util.HashMap;

public class UrlManager {
	public static String url = null;
	public static String URLPATH = "src/com/zoom/cons/";
	public static String URLFILE = "urls.yaml";
	public static String getUrl(String key) {
		HashMap<String, HashMap<String, String>> ml = YamlReader.getml(URLPATH, URLFILE);
		url = ml.get(key).get("url");
		return url;
	}
}
