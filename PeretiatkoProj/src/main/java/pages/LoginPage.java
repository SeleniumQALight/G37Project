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
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {

        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page open");
        } catch (Exception e) {
            logger.error("Can not Login Page");
            Assert.fail("Can not Login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " was inputted into element");
//        } catch (Exception e) {
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }

    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, passWord);
//        try {
//            inputPassword.clear();
//            inputPassword.sendKeys(passWord);
//            logger.info(passWord + " Inputted into element");
//        } catch (Exception e) {
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
//        try {
//            buttonVhod.click();
//            logger.info("Clicked button");
//        } catch (Exception e) {
//            logger.error("Doest not work");
//            Assert.fail("Doest not work");
//        }
//    }
    }
}

