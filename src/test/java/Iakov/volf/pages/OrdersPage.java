package Iakov.volf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by Iakov Volf on 2/19/2015.
 */
public class OrdersPage extends Page {


    @FindBy(xpath = "//*[@id='container']/div/div[4]/div[1]")
    WebElement tableHeader;

    public OrdersPage(WebDriver driver) {

        super(driver);
        // this.PAGE_URL = "https://alphaex.insynctiveapps.com";
        //this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    public void onOrdersPage() {
        verifyText("Перетащите сюда колонку для группировки данных", tableHeader);
    }

    public boolean exists(WebElement element) {
        return super.exists(element);
    }

    public boolean isLoggedIn(WebElement loginButton) {
        return super.exists(loginButton);
    }

    public boolean isNotLoggedIn() {
        return driver.findElements(By.xpath("//span[@class='js-auth-signin b-navbar__exit h-ml-10']")).size() > 0;
    }

    public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
        super.waitUntilElementIsLoaded(element);
    }

    public void waitForElement(WebDriverWait wait, WebElement element) {
        super.waitForElement(wait, element);
    }
}
