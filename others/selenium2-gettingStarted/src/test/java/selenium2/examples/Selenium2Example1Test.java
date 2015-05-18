package selenium2.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium2Example1Test {

	@Test
	public void test() {

		WebDriver webdriver = new FirefoxDriver();

		webdriver.get("https://github.com");

		Assert.assertEquals("GitHub - Social Coding", webdriver.getTitle());

		webdriver.quit();

	}

}
