package Iakov.volf;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.fail;

public class WriteUsTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Test
    public void testWriteUs() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("span.js-auth-feedback.h-dashed-link")).click();

        driver.findElement(By.id("l-auth-name")).sendKeys("Slava");

        driver.findElement(By.id("l-auth-email")).sendKeys("miroxa1979@mail.ru");
        driver.findElement(By.id("l-auth-message")).clear();
        driver.findElement(By.id("l-auth-message")).sendKeys("Test");
        driver.findElement(By.xpath("//*[contains(text(),'Написать')]")).click();
        driver.findElement(By.cssSelector("div.reveal-modal-bg")).click();
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
