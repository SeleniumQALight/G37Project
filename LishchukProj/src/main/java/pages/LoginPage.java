package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open Login Page");

            Assert.fail("Cannot open Login Page");
        }
    }

    public void enterLogin(String login) {
       actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String passWord) {
  /*    try {
            inputPassWord.clear();
            inputPassWord.sendKeys(passWord);
            logger.info(passWord + "was inputted into input");
        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }*/
        actionsWithOurElements.enterTextInToElement(inputPassWord, passWord);
    }
    //Homework below
   /*public void clickButtonVhod() {
        try {
            buttonVhod.click();
            logger.info("was clicked");
        }catch (Exception e) {
            logger.error("Cannot find such a button");
            Assert.fail("Cannot find such a button");
        }
    }*/
    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

}
