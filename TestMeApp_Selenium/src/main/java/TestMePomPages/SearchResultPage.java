package TestMePomPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    private WebDriver driver;

    @FindBy(xpath = "(//div[@class='row'])[4]")
    private WebElement searchedProductText;
    
    @FindBy(xpath = "//a[contains(@href,'/TestMeApp/addProduct')]") // Assuming this is the locator for the "Add to Cart" button
    private WebElement addToCartButton;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String verifyProductName() {
    	return searchedProductText.getText();
    }
    public void addToCart() {
        addToCartButton.click();
    }
}
