package TestCase1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestMePomPages.HomePage;
import Utility.BrowsersUtil;


public class HomePageLinkTest {
    private WebDriver driver;
    private HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

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
    public void testHomePageLinks() {
    	homePage.clickSignInLink();
    	softAssert.assertTrue(driver.getCurrentUrl().contains("login"));
    	driver.navigate().back();
    	homePage.clickSignUpLink();
    	softAssert.assertTrue(driver.getCurrentUrl().contains("RegisterUser"));
    	softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
