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
        // try {webDriver.findElement( By.name( "_username")).clear ();
        //   webDriver.findElement(By.name("_username")).sendKeys(login);

        //try {webDriver.findElement(By.xpath ("//input[@name='_username'and @type='text']")).clear();
        //  webDriver.findElement(By.xpath ("//input[@name='_username'and @type='text']")).sendKeys(login);
        try {
            webDriver.findElement(By.className("form-control")).clear();
            webDriver.findElement(By.className("form-control")).sendKeys(login);
            logger.info(login + "was inpputed into Input");


        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void enterPassWord(String passWord) {
        try {
            webDriver.findElement(By.name("_password")).clear();
            webDriver.findElement(By.name("_password")).sendKeys(passWord);


            logger.info(passWord + "was inputed into Input");

        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickButtonEnter() {

        try {
            webDriver.findElement(By.xpath("//button[@type='submit']")).click();

            logger.info("The enter is successful");

        } catch (Exception e) {
            logger.error("Can not find the element");
            Assert.fail("Can not find the element");
        }
    }

        public void clickStudentButton () {


            try {
                webDriver.findElement(By.className("sidebar-toggle")).click();
                logger.info("Student button is found");

            } catch (Exception e) {
                logger.error("Can not find the Student button");
                Assert.fail("Can not find the Student button");
            }
        }

    public void exitButton () {


        try {
            webDriver.findElement(By.id("Выход")).click();
            logger.info("The exit is successful");

        } catch (Exception e) {
            logger.error("Can not find the Exit button");
            Assert.fail("Can not find the Exit button");
        }
    }

    }

