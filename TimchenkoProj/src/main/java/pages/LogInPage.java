package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends  ParentPage {

    public LogInPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void openLogInPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }

    }

    public void enterLogin(String login) {
        try {webDriver.findElement( By.name( "_username")).clear ();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + "was inpputed into Input");


        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void enterPassWord (String passWord) {
        try { webDriver.findElement( By.name( "_password")).clear ();
            webDriver.findElement(By.name("_password")).sendKeys(passWord);
            logger.info(passWord + "was inputed into Input");

        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
}