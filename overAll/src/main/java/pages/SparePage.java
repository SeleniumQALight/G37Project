package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {
    EditSparePage editSparePage;

    @FindBy(xpath = "//table//tr")
    List<WebElement> listOfRows;

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    public WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + spareName + "']"));
    }

    public void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickButtonDelete();
            counter++;
            // We need this for stopping loop if deleting does not work
            if (counter > 100) {
                Assert.fail("There are more than 100 spare in list or deleting does not work, so test does not go further");
            }
        }
        logger.info(String.format("Was deleted %s spares!", counter));
    }


    public void checkAndDeleteSpare(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("./*[1]"));
                if (cellWithSpare.getText().equals(spareName)) {
                    actionsWithOurElements.clickOnElement(cellWithSpare);
//                logger.info("Yes!!!");
                    Assert.assertTrue("Diff Spare"
                            , editSparePage.checkSpareNameInInput(spareName));
                    editSparePage.clickButtonDelete();
                    logger.info("Spare with name was deleted");
                }
            }
        }
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
