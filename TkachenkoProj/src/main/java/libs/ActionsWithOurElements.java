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
    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5, wait10;

    public ActionsWithOurElements(WebDriver driver) {
        this.driver = driver;
        wait5 = new WebDriverWait(driver,5);
        wait10 = new WebDriverWait(driver, 10);
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
            wait5.until(ExpectedConditions.elementToBeClickable(element));
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

    public void selectValueFromDD(WebElement element, String optionValue) {
        try {
            Select select = new Select(element);
            select.selectByValue(optionValue);
            logger.info(optionValue + " was selected in dropdown");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void selectElementFromDropdownByText(WebElement element, String text) {
        try{
            clickOnElement(element);
            String xpathWithText = "//*[text()='"+text+"']";
            element.findElement(By.xpath(xpathWithText)).click();
            logger.info(text + " was selected in DD");
        }catch (Exception e){
            logger.error("Can not find element by text:"+ text);
            Assert.fail("Can not find element by text:"+ text);
        }
    }

    public boolean isElementDisplayed(By by) {
        try{
            return isElementDisplayed(driver.findElement(by));
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Set needed state
     * @param element
     * @param state (only!!! check or uncheck)
     */
    public void setNeededStateToCheckbox(WebElement element, String state){
        boolean checkState = state.toLowerCase().equals("check");
        boolean uncheckState = state.toLowerCase().equals("uncheck");

        if (checkState || uncheckState){
            if(element.isSelected()  && checkState){
                logger.info("Checkbox is already checked");
            }else if(element.isSelected() && uncheckState){
                clickOnElement(element);
            }else if (!element.isSelected() && checkState){
                clickOnElement(element);
            }else if (!element.isSelected() && uncheckState){
                logger.info("Checkbox is already unchecked");
            }
        }else {
            logger.error("State should be check or uncheck");
            Assert.fail("State should be check or uncheck");
        }
    }
}
