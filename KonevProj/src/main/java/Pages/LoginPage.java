package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Loginpage was opened");
        } catch (Exception e) {
            logger.info("Can not open Login Page");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterLogin(String login) {
        try{
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login +"was inputted into Input");
        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    public void enterPassword(String passWord) {
        try{
            webDriver.findElement(By.name("_password")).clear();
            webDriver.findElement(By.name("_password")).sendKeys(passWord);
            logger.info(passWord +"was inputted into Input");

        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }


    public void clickButtonVhod() {
        try {
            webDriver.findElement(By.tagName("button")).click();
            logger.info("Button 'Vhod' was clicked");
        }catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
        }
}
