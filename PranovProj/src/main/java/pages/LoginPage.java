package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterLogin(String login) {
        actionWithOurElements.enterTextInToElement(inputLogin,login);
    }
    public void enterPassword(String passWord) {
        actionWithOurElements.enterTextInToElement(inputPassWord,passWord);
        //try {
        //    inputPassWord.clear();
        //    inputPassWord.sendKeys(passWord);
        //    logger.info(passWord + " was inputted into Input");
        //}catch (Exception e){
        //    logger.error("Cannot work with element");
        //   Assert.fail("Cannot work with element");
        //}
    }

    public void clickButtonVhod() {
        actionWithOurElements.clickOnElement(buttonVhod);
    }
}
