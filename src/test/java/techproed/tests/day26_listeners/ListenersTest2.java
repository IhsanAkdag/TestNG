package techproed.tests.day26_listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import techproed.utilities.Driver;

public class ListenersTest2 {
    @Test
    public void test01() {
        System.out.println("PASS");
        Assert.assertTrue(true);
    }

    @Test
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

    @Test
    public void test04() {
        System.out.println("Exception");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));
    }
}
