package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) { super(webDriver, "/login"); }

    @Step
    public void openLogInPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");
        }
    }
    @Step
    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    @Step
    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassWord, passWord);
    }

    @Step
    public void clickButtonVhod() { actionsWithOurElements.clickOnElement(buttonVhod); }

    @Step
    public boolean isButtonVhodDisplayed(){
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    @Step
    public void loginIntoApp(String login, String passWord) {
        openLogInPage();
        enterLogin(login);
        enterPassword(passWord);
        clickButtonVhod();
    }

    @Step
    public void validLoginInToApp() {
        loginIntoApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }

}