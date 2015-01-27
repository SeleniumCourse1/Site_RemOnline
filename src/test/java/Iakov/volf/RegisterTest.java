package Iakov.volf;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Iakov
 */

public class RegisterTest extends TestNgTestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testUntitled() throws Exception {
        try {
            assertTrue(isElementPresent(By.xpath("//*[@class=\"js-auth-signin b-navbar__exit h-ml-10\"]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//*[text()[contains(.,'Регистрация')]]")).click();
        driver.findElement(By.id("l-auth-email")).clear();
        driver.findElement(By.id("l-auth-email")).sendKeys("wolf1212@gmail.com");
        driver.findElement(By.id("l-auth-login")).clear();
        driver.findElement(By.id("l-auth-login")).sendKeys("Mary");
        driver.findElement(By.id("l-auth-pass")).clear();
        driver.findElement(By.id("l-auth-pass")).sendKeys("123456");
        driver.findElement(By.xpath("//*[text()[contains(.,'Начать 14-дневный пробный период')]]")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//body/div[4]"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("l-auth-name")).click();
        driver.findElement(By.id("l-auth-name")).clear();
        driver.findElement(By.id("l-auth-name")).sendKeys("Mary");
        driver.findElement(By.id("l-auth-lname")).click();
        driver.findElement(By.id("l-auth-lname")).click();
        driver.findElement(By.id("l-auth-lname")).clear();
        driver.findElement(By.id("l-auth-lname")).sendKeys("Popinse");
        driver.findElement(By.id("l-auth-company")).click();
        driver.findElement(By.id("l-auth-company")).click();
        driver.findElement(By.id("l-auth-company")).clear();
        driver.findElement(By.id("l-auth-company")).sendKeys("SelfEmployed");
        driver.findElement(By.id("js-auth-country")).click();
        driver.findElement(By.id("l-auth-city")).click();
        driver.findElement(By.id("l-auth-city")).clear();
        driver.findElement(By.id("l-auth-city")).sendKeys("London");
        driver.findElement(By.id("l-auth-phone")).click();
        driver.findElement(By.id("l-auth-city")).click();
        driver.findElement(By.id("l-auth-city")).click();
        driver.findElement(By.xpath("//div[6]/button")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//a/span")));
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
