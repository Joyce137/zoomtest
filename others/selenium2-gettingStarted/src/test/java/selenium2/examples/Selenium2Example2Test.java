package selenium2.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium2Example2Test {

	@Test
	public void test() {

		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/drivers/chrome/chromedriver-mac");
		WebDriver webdriver = new ChromeDriver();

		webdriver.get("https://github.com");

		Assert.assertEquals("GitHub - Social Coding", webdriver.getTitle());

		webdriver.quit();

	}

}
