package techproed.tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Driver_Config_Test {

    @Test
    public void firstTest(){
//        amazon a git
//       driver -> Driver.getDriver()
//        ConfigReader.getProperty("amazon_url") -> https://www.amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url")); // driver.get("https://www.amazon.com")
//        title in Amazon icerdigini test et
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

//        close driver
        Driver.closeDriver();
    }

}