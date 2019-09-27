package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePageObject;
import pages.SearchPage;

import java.util.List;
import java.util.function.Function;

public class SearchSteps extends BasePageObject {

    SearchPage searchPage = new SearchPage();
    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 15);
    private String count;
    private String string;

    Function<? super WebDriver, Object> valueChanged = new ExpectedCondition<Object>() {
        @Override
        public Boolean apply(WebDriver webDriver) {
            return !getRequiredCount().equals(count);
        }
    };

    public void setMaxPrice(String value) {
        searchPage.fillProblemField(searchPage.maxPrice, value + "\n");
        wait.until(ExpectedConditions.visibilityOf(searchPage.priceWindow));

    }


    public String getRequiredCount() {
        System.out.println(searchPage.requiredCount.getText());
        return searchPage.requiredCount.getText();
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

    public void addToBasket(List<String> arg) {
        count = arg.get(0);
        string = arg.get(1);


        System.out.println("count is "+ count);
        System.out.println("string is "+ string);

        int i = 1;
        int countLocal = Integer.parseInt(count);

        switch (string){
            case ("четные"):
                while (countLocal > 0) {
                    if (i % 2 == 0) {
                        waitAndClick(i);
                        countLocal--;
                    }
                    i++;
                }
                break;

            case ("нечетные"):
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



