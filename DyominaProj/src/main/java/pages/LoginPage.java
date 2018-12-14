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
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step
    public void openLoginPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e){
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    @Step
    public void enterLogin(String login) {
       actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    @Step
    public void enterPassword(String password) {
//        try{
//            inputPassword.clear();
//            inputPassword.sendKeys(password);
//            logger.info(password + "was inputed into Input");
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);
    }

    @Step
    public void clickButtonVhod(){
//        try{
//            buttonVhod.click();
//            logger.info("Button was clicked");
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    @Step
    public  void loginInToApp(String login, String password){
            openLoginPage();
            enterLogin(login);
            enterPassword(password);
            clickButtonVhod();
    }

    @Step
    public boolean isLogoFormDisplayed(){
        try{
            return webDriver.findElement(By.xpath(".//*[@class='login-box-body']")).isDisplayed();
//            logger.info("Login Form is Displayed");
        }catch (Exception e){
            return false;
        }
    }

    @Step
    public boolean isButtonVhodDisplayed(){
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    @Step
    public void validLoginInToApp(){
        loginInToApp("Student","909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }


}
