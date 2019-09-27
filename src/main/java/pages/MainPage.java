package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.assertTrue;

public class MainPage extends BasePageObject {

  /* Сценарий 1
1. Перейдите на сервис http://www.ozon.ru/ (http://www.ozon.ru/)
2. Выполните авторизацию на сервисе с ранее созданным логином и паролем
3. Выполните поиск по «iphone»
4. Ограничить цену до 60 000
5. Из результатов поиска добавьте в корзину первые 8 нечетных  товаров.
6. Запомнить цену товаров
7. Перейдите в корзину, убедитесь, что все добавленные ранее товары находятся в корзине
8. Проверить, что итоговая цена равна сумме цен добавленных товаров
9. Удалите все товары из корзины
10. Разлогиньтесь с сервиса
11. Выполните авторизацию на сервисе
12. Проверьте, что корзина не содержит никаких товаров
Сценарий 2
1. Перейдите на сервис http://www.ozon.ru/ (http://www.ozon.ru/)
2. Выполните авторизацию на сервисе с ранее созданным логином и паролем
3. Выполните поиск по «беспроводные наушники»
4. Ограничить цену – до 10 000
5. Бренды : Beats, Samsung
6. Из результатов поиска добавьте в корзину первые 8 четных товаров.
7. Перейдите в корзину, убедитесь, что все добавленные ранее товары находятся в корзине
8. Проверить, что итоговая цена равна сумме цен добавленных товаров
9. Удалите все товары из корзины
10. Разлогиньтесь с сервиса
11. Выполните авторизацию на сервисе
12. Проверьте, что корзина не содержит никаких товаров*/

@FindBy(xpath = "//input[@placeholder='Искать на Ozon']")
public WebElement search;

@FindBy(xpath = "//*[@data-test-id='header-search-go']")
public WebElement enter;

    public void selectMenu(String menuName) {
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(BaseSteps.getDriver().findElement(By.xpath("//span[contains(text(), '"+menuName+"')]")));
        BaseSteps.getDriver().findElement(By.xpath("//span[contains(text(), '"+menuName+"')]")).click();
    }

}
