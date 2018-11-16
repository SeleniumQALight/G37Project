package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //везде работаем с Драйвером
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends  ParentPage {      //alt+enter --* выбрать первую строку
    @FindBy(name = "_username")   //описываем все элементы на страничке в анотации, иницилизируется при обращении
    WebElement inputLogin;   //объявляем объект веб элемента

    @FindBy (name = "_password")
    WebElement inputPassWord;

    @FindBy (tagName = "button")
    WebElement buttonVhod;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage () {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info ("Login page was opened");

        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInElement(inputLogin, login);
    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextInElement(inputPassWord, password);
    }

    /*public void clickButtonVhod() {
        try {
            buttonVhod.click();
            logger.info ("Authorization passed successfully");

        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }*/

    public void clickButtonVhod () {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

}
