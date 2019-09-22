package steps;

import io.qameta.allure.Step;
import pages.BasePageObject;
import pages.LoginPage;

public class LoginSteps extends BasePageObject {

    LoginPage loginPage = new LoginPage();

    @Step("авторизация")
    public void login(String login, String password){

        click(loginPage.withEmail);
        loginPage.fillField(loginPage.email, login);
        loginPage.fillField(loginPage.password, password);
        click(loginPage.enter);
    }
}
