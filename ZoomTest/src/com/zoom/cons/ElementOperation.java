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

	//���캯���� driver&element
	public ElementOperation(WebDriver driver, WebElement element){
		this.driver = driver;
		this.element = element;
	}
	
	//���캯���� driver&elements
	public ElementOperation(WebDriver driver, List<WebElement> elements){
		this.driver = driver;
		this.elements = elements;
	}
	
	// assert�M�����ݜyԇ
	public void assertText(String s){
		String text = element.getText();
		Assert.assertEquals(text, s);
	}

	// ݔ���Input�M��̎��(ݔ�룩
	public void inputOperation(String value) {
		element.clear();
		element.sendKeys(value);
		String text = element.getAttribute("value");
		System.out.println("input " + text);
	}

	// link̎��(�Д��Ƿ���link-url @paras urlname in urls.yaml )
	public void linkOperation(String urlname) {
		// �@ȡ������url
		String url = UrlManager.getUrl(urlname);
		// �@ȡhref&text
		String href = element.getAttribute("href");
		System.out.println("href = " + href);
		String text = element.getText();
		System.out.println("text = " + text);
		// �c��link
		element.click();
		synchronized (driver) {
			try {
				driver.wait(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//�@ȡlink����url,�Д��Ƿ����_
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, url);
	}
	// link̎��(�Д��Ƿ���link-url @paras url)
		//���ڴ���̬url
	public void linkUrl(String url) {
		// �@ȡhref&text
		String href = element.getAttribute("href");
		System.out.println("href = " + href);
		String text = element.getText();
		System.out.println("text = " + text);
		// �c��link
		element.click();
		synchronized (driver) {
			try {
				driver.wait(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//�@ȡlink����url,�Д��Ƿ����_
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, url);
	}
	
	// button����
	public void buttonOperation() {
		boolean enable = element.isEnabled();
		if (enable == false) {
			System.out.println("button is enabled?: " + enable);
		} else {
			element.click();
		}
	}
	
	//select dropdown̎��
		//�������x��ă���
	public void selectorOperation(String value){
		if(value == null)
			return;
		Select select = new Select(element);
		select.selectByValue(value);
		String s = select.getFirstSelectedOption().getText();
		System.out.println("You select "+s);
	}
	
	//���x��radio̎��
		//�������x��ڎׂ�
	public void radioOperation(int index){
		WebElement element = elements.get(index);
		element.click();
		String s = element.getText();
		System.out.println(s+" is selected.");
	}
	
	//���x��checkbox̎��
		//�������x��헵Ĕ��M
	public void checkboxOperation(int[] indexs){
		//ss�惦���x�е��x���
		String[] ss = new String[indexs.length];
		//ѭ�h�x��
		for(int i = 0;i<indexs.length; i++){
			WebElement element = elements.get(indexs[i]);
			element.click();
			ss[i] = element.getText();
			System.out.println(ss[i]+" is selected.");
		}	
	}
	
	//alert̎��
		//ݔ��̎�������1-accept�� 0- cancel)
	public void alertOperation(int option){
		Actions action = new Actions(driver);
		action.click(element).perform();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert = "+text);
		
		//���x��Дಢ̎��
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
	
	//JavaScript̎��
	public void jsOperation(){
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("alert('hello world!')");
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("JavaScript-Alert = "+text);
		alert.accept();
	}
	
	//action̎��
	public void actionOperation(){
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		String text = driver.findElement(By.id("over")).getText();
		System.out.println("Action = "+text);
	}
	
	//multiWindows̎��
	public void multiWindows(){
		element.click();
		Set<String> handles = driver.getWindowHandles();
		String handle = driver.getWindowHandle();
		handles.remove(handle);
		WebDriver d = driver.switchTo().window(handles.iterator().next());
		d.close();
		driver.switchTo().window(handle);
	}
	
	//upload̎��
	public void uploadOperation(String filepath){
		File f = new File(filepath);
		if(f.exists()){
			element.sendKeys(filepath);
		}
		else{
			System.out.println("The file doesn't exist!");
		}
	}
	
	//wait�ȴ�̎��
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
	
	//table̎��(�õ���Ԫ�񌦑���element)
	/** �õ�table�Ć�Ԫ��Ԫ��. ����tableCellAddress�ĸ�ʽ��row.column, ���Џ�0�_ʼ.  
	    @param table  table���� 
	    @param tableCellAddress һ����Ԫ���ַ, �� "1.4"  
	    @return һ��table�Ć�Ԫ��element 
    */  
    public WebElement getCellText(WebElement table,String tableCellAddress) {     
        //����Ҫ���ҵĆ�Ԫ��λ���ַ����M�зֽ⣬�õ��䌦���к��С�   
        int index = tableCellAddress.trim().indexOf('.');   
        int row =  Integer.parseInt(tableCellAddress.substring(0, index));   
        int cell = Integer.parseInt(tableCellAddress.substring(index+1));   
        //�õ�table���������Ќ��󣬲��õ���Ҫ��ԃ���Ќ���   
         List<WebElement> rows = table.findElements(By.tagName("tr"));   
         WebElement theRow = rows.get(row);   
         //�{��getCell�����õ��������Ќ���   
         WebElement target = getCell(theRow, cell);   
         return target;   
    }   
    
    private WebElement getCell(WebElement Row,int cell){   
         List<WebElement> cells;   
         WebElement target = null;   
         //���e����"<th>"��"<td>"�ɷN�˻`�����Է��_̎��   
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
