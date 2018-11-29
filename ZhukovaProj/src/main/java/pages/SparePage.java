package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SparePage extends ParentPage {
EditSparePage editSparePage;
    @FindBy(xpath = ".//table//tr")
    List<WebElement> listOfRows;


    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }
@Deprecated
    public void checkAndDeleteSpare(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);

        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                WebElement cellesWithSpare = line.findElement(By.xpath(".//*[1]"));
                if (cellesWithSpare.getText().trim().equals(spareName)) ;
                actionsWithOurElements.clickOnElement(cellesWithSpare);

                Assert.assertTrue("Diff Spare", editSparePage.checkSpareNameInInput(spareName));
                editSparePage.clickButtonDeleteOnEditPage();
            }
        }
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter=0;
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickButtonDeleteOnEditPage();
            counter++;
            if (counter >10){
                Assert.fail("There are more then 100 spare in list or deleting does not work.");
            }
        }

    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(By.xpath(".//*[text(='" + spareName+ "')]"));
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text(='" + spareName+ "')]"));
    }
}
