import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class HomePage extends BasePage{
    Log log=new Log();
    public HomePage(WebDriver driver){
        super(driver);
    }

    By searchBoxBy=new By.ByCssSelector("input.default-input");
    By accountButtonBy= By.cssSelector("a[title='Hesabım']");
    By myFavButtonBy= By.cssSelector("a[title='Favorilerim']");
    By cartButtonButtonBy= By.cssSelector("a[title='Sepetim']");
    By cookiesButton=By.id("onetrust-accept-btn-handler");


    public void control_of_pages(){

        Assert.assertTrue(driver.findElement(accountButtonBy).isEnabled());
        log.info("My Account Checked");
        Assert.assertTrue(driver.findElement(myFavButtonBy).isEnabled());
        log.info("My Favorites Checked");
        Assert.assertTrue(driver.findElement(cartButtonButtonBy).isEnabled());
         log.info("My Cart Checked");

        //Cookies butonu kabul edildi ve kapatıldı
        driver.findElement(cookiesButton).click();

    }

     //SearcBoxta aranacak kelime gönderildi
    public void searchProduct(String productName){
        sendKeys(searchBoxBy, productName);

    }
}
