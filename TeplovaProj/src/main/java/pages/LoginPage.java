package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by 123 on 13.11.2018.
 */
public class LoginPage extends ParentPage {


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
            logger.info(" Web page is opened");


        } catch ( Exception e ) {
            logger.error("Can't open Login Page");
            Assert.fail("Can't open page");

        }
    }

    public void enterLogin(String login) {
        try

        {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys();
            logger.info(login);

        } catch (
                Exception e )

        {
            logger.error("Can't enter login");
            Assert.fail("Can't enter login");
        }
    }


    public void enterPassword(String password) {

        try

        {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_password")).sendKeys("909090");

            logger.info(password + "password was added");

        } catch (
                Exception e )

        {
            logger.error("Can't enter login");
            Assert.fail("Can't enter login");

        }
    }


    public void clickButtonEnter(String buttton) {

        try

        {
            webDriver.findElement(By.xpath(".//button")).click();
            logger.info(buttton + "button is found");

        } catch (
                Exception e )

        {
            logger.error("Password or Username are incorrect");
            Assert.assertTrue( "Password or Username are incorrect", true );

        }
    }
}
