package Iakov.volf;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * Created by Lena on 22/01/2015.
 */
public class PriceTest extends TestNgTestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();



    @Test
    public void testPrice() throws Exception {
        openMainPage();
        clickToPrice();
        selectCurrencyUAH();
        selectCurrencyRUB();
        driver.findElement(By.xpath("//button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5); // wait for a maximum of 5 seconds
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.b-modal > h2.h-ta-c")));

        try {
            assertEquals("Регистрация компании", driver.findElement(By.cssSelector("div.b-modal > h2.h-ta-c")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("div.reveal-modal-bg")).click();
    }

    private void selectCurrencyRUB() {
        driver.findElement(By.xpath("//li[@data-currency=\"RUB\"]")).click();
    }

    private void selectCurrencyUAH() {
        driver.findElement(By.xpath("//li[@data-currency=\"UAH\"]")).click();
    }

    protected void clickToPrice() {
        driver.findElement(By.linkText("Стоимость")).click();
    }

}

