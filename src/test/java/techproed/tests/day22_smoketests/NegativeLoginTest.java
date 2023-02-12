package techproed.tests.day22_smoketests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.time.Duration;

public class NegativeLoginTest {
//    Name:
//      •US100208_Negative_Login
//	  Description:
//       •Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
//	  Acceptance Criteria
//       •Customer email: fake@bluerentalcars.com
//	      •Customer password: fakepass
//       •Error: User with email fake@bluerentalcars.com not found
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test
    public void US100208_Negative_Login() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("fake_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("fake_password"));
        blueRentalLoginPage.loginButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(blueRentalLoginPage.alert));

        Assert.assertEquals(blueRentalLoginPage.alert.getText(),"User with email fake@bluerentalcars.com not found");


    }
}
