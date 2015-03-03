package Iakov.volf;

/**
 * Created by yura on 1/27/2015.
 */


import Iakov.volf.pages.LoginPage;
import Iakov.volf.pages.OrdersPage;
import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestNgTestBase {
    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    LoginPage loginPage;
    OrdersPage ordersPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        ordersPage = PageFactory.initElements(driver, OrdersPage.class);
    }

    @Test
    public void TestLoginSuccess() {
        try {
            loginPage.login();
            ordersPage.onOrdersPage();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void TestLoginInsuccess() {
        try {
            loginPage.loginWithoutPass();
            Assert.assertTrue(loginPage.isNotLoggedIn());


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