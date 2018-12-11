package pages;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;
    @FindBy(name = "_password")
    WebElement inputPassword;
    @FindBy(xpath = ".//button[@type='submit']")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step
    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can't open Login Page");
            Assert.fail("Can't open Login page");
        }
    }

    @Step
    public boolean isInputLoginDisplayed() {
        return actionsWithOurElements.isElementDisplayed(inputLogin);
    }

    @Step
    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    @Step
    public void enterPassword(String password) {
        actionsWithOurElements.enterTextInToElement(inputPassword, password);
    }

    @Step
    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    @Step
    public boolean isButtonVhodDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    @Step
    public void loginInToApp(String login, String password) {
        openLoginPage();
        enterLogin(login);
        enterPassword(password);
        clickButtonVhod();
    }

    @Step
    public void validLoginInToApp() {
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }
}
