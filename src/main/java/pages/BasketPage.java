package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BasketPage extends BasePageObject {
    @FindBy(xpath = "//span[@class='total-middle-footer-text']")
    public WebElement totalPrice;

    @FindBy(xpath = "//div[@class='total-middle m-last']")
    public WebElement totalPriceTable;

    @FindBy(xpath = "//label[contains(text(), 'Выбрать все')]")
    public WebElement checkAll;

    @FindBy(xpath = "//span[contains(text(), 'Удалить выбранные')]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[contains(text(), 'Удалить')]")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[@class='container']//h1")
    public WebElement isBasketEmpty;

}


//(//div[@class='cart-item__column m-price']/div[1]//span[1])[count]