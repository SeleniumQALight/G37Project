package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

public class ActionsWithOurElements {
    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTextIntoElement (WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into Input");
        }catch (Exception e){
            logger.error("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            logger.error("Can not work with element");
           Assert.fail("Can not work with element");
        }
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try{
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in dropdown");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public void workWithDD(WebElement element, String text, WebElement optionValue) {
        try {
            element.click();
            selectTextInDD(optionValue, text);
            logger.info(text + " was found in dropdown");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public void selectValueFromDD(WebElement valueFromDD){
        try{
            valueFromDD.click();
            logger.info(valueFromDD+ " was selected from dropdown");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

}
