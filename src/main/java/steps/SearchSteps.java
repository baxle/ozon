package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePageObject;
import pages.SearchPage;

public class SearchSteps extends BasePageObject {

    SearchPage searchPage = new SearchPage();
    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 15);

    public void setMaxPrice(String value) {
        searchPage.fillProblemField(searchPage.maxPrice, value + "\n");
        wait.until(ExpectedConditions.visibilityOf(searchPage.priceWindow));

    }

    private void waitAndClick(int i) {
        click(BaseSteps.getDriver().findElement(By.xpath("(//*[contains(text(), 'В корзину')])[" + i + "]")));
    }

    public void setBrand(String brand) {

        String[] subStr;
        String delimeter = ", "; // Разделитель
        subStr = brand.split(delimeter); // Разделения строки str с помощью метода split()

        click(searchPage.viewAllBrands);
        wait.until(ExpectedConditions.visibilityOf(searchPage.brandMenu));

        for (int i = 0; i < subStr.length; i++) {

            click(searchPage.brandSearch);
            fillField(searchPage.brandSearch, subStr[i]);
            click(searchPage.brandEnter);
            wait.until(ExpectedConditions.visibilityOf(BaseSteps.getDriver().findElement(By.xpath("//span[.='Бренды: " + subStr[i] + "']"))));

        }
    }

    public void addToBasket(String count, String string) {

        int i = 1;
        int countLocal = Integer.parseInt(count);

        switch (string){
            case ("четных"):
                while (countLocal > 0) {
                    if (i % 2 == 0) {
                        waitAndClick(i);
                        countLocal--;
                    }
                    i++;
                }
                break;

            case ("нечетных"):
                while (countLocal > 0) {
                    if (i % 2 != 0) {
                        waitAndClick(i);
                        countLocal--;
                    }
                    i++;
                }
                break;
        }
    }
}



