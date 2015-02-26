package Iakov.volf;

import Iakov.volf.pages.PricePage;
import Iakov.volf.pages.RegisterFirstPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


/**
 * Created by Lena on 22/01/2015.
 */
public class PriceTest extends TestNgTestBase {
    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    PricePage pricePage;
    RegisterFirstPage registerFirstPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        pricePage = PageFactory.initElements(driver, PricePage.class);
        registerFirstPage = PageFactory.initElements(driver, RegisterFirstPage.class);
    }

    @Test
    public void TestLoginSuccess() {
        try {
            pricePage.testPrice();
            registerFirstPage.onRegisterPage();


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

