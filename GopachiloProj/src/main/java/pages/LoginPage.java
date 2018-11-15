package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            Assert.fail("Can not open login page");
            logger.error("Can not open login page ");
        }
    }

    public void enterLogin(String login) {
        try {
           webDriver.findElement(By.name("_username")).clear();
           webDriver.findElement(By.name("_username")).sendKeys(login);
           logger.info(login+ "was inputted into Input");
        }catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
    public void enterPassword(String passWord) {
        try {
            webDriver.findElement(By.name("_password")).clear();
            webDriver.findElement(By.name("_password")).sendKeys(passWord);
            logger.info(passWord+ "was inputted into Input");

        }catch (Exception e){
            logger.error("Cannot work with element ");
            Assert.fail("Cannot work with element");
        }
    }

    public void clickButtonVhod() {
        try {
            webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
            logger.info("Was click botton Vhod");

        }catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
}
