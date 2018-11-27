package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into Input");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isEnabled() && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info("Text was selected in DD");

        }catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void findElementInDDByTextAndClickOnIt(WebElement element, String text) {
        try{
        clickOnElement(element);
        String xpathWithText = "//*[text() = '"+text+"']";
        element.findElement(By.xpath(xpathWithText)).click();
            logger.info("Text was selected in DD");
        }catch (Exception e){
            logger.error("Cannot find element by text:"+ text + e);
            Assert.fail("Cannot find element by text:"+ text + e);
        }
    }
    public void findElementInDDByValueAndClickOnIt (WebElement element, String value) {
        try{
            clickOnElement(element);
            String xpathWithValue = "//option[@value = '"+value+"']";
            element.findElement(By.xpath(xpathWithValue)).click();
            logger.info("Element was selected in DD by value");
        }catch (Exception e){
            logger.error("Cannot find element by value:"+ value + e);
            Assert.fail("Cannot find element by value:"+ value + e);
        }
    }
}

