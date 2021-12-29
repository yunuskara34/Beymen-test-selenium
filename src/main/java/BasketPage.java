import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;




public class BasketPage extends BasePage{

    Log log=new Log();


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    By actualProductPrice = By.className("m-productPrice__salePrice");
    By quantitySelects = By.id("quantitySelect0");
    By messageTitle=By.cssSelector("strong[class='m-empty__messageTitle']");
    String basketMessageText="SEPETINIZDE ÜRÜN BULUNMAMAKTADIR";


   //Ürünün fiyat karşılastırması
    public void assertBasketPrice(String expectedPrice) throws InterruptedException {
        String actualPrice = findTo(actualProductPrice).getText();
        Assertions.assertEquals(expectedPrice, actualPrice);
        log.info("Price comparison made");
        Thread.sleep(3000);
    }
    //Urun adetini artırma
    public void quantitySelect() throws InterruptedException {

      Select selecTo= new Select(driver.findElement(quantitySelects));
      selecTo.selectByIndex(1);
        log.info("product quantity was 2");
      Thread.sleep(5000);
    }
    //Urun silme
    public void basketDelete()throws InterruptedException {


        driver.findElement(By.id("removeCartItemBtn0")).click();
        Thread.sleep(5000);
        log.info("The product has been deleted");



    }


    public void basketMessageControl(){

        String basketControl=driver.findElement(messageTitle).getText();
        Assertions.assertEquals(basketControl,basketMessageText);
        System.out.println("Sepette ürün yok");

    }



}
