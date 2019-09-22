package steps;

import io.qameta.allure.Step;
import pages.BasePageObject;
import pages.MainPage;

public class MainSteps extends BasePageObject {

    MainPage mainPage = new MainPage();


    @Step("выбран пункт меню {0}")
    public void selectMenu(String menu) {
        mainPage.selectMenu(menu);
    }

    public void search(String itemName) {

        fillField(mainPage.search, itemName);
        click(mainPage.enter);

    }
}
