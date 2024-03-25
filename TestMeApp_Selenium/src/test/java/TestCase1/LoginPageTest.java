package TestCase1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestMePomPages.LoginPage;
import Utility.BrowsersUtil;
import Utility.decodeUtility;

public class LoginPageTest {
    WebDriver driver;
    LoginPage lp;

    @DataProvider
    public Object[][] credentialsProvider() {
        // Provide test data for login
        return new Object[][] {
                { decodeUtility.decodeSensitiveData("UnVzaGlrZXNo"), decodeUtility.decodeSensitiveData("VGVzdDEyMw==") },
                { "Training1", "Test123" },
        };
    }

    @BeforeTest
    public void setup() {
        // Launch browser before test
        driver = BrowsersUtil.launchBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void navigateToLoginPage() {
        // Navigate to login page before each test method
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
        lp = new LoginPage(driver);
    }

    @Test(dataProvider = "credentialsProvider")
    public void testLogin(String username, String password) {
        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLogin();
        // Assert whether the login was successful by checking the title of the home page
        Assert.assertEquals(driver.getTitle(), "Home", "Login failed for user: " + username);
    }

    @AfterTest
    public void tearDown() {
        // Close the browser after test
        if (driver != null) {
            driver.quit();
        }
    }
}
