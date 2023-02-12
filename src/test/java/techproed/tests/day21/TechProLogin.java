package techproed.tests.day21;

import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TechProLogin {
    @Test(groups = "regression-tests")
    public void loginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("techpro_url"));

        TechproLoginPage techproLoginPage = new TechproLoginPage();
        techproLoginPage.userName.sendKeys(ConfigReader.getProperty("techpro_user_name"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_user_password"));
        techproLoginPage.submitButton.click();

        TechproHomePage techproHomePage = new TechproHomePage();
        assert techproHomePage.alert.isDisplayed();
        techproHomePage.logout.click();

        assert techproLoginPage.loginPageHead.isDisplayed();
    }
}
