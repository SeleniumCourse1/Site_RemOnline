package Iakov.volf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by Iakov Volf on 2/19/2015.
 */
public class LoginPage extends Page {


    @FindBy(id = "l-auth-login")
    WebElement loginUsernameField;
    @FindBy(id = "l-auth-pass")
    WebElement loginPasswordField;
    @FindBy(xpath = "//div[3]/button")
    WebElement loginButton;
    @FindBy(xpath = "//*[@class='js-auth-signin b-navbar__exit h-ml-10']")
    WebElement goToLoginButton;

    public LoginPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "dev.remonline.ru";
        //this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void openLoginPage() {
        driver.get(PAGE_URL);
        clickElement(goToLoginButton);
    }

    public void fillTheFields(String userName, String pass) {
        loginUsernameField.sendKeys(userName);
        loginPasswordField.sendKeys(pass);
    }

    public void login() throws Exception {
        openLoginPage();
        waitUntilElementIsLoaded(loginButton);
        fillTheFields("Mary", "123456");
        clickToLogin();
    }

    public void loginWithoutPass() throws Exception {
        openLoginPage();
        waitUntilElementIsLoaded(loginButton);
        fillTheFields("Mary", "");
        clickToLogin();
    }

    public void clickToLogin() {
        clickElement(loginButton);
    }


    public boolean exists(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }


    public boolean isLoggedIn(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public boolean isNotLoggedIn() {
        return verifyElementIsPresent(loginButton);
    }

    public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement(WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }
}
