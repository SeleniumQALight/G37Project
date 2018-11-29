package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SparePage extends ParentPage {

    EditSparePage editSparePage;

    @FindBy(xpath = ".//table/tr")
    private List<WebElement> listOfRows;

    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    @Deprecated
    public void checkAndDeleteSpare(String spareName) {
        if (listOfRows.size() > 0) {
            for (WebElement line : listOfRows) {
                EditSparePage editSparePage = new EditSparePage(webDriver);
                WebElement cellWithSpare = line.findElement(By.xpath("/*[1]"));
                if (cellWithSpare.getText().trim().equals(spareName)) ;
                actionsWithOurElements.clickOnElement(cellWithSpare);
                //logger.info("Yes!!!");

                Assert.assertTrue("Diff spare", editSparePage.checkSpareNameInInput(spareName));
                editSparePage.clickDeleteOnElement();
            }
        }
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void deletingSpareUntilPresent(String spareName) {

        int count = 0;
        while (isSpareInList (spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickDeleteOnElement();
            count++;
            if (count > 10) {
                Assert.fail("There are more than 100 spare in list " +
                        "or deleting does not work, so test does not go further");
            }
        }

    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDispayed(By.xpath(".//*[text()='" + spareName + "']"));
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(getSpareWithName(spareName));
    }

    private WebElement getSpareWithName(String spareName) {
        return webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']"));
    }
}
