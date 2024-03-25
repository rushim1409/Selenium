package TestCase1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestMePomPages.HomePage;
import Utility.BrowsersUtil;

public class AlertHandling {
	private WebDriver driver;
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
		homePage.clickFindDetailsButton();
		Thread.sleep(3000);
		if (ExpectedConditions.alertIsPresent() != null) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert Dialog Text Is - " + alert.getText());
			alert.accept();
		}
	}

	@AfterMethod
	public void tearDown() {
		
			driver.quit();
		}
	
}
