package selenium2.examples;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium2Example7Test {

	@Test
	public void test() {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setVersion("14");
		capability.setPlatform(Platform.MAC);

		WebDriver webdriver = null;
		try {
			webdriver = new RemoteWebDriver(new URL(
					"http://localhost:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		webdriver.get("https://github.com");

		List<WebElement> webElements = webdriver.findElements(By
				.xpath("//ul[@class='nav logged_out']/li"));

		Assert.assertEquals(5, webElements.size());

		WebElement anchor1 = webElements.get(0).findElement(By.tagName("a"));
		WebElement anchor2 = webElements.get(1).findElement(By.tagName("a"));
		WebElement anchor3 = webElements.get(2).findElement(By.tagName("a"));
		WebElement anchor4 = webElements.get(3).findElement(By.tagName("a"));
		WebElement anchor5 = webElements.get(4).findElement(By.tagName("a"));

		Assert.assertEquals("Signup and Pricing", anchor1.getText());
		Assert.assertEquals("Explore GitHub", anchor2.getText());
		Assert.assertEquals("Features", anchor3.getText());
		Assert.assertEquals("Blog", anchor4.getText());
		Assert.assertEquals("Login", anchor5.getText());

		webdriver.quit();

	}
}
