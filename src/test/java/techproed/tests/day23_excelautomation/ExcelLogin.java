package techproed.tests.day23_excelautomation;

import org.testng.annotations.AfterMethod;
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

public class ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    //    Bu metot login sayfasina gitmek icin kullanililacak
    public void login(){
//        Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        home page logine tikla
        blueRentalHomePage= new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

//        ------SADECE ILK GIRIS---------
//        loginLink butonu sadece ilk girisde sayfada gorunur
//        ikinci ve ucunci girislerde sayfada gorunmeyeceginden NOSUCHELEMENTEXCEPTION alinir
//        Biz bu exception u try catch kullanarak yakalariz ve test cases calismaya devam eder
        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
//        LOGIN SAYFASINDAYIZ
        }catch (Exception e){
        }

//      -------------SONRAKI GIRISLER------
        try{
//            kullanici ID ye tikla      --->>> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
//            Logout linkine tikla       --->>> try catch
            blueRentalHomePage.logoutButton.click();
            ReusableMethods.waitFor(1);
//            OK e tikla                --->>> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
//            home page logine tikla    --->>> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
//        LOGIN SAYFASINDAYIZ
        }catch (Exception e){

        }
    }

    @Test
    public void customerLogin() throws IOException {
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
//        ./ ONCEKI TUM DOSYALARI ICER. RELATIVE PATH.
        String sayfa = "customer_info";
//        DATALARI EXCEL UTILS METOTLARINI KULLANARAK BURAYA ALACAZ
        excelUtils = new ExcelUtils(path,sayfa);
//        excel datalarini getDataList metotu ile cekelim
        excelDatalari = excelUtils.getDataList();
//        LOOP KULLANARAK DATALARI TEK TEK TEST CASEDE KULLNA
        for (Map<String,String> data : excelDatalari){
            login();//Her Loopda Login Sayfasina Goturecek
//            kullanici adini gir
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
//            kullanici sifresini gir
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
//            ligin buttonuna tikla
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            giris isleminin basarili oldugunu gostermek icin assertion
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethods.waitFor(1);
//            Her bir girisden sonra ekran goruntusu aldik
            ReusableMethods.getScreenshot("EkranGoruntusu");
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
