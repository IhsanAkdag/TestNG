package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
//    page objelerini bu sinifta buluruz

//    1.contructor (herbir page sinifi cons. ile baslamak zorunda
    public OpenSourcePage(){
//        PageFactory seleniumdan gelen ve bu sayfa elementlerini (baslangic degeri vermek) intantiate etmek icin kullanilir
//        Sayfa objeleri cagrildiginda null pointer exc alinmaz
        PageFactory.initElements(Driver.getDriver(),this);
    }


//    Page objelerini olustur
    @FindBy(name = "username") public WebElement username;
    @FindBy(xpath = "//input[@name='password']") public WebElement password;
    @FindBy(xpath = "//button[@type='submit']") public WebElement submitButton;



}
