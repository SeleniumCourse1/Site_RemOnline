package Iakov.volf;

/**
 * Created by Olga on 1/27/2015.
 */


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class OpportunityTest extends TestNgTestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testOpportunitiesRemOnline() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a[contains(text(),'Возможности')]")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@class='b-feature__title h-ta-c']"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertEquals("Возможности", driver.findElement(By.xpath("//*[@class='b-feature__title h-ta-c']")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    private boolean isElementPresent(By by) {
        return super.isElementPresent(by);
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