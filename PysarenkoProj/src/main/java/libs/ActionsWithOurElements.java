package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoElement(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input in element password");

        } catch (Exception e){
            logger.error("Can't work with element" + e);
            Assert.fail("Can't work with element" + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked");
        } catch(Exception e){
            logger.info("Can't work with element" + e);
            Assert.fail("Can't work with element" + e);
        }

    }

    public boolean isElementDisplayed (WebElement element){
        try{
            return element.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try{
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DD");
        }catch (Exception e){
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public void selectOptionByNameInDDHomemade( WebElement dropdownElementField, String dropdownOptionName){
        WebElement neededOptionInDD = webDriver.findElement(By.xpath(".//option[contains(text(),'" + dropdownOptionName + "')]"));

        try{

            clickOnElement(dropdownElementField);
            clickOnElement(neededOptionInDD);
            logger.info(dropdownOptionName + " was selected in DD");


        }catch (Exception e){
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }

    public void selectOptionByValueHomemade (WebElement dropdownElementField, String dropdownValue){
        WebElement neededOptionByValueInDD = webDriver.findElement(By.xpath(".//option[@value = '" + dropdownValue + "']"));
        try {
            clickOnElement(dropdownElementField);
            clickOnElement(neededOptionByValueInDD);
            logger.info(dropdownValue + " was selected in DD as value");
        } catch (Exception e){
            logger.error("Can't work with element");
            Assert.fail("Can't work with element");
        }
    }
}
