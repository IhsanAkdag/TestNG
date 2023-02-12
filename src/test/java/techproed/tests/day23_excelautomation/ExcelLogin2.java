package techproed.tests.day23_excelautomation;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public class ExcelLogin2 {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    //    Bu metot login sayfasina gitmek icin kullanililacak
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;
    @Test
    public void customerLogin() throws IOException {
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        excelUtils=new ExcelUtils(path,sayfa);
        excelDatalari=excelUtils.getDataList();

//        home page logine tikla
        for (Map<String,String> data:excelDatalari) {
            // Sayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));//HOME SAYFASINA
            blueRentalHomePage= new BlueRentalHomePage();
            blueRentalLoginPage = new BlueRentalLoginPage();

            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();

            // GIRIS YAPILDI
            ReusableMethods.waitFor(1);
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);//ASSERTION
            ReusableMethods.waitFor(1);
            ReusableMethods.getScreenshot("EkranGoruntusu");
            ReusableMethods.waitFor(1);
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.logoutButton.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.OK.click();
        }
        Driver.closeDriver();
    }
}