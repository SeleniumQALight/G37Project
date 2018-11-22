package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());


    public ActionsWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
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
}
