package libs;

import org.apache.commons.logging.impl.Jdk14Logger;
import org.apache.commons.logging.impl.SimpleLog;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.soap.Text;

public class ActionsWithOurElements {
    WebDriver webDriver;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        Logger logger = Logger.getLogger(getClass());
    }

    public void enterTextInToElement(WebElement element, String text) {
        SimpleLog logger = null;
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into input");
        }catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void clickOnElement(WebElement element) {
        SimpleLog logger = null;
        try {
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }
}
