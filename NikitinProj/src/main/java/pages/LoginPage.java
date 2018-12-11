package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(name = "_password")
    WebElement inputPassword;

    @FindBy(tagName = "button")
    WebElement buttonVhod;



    public LoginPage(WebDriver webDriver) {

        super(webDriver,"/login");
    }

    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Login page was opened");

        }catch (Exception e){
            logger.error("Can't open login page");
            Assert.fail("Can't open login page");
        }
    }

    public void loginIntoApp(String login, String password){
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickButtonVhod();
    }


    public void enterLogin(String login) {
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isButtonVhodDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonVhod); // to fix method name, or even method itself
    }



    public void validLoginIntoApp(){
        loginIntoApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }


}
