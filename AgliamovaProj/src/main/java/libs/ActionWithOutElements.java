package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionWithOutElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithOutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void  enterTextInToElement(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered in Input field");

        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }

    public  void clickOnElement(WebElement element){
        try {
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");

        }
    }
}
