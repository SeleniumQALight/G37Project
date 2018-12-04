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
    public void enterTextToElement(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into Input field");

        }catch(Exception e){
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }

    }
    public void clickOnElement(WebElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));

           // wait5.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));

            element.click();
            logger.info("Element was clicked");
        }catch(Exception e){
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }

    }
    public boolean isElementDisplayed(WebElement element){
        try{
            return element.isDisplayed();

        }catch (Exception e){
            return false;
        }

    }


    public void selectTextInDD(WebElement element, String text) {
        try{
            Select select = new Select(element);   // object, which works with elements
            select.selectByVisibleText(text);
            logger.info(text + " was selected from drop-down");
        }

        catch(Exception e){
            logger.error("Cannot work with url");
            Assert.fail("Cannot work with url");
        }
    }

    public boolean isElementDisplayed(By by) {
        try{
            return isElementDisplayed(webDriver.findElement(by));

        }catch(Exception e){
            return false;


        }
    }

     //  method working with checkbox 29.11.2018

    /**
     * Set needed state
     * @param element
     * @param state (Only !!! check or uncheck)
     */
    public void setNeededStateToCheckBox(WebElement element, String state){

        boolean checkState = state.toLowerCase().equals("check");
        boolean unCheckState = state.toLowerCase().equals("uncheck");

        if (checkState || unCheckState){
            if (element.isSelected() && checkState){
                logger.info("Checkbox is already checked");
            }
            else if (element.isSelected() && unCheckState){
                clickOnElement(element);
            }
            else if(!element.isSelected() && checkState){
                clickOnElement(element);
            }
            else if (!element.isSelected() && unCheckState){
                logger.info("Checkbox is already unchecked");

            }
        }else{
            logger.error("State should be check or uncheck");
            Assert.fail("State should be check or uncheck");
        }



    }
}
