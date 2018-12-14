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


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step
    public void openLoginPage() {

        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not Login Page");
            Assert.fail("Can not Login Page");
        }
    }

    @Step
    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login+ "was inputted into element");
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }

    @Step
    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextIntoElement(inputPassWord, passWord);
//        try {
//            inputPassWord.clear();
//            inputPassWord.sendKeys(passWord);
//            logger.info(passWord+ "was inputted into element");
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }

    @Step
    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
// try {
//            buttonVhod.click();
//
//            logger.info( "Was clicked on button 'Vhod' ");
//        }catch (Exception e){
//            logger.error("Cannot work with element button 'Vhod'");
//            Assert.fail("Cannot work with element button 'Vhod'");
//        }

    }

    @Step
    public boolean isButtonVhodDisplaetd() {
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    @Step
    public void loginIntoApp(String login, String password) {
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickButtonVhod();


    }

    @Step
    public void validLoginIntoApp() {
        loginIntoApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarPresent();

    }


}




