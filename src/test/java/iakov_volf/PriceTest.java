package iakov_volf;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


/**
 * Created by Lena on 22/01/2015.
 */
public class PriceTest extends TestNgTestBase {
    public class Untitled {

        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "http://dev.remonline.ru/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testUntitled() throws Exception {
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
}
