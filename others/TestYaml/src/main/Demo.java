package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Demo {
	private String yamlFile;
	private WebDriver driver;
	 public Demo()
	 {     
	        yamlFile = "demo";
	        this.getYamlFile();
	      //driver
			//System.setProperty("webdriver.ie.driver","D:\\安装包\\测试Test\\Selenium\\IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
	        driver = new FirefoxDriver();
	 }
	 
	 private HashMap<String, HashMap<String, String>> ml;
	 
	 
	 //處理xpath特殊情況
	 private HashMap<String, HashMap<String, String>> extendLocator;
	
	 
	 @SuppressWarnings("unchecked")
	 public void getYamlFile()
	 {
	        File f = new File("locator/" + yamlFile + ".yaml");
	        try {
	            ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()),HashMap.class);
	        }catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	 }  
	 /*
	 @SuppressWarnings("unchecked")
	 public void loadExtendLocator(String fileName){
	     File f = new File("locator/" + fileName + ".yaml");
	     try {
	         extendLocator = Yaml.loadType(new FileInputStream(f.getAbsolutePath()),
	                 HashMap.class);
	         ml.putAll(extendLocator);
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     }
	 }   
	 public void setLocatorVariableValue(String variable, String value){
	        Set<String> keys = ml.keySet();
	        for(String key:keys){
	             String v = ml.get(key).get("value").replaceAll("%"+variable+"%", value);
	             ml.get(key).put("value",v);
	        }
	    }
	 
	    private String getLocatorString(String locatorString, String[] ss) {
	        for (String s : ss) {
	            locatorString = locatorString.replaceFirst("%s", s);
	        }
	        return locatorString;
	    }
	    
	    */
	//統一處理各種type
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
	    
	  //得到各種WebElementString
	    public String getElementString(String key) {
	        String type = ml.get(key).get("type");
	        String value = ml.get(key).get("value");
	        WebElement e = driver.findElement(this.getBy(type, value));
	        
	        return type+"--"+value;
	    }
	 
	    //得到各種WebElement
	    public WebElement getElement(String key) {
	        String type = ml.get(key).get("type");
	        String value = ml.get(key).get("value");
	        return driver.findElement(this.getBy(type, value));
	    }
	    
	  //test goto
		public void testGoto(String url){
			driver.navigate().to(url);
			driver.manage().window().maximize();
		}
		
		//quit
		public void testQuit(){
			driver.quit();
		}
		
		//test input
		public void testInput(String value){
			WebElement element = getElement("baidu_input");
			element.sendKeys(value);
			element.clear();
			element.sendKeys(value);
			String text = element.getAttribute("value");
			System.out.println("input= "+text);
		}
		
		//test link
		public void testLink(){
			WebElement element = getElement("link");
			String href = element.getAttribute("href");
			System.out.println("href = "+href);
			String text = element.getText();
			System.out.println("text = "+text);	
			element.click();
			try {
				driver.wait(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.navigate().back();
		}
	     
	    public static void main(String[] args){
	        Demo d = new Demo();
	        d.testGoto("http://www.baidu.com");
	        WebElement e = d.driver.findElement(By.id("kw"));
	        e.sendKeys("hello");
	        //WebElement element = d.getElement("baidu_input");
	       // element.sendKeys("hello");
	        //d.testGoto("http://www.caoruijuan.com/demo.html");
	        
			//d.testInput("hello");
	        //WebElement element = d.driver.findElement(By.id("user"));
			//element.sendKeys("hello");
	        //System.out.println(d.getElementString("binput"));
			//d.testQuit();
	        //System.out.println("element");
	    }
	
}
