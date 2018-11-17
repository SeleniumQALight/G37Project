package Libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.soap.Text;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoElement (WebElement element, String text)
     try {
        element.clear();
        element.sendKeys(Text);
        logger.info(Text + "was inputted into input");
    } catch (Exception e) {
        logger.error("Cannot work with element" + e);
        Assert.fail("Cannot work with element" + e);
    }

    public void clickOnElement (WebElement element) {
         try {
             element.click();
             Logger.info("Element was clicked" + e);
         } catch (Exception e) {
             logger.error("Cannot work with element" + e);
             Assert.fail("Cannot work with element" + e);

         }
    }
}
