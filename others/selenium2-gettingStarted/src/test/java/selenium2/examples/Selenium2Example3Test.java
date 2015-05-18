package selenium2.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium2Example3Test {

	@Test
	public void test() {

		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();

		capability
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		WebDriver webdriver = new InternetExplorerDriver(capability);

		webdriver.get("https://github.com");

		Assert.assertEquals("GitHub - Social Coding", webdriver.getTitle());

		webdriver.quit();

	}

}
