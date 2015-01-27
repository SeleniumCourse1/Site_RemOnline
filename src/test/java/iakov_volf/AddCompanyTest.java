package iakov_volf;

/**
 * Created by yura on 1/27/2015.
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class AddCompanyTest extends TestNgTestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testRemoteOnline() throws Exception {    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=b-button b-button_type_cta b-button_color_lgreen js-auth-signup h-mt-35]]
        driver.findElement(By.id("l-auth-email")).clear();
        driver.findElement(By.id("l-auth-email")).sendKeys("yurashvartz@gmail.com");
        driver.findElement(By.id("l-auth-login")).clear();
        driver.findElement(By.id("l-auth-login")).sendKeys("vuz");
        driver.findElement(By.id("l-auth-pass")).clear();
        driver.findElement(By.id("l-auth-pass")).sendKeys("yura1979");
        driver.findElement(By.xpath("//div[5]/button")).click();
        driver.findElement(By.id("l-auth-name")).clear();
        driver.findElement(By.id("l-auth-name")).sendKeys("arbuzan");
        driver.findElement(By.id("l-auth-lname")).clear();
        driver.findElement(By.id("l-auth-lname")).sendKeys("gost");
        driver.findElement(By.id("l-auth-company")).clear();
        driver.findElement(By.id("l-auth-company")).sendKeys("lulka");
        driver.findElement(By.id("l-auth-city")).clear();
        driver.findElement(By.id("l-auth-city")).sendKeys("baku");
        driver.findElement(By.id("l-auth-phone")).click();
        driver.findElement(By.xpath("//div[6]/button")).click();
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