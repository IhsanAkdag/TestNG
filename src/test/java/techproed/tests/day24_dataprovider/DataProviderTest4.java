package techproed.tests.day24_dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class DataProviderTest4 {
    // bu ornekde , data provider metodumuz Util classdan gelecek

    //  musteriVerileri
    @Test(dataProvider = "musteriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTest(String username , String password , String sube) {
        System.out.println("username : "+username+ "   |   password : " + password + "   |   sube : " + sube);
    }

    @Test(dataProvider = "musteriHizmetleriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriHizmetleriVerileriTest(String username , String password) {
        System.out.println("username : "+username+ "   |   password : " + password);
    }

    @Test(dataProvider = "personelVerileri",dataProviderClass = DataProviderUtils.class)
    public void personelVerileriTest(String username , String password) {
        System.out.println("username : "+username+ "   |   password : " + password);
    }

    @Test(dataProvider = "kullaniciVerileri",dataProviderClass = DataProviderUtils.class)
    public void kullaniciVerileriTest(String username , String password) {
        System.out.println("-----Excelden gelen veriler-------");
        System.out.println("username : "+username+ "   |   password : " + password);
    }
}
