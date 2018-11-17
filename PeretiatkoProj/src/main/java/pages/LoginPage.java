package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement buttonEnter;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        actionsWithOurElements.openBrowser();
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, passWord);
    }

    public void clickButtonEnter() {
        actionsWithOurElements.clickOnElement(buttonEnter);
    }
}

