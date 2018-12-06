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
        wait5 = new WebDriverWait( webDriver, 5);
        wait10 = new WebDriverWait( webDriver, 10);
    }


    public void clickOnElement(WebElement element) {

        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));
        //    wait5.until(ExpectedConditions.not (ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Can not find the element" + e);
            Assert.fail("Can not find the element" + e);

        }
    }

    public void enterTextIntoElement(WebElement element, String text) {

        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputed into Input");
        } catch (Exception e) {
            logger.error("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void selectTextInDropDown(WebElement element, String text) {
        try {

            Select select = new Select (element);
            select.selectByVisibleText(text);
            logger.info("Text was selected in drop down");
        } catch (Exception e) {
            logger.error("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }


    /**
     * Set needed state
     * @param element
     * @param state (Only  !!! ckeck or uncheck)
     */
    public  void setNeededStateToCheckBox (WebElement element, String state) {

        boolean checkState = state.toLowerCase().equals("check");
        boolean  uncheckState = state.toLowerCase().equals("uncheck");

        if (checkState|| uncheckState) {   // || или
            if (element.isSelected() && checkState) {  // && и
                logger.info("Checkbox is already checked");
            } else if (element.isSelected() && uncheckState) {
                    clickOnElement(element);
                } else if (!element.isSelected() && checkState){
                    clickOnElement(element);
            }  else if (!element.isSelected() && uncheckState) {
                logger.info("Checkbox is already unchecked"); }
        } else {
            logger.error("State should be check or uncheck");
            Assert.fail("State should be check or uncheck");
        }



    }

    public boolean isElementDisplayed(By by) {
        try {
            return isElementDisplayed(webDriver.findElement(by));
        } catch (Exception e) {
            return false;
        }

    }
}


///atl insert = fn alt enter