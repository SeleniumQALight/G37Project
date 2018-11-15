package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Parent_page {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was Opened");

        } catch (Exception e){
            logger.error("Can't open Login Page");
            Assert.fail("Can not open Login Page!");
        }
    }


    public void enterLogin(String login) {
        try{
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + "was input in element login");
        } catch (Exception e){
            logger.error("Can't work with login element");
            Assert.fail("Can't work with login element");
        }

    }

    public void enterPassword(String password) {
        try{
            webDriver.findElement(By.name("_password")).clear();
            webDriver.findElement(By.name("_password")).sendKeys(password);
            logger.info(password + "was input in element password");

        } catch (Exception e){
            logger.error("Can't work with password element");
            Assert.fail("Can't work with password element");
        }

    }

    public void clickButtonVhod(){
        try {
            webDriver.findElement(By.tagName("button")).click();
            logger.info( "Button was input in element password");
        } catch(Exception e) {
            logger.error("Can't click on Element");
            Assert.fail("Can't find/Click element");
        }

    }


}
