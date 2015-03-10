package Iakov.volf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iakov Volf on 2/19/2015.
 */
public class HeaderPage extends Page {


    @FindBy(xpath = "//*[@class='b-navbar__logo pull-left']")
    WebElement homePageLink;
    @FindBy(xpath = "//*[@class='b-navbar__item'][@href='/pricing']")
    WebElement pricingLink;
    @FindBy(xpath = "//*[@class='b-navbar__item'][@href='/features']")
    WebElement opportunityLink;
    @FindBy(xpath = "//*[@class='b-navbar__item'][@href='/blog']")
    WebElement blogLink;
    @FindBy(xpath = "//*[@class='js-auth-signin b-navbar__exit h-ml-10']")
    WebElement goToLoginButton;
    @FindBy(xpath = "//li[4]//span[@class='js-auth-signup b-navbar__entrance h-ml-15']")
    WebElement goToRegistrationButton;

    public HeaderPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "dev.remonline.ru";
        //this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void openLoginPage() {
        loadPage();
        clickElement(goToLoginButton);
        LoginPage loginPage;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    public void openRegistrationFirstPage() {
        loadPage();
        clickElement(goToRegistrationButton);
        RegisterFirstPage registerFirstPage;
        registerFirstPage = PageFactory.initElements(driver, RegisterFirstPage.class);
    }


}
