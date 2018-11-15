package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //везде работаем с Драйвером

public class LoginPage  extends  ParentPage{      //alt+enter --* выбрать первую строку
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
        try {
            webDriver.findElement(By.name("_username"));
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was inputted into Input");
        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    public void enterPassword(String password) {
        try {
            webDriver.findElement(By.name("_password"));
            webDriver.findElement(By.name("_password")).sendKeys(password);
            logger.info(password + " was inputted into Input");

        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
// ДОПИСАТЬ!!!!!
    public void clickButtonVhod() {
        try {
            webDriver.findElement(By.tagName("button")).click();
            logger.info ("Authorization passed successfully");

        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
}
