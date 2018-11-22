package libs;

import com.gargoylesoftware.htmlunit.WebAssert;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;

/**
 * Created by 123 on 15.11.2018.
 */
public class ActionWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger((getClass()));

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoElement(WebElement element, String text) {
        try

        {
            element.clear();
            element.sendKeys(text);

            logger.info(text + "element was added");

        } catch (
                Exception e ) {
            logger.error("Can't enter element" + e);
            Assert.fail("Can't enter element" + e);

        }
    }

    public void clickOnElement(WebElement element) {

        try

        {
            element.click();
            logger.info("button is found");

        } catch (
                Exception e )

        {
            logger.error("Password or Username are incorrect");
            Assert.assertTrue("Password or Username are incorrect", true);

        }


    }


    public boolean isElementDisplayed(WebElement element) {
        try

        {
            return element.isEnabled();

        } catch ( Exception e )

        {
            return false;

        }

    }

    public void selectTextInDD(WebElement element, String text) {
        try {
            Select select = new Select(element); // work with drop-down menu
            select.selectByVisibleText(text);// choose selected item
            logger.info(text + "was selected in DD");

        } catch (
                Exception e ) {
            logger.error("Can't enter element" + e);
            Assert.fail("Can't enter element" + e);

        }

    }

}
