package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.ho.yaml.Yaml;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Demo {
	private WebDriver driver;
	//yaml文件
	private String yamlFile;
	//用HashMap存儲yaml文件
	private HashMap<String, HashMap<String, String>> ml; 
	private HashMap<String, HashMap<String, String>> extendLocator;
	
	//構造函數
	public Demo(){	
		//yaml
		yamlFile = "demo";
		this.getYamlFile();
		
		//driver
		//System.setProperty("webdriver.ie.driver","D:\\安装包\\测试Test\\Selenium\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		driver = new FirefoxDriver();
	}
	
	//get yaml file
	@SuppressWarnings("unchecked")
	public void getYamlFile() {
		File f = new File("data/"+yamlFile+".yaml");
		//存到HashMap ml中
		try {
			FileInputStream fi=new FileInputStream(f.getAbsolutePath());
			ml = Yaml.loadType(fi, HashMap.class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 @SuppressWarnings("unchecked")
	 public void loadExtendLocator(String fileName){
		 File f = new File("data/" + fileName + ".yaml");
		 try {
			 extendLocator = Yaml.loadType(new FileInputStream(f.getAbsolutePath()),HashMap.class);
	         ml.putAll(extendLocator);
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
	 }
	 
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
	 
    //得到各種WebElement
    public WebElement getElement(String key) {
        String type = ml.get(key).get("type");
        String value = ml.get(key).get("value");
        return driver.findElement(this.getBy(type, value));
    }
    //处理RadioBox等控件,得到WebElements(List<Element>)
    public List<WebElement> getElements(String key){
    	String type = ml.get(key).get("type");
        String value = ml.get(key).get("value");
    	return driver.findElements(this.getBy(type, value));
    }
	    
	//test goto
	public void testGoto(String url){
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	//quit
	public void testQuit(){
		//driver.quit();
		driver.close();
	}
	
	//test input
	public void testInput(String value){
		WebElement element = getElement("input");
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
		synchronized(driver){
			try {
				driver.wait(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.navigate().back();
	}
	
	//test select
	public void testSelect(String value){
		WebElement element = getElement("select");
		Select select = new Select(element);
		select.selectByValue(value);
		String s = select.getFirstSelectedOption().getText();
		System.out.println("select = "+s);
	}
	
	//test radiobox
	public void testRadioBox(int index){
		List<WebElement> elements = getElements("radiobox");
		WebElement element = elements.get(index);
		element.click();
		boolean select = element.isSelected();
		System.out.println("radiobox is selected?: "+select);
	}
	
	//test checkbox
	public void testCheckbox(int index){
		List<WebElement> elements = getElements("checkbox");
		WebElement element = elements.get(index);
		element.click();
		boolean check = element.isSelected();
		System.out.println("checkbox is checked?: "+check);
	}
	
	//test button
	public void testButton(){
		WebElement element = getElement("button");
		element.click();
		boolean button = element.isEnabled();
		System.out.println("button is enabled?: "+button);
	}
	
	//test alert
	public void testAlert(){
		WebElement element = getElement("alert");
		Actions action = new Actions(driver);
		action.click(element).perform();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert = "+text);
		alert.accept();
	}
	
	//test upload
	public void testUpload(String filepath){
		File f = new File(filepath);
		if(f.exists()){
			WebElement element = getElement("upload");
			element.sendKeys(filepath);
		}
		else{
			System.out.println("The file doesn't exist!");
		}
	}
	
	//test javascript
	public void testJavascript(){
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("alert('hello world!')");
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("JavaScript-Alert = "+text);
		alert.accept();
	}
	
	//test multiWindow
	public void testMultiWindows(){
		WebElement element = getElement("multiwindow");
		element.click();
		Set<String> handles = driver.getWindowHandles();
		String handle = driver.getWindowHandle();
		handles.remove(handle);
		WebDriver d = driver.switchTo().window(handles.iterator().next());
		d.close();
		driver.switchTo().window(handle);
	}
	
	//test action
	public void testAction(){
		WebElement element = getElement("action");
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		String text = driver.findElement(By.id("over")).getText();
		System.out.println("Action = "+text);
	}
	
	//test wait
	public void testWait(){
		WebElement element = getElement("wait");
		element.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean wait = new WebDriverWait(driver, 3)
			.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver arg0) {
					return driver.findElement(By.className("red")).isDisplayed();
				}
			});
		System.out.println("Waiting = "+wait);
        System.out.println(driver.findElement(By.className("red")).getText());
	}
	
	//main
	public static void main(String[] args){
		Demo d = new Demo();
		d.testGoto("http://www.caoruijuan.com/demo.html");
		d.testInput("hello");
		d.testLink();
		d.testRadioBox(2);
        d.testSelect("opel");
        d.testCheckbox(2);
        d.testButton();
        d.testUpload("f:\\test.txt");
        d.testAlert();
        d.testAction();
        d.testMultiWindows();
        d.testJavascript();
		d.testWait();
		d.testQuit();
	}
}
