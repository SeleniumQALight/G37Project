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


    public void clickOnElement(WebElement element){

        try {
            element.click();
            logger.info("The enter is successful");
        } catch (Exception e) {
            logger.error("Can not find the element" + e);
            Assert.fail("Can not find the element" + e);

        }
    }

    public void enterTextIntoElement(WebElement element, String text) {

        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text+ "was inputed into Input");
        } catch (Exception e) {
            logger.error("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }


}

///atl insert = fn alt enter