import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchPage extends  BasePage {
    Log log=new Log();
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By moreButton=By.xpath("//*[@id=\"moreContentButton\"]");
    By productSize=By.xpath("//div[@class='m-productCard__photo']");
    By selectSizeOfProduct = By.xpath("//*[@id=\"sizes\"]/div/span[1]");
    By addToCarButtonLocator = By.id("addBasket");
    By cartButtonButton= new By.ByCssSelector("a[href='/cart'] span");
    By priceNew = By.id("priceNew");

    //Daha fazla göster butonuna tıkladık
    public void clickMoreButton(){
        clickTo(moreButton);
        log.info("More Button Click");

    }
    //Rastgele urun seçme
    public String clickRandomProduct() throws InterruptedException {
        return randomSelect(productSize);

    }
    //Ürünün beden seçimi sonra sepete ekleme
    public void sizeBasket() throws InterruptedException {
        clickTo(selectSizeOfProduct);
        log.info("size selection");

        Thread.sleep(1000);
        clickTo(addToCarButtonLocator);
        Thread.sleep(1000);
        log.info("add to cart");

    }
//Sepetime gitme
    public void clickBasket() {
        clickTo(cartButtonButton);
        log.info("go to cart");

    }
}
