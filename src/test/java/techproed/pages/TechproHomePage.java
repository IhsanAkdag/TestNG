package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproHomePage {
    public TechproHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@role='alert']") public WebElement alert;
    @FindBy(xpath = "//*[text()=' Logout']") public WebElement logout;
}
