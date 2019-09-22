package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.BaseSteps;

public class SearchPage extends BasePageObject{

    @FindBy(xpath = "//div[@data-test-id='filter-block-price']//*[@data-test-id='range-filter-to-input']")
    public  WebElement maxPrice;

    @FindBy(xpath = "//span[contains(text(), 'Цена')]")
    public WebElement priceWindow;

    @FindBy(xpath = "//span[@class='f-caption--bold ef9580']")
    public WebElement requiredCount;

    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    public WebElement viewAllBrands;

    @FindBy(xpath = "//div[@class='input-wrap search-input m-low-height']/input[@class='input']")
    public WebElement brandSearch;

    @FindBy(xpath = "//*[@class='search-button button default small flat-button']")
    public WebElement brandEnter;

    @FindBy(xpath = "//div[@class='search-show-container']")
    public WebElement brandMenu;


  /*  public void addToBasket(int count) {
       //BaseSteps.getDriver().findElement(By.xpath("(//*[contains(text(), 'В корзину')])["+count+"]")).click();
        click(BaseSteps.getDriver().findElement(By.xpath("(//*[contains(text(), 'В корзину')])["+count+"]")));
    }*/

}
