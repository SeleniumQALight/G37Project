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



    public void enterTextIntoElement(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered into the field");
        }catch (Exception e){
            logger.error("can't work with element " + e);
            Assert.fail("can't work with element " + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("element was clicked");
        }catch (Exception e){
            logger.error("can't work with element " + e);
            Assert.fail("can't work with element " + e);
        }


    }

    public boolean isAvatarDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }
}
