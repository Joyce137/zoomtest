package selenium2.examples;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;

public class Selenium2Example4Test {

	@Test
	public void test() {

		WebDriver webdriver = new OperaDriver();

		webdriver.get("https://github.com");

		Assert.assertEquals("GitHub - Social Coding", webdriver.getTitle());

		webdriver.quit();

	}

}
