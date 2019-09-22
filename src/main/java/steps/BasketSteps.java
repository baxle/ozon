package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePageObject;
import pages.BasketPage;

import static org.junit.Assert.assertEquals;

public class BasketSteps extends BasePageObject {
    MainSteps mainSteps = new MainSteps();
    BasketPage basketPage = new BasketPage();
    private static int sum;
    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 15);

    public static int getSum() {
        return sum;
    }

    public void saveSumm() {
        mainSteps.selectMenu("Корзина");

        wait.until(ExpectedConditions.visibilityOf(basketPage.totalPriceTable));
        String localSum = basketPage.totalPrice.getText().replaceAll("[^0-9]", "");
        sum = Integer.parseInt(localSum);
        // System.out.println("sum is " + sum);
    }


    public void checkAllSums(int count) {
        int sumEachProduct = 0;

        for (int i = 1; i < count + 1; i++) {
            String localSum = BaseSteps.getDriver().findElement(By.xpath("(//div[@class='cart-item__column m-price']/div[1]//span[1])[" + i + "]")).getText().replaceAll("[^0-9]", "");
            sumEachProduct = sumEachProduct + Integer.parseInt(localSum);
        }

        // System.out.println("сумма покупок "+sumEachProduct );
        assertEquals("Сумма покупок не соотвествует ожидаемой сумме", sumEachProduct, getSum());

    }

    public void deleteAllProducts() {
        if (basketPage.checkAll.isSelected()) {
            click(basketPage.checkAll);
        }
        click(basketPage.deleteButton);
        click(basketPage.confirmDeleteButton);

    }

    public void checkEmptyBasket() {
       // mainSteps.selectMenu("Корзина");
        assertEquals("Корзина не пуста", "Корзина пуста",basketPage.isBasketEmpty.getText());
    }
}
