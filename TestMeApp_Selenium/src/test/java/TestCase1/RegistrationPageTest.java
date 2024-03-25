package TestCase1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestMePomPages.RegistrationPage;
import Utility.BrowsersUtil;
import java.util.Random;

public class RegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        // Launch browser and navigate to registration page
        driver = BrowsersUtil.launchBrowser("chrome");
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/RegisterUser.htm");
    }

    @Test
    public void testRegistration() {
        // Generate a random number between 1000 and 9999
        Random rand = new Random();
        int randomNum = rand.nextInt(90000) + 10000;

        // Append the random number to the base username "testUser"
        String username = "Rushikesh" + randomNum;

        // Fill out the registration form
        registrationPage.enterUsername(username);
        registrationPage.enterFirstName("rushi");
        registrationPage.enterLastName("Magar");
        registrationPage.enterPassword("password");
        registrationPage.confirmPassword("password");
        registrationPage.selectGender("male");
        registrationPage.enterEmail("test@example.com");
        registrationPage.enterMobileNumber("1234567890");
        registrationPage.enterBirthDate("09/14/1999");
        registrationPage.enterAddress("123 Test Maharashtra");
        registrationPage.selectSecurityQuestion("What is your Pet Name?");
        registrationPage.enterAnswer("carry");
        registrationPage.clickRegisterButton();

        // Assert registration success
        Assert.assertEquals(driver.getTitle(), "Login", "Registration failed.");
    }

    @AfterMethod
    public void tearDown() {
         //Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
