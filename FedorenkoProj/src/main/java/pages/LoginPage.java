package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(tagName = "button")
    WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
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
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonSubmit);

//        try {
//            buttonSubmit.click();
//            logger.info("Button was clicked");
//        } catch (Exception e) {
//            logger.error("Can't find submit button");
//            Assert.fail("Can't find submit button");
//        }
    }

    public void loginInToApp(String login, String password) {
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickButtonVhod();
    }

    public void validLoginInToApp() {
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarPresent();
    }


    public boolean isLoginInputPresent() {
        return actionsWithOurElements.isElementPresent(inputLogin);
//        try {
//            return inputLogin.isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
    }
}
