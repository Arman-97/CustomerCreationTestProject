package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminAreaLoginPage extends BasePage {

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//a[contains(text(),'John Smith')]")
    private WebElement loginVerificationElement;

    public WebElement getLoginVerificationElement() {
        waitForElementToBeVisible(loginVerificationElement);
        return loginVerificationElement;
    }

    public AdminAreaLoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminAreaLoginPage email(String email) {
        emailField.clear();
        click(emailField);
        emailField.sendKeys(email);
        return this;
    }

    public AdminAreaLoginPage password(String password) {
        click(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
        return this;
    }

    public void demonstrateLogin(String emailtxt, String passwordtxt) {
        email(emailtxt);
        password(passwordtxt);
    }
}
