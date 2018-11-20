package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
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
        super(webDriver);
    }

    public void openLogInPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");

        }catch(Exception e){
            logger.error("Cannot open Login Page!");
            Assert.fail("Cannot open Login Page!"); // stop test without any checking

        }
    }

    public void enterLogin(String login) {

        actionsWithOurElements.enterTextToElement(inputLogin,login);
    }


    public void enterPassword(String password)
    {
        actionsWithOurElements.enterTextToElement(inputPassword, password);
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isButtonPresent(){
        try{
            return webDriver.findElement(By.tagName("button")).isDisplayed();

        }catch(Exception e){
            return false;
        }
    }
    // homework 17.11.2018 "схлопнуть логін"
    public void loginInToApp(String logIn, String paSSword){
        openLogInPage();
        enterLogin(logIn);
        enterPassword(paSSword);
        clickButtonVhod();

    }
}
