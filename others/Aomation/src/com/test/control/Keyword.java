package com.test.control;

import java.io.File;
import java.util.HashMap;

import com.test.util.ParserXml;

public class Keyword {

	private static HashMap<String, String> keyword = null;

	private static synchronized void getKeywordMap() {
		if (keyword == null) {
			ParserXml p = new ParserXml();
			keyword = p.parser2Xml(new File("config/keyword.xml")
					.getAbsolutePath());
		}
	}

	public static String getKeyword(String key) {
		String value = null;
		if (keyword == null)
			Keyword.getKeywordMap();
		if (keyword.containsKey(key))
			value = keyword.get(key);		
		return value;
	}

}
