package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainPageSteps = new MainSteps();
    LoginSteps loginSteps = new LoginSteps();
    SearchSteps searchSteps = new SearchSteps();
    BasketSteps basketSteps = new BasketSteps();

   /* Когда выбрано "Войти"
    Когда выполнена авторизация*/

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

    //добавлены в корзину первые "8" нечентых товаров

    @When("^добавлены в корзину первые \"(.+)\" нечетных товаров")
    public void addOddToBasket(String count) {
        searchSteps.addOddToBasket(count);
    }

    @When("^добавлены в корзину первые \"(.+)\" четных товаров")
    public void addEvenToBasket(String count) {
        searchSteps.addEvenToBasket(count);
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
