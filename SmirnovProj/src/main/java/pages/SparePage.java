package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage{
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
    public void chackAndDeleteSpare(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        if (listOfRows.size()>0) {
        for (WebElement line: listOfRows) {
        WebElement cellWithSpare = line.findElement(By.xpath("//*[1]"));
        if (cellWithSpare.getText().equals(spareName)){
            actionsWithOurElements.clickOnElement(cellWithSpare);

            Assert.assertTrue("Diff Spare", editSparePage.checkSpareNameInInput(spareName));
            editSparePage.clickButtonDelete();
        }



        }

    }
}

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        while (isSpareInList (spareName)){
            clickOnSpare(spareName);
            editSparePage.clickButtonDelete();
            counter ++;
            if (counter > 100){
                Assert.fail("There are more 100 spare in list or deleting does not work, so test does not go further");
            }
        }
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDispayed(By.xpath(".//*[text='"+ spareName + "']"));
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWhisName(spareName));
    }

    private WebElement getSpareWhisName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text='"+ spareName + "']"));
    }
}
