package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5, wait10;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait5 = new WebDriverWait(webDriver, 5);
        wait10 = new WebDriverWait(webDriver, 10);
    }


    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into Input");

        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }
    public void clickOnElement(WebElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));

            element.click();
            logger.info("Elementwas clicked");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }

    }
    public boolean isAuthorizationFormPresent() {
        try {
            return webDriver.findElement(By.xpath(".//p[@class='login-box-msg']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isElementDisplayed (WebElement element){
        try {
            return element.isDisplayed();

        }catch (Exception e){
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in DD");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }
    public void manualSelectTextInDD(WebElement element, String xpath){
        try{
            element.click();
            webDriver.findElement(By.xpath(xpath)).click();
        }catch (Exception e){
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }
    }
    public void selectValueInDD(WebElement element, String value){
        try{
            Select select = new Select(element);
            select.selectByValue(value);
        }catch (Exception e){
            logger.error("Cannot work with element " + e);
            Assert.fail("Cannot work with element " + e);
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            return isElementDisplayed(webDriver.findElement(by));
        }catch (Exception e){
            return false;
        }

    }
}
