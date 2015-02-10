package Iakov.volf;

/**
 * Created by yura on 1/27/2015.
 */


import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class LoginTest extends TestNgTestBase {
    protected boolean acceptNextAlert = true;

    @Test
    public void TestLoginSuccess() {
        try {
            login();


        } catch (Exception e) {
            e.printStackTrace();
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