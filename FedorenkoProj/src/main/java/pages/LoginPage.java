package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e ) {
            logger.info("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

}
