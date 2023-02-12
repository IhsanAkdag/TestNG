package techproed.tests.day22_smoketests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class PositiveLoginTest {
//  •Name: US100201_Admin_Login
//	•Description:
//      •Admin bilgileriyle giriş
//	•Acceptance Criteria:
//      •Admin olarak, uygulamaya giriş yapabilmeliyim
//	    •https://www.bluerentalcars.com/
//      •Admin email: jack@gmail.com
//	    •Admin password: 12345

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test
    public void US100201_Admin_Login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        Reporter.log("URL ye gidildi");
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        Reporter.log("LOGIN butonuna tiklandi");
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin_password"));
        blueRentalLoginPage.loginButton.click();
        assert blueRentalHomePage.userID.isDisplayed();
        Driver.closeDriver();
    }
}
