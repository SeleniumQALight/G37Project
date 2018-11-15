package pages;

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



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was Opened");

        } catch (Exception e){
            logger.error("Can't open Login Page");
            Assert.fail("Can not open Login Page!");
        }
    }


    public void enterLogin(String login) {
       actionsWithOurElements.enterTextIntoElement(inputLogin,login);

    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);

    }

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


}
