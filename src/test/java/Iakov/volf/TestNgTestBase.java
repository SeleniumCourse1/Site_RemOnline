package Iakov.volf;

import Iakov.volf.util.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected WebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
        capabilities = PropertyLoader.loadCapabilities();
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }

    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissAll();
    }


    public void login() throws Exception {
        openPage();
        clickToLogin();
        fillTheFields("Mary", "123456");
        pressToSubmitButton();
        clickToPage();
    }

    protected void verifyText(String text) {
        try {
            assertEquals(text, driver.findElement(By.cssSelector("div.k-grouping-header")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    protected void clickToPage() {
        driver.findElement(By.cssSelector("div.b-wrapper__content")).click();
    }

    protected void pressToSubmitButton() {
        driver.findElement(By.xpath("//div[3]/button")).click();
    }

    protected void fillTheFields(String UserName, String pass) {
        driver.findElement(By.id("l-auth-login")).sendKeys(UserName);
        driver.findElement(By.id("l-auth-pass")).sendKeys(pass);
    }

    protected void clickToLogin() {
        driver.findElement(By.xpath("//*[@class='js-auth-signin b-navbar__exit h-ml-10']")).click();
    }

    protected void openPage() {
        driver.get(baseUrl);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void addDataToRegFields(String Email, String login, String pass) {
        driver.findElement(By.id("l-auth-email")).sendKeys(Email);
        driver.findElement(By.id("l-auth-login")).sendKeys(login);
        driver.findElement(By.id("l-auth-pass")).sendKeys(pass);
    }

    protected void clickButoonReg() {
        driver.findElement(By.xpath("//span")).click();
    }
}
