package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
            logger.info(text+ " was inputted into Input");
        }catch (Exception e){
            logger.error("Cannot work with element " +e);
            Assert.fail("Cannot work with element " +e);
        }
    }


    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            logger.error("Cannot work with element " +e);
            Assert.fail("Cannot work with element " +e);
        }



    }
    public boolean isElemetDisplayed(WebElement element){
        try {
            return element.isDisplayed();


        }catch (Exception e){
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String Text) {
        try {
            //Select open DD
            Select select=new Select(element);
            select.selectByVisibleText(Text);
            logger.info(Text+" was select in DD");
        }catch (Exception e){
            logger.error("Cannot work with element " +e);
            Assert.fail("Cannot work with element " +e);
        }


    }
    /**
     * Method for work with drop down.
     * Finding necessary using SelectValue
     * @param webElement
     * @param value
     */
    public void selectValueInDD(WebElement webElement,String value){
        try{
            Select select=new Select(webElement);
            select.selectByValue(value);

        }catch (Exception e){
            logger.error("Cannot work with element " +e);
            Assert.fail("Cannot work with element " +e);
        }
    }
}
