package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends BasePage {
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']//li[@class='nav-item has-treeview'][3]")
    private WebElement customersButton;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p")
    private WebElement customerBtn;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement newButton;

    @FindBy(xpath = "//h1[@class='float-left']")
    private WebElement CustomerVerificationElement;

    public WebElement getCustomerVerificationElement() {
        return CustomerVerificationElement;
    }

    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    public CustomersPage navigateToNewCustomerCreationField() {
        forceWait(4000);
        click(customersButton);
        click(customerBtn);
        waitForElementToBeClickable(newButton);
        highlightElement(newButton);
        forceWait(1000);
        newButton.click();
        return this;
    }
}
