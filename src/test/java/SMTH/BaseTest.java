package SMTH;

import driver.driver.DriverDecorator;
import driver.driver.DriverFactory;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    public static WebDriver driver = DriverFactory.createWebDriver("chrome");
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();


    @BeforeMethod
    @Description("Browser initialization")
    public void setup() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    @Description("Browser's tear down")
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public static synchronized WebDriver getDriver() {
        return driver;
    }

}
