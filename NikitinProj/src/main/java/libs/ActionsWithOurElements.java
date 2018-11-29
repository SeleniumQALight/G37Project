package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5, wait10;

    public ActionsWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        wait5 = new WebDriverWait(webDriver,5);
        wait10 = new WebDriverWait(webDriver,10);
    }


    public void enterTextIntoElement(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered into the field");
        }catch (Exception e){
            logger.error("can't work with element " + e);
            Assert.fail("can't work with element " + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("element was clicked");
        }catch (Exception e){
            logger.error("can't work with element " + e);
            Assert.fail("can't work with element " + e);
        }


    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

    //build-in webdriver solution for dropdown
    public void selectTextInDD(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in dropdown");
        }catch (Exception e){
            logger.error("Can't work with element (dropdown)" + e);
            Assert.fail("Can't work with element (dropdown)" + e);
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            return isElementDisplayed(webDriver.findElement(by));
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Set needed state
     * @param element
     * @param state (only check or uncheck)
     */
    public void setNeededStateToCheckbox(WebElement element,String state){
        boolean checkState = state.toLowerCase().equals("checked");
        boolean uncheckedState = state.toLowerCase().equals("unchecked");

        if (checkState || uncheckedState){
            if (element.isSelected() && checkState){
                logger.info("checkbox is already checked");
            }else if (element.isSelected() && uncheckedState){
                clickOnElement(element);
            }else if(!element.isSelected() && checkState){
                clickOnElement(element);
            } else if(!element.isSelected() && uncheckedState){
                logger.info("checkbox is already unchecked");
            }
        }else {
            logger.error("state should be checked or unchecked");
            Assert.fail("state should be checked or unchecked");
        }
    }
}
