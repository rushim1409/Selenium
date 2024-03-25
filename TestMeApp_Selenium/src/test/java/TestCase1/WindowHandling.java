package TestCase1;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestMePomPages.HomePage;
import Utility.BrowsersUtil;

public class WindowHandling {
	WebDriver driver;
	private HomePage homePage;

	@BeforeMethod
	public void setUp() {
		// Set up WebDriver
		driver = BrowsersUtil.launchBrowser("chrome");
		driver.manage().window().maximize();

		// Initialize HomePage instance
		homePage = new HomePage(driver);
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	}

	@Test
	public void testHomePageLinks() throws InterruptedException {
		homePage.moveAndClickOnChennaiLocationButton();
		Set<String> allWindows = driver.getWindowHandles();
		for(String windows : allWindows) {
			driver.switchTo().window(windows);
			System.out.println(driver.getTitle());
		}
		Assert.assertEquals("Contact Us", driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		// Close the WebDriver instance
		if (driver != null) {
			driver.quit();
		}
	}
}
