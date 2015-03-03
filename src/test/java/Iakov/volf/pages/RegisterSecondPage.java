package Iakov.volf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lena on 03/03/2015.
 */
public class RegisterSecondPage extends Page {
    //WebElement firstRegPageHeader;
    @FindBy(id = "l-auth-name")
    WebElement firstName;
    @FindBy(id = "l-auth-lname")
    WebElement lastName;
    @FindBy(id = "l-auth-company")
    WebElement companyName;
    @FindBy(id = "js-auth-country")
    WebElement coutry;
    @FindBy(id = "l-auth-city")
    WebElement city;
    @FindBy(id = "l-auth-phone")
    WebElement phone;
    @FindBy(xpath = "//div[5]/button")
    WebElement submitRegisterButton;

    public RegisterSecondPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this); 
    }
    
    
}
