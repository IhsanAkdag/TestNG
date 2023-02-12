package techproed.tests.day26_listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest3 {

    public void test01() {
        System.out.println("PASS");
        Assert.assertTrue(true);
    }
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test02() {
        System.out.println("FAIL");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));
    }

    @Test
    public void test03() {
        System.out.println("SKIP");
        throw new SkipException("Methodu Atla");
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test04() {
        System.out.println("Exception");
        //throw new NoSuchElementException("NoSuchElementException");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));
    }
}
