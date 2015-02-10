package Iakov.volf;

import org.openqa.selenium.By;
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
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Стоимость")).click();
        driver.findElement(By.xpath("//li[@data-currency=\"UAH\"]")).click();
        driver.findElement(By.xpath("//li[@data-currency=\"RUB\"]")).click();
        driver.findElement(By.xpath("//button")).click();
        try {
            assertEquals("Регистрация компании", driver.findElement(By.cssSelector("div.b-modal > h2.h-ta-c")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("div.reveal-modal-bg")).click();
    }

}

