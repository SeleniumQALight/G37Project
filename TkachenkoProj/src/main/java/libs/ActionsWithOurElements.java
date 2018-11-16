package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver driver) {
        this.driver = driver;
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
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            logger.error("Can not work with element");
           Assert.fail("Can not work with element");
        }
    }
}
