package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error(" Don't work open Login Page");
            Assert.fail(" Don't work open Login Page");
        }
    }

    public void enterTextIntoElement(WebElement element, String textInput) {
        try {
            element.clear();
            element.sendKeys(textInput);
            logger.info(textInput + " Has inputted into element");
        } catch (Exception e) {
            logger.error(" Doest'nt work with element" + e);
            Assert.fail(" Doest'nt work with element" + e);
        }

    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error(" Don't click on element" + e);
            Assert.fail(" Don't click on element" + e);
        }
    }
}