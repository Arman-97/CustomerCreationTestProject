package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerRegistrationPage extends BasePage {
    @FindBy(id = "Password")
    private WebElement passField;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Gender_Male")
    private WebElement maleGenderRadio;

    @FindBy(xpath = "//span[@aria-controls='DateOfBirth_dateview']")
    private WebElement dateField;

    @FindBy(name = "Company")
    private WebElement companyField;

    @FindBy(xpath = "//input[@aria-labelledby='SelectedNewsletterSubscriptionStoreIds_label']")
    private WebElement newsLetterField;

    @FindBy(xpath = "//li[contains(text(),'Test store 2')]")
    private WebElement dropDownField;

    @FindBy(xpath = "//input[@aria-labelledby='SelectedCustomerRoleIds_label']")
    private WebElement rolesField;

    @FindBy(xpath = "//li[contains(text(),'Administrator')]")
    private WebElement adminRole;

    @FindBy(xpath = "//textarea[@name='AdminComment']")
    private WebElement commentField;

    @FindBy(name = "save")
    private WebElement saveButton;

    public WebElement getSuccessfulCreationMessage() {
        return successfulCreationMessage;
    }

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    private WebElement successfulCreationMessage;


    public NewCustomerRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public NewCustomerRegistrationPage setPassword(String pswd) {
        waitForPageToLoad();
        click(passField);
        passField.sendKeys(pswd);
        return this;
    }

    public NewCustomerRegistrationPage setFirstAndLastNames(String firstName, String lastName) {
        click(firstNameField);
        firstNameField.sendKeys(firstName);
        click(lastNameField);
        lastNameField.sendKeys(lastName);
        return this;
    }

    public NewCustomerRegistrationPage setMaleGender() {
        click(maleGenderRadio);
        return this;
    }

    public NewCustomerRegistrationPage setDateOfBirth() {
        click(dateField);
        click(driver.findElement(By.xpath("//a[@data-value='2022/1/1']")));
        return this;
    }

    public NewCustomerRegistrationPage setCompany(String companyName) {
        click(companyField);
        companyField.sendKeys(companyName);
        return this;
    }

    public NewCustomerRegistrationPage setNewsLetter() {
        click(newsLetterField);
        click(dropDownField);
        return this;
    }

    public NewCustomerRegistrationPage setRoleAsAdmin() {
        driver.findElement(By.xpath("//span[@title='delete']")).click();
        click(rolesField);
        click(adminRole);
        return this;
    }

    public NewCustomerRegistrationPage adminComment(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        click(commentField);
        commentField.sendKeys(text);
        js.executeScript("window.scrollBy(0,-350)");
        return this;
    }

    public NewCustomerRegistrationPage newCustomerAddingProcess() {
        forceWait(1000);
        highlightElement(saveButton);
        saveButton.click();
        return this;
    }
}
