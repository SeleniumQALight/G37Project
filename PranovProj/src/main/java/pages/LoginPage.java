package pages;

import io.qameta.allure.Step;
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
        super(webDriver, "/login");
    }

    @Step
    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    @Step
    public void enterLogin(String login) {
        actionWithOurElements.enterTextInToElement(inputLogin,login);
    }
    @Step
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

    @Step
    public void clickButtonVhod() {
        actionWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isButtonVhodDisplayed(){
        return actionWithOurElements.isElementDisplayed(buttonVhod);
    }

    @Step
    public void loginInToApp(String login, String passWord){
        openLoginPage();
        enterLogin(login);
        enterPassword(passWord);
        clickButtonVhod();
    }

    @Step
    public void validLoginInToApp(){
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }
}
