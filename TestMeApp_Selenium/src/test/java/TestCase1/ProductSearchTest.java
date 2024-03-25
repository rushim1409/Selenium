package TestCase1;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestMePomPages.HomePage;
import TestMePomPages.SearchResultPage;
import Utility.BrowsersUtil;

public class ProductSearchTest {
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
    public void testProductSearch() {
        // Search for a product
        homePage.enterSearchText("Gift set");
        homePage.clickFindDetailsButton();

        // Assuming search results page is displayed after searching
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String searchedText = searchResultPage.verifyProductName();
        Assert.assertTrue(searchedText.contains("Gift set"), "Searched text doesn't contain 'Gift set'");
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
