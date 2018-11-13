package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends ParentPage {
    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLogInPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");

        }catch(Exception e){
            logger.error("Cannot open Login Page!");
            Assert.fail("Cannot open Login Page!"); // stop test without any checking

        }
    }


    public void enterLogin(String login) {
        try{
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was entered in Input field");


        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }


    public void enterPassword(String password) {
        try{
            webDriver.findElement(By.name("_password")).clear();
            webDriver.findElement(By.name("_password")).sendKeys(password);
            logger.info(password + " was entered in Password field");


        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
}
