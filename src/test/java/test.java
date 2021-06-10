;
 import Selenium.Basket;
        import Selenium.LoginPage;
        import Selenium.Product;
        import Selenium.homePage;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class test {


    WebDriver driver;
//ilk yapılacak işlemler
    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\feyza\\Desktop\\selenium\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }
//test haline getimek için @test ekle
    @Test
    public void start() {
        homePage gittigidiyor = new homePage(driver);
        /* ana sayfamız gitti diyor driver yoluyla siteye baglantı kur */
        gittigidiyor.connect();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/");
       //ana sayfanın açıldıgı kontrol edilir
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("********");
        loginPage.setPass("*********");
        loginPage.loginGittiGidiyor();
        //kullanıcının ismi ile login işlemi yapılabiliyormu konrol edilir
        Assert.assertEquals(loginPage.loginControl(),"*******");
       //aranacak ürün bilgisayar ve o girilir
        Product product = new Product(driver);
        product.setSearchWord("bilgisayar");
        product.sendAndClickSearch();
     //ürünlerden 2.sayfaya gidilir çünkü öyle isteniyor
        product.secondPage();
       //assert.assertequal kullanarak 2. sayfaya girmiş mi kontrol edilir
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        //favorilerime tıklanır
        product.setSearchWord("favorilerim");
        product.sendAndClickSearch();

        //sonuça göre rastgele sepetten bir ürün seçilir
        product.productSelect();

        Basket basket = new Basket(driver);
        //sepete ekleme
        basket.addBasked();
        //sepete gitme
        basket.goToBasked();


       //ürünü sepetten sil boş mu kontrole et.
        basket.baskedProductRemove();
        Assert.assertEquals(basket.productRemoveControl(),"Sepetiniz Boş");

        System.out.println("Successful");
    }
}
