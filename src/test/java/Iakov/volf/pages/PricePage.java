package Iakov.volf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Lena on 25/02/2015.
 */
public class PricePage extends Page {
    @FindBy(xpath = "//li[@data-currency=\"UAH\"]" )
    WebElement selectCurrencyUAH;
    @FindBy (xpath = "//li[@data-currency=\"RUB\"]")
    WebElement selectCurrencyRUB;
    @FindBy (xpath = "//button[@class='b-button b-button_type_cta b-button_color_blue js-auth-signup']")
    WebElement confirmFreeTrialButton;
    @FindBy (xpath = "//div[1]/p[@data-currency='UAH']")
    WebElement displayedCurrencyUAH;
    @FindBy (xpath = "//div[1]/p[@data-currency='RUB']")
    WebElement displayedCurrencyRUB;
    
    public PricePage(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);
    }

// Elements on the page
    public void testPrice() throws Exception {
        clickToPrice();
        selectCurrencyUAH();
        verifyText("грн", displayedCurrencyUAH);
        selectCurrencyRUB();
        verifyText("руб", displayedCurrencyRUB);
        confirmFreeTrialButton();
        
    }
    
    
    //__________________________________________________________________________________________________________

    public void clickToPrice() {
        driver.findElement(By.xpath("//li[2]//a[@class='b-navbar__item']")).click();
    }
    public void selectCurrencyRUB() {
        driver.findElement(By.xpath("//li[@data-currency=\"RUB\"]")).click();
    }
    public void selectCurrencyUAH() {
        driver.findElement(By.xpath("//li[@data-currency=\"UAH\"]")).click();
    }
    public void confirmFreeTrialButton() {driver.findElement(By.xpath("//button[@class='b-button b-button_type_cta b-button_color_blue js-auth-signup']")).click();
    }

    WebDriverWait wait = new WebDriverWait(driver, 5); // wait for a maximum of 5 seconds
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.b-modal > h2.h-ta-c")));
//
//        try {
//            assertEquals("Регистрация компании", driver.findElement(By.cssSelector("div.b-modal > h2.h-ta-c")).getText());
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }
//        driver.findElement(By.cssSelector("div.reveal-modal-bg")).click();
//    }
}
