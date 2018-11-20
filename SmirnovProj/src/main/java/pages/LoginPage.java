package pages;

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

    @FindBy(xpath = ".//button[@type='submit']")
    WebElement buttonVhod;

    @FindBy(xpath = ".//a[@href='http://v3.test.itpmgroup.com/']")
    WebElement loginLogo;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage (){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");
        }

    }


    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin,login);
    }

    public void enterPassword (String passWord) {
//        try{
//            inputPassWord.clear();
//            inputPassWord.sendKeys(passWord);
//            logger.info(passWord + " was inputted into Inout");
//        }catch (Exception e) {
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
        actionsWithOurElements.enterTextInToElement(inputPassWord,passWord);

    }

    public void clickButtonVhod () {
//        try {
//            buttonVhod.click();
//            logger.info("Button submit pressed");
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
        actionsWithOurElements.clickOnElement(buttonVhod);

    }
    public void chekVisibleLoginPage () {
        actionsWithOurElements.cheсkVisibleElement(loginLogo);
    }


}
