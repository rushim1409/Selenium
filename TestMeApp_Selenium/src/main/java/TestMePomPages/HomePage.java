package TestMePomPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    Actions act;

    @FindBy(id = "myInput")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value='FIND DETAILS']")
    private WebElement findDetailsButton;

    @FindBy(xpath = "//a[contains(text(),'SignIn')]")
    private WebElement signInLink;

    @FindBy(xpath = "//a[contains(text(),'SignUp')]")
    private WebElement signUpLink;
    
    @FindBy(xpath = "//span[text()='AboutUs']")
    private WebElement aboutUsButton;
    
    @FindBy(xpath = "//span[contains(text(),'Offices')]")
    private WebElement ourOfficesButton;
    
    @FindBy(xpath ="//span[contains(text(),'Chennai')]")
    private WebElement chennaiButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterSearchText(String searchText) {
        searchInput.sendKeys(searchText);
    }

    public void clickFindDetailsButton() {
    	findDetailsButton.click();
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickSignUpLink() {
        signUpLink.click();
    }
 
    public void moveAndClickOnChennaiLocationButton() {
    	act = new Actions(driver);
    	act.moveToElement(aboutUsButton).moveToElement(ourOfficesButton)
    	.moveToElement(chennaiButton).click().build().perform();
    }

}
