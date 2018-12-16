package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Parent_page {
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy (tagName = "button")
    WebElement buttonToEnter;

    @FindBy (xpath = ".//div[@class = 'login-logo']")
    WebElement loginTable;



    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public boolean isLoginLogoDisplayed() {
        try {
            return actionsWithOurElements.isElementDisplayed(loginTable);
        } catch (Exception e) {
            return false;
        }
    }
    @Step
    public void openLoginPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was Opened");

        } catch (Exception e){
            logger.error("Can't open Login Page");
            Assert.fail("Can not open Login Page!");
        }
    }

    @Step
    public void enterLogin(String login) {
       actionsWithOurElements.enterTextIntoElement(inputLogin,login);

    }
    @Step
    public void enterPassword(String password) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);

    }
    @Step
    public void clickButtonVhod(){
        actionsWithOurElements.clickOnElement(buttonToEnter);
//        try {
//            buttonToEnter.click();
//            logger.info( "Button was input in element password");
//        } catch(Exception e) {
//            logger.error("Can't click on Element");
//            Assert.fail("Can't find/Click element");
//        }

    }
    @Step
    public void loginInToApp(String userTypeValue1, String userTypeValue2){
        openLoginPage();
        enterLogin(userTypeValue1);
        enterPassword(userTypeValue2);
        clickButtonVhod();
    }
    @Step
    public void validLoginIntoApp(){
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }



}
