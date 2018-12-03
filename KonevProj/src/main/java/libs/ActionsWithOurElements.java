package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5, wait10;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait5 =  new WebDriverWait(webDriver, 5);
        wait10 = new WebDriverWait(webDriver, 10);
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into Input");

        } catch (Exception e) {
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));
          //  wait5.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }

    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try{
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text+" was selected in dropdown");
        }catch (Exception e){
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }
    }

    public void manualSelectTextInDD(WebElement element, String text){
        try{
            element.click();
            element.findElement(By.xpath("//option[text()='"+text+"']")).click();
            logger.info(text+" was selected in dropdown");
        }catch (Exception e){
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }
    }

    public void selectValueInDD(WebElement element, String value){
        try{
            Select select = new Select(element);
            select.selectByValue(value);
          //  logger.info("Element with xpath '"+xpath+"' was selected in dropdown");
        }catch (Exception e){
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            return isElementDisplayed(webDriver.findElement(by));

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Set needed state
     * @param element
     * @param state (Only !!! check or uncheck)
     */
    public  void setNeededStateToCheckBox(WebElement element, String state){
        boolean checkState = state.toLowerCase().equals("check");
        boolean uncheckState = state.toLowerCase().equals("uncheck");
        if(checkState||uncheckState){
            if(element.isSelected()&&checkState){
                logger.info("Checkbox is already checked");
            }else if(element.isSelected()&&uncheckState){
                clickOnElement(element);
            }else if(!element.isSelected()&&checkState){
                clickOnElement(element);
            }else  if(!element.isSelected()&&uncheckState){
                logger.info("Checkbox is already checked");
            }
        }else {
            logger.error("State should be check or uncheck");
            Assert.fail("State should be check or uncheck");
        }
    }
}
