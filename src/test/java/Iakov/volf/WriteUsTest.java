package Iakov.volf;
/**
 * Created by Slava on 1/27/2015.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class WriteUsTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://dev.remonline.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testWriteUs1() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("span.js-auth-feedback.h-dashed-link")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector("div.b-modal > h2.h-ta-c"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        fillTheFields("Miroslav", "miroxa1979@gmail.com", "Test1");
        submitText();
        clickOnPage();
    }

    private void clickOnPage() {
        driver.findElement(By.cssSelector("div.reveal-modal-bg")).click();
    }

    private void submitText() {
        driver.findElement(By.xpath("//div[4]/button")).click();
    }

    private void fillTheFields(String name, String mail, String text) {
        driver.findElement(By.id("l-auth-name")).click();
        driver.findElement(By.id("l-auth-name")).clear();
        driver.findElement(By.id("l-auth-name")).sendKeys(name);
        driver.findElement(By.id("l-auth-email")).clear();
        driver.findElement(By.id("l-auth-email")).sendKeys(mail);
        driver.findElement(By.id("l-auth-message")).clear();
        driver.findElement(By.id("l-auth-message")).sendKeys(text);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
