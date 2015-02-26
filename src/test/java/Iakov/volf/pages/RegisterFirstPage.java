package Iakov.volf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lena on 26/02/2015.
 */
public class RegisterFirstPage extends Page {
    
    @FindBy(xpath = "//*[text()[contains(.,'Регистрация')]]")
    WebElement (firstRegPageHeader);
    




    public LoginPage(WebDriver driver) {

        super(driver);
        // this.PAGE_URL = "https://alphaex.insynctiveapps.com";
        //this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    
    
    
    public void onRegisterPage() {

    }
}
