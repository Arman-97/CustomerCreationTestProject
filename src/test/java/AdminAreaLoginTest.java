import POM.AdminAreaLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AdminAreaLoginTest extends BaseTest {
    AdminAreaLoginPage loginPage = new AdminAreaLoginPage(driver);

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.demonstrateLogin("admin@yourstore.com", "admin");
        Thread.sleep(4000);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of the links on the page is: " + links.size());
//        links.forEach(link -> {
//            System.out.println(link.getText());
//        });

        long workingLinks = links.stream().filter(link -> link.getAttribute("href") != null).count();
        System.out.println("The working links are " + workingLinks);

        Assert.assertEquals(links.size(),workingLinks);

    }
}
