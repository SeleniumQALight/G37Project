package pages;

import libs.ActionWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 123 on 13.11.2018.
 */
public class LoginPage extends ParentPage {

    @FindBy (name = "_username")
    WebElement inputLogin;

    @FindBy (name = "_password")
    WebElement inputPassword;

    @FindBy (xpath = ".//button")
    WebElement buttonEnter;


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info(" Web page is opened");


        } catch ( Exception e ) {
            logger.error("Can't open Login Page");
            Assert.fail("Can't open page");

        }
    }

    public void enterLogin(String login) {
        actionWithOurElements.enterTextIntoElement(inputLogin, login);
//        try
//
//        {
//            inputLogin.clear();
//            inputLogin.sendKeys();
//            logger.info(login);
//
//        } catch (
//                Exception e )
//
//        {
//            logger.error("Can't enter login");
//            Assert.fail("Can't enter login");
//        }
    }


    public void enterPassword(String password) {
        actionWithOurElements.enterTextIntoElement(inputPassword, password);

//        try
//
//        {
//            inputPassword.clear();
//            inputPassword.sendKeys("909090");
//
//            logger.info(password + "password was added");
//
//        } catch (
//                Exception e )
//
//        {
//            logger.error("Can't enter login");
//            Assert.fail("Can't enter login");
//
//        }
    }


    public void clickButtonEnter() {

        actionWithOurElements.clickOnElement(buttonEnter);


//        try
//
//        {
//            buttonEnter.click();
//            logger.info("button is found");
//
//        } catch (
//                Exception e )
//
//        {
//            logger.error("Password or Username are incorrect");
//            Assert.assertTrue( "Password or Username are incorrect", true );
//
//        }
    }



}
