package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class ScenarioSteps {

    MainSteps mainPageSteps = new MainSteps();
    LoginSteps loginSteps = new LoginSteps();
    SearchSteps searchSteps = new SearchSteps();
    BasketSteps basketSteps = new BasketSteps();


    @When("^выбрано \"(.+)\"$")
    public void selectMenu(String menu) {
        mainPageSteps.selectMenu(menu);
    }

    @When("выполнена авторизация")
    public void login() {
        loginSteps.login(BaseSteps.properties.getProperty("login"), BaseSteps.properties.getProperty("password"));
    }

    @Then("^выполняется поиск по \"(.+)\"$")
    public void search(String itemName) {
        mainPageSteps.search(itemName);
    }

    @When("^цена ограничивается до \"(.+)\"$")
    public void setMaxPrice(String value) {
        searchSteps.setMaxPrice(value);
    }


    @When("в корзину добавлено первые \"(.*)\"  \"(.*)\" продуктов")
    public void addOddToBasket(String count, String string) {
        searchSteps.addToBasket(count, string);
    }


    @When("записана суммарная цена товаров")
    public void saveSumm() {
        basketSteps.saveSumm();
    }


    @Then("проверено, что итоговая цена равна сумме цен \"(.+)\" добавленных товаров")
    public void checkAllSums(int count) {
        basketSteps.checkAllSums(count);
    }

    @When("удалены все товары из корзины")
    public void deleteAllProducts() {
        basketSteps.deleteAllProducts();
    }

    @Then("проверено, что корзина не содержит товаров")
    public void checkEmptyBasket() {
        basketSteps.checkEmptyBasket();
    }

    @When("^бренды ограничиваются до \"(.+)\"$")
    public void setBrand(String brand) {
        searchSteps.setBrand(brand);
    }

}
