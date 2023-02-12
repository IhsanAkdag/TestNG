package techproed.tests.day25_paralleltesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import techproed.utilities.ReusableMethods;
import java.time.Duration;
public class SearchItems {
    @Test
    public void googleSearch(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.google.com");
        ReusableMethods.waitFor(2);
        System.out.println("Google Title : "+driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
        driver.quit();
    }
    @Test
    public void ebaySearch(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.ebay.com");
        ReusableMethods.waitFor(2);
        System.out.println("Resort line Title : "+driver.getTitle());
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("porcelain teapot"+Keys.ENTER);
        driver.quit();
    }
    @Test
    public void amazonSearch(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.amazon.com");
        ReusableMethods.waitFor(2);
        System.out.println("Amazon Title : "+driver.getTitle());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot"+ Keys.ENTER);
        driver.quit();
    }
}