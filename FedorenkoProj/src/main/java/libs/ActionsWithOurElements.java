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
        wait5 = new WebDriverWait(webDriver, 5);
        wait10 = new WebDriverWait(webDriver, 10);
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
            wait5.until(ExpectedConditions.elementToBeClickable(element));
//            wait5.until(ExpectedConditions.not
//                      (ExpectedConditions.elementToBeClickable(element)));
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

        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void findElementInDDByTextAndClickOnIt(WebElement element, String text) {
        try {
            clickOnElement(element);
            String xpathWithText = "//*[text() = '" + text + "']";
            element.findElement(By.xpath(xpathWithText)).click();
            logger.info("Text was selected in DD");
        } catch (Exception e) {
            logger.error("Cannot find element by text:" + text + e);
            Assert.fail("Cannot find element by text:" + text + e);
        }
    }

    public void findElementInDDByValueAndClickOnIt(WebElement element, String value) {
        try {
            clickOnElement(element);
            String xpathWithValue = "//option[@value = '" + value + "']";
            element.findElement(By.xpath(xpathWithValue)).click();
            logger.info("Element was selected in DD by value");
        } catch (Exception e) {
            logger.error("Cannot find element by value:" + value + e);
            Assert.fail("Cannot find element by value:" + value + e);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            return isElementPresent(webDriver.findElement(by));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Set needed state
     *
     * @param element
     * @param state   (Only !!! check or uncheck)
     */
    public void setNeededStateToCheckBox(WebElement element, String state) {
        boolean checkState = state.toLowerCase().equals("check");
        boolean unCheckState = state.toLowerCase().equals("uncheck");
        if (checkState || unCheckState) {
            if (element.isSelected() && checkState) {
                logger.info("Checkbox is already checked");
            } else if (element.isSelected() && unCheckState) {
                clickOnElement(element);
            } else if (!element.isSelected() && checkState) {
                clickOnElement(element);
            } else if (!element.isSelected() && unCheckState) {
                logger.info("Checkbox is already unchecked");
            }
        } else {
            logger.error("State should be check or uncheck");
            Assert.fail("State should be check or uncheck");
        }
    }

}

