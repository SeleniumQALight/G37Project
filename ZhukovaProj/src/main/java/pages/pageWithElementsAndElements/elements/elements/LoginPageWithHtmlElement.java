package pages.pageWithElementsAndElements.elements.elements;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPageWithHtmlElement extends ParentPageWithHtmlElements {
    @FindBy(name = "_username")
    private TextInput inputLogin;
    @FindBy(name = "_password")
    private TextInput inputPassWord;
    @FindBy(tagName = "button")
    private Button buttonLogin;

    public LoginPageWithHtmlElement(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step
    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    @Step
    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    @Step
    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassWord, passWord);
    }

    @Step
    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonLogin);
    }

    @Step
    public boolean isButtonVhodDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonLogin);
    }

    @Step
    public void loginInToApp(String login, String passWord) {
        openLoginPage();
        enterLogin(login);
        enterPassword(passWord);
        clickButtonVhod();
    }

    @Step
    public void validLoginInToApp() {
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarPresent();
    }
}
