package pages;

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

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Loginpage was opened");
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


    //public void clickButtonVhod() {
    // try {
    //    buttonVhod.click();
    //   logger.info("Button 'Vhod' was clicked");
    // }catch (Exception e){
    // logger.error("Cannot work with element");
    // Assert.fail("Cannot work with element");
    // }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");

        }catch (Exception e){
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);

        }

    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }
}

