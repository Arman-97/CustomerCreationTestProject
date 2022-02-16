package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Objects;

public class GetRandomGeneratedMail extends BasePage {
    @FindBy(id = "number")
     private WebElement generatedMailCount;

    @FindBy(id = "btnGet")
    private WebElement getBTN;

    @FindBy(xpath = "//div[@class='card-body']")
    private WebElement randomGeneratedMailField;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement mailField;

    private String randomGeneratedMail;



    public GetRandomGeneratedMail(WebDriver driver) {
        super(driver);
    }

    public String getRandomGeneratedMail(){
        return randomGeneratedMail;
    }

    public String getMailFieldValue (){
        waitForElementToBeVisible(mailField);
        return mailField.getAttribute("value");
    }

    public WebElement getMailField() {
        waitForElementToBeVisible(mailField);
        return mailField;
    }

    public GetRandomGeneratedMail getRandomEmail() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://randommer.io/random-email-address");
        waitForPageToLoad();
        click(generatedMailCount);
        generatedMailCount.clear();
        generatedMailCount.sendKeys("1");
        click(getBTN);
        randomGeneratedMail = randomGeneratedMailField.getText();
        System.out.println(randomGeneratedMail);
        return this;
    }


    public GetRandomGeneratedMail setGeneratedEmail(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        click(mailField);
        mailField.sendKeys(randomGeneratedMail);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetRandomGeneratedMail that = (GetRandomGeneratedMail) o;
        return Objects.equals(generatedMailCount, that.generatedMailCount) && Objects.equals(getBTN, that.getBTN) && Objects.equals(randomGeneratedMailField, that.randomGeneratedMailField) && Objects.equals(mailField, that.mailField) && Objects.equals(randomGeneratedMail, that.randomGeneratedMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generatedMailCount, getBTN, randomGeneratedMailField, mailField, randomGeneratedMail);
    }
}
