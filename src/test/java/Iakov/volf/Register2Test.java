package Iakov.volf;

/**
 * Created by Iakov Volf on 1/27/2015.
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Register2Test extends TestNgTestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testReg1() throws Exception {
        driver.get(baseUrl + "/");
        clickButoonReg();
        addDataToRegFields("volf2g47672@gmail.com", "hVolf766", "123987666");
        clickButtonEnter();
        try {
            assertEquals("Моя мастерская", driver.findElement(By.xpath("//span[@class = \"b-navigation-control__item h-mt-3 h-branch-1\"]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//span[@class =\"text-label\"]")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//li[5]/span")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
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
