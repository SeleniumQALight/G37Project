package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionWithOurElements {
    WebDriver webDriver;
    Logger logger=Logger.getLogger(getClass());

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void enterTextIntoElement(WebElement element,String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text+ "was inputted into Input");
        }catch (Exception e){
            logger.error("Cannot work with element " +e);
            Assert.fail("Cannot work with element " +e);
        }
    }



}
