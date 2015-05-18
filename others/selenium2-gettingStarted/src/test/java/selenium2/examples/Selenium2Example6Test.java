package selenium2.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;

public class Selenium2Example6Test {

	@Test
	public void test() {

		String url = "https://github.com";
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/drivers/chrome/chromedriver-mac");
		WebDriver webdriver = new ChromeDriver();

		webdriver.get(url);

		Selenium selenium = new WebDriverBackedSelenium(webdriver, url);
		selenium.open(url);

		Number lis = selenium.getXpathCount("//ul[@class='nav logged_out']/li");

		Assert.assertEquals(5, lis.intValue());

		String anchor1Text = selenium
				.getText("//ul[@class='nav logged_out']/li[1]/a");
		String anchor2Text = selenium
				.getText("//ul[@class='nav logged_out']/li[2]/a");
		String anchor3Text = selenium
				.getText("//ul[@class='nav logged_out']/li[3]/a");
		String anchor4Text = selenium
				.getText("//ul[@class='nav logged_out']/li[4]/a");
		String anchor5Text = selenium
				.getText("//ul[@class='nav logged_out']/li[5]/a");

		Assert.assertEquals("Signup and Pricing", anchor1Text);
		Assert.assertEquals("Explore GitHub", anchor2Text);
		Assert.assertEquals("Features", anchor3Text);
		Assert.assertEquals("Blog", anchor4Text);
		Assert.assertEquals("Login", anchor5Text);

		webdriver.quit();

	}
}
