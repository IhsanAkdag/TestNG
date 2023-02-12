package techproed.tests.day20;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class SoftAssertion {
    @Test
    public void softAssertTest(){
//        1. SoftAssert objesi olustur
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Satir 14");
        softAssert.assertEquals(2,5);//FAIL
        System.out.println("Satir 16");
        softAssert.assertTrue("JAVA".contains("U"));//FAIL
        System.out.println("Satir 18");
        softAssert.assertTrue(true);//PASS
        System.out.println("Satir 20");
        softAssert.assertAll();//PASS yada FAIL olarak assertion lari isaretler
    }
}