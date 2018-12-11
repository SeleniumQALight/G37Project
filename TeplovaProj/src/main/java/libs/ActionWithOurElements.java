package libs;

import com.gargoylesoftware.htmlunit.WebAssert;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

/**
 * Created by 123 on 15.11.2018.
 */
public class ActionWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger((getClass()));
//    WebDriverWait wait5, wait10;


    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
//        wait5 = new WebDriverWait(WebDriver, 5);
//        wait10 = new WebDriverWait(WebDriver, 10);
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
//            wait5.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("button is found");
        } catch (
                Exception e ) {
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

    public boolean isElementDisplayed(By by) {
        try {
            return isElementDisplayed(webDriver.findElement(by));
        } catch ( Exception e ) {
            return false;
        }

    }

    /**
     * Set need state
     * @param element
     * @param state (Only !!! check or uncheck)
     */
    public void setNeededStateToCheckBox(WebElement element, String state) {
        boolean checkState = state.toLowerCase().equals("check");
        boolean unCheckState = state.toLowerCase().equals("uncheck");

        if (checkState || unCheckState) {
            if (element.isSelected() && checkState) {
                logger.info("Already cheked");

            } else if (element.isSelected() && unCheckState) {
                clickOnElement(element);
            } else if (!element.isSelected() && checkState) {
                clickOnElement(element);
            } else if (!element.isSelected() && unCheckState) {
                logger.info("Already cheked");
            }
        } else {
            logger.error("Staet should be checked or unchecked");
            Assert.fail("Staet should be checked or unchecked");
        }
    }

}
