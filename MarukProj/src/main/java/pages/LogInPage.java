package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends ParentPage {
    @FindBy(name = "_username") // annotation jUnit описує елемент на веб-сторінці
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement buttonVhod;
    public LogInPage(WebDriver webDriver) {
        super(webDriver,"/login");
    }

    @Step
    public void openLogInPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");

        }catch(Exception e){
            logger.error("Cannot open Login Page!");
            Assert.fail("Cannot open Login Page!"); // stop test without any checking

        }
    }
    @Step
    public void enterLogin(String login) {

        actionsWithOurElements.enterTextToElement(inputLogin,login);
    }

    @Step
    public void enterPassword(String password) {

        actionsWithOurElements.enterTextToElement(inputPassword, password);
    }
    @Step
    public void clickButtonVhod() {

        actionsWithOurElements.clickOnElement(buttonVhod);
    }
    @Step
    public boolean buttonVhodDisplayed(){
//        try{
//            return webDriver.findElement(By.tagName("button")).isDisplayed();
//
//        }catch(Exception e){
//            return false;
//        }
         return actionsWithOurElements.isElementDisplayed(buttonVhod);


    }
    // homework 17.11.2018 "схлопнуть логін"
    @Step
    public void loginInToApp(String logIn, String paSSword){
        openLogInPage();
        enterLogin(logIn);
        enterPassword(paSSword);
        clickButtonVhod();
    }
    @Step
    public void validLoginIntoApp(){
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();

    }
}
