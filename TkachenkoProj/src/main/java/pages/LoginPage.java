package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.naming.Name;
import java.util.concurrent.ExecutionException;

public class LoginPage extends ParentPage{
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    @FindBy(xpath = ".//*[@class='login-logo']")
    WebElement loginLogo;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            driver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }
    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, passWord);
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public void loginInToApp(String login, String passWord){
        openLoginPage();
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
        actionsWithOurElements.enterTextIntoElement(inputPassword, passWord);
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isLogoPresent(){
        try {
            return loginLogo.isDisplayed();

        }catch (Exception e){
            return false;
        }
    }
}
