package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement buttonVhod;



    public LoginPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void loginIntoApp(String login, String password){
        actionsWithOurElements.enterTextIntoElement(inputLogin,login);
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public void openLoginPage(String text){
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Login page was opened");

        }catch (Exception e){
            logger.error("Can't open login page");
            Assert.fail("Can't open login page");
        }
    }
//
//    public void openLoginPage(String address){
//        actionsWithOurElements.
//    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }
}
