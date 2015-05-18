package com.zoom.cons;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ElementOperation {
	private WebDriver driver = DriverManager.getDriver();
	private WebElement element;
	private List<WebElement> elements;

	//構造函數： driver&element
	public ElementOperation(WebDriver driver, WebElement element){
		this.driver = driver;
		this.element = element;
	}
	
	//構造函數： driver&elements
	public ElementOperation(WebDriver driver, List<WebElement> elements){
		this.driver = driver;
		this.elements = elements;
	}
	
	// assert組件內容測試
	public void assertText(String s){
		String text = element.getText();
		Assert.assertEquals(text, s);
	}

	// 輸入框Input組件處理(輸入）
	public void inputOperation(String value) {
		element.clear();
		element.sendKeys(value);
		String text = element.getAttribute("value");
		System.out.println("input " + text);
	}

	// link處理(判斷是否是link-url)
	public void linkOperation(String urlname) {
		// 獲取對應的url
		String url = UrlManager.getUrl(urlname);
		// 獲取href&text
		String href = element.getAttribute("href");
		System.out.println("href = " + href);
		String text = element.getText();
		System.out.println("text = " + text);
		// 點擊link
		element.click();
		synchronized (driver) {
			try {
				driver.wait(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//獲取link頁面的url,判斷是否正確
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, url);
	}

	// button处理
	public void buttonOperation() {
		boolean enable = element.isEnabled();
		if (enable == false) {
			System.out.println("button is enabled?: " + enable);
		} else {
			element.click();
		}
	}
	
	//select dropdown處理
		//參數為選擇的內容
	public void selectorOperation(String value){
		Select select = new Select(element);
		select.selectByValue(value);
		String s = select.getFirstSelectedOption().getText();
		System.out.println("You select "+s);
	}
	
	//單選框radio處理
		//參數為選擇第幾個
	public void radioOperation(int index){
		WebElement element = elements.get(index);
		element.click();
		String s = element.getText();
		System.out.println(s+" is selected.");
	}
	
	//多選框checkbox處理
		//參數為選擇項的數組
	public void checkboxOperation(int[] indexs){
		//ss存儲被選中的選項名
		String[] ss = new String[indexs.length];
		//循環選擇
		for(int i = 0;i<indexs.length; i++){
			WebElement element = elements.get(indexs[i]);
			element.click();
			ss[i] = element.getText();
			System.out.println(ss[i]+" is selected.");
		}	
	}
	
	//alert處理
		//輸入處理動作（1-accept， 0- cancel)
	public void alertOperation(int option){
		Actions action = new Actions(driver);
		action.click(element).perform();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert = "+text);
		
		//對選項判斷并處理
		if(option == 1){
			alert.accept();
		}
		else if(option == 0){
			alert.dismiss();
		}
		else{
			System.out.println("Wrong parameter.");
		}
	}
	
	//JavaScript處理
	public void jsOperation(){
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("alert('hello world!')");
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("JavaScript-Alert = "+text);
		alert.accept();
	}
	
	//action處理
	public void actionOperation(){
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		String text = driver.findElement(By.id("over")).getText();
		System.out.println("Action = "+text);
	}
	
	//multiWindows處理
	public void multiWindows(){
		element.click();
		Set<String> handles = driver.getWindowHandles();
		String handle = driver.getWindowHandle();
		handles.remove(handle);
		WebDriver d = driver.switchTo().window(handles.iterator().next());
		d.close();
		driver.switchTo().window(handle);
	}
	
	//upload處理
	public void uploadOperation(String filepath){
		File f = new File(filepath);
		if(f.exists()){
			element.sendKeys(filepath);
		}
		else{
			System.out.println("The file doesn't exist!");
		}
	}
	
	//wait等待處理
	public void waitOperation(){
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
	
	//table處理(得到單元格對應的element)
	/** 得到table的單元格元素. 參數tableCellAddress的格式為row.column, 行列從0開始.  
	    @param table  table對象 
	    @param tableCellAddress 一個單元格地址, 如 "1.4"  
	    @return 一个table的單元格element 
    */  
    public WebElement getCellText(WebElement table,String tableCellAddress) {     
        //對索要查找的單元格位置字符串進行分解，得到其對應行和列。   
        int index = tableCellAddress.trim().indexOf('.');   
        int row =  Integer.parseInt(tableCellAddress.substring(0, index));   
        int cell = Integer.parseInt(tableCellAddress.substring(index+1));   
        //得到table表中所有行對象，并得到所要查詢的行對象。   
         List<WebElement> rows = table.findElements(By.tagName("tr"));   
         WebElement theRow = rows.get(row);   
         //調用getCell方法得到對應的列對象。   
         WebElement target = getCell(theRow, cell);   
         return target;   
    }   
    
    private WebElement getCell(WebElement Row,int cell){   
         List<WebElement> cells;   
         WebElement target = null;   
         //列裡面有"<th>"、"<td>"兩種標籤，所以分開處理。   
         if(Row.findElements(By.tagName("th")).size()>0){   
            cells = Row.findElements(By.tagName("th"));   
            target = cells.get(cell);   
         }   
         if(Row.findElements(By.tagName("td")).size()>0){   
            cells = Row.findElements(By.tagName("td"));   
            target = cells.get(cell);   
         }   
        return target;           
    }   
}
