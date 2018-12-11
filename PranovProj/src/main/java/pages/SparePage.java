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

    @Deprecated
    public void checkAndDeleteSpare(String spareName) {
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellWithSpare = line.findElement(By.xpath("//*[1]"));
                if (cellWithSpare.getText().equals(spareName)) {
                    actionWithOurElements.clickOnElement(cellWithSpare);
                    //logger.info("Yes!!!");
                    Assert.assertTrue("Diff Spare", editSparePage.checkSpareNameInInput(spareName));
                    editSparePage.clickButtonDelete();

                }
            }
        }
    }

    public void clickOnAddButton() {
        actionWithOurElements.clickOnElement(buttonAdd);
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickButtonDelete();
            counter++;
            if (counter > 100){
                Assert.fail("There are more than 100 spare in list or deleting does not work, so test does not go further");
            }
        }
    }

    public boolean isSpareInList(String spareName) {
        return actionWithOurElements.isElementDisplayed(By.xpath(".//*[text()='" + spareName + "']"));
    }

    private void clickOnSpare(String spareName) {
        actionWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }
}