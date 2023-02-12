package techproed.tests.day21;

import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class OpenSourceLogin {
    @Test
    public void openSourceLogin() throws InterruptedException {
//        1. sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

//        2. page objesi olustur
        OpenSourcePage openSourcePage = new OpenSourcePage();

//        3. bu objesi kullanarak o classdaki objelere ulas
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submitButton.click();

//        4. asserion
        OpenSourceDashboardPage openSourceDashboardPage = new OpenSourceDashboardPage();
        assert openSourceDashboardPage.dashboardHeader.isDisplayed();

//        5. close driver
        Driver.closeDriver();

    }
}
