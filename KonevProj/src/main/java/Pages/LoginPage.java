package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name="_username")
    WebElement inputLogin;

    @FindBy(name="_password")
    WebElement inputPassword;

    @FindBy(tagName="button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.info("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassword, passWord);
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
        }

    public void loginInToApp(String login, String password) {
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickButtonVhod();
    }
}
