package Pages;

import io.qameta.allure.Step;
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
        super(webDriver, "/login");
    }

    @Step
    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.info("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }
    @Step
    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }
    @Step
    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassword, passWord);
    }
    @Step
    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
        }
    @Step
    public void loginInToApp(String login, String password) {
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickButtonVhod();
    }
    @Step
    public void validLoginInToApp(){
        HomePage homePage = new HomePage(webDriver);
        loginInToApp("student","909090");
        homePage.isAvatarDisplayed();
    }
    @Step
    public boolean isButtonVhodDisplayed(){
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }
}
