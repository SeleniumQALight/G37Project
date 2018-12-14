package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")     //Объявляем элемент (вместо    webDriver.findElement(By.name("_password")))
            WebElement inputLogin;          // Называем элемент
    @FindBy(name = "_password")
    WebElement inputPassword;
    @FindBy(tagName = "button")
    WebElement buttonVhod;
    @FindBy(xpath = ".//*[@class='login-box-msg']")
    WebElement autorizationSection;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step
    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login page");
            Assert.fail("Can not open Login page");
        }
    }

    @Step
    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    @Step
    public void enterPass(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassword, passWord);
    }

    @Step
    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    @Step
    public boolean isAutorizationSectionDisplayed() {return actionsWithOurElements.isElementDisplayed(autorizationSection);}

    @Step
    public void loginInToApp (String login, String passWord){
        openLoginPage();
        enterLogin(login);
        enterPass(passWord);
        clickButtonVhod();
    }

    @Step
    public void validLoginInToApp(){
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }
}
