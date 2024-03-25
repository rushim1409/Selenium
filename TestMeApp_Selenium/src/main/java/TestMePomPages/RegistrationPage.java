package TestMePomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(id = "userName")
    private WebElement usernameInput;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "pass_confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement maleGenderRadioButton;
    
    @FindBy(xpath = "//input[@value='Female']")
    private WebElement femaleGenderRadioButton;

    @FindBy(id = "emailAddress")
    private WebElement emailInput;

    @FindBy (id = "mobileNumber")
    private WebElement mobileNumberInput;
    
    @FindBy(id = "dob")
    private WebElement birthDateInput;

    @FindBy(id = "address")
    private WebElement addressTextarea;

    @FindBy(id = "securityQuestion")
    private WebElement securityQuestionDropdown;

    @FindBy(id = "answer")
    private WebElement answerInput;
    
    @FindBy (xpath = "//input[@value='Register']")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void confirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            maleGenderRadioButton.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            femaleGenderRadioButton.click();
        }
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterMobileNumber(String mobileNumber) {
    	mobileNumberInput.sendKeys(mobileNumber);
    }
    public void enterBirthDate(String birthDate) {
        birthDateInput.sendKeys(birthDate);
    }

    public void enterAddress(String address) {
        addressTextarea.sendKeys(address);
    }

    public void selectSecurityQuestion(String question) {
        Select select = new Select(securityQuestionDropdown);
        select.selectByVisibleText(question);
    }

    public void enterAnswer(String answer) {
        answerInput.sendKeys(answer);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
