package Iakov.volf;


import Iakov.volf.pages.HeaderPage;
import Iakov.volf.pages.RegisterFirstPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Iakov
 */

public class RegisterTest extends TestNgTestBase {
    public StringBuffer verificationErrors = new StringBuffer();
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    HeaderPage headerPage;
    RegisterFirstPage registerFirstPage;
   //RegisterSecondPage registerSecondPage

    @BeforeClass(alwaysRun = true)
    public void setup() {
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        headerPage.openRegistrationFirstPage();
        //registerSecondPage = PageFactory.initElements(driver, RegisterSecondPage.class);
       
    }
    @Test
    public void RegisterFirstFormTest() throws Exception {
        try {
            registerFirstPage.onRegisterPage();
           // registerSecondPage.onRegisterSecondPage();


        } catch (Exception e) {
            e.printStackTrace();
        }
//        public void registerFirstFormTest() {
//            try {
//                registerFirstPage.
//                assertTrue(isElementPresent(By.xpath("//*[@class=\"js-auth-signin b-navbar__exit h-ml-10\"]")));
//            } catch (Error e) {
//                verificationErrors.append(e.toString());
//            }
//        }
      
       //what's this?
//        driver.findElement(By.xpath("//div[6]/button")).click();
//        try {
//            assertTrue(isElementPresent(By.xpath("//a/span")));
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }
   
    
    fillSecondRegisterForm("Mary", "Popinse", "SelfEmployed", "London");
        //todo add clickbutton method
    }

    private void fillSecondRegisterForm(String firstName, String lastName, String companyName, String city) throws InterruptedException {
        //firstName
        driver.findElement(By.id("l-auth-name")).click();
        driver.findElement(By.id("l-auth-name")).clear();
        driver.findElement(By.id("l-auth-name")).sendKeys(firstName);
        //lastName
        driver.findElement(By.id("l-auth-lname")).click();
        driver.findElement(By.id("l-auth-lname")).clear();
        driver.findElement(By.id("l-auth-lname")).sendKeys(lastName);
        //companyName
        driver.findElement(By.id("l-auth-company")).click();
        driver.findElement(By.id("l-auth-company")).clear();
        driver.findElement(By.id("l-auth-company")).sendKeys(companyName);
        //selectCountry
        driver.findElement(By.id("js-auth-country")).click();
        //driver.findElement(By.xpath("//li[@class='clearfix b-dropdown__item'][index]"));
        selectCountryByIndex(3);
        
        
        //city
        driver.findElement(By.id("l-auth-city")).click();
        driver.findElement(By.id("l-auth-city")).clear();
        driver.findElement(By.id("l-auth-city")).sendKeys(city);
        
        //telephone
        driver.findElement(By.id("l-auth-phone")).click();
    }

    private void selectCountryByIndex(int index) {
        driver.findElement(By.xpath("//li[@class='clearfix b-dropdown__item']["+(index + 1) + " ]")).click();

        }



    private void clickOnRegisterButton() throws InterruptedException {
        driver.findElement(By.xpath("//li[4]//span[@class='js-auth-signup b-navbar__entrance h-ml-15']")).click();
             for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//body/div[4]"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
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

