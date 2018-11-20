package pages;

import org.junit.Assert;
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
        try {
            String URL = "http://v3.test.itpmgroup.com";
            webDriver.get(URL);
            logger.info(URL + " Login page was opened");
        } catch (Exception e) {
            logger.error(" Don't work open Login Page");
            Assert.fail(" Don't work open Login Page");
        }
    }

    public void loginInToApp(String login, String password) {
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickButtonEnter();
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

