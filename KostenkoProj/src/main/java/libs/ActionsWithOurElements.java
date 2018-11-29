package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements { // это метод, здесь объявляем
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5, wait10;

    public ActionsWithOurElements(WebDriver webDriver) {   //это конструктор, здесь инициализируем
        this.webDriver = webDriver;
        wait5 = new WebDriverWait(webDriver,5);
        wait10 = new WebDriverWait(webDriver, 10);
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into Input");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element)); //вейт ждет 5 сек, кликает по элементу, потом опять ждет 5 сек и кликает.
//            wait5.until(ExpectedConditions.not.ExpectedConditions(element));  // просто для примера, как работает not (библиотека Actions)
            element.click();
            logger.info("Element was clicked ");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try {
            Select select = new Select (element);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DD");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public boolean isElementDisplayed(By by) {
        try{
            return  isElementDisplayed(webDriver.findElement(by));
        }catch (Exception e) {
            return false;
        }
    }
}

// ДЗ (22.11.18)
// 1-найти дропдайн - кликнуть на него - найти текст - кликнуть.
// 2-написать метод, который будет выбирать по value
