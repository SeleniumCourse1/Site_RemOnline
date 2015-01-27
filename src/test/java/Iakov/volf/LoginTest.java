package Iakov.volf;

/**
 * Created by yura on 1/27/2015.
 */


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends TestNgTestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testLogin() throws Exception {    driver.findElement(By.xpath("//*[@class=\"b-navbar__entrance h-ml-15\"]")).click();
        driver.findElement(By.id("l-auth-login")).clear();
        driver.findElement(By.id("l-auth-login")).sendKeys("wolf1212@gmail.com");
        driver.findElement(By.id("l-auth-pass")).clear();
        driver.findElement(By.id("l-auth-pass")).sendKeys("123456");
        driver.findElement(By.xpath("//div[3]/button")).click();
        driver.findElement(By.xpath("//div[3]/button")).click();
        driver.findElement(By.cssSelector("div.b-wrapper__content")).click();
        try {
            assertEquals("Перетащите сюда колонку для группировки данных", driver.findElement(By.cssSelector("div.k-grouping-header")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
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