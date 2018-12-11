package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5, wait10;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait5 = new WebDriverWait(webDriver, 5);
        wait10 = new WebDriverWait(webDriver, 10);
    }

    public void enterTextIntoElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was inputted into element");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }

    }

    public void clickOnElement(WebElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));


            element.click();
            logger.info("Element was ckicked");
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

    // работа с дропдаун
    public void selectTextInDD(WebElement element, String text) {

        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DD");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void selectValueInDD(WebElement element, String value) {

        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + " was selected in DD");
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    //мои методы с чек -боксом selectCheckBox deSelectCheckBox
    public void selectCheckBox(WebElement element) {
        try {
            if (!element.isSelected()) {
                clickOnElement(element);
                logger.info(element + "  was selected in check-box");
            }
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public void deSelectCheckBox(WebElement element) {
        try {
            if (element.isSelected()) {
                clickOnElement(element);
                logger.info(element + "  was deselected in check-box");
            }
        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            return isElementDisplayed(webDriver.findElement(by));
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * set needed
     *
     * @param element
     * @param state   only!!!! check  or uncheck
     */
    public void setNeededStateCheckBox(WebElement element, String state) {
        boolean checkState = state.toLowerCase().equals("check");
        boolean unCheckState = state.toLowerCase().equals("unCheck");

        if (checkState || unCheckState) {

            if (element.isSelected() && checkState) {
                logger.info(" Checkbox is already checked  ");

            } else if (element.isSelected() && unCheckState) {
                clickOnElement(element);

            } else if (!element.isSelected() && checkState) {
                clickOnElement(element);

            } else if (!element.isSelected() && unCheckState) {
                logger.info(" Checkbox is already unchecked  ");

            } else {
                logger.error("State should be check or uncheck");
                Assert.fail("State should be check or uncheck");
            }
        }
    }

    public void enterTextInToElement(TextInput textInput, String text) {
        try {
            textInput.clear();
            textInput.sendKeys(text);
            logger.info("'" + text + "' was inputed into '" + textInput.getName() + "'");
        } catch (Exception e) {
            printExceptionAndStopTest(textInput, e);
        }
    }
    public void clickOnElement(TypifiedElement element) {
        try {
            wait5.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element '" + element.getName() + "' was clicked ");
        } catch (Exception e) {
            printExceptionAndStopTest(element, e);
        }
    }
    private void printExceptionAndStopTest(TypifiedElement element, Exception e) {
        logger.error("Can not work with element '" + element.getName() + "'\n " + e);
        Assert.fail("Can not work with element '" + element.getName() + "'\n " + e);
    }

}