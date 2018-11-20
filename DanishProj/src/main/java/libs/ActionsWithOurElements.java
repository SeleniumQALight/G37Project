package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
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
}
