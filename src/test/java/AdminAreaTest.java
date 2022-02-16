
import POM.AdminAreaLoginPage;
import POM.GetRandomGeneratedMail;
import POM.CustomersPage;
import POM.NewCustomerRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class AdminAreaTest extends BaseTest {
    AdminAreaLoginPage loginPage = new AdminAreaLoginPage(driver);
    CustomersPage customersPage = new CustomersPage(driver);
    GetRandomGeneratedMail randomGeneratedMail = new GetRandomGeneratedMail(driver);
    NewCustomerRegistrationPage newCustomerRegistrationPage = new NewCustomerRegistrationPage(driver);


    @Test(description = "Demonstrate login")
    public void login() {
        loginPage.email("admin@yourstore.com")
                .password("admin");
        Assert.assertTrue(loginPage.getLoginVerificationElement().isDisplayed());
    }


    @Test(description = "Adding new customer", priority = 1)
    public void addNewCustomer() {
        loginPage.demonstrateLogin("admin@yourstore.com", "admin");
        Assert.assertTrue(loginPage.getLoginVerificationElement().isDisplayed());

        customersPage.navigateToNewCustomerCreationField();
        customersPage.waitForPageToLoad();
        Assert.assertTrue(customersPage.getCustomerVerificationElement().isDisplayed());

        randomGeneratedMail.getRandomEmail()
                .setGeneratedEmail();

        Assert.assertTrue(randomGeneratedMail.getRandomGeneratedMail()
                .equals(randomGeneratedMail.getMailFieldValue()));

        newCustomerRegistrationPage.setPassword("ultimateQA")
                .setFirstAndLastNames("Cyclops", "Maximov")
                .setMaleGender()
                .setDateOfBirth()
                .setCompany("Freelancer")
                .setNewsLetter()
                .setRoleAsAdmin()
                .adminComment("-What's up man, -Yshty ap")
                .newCustomerAddingProcess();

        Assert.assertTrue(newCustomerRegistrationPage
                .getSuccessfulCreationMessage()
                .isDisplayed());

    }
}
