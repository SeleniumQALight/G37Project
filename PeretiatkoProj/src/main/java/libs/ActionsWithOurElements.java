package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void enterTextIntoElement(WebElement element, String textInput) {
        try {
            element.clear();
            element.sendKeys(textInput);
            logger.info(textInput + " Has inputted into element");
        } catch (Exception e) {
            logger.error(" Doest'nt work with element" + e);
            Assert.fail(" Doest'nt work with element" + e);
        }

    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error(" Don't click on element" + e);
            Assert.fail(" Don't click on element" + e);
        }
    }

    public boolean isElementDispayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void selectTextInDropDown(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "Was selected in Drop Down");
        } catch (Exception e) {
            logger.info("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }
}