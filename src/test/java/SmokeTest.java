import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void smokeTestUp() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.control_of_pages();
        homePage.searchProduct("pantolon");

        BasePage basePage = new BasePage(driver);
        basePage.scrollDownOne();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickMoreButton();
        String productPrice = searchPage.clickRandomProduct();
        searchPage.sizeBasket();
        searchPage.clickBasket();

        BasketPage basketPage=new BasketPage(driver);
        basketPage.assertBasketPrice(productPrice);
        basketPage.quantitySelect();
        basketPage.basketDelete();
        basketPage.basketMessageControl();
    }



}
