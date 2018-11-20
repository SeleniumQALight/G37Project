package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void enterTextInToElement(WebElement element, String text) {
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into Input ");
        }catch (Exception e) {
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }


    }

    public void clickOnElement(WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked ");
        }catch (Exception e){
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }
    }

    public void cheсkVisibleElement(WebElement element) {
        try {
            element.isDisplayed();
            logger.info("Element was visible ");
        }catch (Exception e) {
            logger.error("Invisible element " + e);
            Assert.fail("Invisible element " + e);

        }

    }
}
