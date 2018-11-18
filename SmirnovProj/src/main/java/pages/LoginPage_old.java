package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_old extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;




    public LoginPage_old(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage (){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");
        }

    }


    public void enterLogin(String login) {
        try{
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was inputted into Inout");
        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    public void enterPassword (String passWord) {
        try{
            webDriver.findElement(By.name("_password")).clear();
            webDriver.findElement(By.name("_password")).sendKeys(passWord);
            logger.info(passWord + " was inputted into Inout");
        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    public void clickButtonVhod () {
        try {
           webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
            logger.info("Button submit pressed");
        }catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
}
