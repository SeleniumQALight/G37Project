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

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) { super(webDriver, "/login"); }

    public void openLogInPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassWord, passWord);
    }

    public void clickButtonVhod() { actionsWithOurElements.clickOnElement(buttonVhod); }

    public boolean isButtonVhodDisplayed(){
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    public void loginIntoApp(String login, String passWord) {
        openLogInPage();
        enterLogin(login);
        enterPassword(passWord);
        clickButtonVhod();
    }

    public void validLoginInToApp() {
        loginIntoApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }

}