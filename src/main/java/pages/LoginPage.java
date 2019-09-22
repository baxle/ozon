package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject{

    @FindBy(xpath = "//a[contains(text(), 'Войти по почте')]")
    public WebElement withEmail;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//span[.='Войти']")
    public WebElement enter;


}
