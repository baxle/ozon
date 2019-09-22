package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }


    public void fillProblemField(WebElement field, String value) {
        String selectAll = Keys.chord(Keys.CONTROL, "a");

        field.sendKeys(selectAll);
        field.sendKeys(Keys.BACK_SPACE);

        field.sendKeys(value);
    }

    public void click(WebElement element) {
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 15);
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public boolean isElementPresent(By by) {
        try {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            BaseSteps.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void selectCollectionItem(String itemName, List<WebElement> collection) {
        for (WebElement item : collection) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элемент коллеции - " + itemName);
    }

}
