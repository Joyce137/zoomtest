package com.test.control;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	private boolean match(String reg, String str) {
		return Pattern.matches(reg, str);
	}

	private List<String> find(String reg, String str) {
		Matcher matcher = Pattern.compile(reg).matcher(str);
		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group());
		}
		return list;
	}

	private String findString(String reg, String str) {
		String returnStr = null;
		List<String> list = this.find(reg, str);
		if (list.size() != 0)
			returnStr = list.get(0);
		return returnStr;
	}

	private String replaceSpecialParameter(String str, String key,
			String replace) {
		String findStr = this.findString(
				key + "[^\\" + Keyword.getKeyword("parameter_b") + "]*\\"
						+ Keyword.getKeyword("parameter_b") + ".*?\\"
						+ Keyword.getKeyword("parameter_e") + "", str);	
		String s = this.findString("(?<=\\" + Keyword.getKeyword("parameter_b") + ").*(?=\\"
				+ Keyword.getKeyword("parameter_e") + ")", findStr);
		String findStr_ = findStr.replace(s, replace);
		return str.replace(findStr, findStr_);
	}

	public boolean isComments(String str) {
		return this.match("^#.*", str.trim());
	}

	public boolean isOpen(String str) {
		return this.match(".*" + Keyword.getKeyword("open") + ".*", str);
	}

	public List<String> open(String str) {
		return this.find("(?<=" + Keyword.getKeyword("open") + "\").*?(?=\")",
				str);
	}

	public String replaceOpenUrl(String str, String replace) {
		return this.replaceSpecialParameter(str, Keyword.getKeyword("open"),
				replace);
	}

	public boolean isImport(String str) {
		return this.match(".*" + Keyword.getKeyword("import") + ".*", str);
	}

	public List<String> importClass(String str) {
		String findStr = this.findString(Keyword.getKeyword("import")
				+ "[^\\{]*\\{.*?\\}", str);
		if (findStr != null)
			return this.parameterName(findStr);
		else
			return null;
	}

	public List<String> importName(String str) {
		String findStr = this.findString(Keyword.getKeyword("importName")
				+ "[^\\{]*\\{.*?\\}", str);
		if (findStr != null)
			return this.parameterName(findStr);
		else
			return null;
	}

	public boolean isPageOrObject(String str) {
		return this.match(".*" + Keyword.getKeyword("page") + ".*", str);
	}

	public List<String> pageOrObjectName(String str) {
		String findStr = this.findString(Keyword.getKeyword("page")
				+ "[^\\{]*\\{.*?\\}", str);
		if (findStr != null)
			return this.parameterName(findStr);
		else
			return null;
	}

	private boolean hasObject(String str, String begin, String end) {
		String reg = "(?<=\\" + begin + ")[^\\" + begin + "]*?(?=\\" + end
				+ ")";
		return this.match(".*" + reg + ".*", str);
	}

	private List<String> objectName(String str, String begin, String end) {
		String reg = "(?<=\\" + begin + ")[^\\" + begin + "]*?(?=\\" + end
				+ ")";
		return this.find(reg, str);
	}

	private boolean isObjectParameter(String str, String begin, String end) {
		String reg = ".*\\" + begin + "[^\\" + begin + "]*?\\" + end + "[^\\"
				+ Keyword.getKeyword("element_b") + "\\"
				+ Keyword.getKeyword("element_b_") + "\\"
				+ Keyword.getKeyword("method_b") + "\\"
				+ Keyword.getKeyword("object_b") + "]*\\{.+?\\}.*";
		return this.match(reg, str);
	}

	private List<String> getObjectParameter(String str, String begin, String end) {
		String reg = "\\" + begin + "[^\\" + begin + "]*?\\" + end + "[^\\"
				+ Keyword.getKeyword("element_b") + "\\"
				+ Keyword.getKeyword("element_b_") + "\\"
				+ Keyword.getKeyword("method_b") + "\\"
				+ Keyword.getKeyword("object_b") + "]*\\{.+?\\}";
		String findStr = this.findString(reg, str);
		if (findStr != null)
			return this.parameterName(findStr);
		else
			return null;
	}

	private String replaceObjectParameter(String str, String begin, String end,
			String replace) {
		return this.replaceSpecialParameter(str, "\\" + begin + "[^\\" + begin
				+ "]*\\" + end, replace);
	}

	public boolean hasElement(String str) {
		boolean flag = false;
		if (this.hadElement1(str) || this.hadElement2(str))
			flag = true;
		return flag;
	}

	public boolean hadElement1(String str) {
		return this.hasObject(str, Keyword.getKeyword("element_b"),
				Keyword.getKeyword("element_e"));
	}

	public boolean hadElement2(String str) {
		return this.hasObject(str, Keyword.getKeyword("element_b_"),
				Keyword.getKeyword("element_e_"));
	}

	public List<String> elementName(String str) {
		List<String> list = null;
		if (this.hadElement1(str))
			list = this.objectName(str, Keyword.getKeyword("element_b"),
					Keyword.getKeyword("element_e"));
		if (this.hadElement2(str))
			list = this.objectName(str, Keyword.getKeyword("element_b_"),
					Keyword.getKeyword("element_e_"));
		return list;
	}

	public boolean isElementParameter(String str) {
		boolean flag = false;
		if (this.hadElement1(str))
			flag = this.isObjectParameter(str, Keyword.getKeyword("element_b"),
					Keyword.getKeyword("element_e"));
		if (this.hadElement2(str))
			flag = this.isObjectParameter(str,
					Keyword.getKeyword("element_b_"),
					Keyword.getKeyword("element_e_"));
		return flag;
	}

	public List<String> getElementParameter(String str) {
		List<String> list = null;
		if (this.hadElement1(str))
			list = this.getObjectParameter(str,
					Keyword.getKeyword("element_b"),
					Keyword.getKeyword("element_e"));
		if (this.hadElement2(str))
			list = this.getObjectParameter(str,
					Keyword.getKeyword("element_b_"),
					Keyword.getKeyword("element_e_"));
		return list;
	}

	public String replaceElementParameter(String str, String replace) {
		String re = null;
		if (this.hadElement1(str))
			re = this.replaceObjectParameter(str,
					Keyword.getKeyword("element_b"),
					Keyword.getKeyword("element_e"), replace);
		if (this.hadElement2(str))
			re = this.replaceObjectParameter(str,
					Keyword.getKeyword("element_b_"),
					Keyword.getKeyword("element_e_"), replace);
		return re;
	}

	public boolean hasMethod(String str) {
		return this.hasObject(str, Keyword.getKeyword("method_b"),
				Keyword.getKeyword("method_e"));
	}

	public List<String> methodName(String str) {
		return this.objectName(str, Keyword.getKeyword("method_b"),
				Keyword.getKeyword("method_e"));
	}

	public boolean hasParameter(String str) {
		return this.isObjectParameter(str, Keyword.getKeyword("method_b"),
				Keyword.getKeyword("method_e"));
	}

	public List<String> getMethodParameterName(String str) {
		return this.getObjectParameter(str, Keyword.getKeyword("method_b"),
				Keyword.getKeyword("method_e"));
	}

	public List<String> parameterName(String str) {
		return this.objectName(str, Keyword.getKeyword("parameter_b"),
				Keyword.getKeyword("parameter_e"));
	}

	public String replaceParameter(String str, String replace) {
		return this.replaceObjectParameter(str, Keyword.getKeyword("method_b"),
				Keyword.getKeyword("method_e"), replace);
	}

	public boolean hasReturnValue(String str) {
		return this.match(".*" + Keyword.getKeyword("return") + ".*", str);
	}

	public List<String> returnName(String str) {
		String findStr = this.findString(Keyword.getKeyword("return")
				+ "[^\\{]*\\{.*?\\}", str);
		if (findStr != null)
			return this.parameterName(findStr);
		else
			return null;
	}

	public String replaceReturn(String str, String replace) {
		return this.replaceSpecialParameter(str, Keyword.getKeyword("return"),
				replace);
	}

	public boolean isIfCase(String str) {
		return this.match(".*" + Keyword.getKeyword("if") + ".*", str);
	}

	public List<String> getIfCondition(String str) {
		return this.find("\\{[^\\{]*\\}" + Keyword.getKeyword("isEquals")
				+ "\\{.*?\\}", str);
	}

	public String replaceIfCondition(String str, List<String> list) {
		String[] p = str.split("\\{[^\\{]*\\}" + Keyword.getKeyword("isEquals")
				+ "\\{.*?\\}");
		String newStr = p[0];
		for (int i = 0; i < list.size(); i++) {
			if (p.length - 1 > i)
				newStr = newStr + list.get(i) + p[i + 1];
			else
				newStr = newStr + list.get(i);
		}
		return newStr;
	}

	public String replaceIfParameter(String str, List<String> list) {
		String reg = "(?<=\\" + Keyword.getKeyword("parameter_b") + ")[^\\"
				+ Keyword.getKeyword("parameter_b") + "]*?(?=\\"
				+ Keyword.getKeyword("parameter_e") + ")";
		String[] p = str.split(reg);
		String newStr = p[0];
		for (int i = 0; i < list.size(); i++) {
			newStr = newStr + list.get(i) + p[i + 1];
		}
		return newStr;
	}

	public String getLogicConnector(String str) {
		List<String> list = this
				.find(Keyword.getKeyword("or") + "|"
						+ Keyword.getKeyword("and"), str);
		String conn = null;
		if (list.size() > 0)
			conn = list.get(0);
		return conn;
	}

	public String getDetermine(String str) {
		List<String> results = this.find("(?<=\\}).*(?=\\{)", str);
		String determine = null;
		if (results.size() != 0)
			determine = results.get(0);
		return determine;
	}

	public boolean isLogicBlock(String str) {
		return this
				.match("^" + Keyword.getKeyword("logicBlock") + "[^-]+", str);
	}

	public int getLogicLevel(String str) {
		List<String> list = this.find("-+", str);
		int count = 0;
		if (list.size() > 0)
			count = list.get(0).length();
		return count;
	}

	public boolean isForCase(String str) {
		return this.match(".*" + Keyword.getKeyword("for") + ".*", str);
	}

	public static void main(String[] args) {
		RegExp re = new RegExp();
		String str = "xxx";
		String s1 = "$('input[name=toDate]').val('2014-05-29')";
		System.out.println(re.replaceReturn(str,s1));
	}
}
