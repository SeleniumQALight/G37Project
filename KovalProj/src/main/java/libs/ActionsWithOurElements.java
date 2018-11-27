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

    public void enterTextInToElement(WebElement element, String text) {
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
        try{
            wait5.until(ExpectedConditions.elementToBeClickable(element));
    //        Дождись пока будет не кликабельным (через not)
    //        wait5.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));

            element.click();
            logger.info(element + " was successfully clicked");
        }catch (Exception e){
            logger.error("Cannot click button");
            Assert.fail("Cannot click button");
        }
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(By by) {
        try{
            return isElementDisplayed(webDriver.findElement(by));
        }catch (Exception e) {
            return false;
        }
    }

   // Find By text
    public void selectTextInDD(WebElement element, String text) {
        try{
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was successfully selected");
        }catch (Exception e){
            logger.error("Can not work with Element");
            Assert.fail("Can not work with Element");
        }
    }

    // Find By Value
    public void selectTextFromDD(WebElement element, String text) {
        try{
            Select select = new Select(element);
            select.selectByValue(text);
            logger.info(text + " was successfully selected");
        }catch (Exception e){
            logger.error("Can not work with Element");
            Assert.fail("Can not work with Element");
        }
    }
}
