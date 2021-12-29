
import org.openqa.selenium.*;
import java.util.List;
import java.util.Random;

public class BasePage{



    WebDriver driver;
    public BasePage(WebDriver driver){

        this.driver = driver;

    }

    By priceNew = By.id("priceNew");

    //Elementlerin locator işlemi
    public WebElement findTo(By locator){

        return driver.findElement(locator);
    }

    //Elemenlere tıklama işlemi
    public void clickTo(By locator){

        findTo(locator).click();
    }

    //Searchboxtan gelen kelime enter ile aratıldı
    public void sendKeys(By locator , String text){
        findTo(locator).sendKeys(text+ Keys.ENTER);
    }

    //Sayfa scroll edildi
    public void scrollDownOne() throws InterruptedException {

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
                Thread.sleep(3000);
    }
    //Sayfada ki elementler alındı
    public List<WebElement> findToAll(By locator){
        return driver.findElements(locator);
    }

    // Rastgele bir ürün seçildi
    public String randomSelect(By locator) throws InterruptedException {
        int randomSize = driver.findElements(locator).size();
        Random rand = new Random();
        findToAll(locator).get(rand.nextInt(randomSize)).click();
        Thread.sleep(2000);
        return findTo(priceNew).getText();
    }



}
