package techproed.tests.day25_paralleltesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class TechProEducationTest {
    @Test
    public void lmsPageNavigation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.linkText("LMS LOGIN")).click();
        boolean isDisplayed = driver.findElement(By.xpath("//span[.='Login/Register']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.quit();
    }
}